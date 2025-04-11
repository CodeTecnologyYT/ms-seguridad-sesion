/*
 * @(#)UserFindUseCaseTest.java
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

import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.bci.banco.ms.seguridad.sesion.user.domain.repository.UserRepositoryPort;
import pe.bci.banco.ms.seguridad.sesion.user.fixture.UserFixture;

/**
 * UserFindUseCaseTest.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
class UserFindUseCaseTest {

    /** userRepositoryPort. */
    @Mock
    private UserRepositoryPort userRepositoryPort;
    /** userFindUseCase. */
    @InjectMocks
    private UserFindUseCase userFindUseCase;

    /**
     * Set up.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test.
     */
    @Test
    void findByEmail(){
        // GIVEN
        final var email = UserFixture.TEST_EMAIL;
        Mockito.when(this.userRepositoryPort.findByEmail(email))
            .thenReturn(Optional.of(UserFixture.getUserRs()));
        // WHEN
        final var userRs = this.userFindUseCase.findByEmail(email);
        // THEN
        Mockito.verify(this.userRepositoryPort, Mockito.times(1)).findByEmail(email);
        Assertions.assertNotNull(userRs);
        Assertions.assertEquals(email, userRs.getEmail());
    }

    /**
     * Test.
     */
    @Test
    void findOptionalByEmail(){
        // GIVEN
        final var email = UserFixture.TEST_EMAIL;
        Mockito.when(this.userRepositoryPort.findByEmail(email))
            .thenReturn(Optional.of(UserFixture.getUserRs()));
        // WHEN
        final var userRs = this.userFindUseCase.findOptionalByEmail(email);
        // THEN
        Mockito.verify(this.userRepositoryPort, Mockito.times(1)).findByEmail(email);
        Assertions.assertTrue(userRs.isPresent());
        Assertions.assertEquals(email, userRs.get().getEmail());
    }

}
