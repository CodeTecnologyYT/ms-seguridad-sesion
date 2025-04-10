/*
 * @(#)PhoneMapper.java
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

import java.time.LocalDateTime;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.PhoneRs;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.entity.PhoneEntity;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.entity.TypePhone;

/**
 * PhoneMapper.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Mapper(imports = { LocalDateTime.class, Boolean.class, UUID.class, TypePhone.class })
public interface PhoneMapper {

    /**
     * Convert entity to domain.
     *
     * @param phone {@link PhoneEntity}
     * @return {@link PhoneRs}
     */
    @Mapping(target = "citycode", source = "cityCode")
    @Mapping(target = "countrycode", source = "countryCode")
    @Mapping(target = "number", source = "phoneNumber")
    PhoneRs entityToResponse(final PhoneEntity phone);

    /**
     * Convert domain to entity.
     *
     * @param phone {@link PhoneRs}
     * @return {@link AuthUserRegisterRq.PhoneRegister}
     */
    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "cityCode", source = "citycode")
    @Mapping(target = "countryCode", source = "countrycode")
    @Mapping(target = "phoneNumber", source = "number")
    @Mapping(target = "typePhone", expression = "java(TypePhone.MOBILE)")
    @Mapping(target = "active", expression = "java(Boolean.TRUE)")
    @Mapping(target = "createdAt", expression = "java(LocalDateTime.now())")
    @Mapping(target = "updatedAt", expression = "java(LocalDateTime.now())")
    PhoneEntity requestToEntity(final AuthUserRegisterRq.PhoneRegister phone);

}
