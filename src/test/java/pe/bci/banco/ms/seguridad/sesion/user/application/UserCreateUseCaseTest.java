/*
 * @(#)UserCreateUseCaseTest.java
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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.bci.banco.ms.seguridad.sesion.auth.fixture.AuthUserFixture;
import pe.bci.banco.ms.seguridad.sesion.user.domain.repository.UserRepositoryPort;
import pe.bci.banco.ms.seguridad.sesion.user.fixture.UserFixture;

/**
 * UserCreateUseCaseTest.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
class UserCreateUseCaseTest {

    /** userRepositoryPort. */
    @Mock
    private UserRepositoryPort userRepositoryPort;
    /** userCreateUseCase. */
    @InjectMocks
    private UserCreateUseCase userCreateUseCase;

    /**
     * Set up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createUser() {
        // GIVEN
        final var userRegister = AuthUserFixture.getAuthUserRegisterRqSuccess();
        Mockito.when(this.userRepositoryPort.save(userRegister))
            .thenReturn(UserFixture.getUserRs());
        // WHEN
        final var userRs = this.userCreateUseCase.createUser(userRegister);
        // THEN
        Assertions.assertNotNull(userRs);
        Assertions.assertEquals(userRegister.getEmail(), userRs.getEmail());
    }

}
