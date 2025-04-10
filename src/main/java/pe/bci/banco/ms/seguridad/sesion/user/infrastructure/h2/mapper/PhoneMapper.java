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

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.Phone;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.entity.PhoneEntity;

/**
 * PhoneMapper.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Mapper
public interface PhoneMapper {

    /**
     * Convert entity to domain.
     *
     * @param phone {@link PhoneEntity}
     * @return {@link Phone}
     */
    @Mapping(target = "citycode", source = "cityCode")
    @Mapping(target = "countrycode", source = "countryCode")
    @Mapping(target = "number", source = "phoneNumber")
    Phone entityToResponse(final PhoneEntity phone);

}
