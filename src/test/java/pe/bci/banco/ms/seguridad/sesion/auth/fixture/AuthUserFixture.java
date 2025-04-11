/*
 * @(#)AuthUserFixture.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.fixture;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.UUID;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRs;
import pe.bci.banco.ms.seguridad.sesion.shared.exceptions.SecuritySessionError;
import pe.bci.banco.ms.seguridad.sesion.shared.response.SimpleErrorResponse;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.PhoneRs;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.UserRs;
import pe.bci.banco.ms.seguridad.sesion.user.fixture.UserFixture;

/**
 * AuthUserFixture.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
public final class AuthUserFixture {

    /** TEST_PASSWORD. */
    public static final String TEST_PASSWORD = "123123faca";
    /** TEST_TOKEN. */
    public static final String TEST_TOKEN = "token";

    /**
     * Get auth user register rq success.
     *
     * @return {@link AuthUserRegisterRq}
     */
    public static AuthUserRegisterRq getAuthUserRegisterRqSuccess() {
        return AuthUserRegisterRq.builder()
            .name("Bryan Rosas Quispe")
            .email("bryan@nisum.com")
            .password("Hunter23")
            .phones(Collections.singletonList(
                AuthUserRegisterRq.PhoneRegister.builder()
                    .number("95402063")
                    .citycode("1")
                    .countrycode("51")
                    .build()))
            .build();
    }

    /**
     * Get auth user register rq email exist.
     *
     * @return {@link AuthUserRegisterRq}
     */
    public static AuthUserRegisterRq getAuthUserRegisterRqEmailExist() {
        return AuthUserRegisterRq.builder()
            .name("Bryan Rosas Quispe")
            .email(UserFixture.TEST_EMAIL)
            .password("Hunter23")
            .phones(Collections.singletonList(
                AuthUserRegisterRq.PhoneRegister.builder()
                    .number("95402063")
                    .citycode("1")
                    .countrycode("51")
                    .build()))
            .build();
    }

    /**
     * Get auth user register rq email not format.
     *
     * @return {@link AuthUserRegisterRq}
     */
    public static AuthUserRegisterRq getAuthUserRegisterRqEmailNotFormat() {
        return AuthUserRegisterRq.builder()
            .name("Bryan Rosas Quispe")
            .email("bryan@nisumcom")
            .password("Hunter23")
            .phones(Collections.singletonList(
                AuthUserRegisterRq.PhoneRegister.builder()
                    .number("95402063")
                    .citycode("1")
                    .countrycode("51")
                    .build()))
            .build();
    }

    /**
     * Get auth user register rq password not format.
     *
     * @return {@link AuthUserRegisterRq}
     */
    public static AuthUserRegisterRq getAuthUserRegisterRqPasswordNotFormat() {
        return AuthUserRegisterRq.builder()
            .name("Bryan Rosas Quispe")
            .email("bryan@nisum.com")
            .password("Hunter")
            .phones(Collections.singletonList(
                AuthUserRegisterRq.PhoneRegister.builder()
                    .number("95402063")
                    .citycode("1")
                    .countrycode("51")
                    .build()))
            .build();
    }

    /**
     * Get auth user register rs success.
     *
     * @return {@link AuthUserRegisterRs}
     */
    public static AuthUserRegisterRs getAuthUserRegisterRsSuccess() {
        return AuthUserRegisterRs.builder()
            .id(UUID.randomUUID())
            .isactive(Boolean.TRUE)
            .lastLogin(LocalDateTime.now())
            .modified(LocalDateTime.now())
            .created(LocalDateTime.now())
            .build();
    }

    /**
     * Get error message email exist.
     *
     * @return {@link SimpleErrorResponse}
     */
    public static SimpleErrorResponse getErrorMessageEmailExist() {
        return SimpleErrorResponse.builder()
            .mensaje(SecuritySessionError.ERROR_EXIST_USER.getMessage())
            .build();
    }

    /**
     * Get error message email not format.
     *
     * @return {@link SimpleErrorResponse}
     */
    public static SimpleErrorResponse getErrorMessageEmailNotFormat() {
        return SimpleErrorResponse.builder()
            .mensaje("Email no tiene el formato Correcto")
            .build();
    }

    /**
     * Get error message password not format.
     *
     * @return {@link SimpleErrorResponse}
     */
    public static SimpleErrorResponse getErrorMessagePasswordNotFormat() {
        return SimpleErrorResponse.builder()
            .mensaje("La contraseña no tiene el formato correcto")
            .build();
    }

}
