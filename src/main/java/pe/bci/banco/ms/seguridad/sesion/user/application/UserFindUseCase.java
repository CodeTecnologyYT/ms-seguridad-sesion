/*
 * @(#)UserFindUseCase.java
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
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.User;
import pe.bci.banco.ms.seguridad.sesion.user.domain.repository.UserRepositoryPort;

/**
 * UserFindUseCase.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Component
@RequiredArgsConstructor
public class UserFindUseCase implements IUserFindUseCase {

    /** userRepositoryPort. */
    private final UserRepositoryPort userRepositoryPort;

    public User findByEmail(final String email) {
        return userRepositoryPort.findByEmail(email)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }


}
