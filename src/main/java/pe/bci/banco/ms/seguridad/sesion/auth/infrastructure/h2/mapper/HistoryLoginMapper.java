/*
 * @(#)HistoryLoginMapper.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.h2.mapper;

import java.time.LocalDateTime;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.h2.entity.HistoryLoginEntity;

/**
 * HistoryLoginMapper.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 11-04-2025
 */
@Mapper(imports = {LocalDateTime.class, UUID.class})
public interface HistoryLoginMapper {

    /**
     * toHistoryLoginEntity.
     *
     * @param username username {@link String}
     * @param ipAddress ipAddress {@link String}
     * @param loginTime loginTime {@link LocalDateTime}
     * @return HistoryLoginEntity {@link HistoryLoginEntity}
     */
    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "email", source = "username")
    @Mapping(target = "ipAddress", source = "ipAddress")
    @Mapping(target = "loginTime", expression = "java(LocalDateTime.now())")
    HistoryLoginEntity toHistoryLoginEntity(String username, String ipAddress, LocalDateTime loginTime);

}
