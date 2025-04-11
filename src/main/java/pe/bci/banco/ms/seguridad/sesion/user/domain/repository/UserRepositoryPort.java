/*
 * @(#)UserRepositoryPort.java
 *
 * Copyright (c) BCI (Chile). All rights reserved.
 *
 * All rights to this product are owned by BCI and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by BCI.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package pe.bci.banco.ms.seguridad.sesion.user.domain.repository;

import java.util.Optional;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.UserRs;

/**
 * UserRepositoryPort.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
public interface UserRepositoryPort {

    /**
     * Find UserRs by email.
     *
     * @param email {@link String}
     * @return {@link UserRs}
     */
    Optional<UserRs> findByEmail(String email);

    /**
     * Save user.
     *
     * @param userRequest {@link UserRs}
     * @return {@link UserRs}
     */
    UserRs save(AuthUserRegisterRq userRequest);
    
}
