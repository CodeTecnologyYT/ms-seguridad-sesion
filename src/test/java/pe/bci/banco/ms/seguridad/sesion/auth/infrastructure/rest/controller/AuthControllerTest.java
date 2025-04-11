/*
 * @(#)AuthControllerTest.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.rest.controller;

import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRs;
import pe.bci.banco.ms.seguridad.sesion.auth.fixture.AuthUserFixture;
import pe.bci.banco.ms.seguridad.sesion.shared.response.SimpleErrorResponse;

/**
 * AuthControllerTest.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql("classpath:sql/v1/v1.0-insert-data.sql")
class AuthControllerTest {

    /** client. */
    @Autowired
    private TestRestTemplate client;

    /**
     * Test.
     */
    @Test
    void testAuthUserRegisterSuccess(){
        // GIVEN
        final var dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final var authRequest = AuthUserFixture.getAuthUserRegisterRqSuccess();
        final var authResponseExpect = AuthUserFixture.getAuthUserRegisterRsSuccess();
        // WHEN
        final var response = client.postForEntity("/security/session/auth/register",
            authRequest, AuthUserRegisterRs.class);
        // THEN
        Assertions.assertEquals(HttpStatus.CREATED, response.getStatusCode());
        Assertions.assertEquals(authResponseExpect.getCreated().format(dateFormat),
            response.getBody().getCreated().format(dateFormat));
        Assertions.assertEquals(authResponseExpect.getLastLogin().format(dateFormat),
            response.getBody().getLastLogin().format(dateFormat));
        Assertions.assertEquals(authResponseExpect.getModified().format(dateFormat),
            response.getBody().getModified().format(dateFormat));
    }

    @Test
    void testAuthUserRegisterConflictEmailExist(){
        // GIVEN
        final var authRequest = AuthUserFixture.getAuthUserRegisterRqEmailExist();
        final var errorExpect = AuthUserFixture.getErrorMessageEmailExist();
        // WHEN
        final var response = client.postForEntity("/security/session/auth/register",
            authRequest, SimpleErrorResponse.class);
        // THEN
        Assertions.assertEquals(HttpStatus.CONFLICT, response.getStatusCode());
        Assertions.assertEquals(errorExpect.getMensaje(), response.getBody().getMensaje());
    }

    @Test
    void testAuthUserRegisterBadRequestEmailNotFormat(){
        // GIVEN
        final var authRequest = AuthUserFixture.getAuthUserRegisterRqEmailNotFormat();
        final var errorExpect = AuthUserFixture.getErrorMessageEmailNotFormat();
        // WHEN
        final var response = client.postForEntity("/security/session/auth/register",
            authRequest, SimpleErrorResponse.class);
        // THEN
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertEquals(errorExpect.getMensaje(), response.getBody().getMensaje());
    }

    @Test
    void testAuthUserRegisterBadRequestPasswordNotFormat(){
        // GIVEN
        final var authRequest = AuthUserFixture.getAuthUserRegisterRqPasswordNotFormat();
        final var errorExpect = AuthUserFixture.getErrorMessagePasswordNotFormat();
        // WHEN
        final var response = client.postForEntity("/security/session/auth/register",
            authRequest, SimpleErrorResponse.class);
        // THEN
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        Assertions.assertEquals(errorExpect.getMensaje(), response.getBody().getMensaje());
    }

}
