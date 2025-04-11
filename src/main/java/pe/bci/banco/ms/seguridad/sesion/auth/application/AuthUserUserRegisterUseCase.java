/*
 * @(#)AuthUserUserRegisterUseCase.java
 *
 * Copyright (c) BCI (Chile). All rights reserved.
 *
 * All rights to this product are owned by SEEK and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by SEEK.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package pe.bci.banco.ms.seguridad.sesion.auth.application;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRs;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.provider.EncryptProviderPort;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.provider.JwtProviderPort;
import pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.encript.EncryptProvider;
import pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.jwt.provider.JwtProvider;
import pe.bci.banco.ms.seguridad.sesion.shared.exceptions.SecuritySessionError;
import pe.bci.banco.ms.seguridad.sesion.shared.exceptions.SimpleException;
import pe.bci.banco.ms.seguridad.sesion.user.application.IUserCreateUseCase;
import pe.bci.banco.ms.seguridad.sesion.user.application.IUserFindUseCase;

/**
 * AuthUserUserRegisterUseCase.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Component
@RequiredArgsConstructor
public class AuthUserUserRegisterUseCase implements IAuthUserRegisterUseCase {

    /** userFindUseCase. */
    private final IUserFindUseCase userFindUseCase;
    /** userCreateUseCase. */
    private final IUserCreateUseCase userCreateUseCase;
    /** encryptProvider. */
    private final EncryptProviderPort encryptProvider;
    /** jwtProvider. */
    private final JwtProviderPort jwtProvider;

    /**
     * {@inheritDoc}
     */
    @Override
    public AuthUserRegisterRs register(final AuthUserRegisterRq userRegisterRequest) {
        final var user = this.userFindUseCase.findOptionalByEmail(userRegisterRequest.getEmail());
        if(user.isPresent()){
            throw new SimpleException(SecuritySessionError.ERROR_EXIST_USER, HttpStatus.CONFLICT.value());
        }
        userRegisterRequest.setPassword(encryptProvider.encrypt(userRegisterRequest.getPassword()));
        final var newUser = this.userCreateUseCase.createUser(userRegisterRequest);
        // Generate Token
        final var userDetails = org.springframework.security.core.userdetails.User.builder()
            .username(userRegisterRequest.getEmail())
            .password(newUser.getPassword())
            .roles("USER")
            .build();

        return AuthUserRegisterRs
            .builder()
            .id(newUser.getId())
            .created(newUser.getCreatedAt())
            .lastLogin(newUser.getLastLogin())
            .modified(newUser.getUpdatedAt())
            .token(this.jwtProvider.generateToken(userDetails))
            .isactive(newUser.getActive())
            .build();
    }

}
