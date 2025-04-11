/*
 * @(#)UserCreateUseCase.java
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
package pe.bci.banco.ms.seguridad.sesion.user.application;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.UserRs;
import pe.bci.banco.ms.seguridad.sesion.user.domain.repository.UserRepositoryPort;

/**
 * UserCreateUseCase.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Component
@RequiredArgsConstructor
public class UserCreateUseCase implements IUserCreateUseCase {

    /** userRepositoryPort. */
    private final UserRepositoryPort userRepositoryPort;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRs createUser(final AuthUserRegisterRq userRegister) {
        return userRepositoryPort.save(userRegister);
    }

}
