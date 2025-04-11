/*
 * @(#)AuthUserUserRegisterUseCaseTest.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.application;

import io.micrometer.core.instrument.Counter;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.provider.EncryptProviderPort;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.provider.JwtProviderPort;
import pe.bci.banco.ms.seguridad.sesion.auth.fixture.AuthUserFixture;
import pe.bci.banco.ms.seguridad.sesion.shared.exceptions.SimpleException;
import pe.bci.banco.ms.seguridad.sesion.user.application.IUserCreateUseCase;
import pe.bci.banco.ms.seguridad.sesion.user.application.IUserFindUseCase;
import pe.bci.banco.ms.seguridad.sesion.user.fixture.UserFixture;

/**
 * AuthUserUserRegisterUseCaseTest.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
class AuthUserUserRegisterUseCaseTest {

    /** userFindUseCase. */
    @Mock
    private IUserFindUseCase userFindUseCase;
    /** userCreateUseCase. */
    @Mock
    private IUserCreateUseCase userCreateUseCase;
    /** encryptProvider. */
    @Mock
    private EncryptProviderPort encryptProviderPort;
    /** jwtProvider. */
    @Mock
    private JwtProviderPort jwtProviderPort;
    /** loginCounter. */
    @Mock
    private Counter loginCounter;
    /** authUserUserRegisterUseCase. */
    @InjectMocks
    private AuthUserUserRegisterUseCase authUserUserRegisterUseCase;

    /**
     * setUp.
     */
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /**
     * Test.
     */
    @Test
    void testRegisterSuccess(){
        // GIVEN
        Mockito.when(this.userFindUseCase.findOptionalByEmail(ArgumentMatchers.anyString()))
            .thenReturn(Optional.empty());
        Mockito.when(this.userCreateUseCase.createUser(ArgumentMatchers.any(AuthUserRegisterRq.class)))
            .thenReturn(UserFixture.getUserRs());
        Mockito.when(this.encryptProviderPort.encrypt(ArgumentMatchers.anyString()))
            .thenReturn(AuthUserFixture.TEST_PASSWORD);
        Mockito.when(this.jwtProviderPort.generateToken(ArgumentMatchers.any()))
            .thenReturn(AuthUserFixture.TEST_TOKEN);
        Mockito.doNothing().when(this.loginCounter).increment();
        // WHEN
        final var response = this.authUserUserRegisterUseCase.register(
            AuthUserFixture.getAuthUserRegisterRqEmailExist());
        // THEN
        Mockito.verify(this.userFindUseCase, Mockito.times(1))
            .findOptionalByEmail(ArgumentMatchers.anyString());
        Mockito.verify(this.userCreateUseCase, Mockito.times(1))
            .createUser(ArgumentMatchers.any(AuthUserRegisterRq.class));
        Mockito.verify(this.encryptProviderPort, Mockito.times(1))
            .encrypt(ArgumentMatchers.anyString());
        Mockito.verify(this.jwtProviderPort, Mockito.times(1))
            .generateToken(ArgumentMatchers.any());
        Assertions.assertNotNull(response);
        Assertions.assertEquals(AuthUserFixture.TEST_TOKEN, response.getToken());
    }

    /**
     * Test.
     */
    @Test
    void testRegisterUserExist(){
        // GIVEN
        final var request = AuthUserFixture.getAuthUserRegisterRqEmailExist();
        Mockito.when(this.userFindUseCase.findOptionalByEmail(ArgumentMatchers.anyString()))
            .thenReturn(Optional.of(UserFixture.getUserRs()));
        // THEN
        Assertions.assertThrows(
            SimpleException.class, () -> this.authUserUserRegisterUseCase.register(request));
    }

}
