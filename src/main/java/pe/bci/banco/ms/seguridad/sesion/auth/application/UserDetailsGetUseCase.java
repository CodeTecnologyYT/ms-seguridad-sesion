/*
 * @(#)UserDetailsGetUseCase.java
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
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import pe.bci.banco.ms.seguridad.sesion.user.application.IUserFindUseCase;

/**
 * UserDetailsGetUseCase.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Component
@RequiredArgsConstructor
public class UserDetailsGetUseCase implements UserDetailsService {

    /** userRepositoryPort. */
    private final IUserFindUseCase userFindUseCase;

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        final var user = userFindUseCase.findByEmail(email);
        return User.builder()
            .username(user.getEmail())
            .password(user.getPassword())
            .roles("USER")
            .build();
    }

}
