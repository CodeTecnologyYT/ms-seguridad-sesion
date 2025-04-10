/*
 * @(#)UserMapper.java
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
package pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.UserRs;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.entity.UserEntity;

/**
 * UserMapper.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Mapper(uses = PhoneMapper.class, imports = {LocalDateTime.class, Boolean.class, UUID.class})
public interface UserMapper {

    /**
     * Convert entity to domain.
     *
     * @param user {@link UserEntity}
     * @return {@link UserRs}
     */
    UserRs entityToResponse(final UserEntity user);

    /**
     * Convert domain to entity.
     *
     * @param user {@link UserRs}
     * @return {@link UserEntity}
     */
    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "active", expression = "java(Boolean.TRUE)")
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    UserEntity requestToEntity(final AuthUserRegisterRq user);

}
