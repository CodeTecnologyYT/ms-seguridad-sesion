/*
 * @(#)UserJpaRepository.java
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
package pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.entity.UserEntity;

/**
 * UserJpaRepository.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {

    /**
     * Find UserRs by email.
     *
     * @param email {@link String}
     * @return {@link UserEntity}
     */
    Optional<UserEntity> findByEmail(String email);

}