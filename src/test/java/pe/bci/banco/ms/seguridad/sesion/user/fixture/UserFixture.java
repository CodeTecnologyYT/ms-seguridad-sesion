/*
 * @(#)UserFixture.java
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
package pe.bci.banco.ms.seguridad.sesion.user.fixture;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.UUID;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.PhoneRs;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.UserRs;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.entity.PhoneEntity;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.entity.UserEntity;

/**
 * UserFixture.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
public final class UserFixture {

    /** TEST_EMAIL. */
    public static final String TEST_EMAIL = "prueba@test.com";

    /**
     * Get UserEntity.
     *
     * @return {@link UserEntity}
     */
    public static UserEntity getUserEntity(){
        return  UserEntity.builder()
            .id(UUID.randomUUID())
            .name("Juan Rodrigez")
            .email(TEST_EMAIL)
            .password("zH123")
            .active(Boolean.TRUE)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .lastLogin(LocalDateTime.now())
            .phones(Collections.singletonList(PhoneEntity.builder()
                    .id(UUID.randomUUID())
                    .phoneNumber("123143")
                    .cityCode("1")
                    .countryCode("52").build()))
            .build();
    }

    /**
     * Get user response.
     *
     * @return {@link UserRs}
     */
    public static UserRs getUserRs() {
        return UserRs.builder()
            .id(UUID.randomUUID())
            .name("Juan Rodrigez")
            .email(TEST_EMAIL)
            .password("zH123")
            .active(Boolean.TRUE)
            .createdAt(LocalDateTime.now())
            .updatedAt(LocalDateTime.now())
            .lastLogin(LocalDateTime.now())
            .phones(Collections.singletonList(PhoneRs.builder()
                .id(UUID.randomUUID())
                .number("123143")
                .citycode("1")
                .countrycode("52")
                .build()))
            .build();
    }

}
