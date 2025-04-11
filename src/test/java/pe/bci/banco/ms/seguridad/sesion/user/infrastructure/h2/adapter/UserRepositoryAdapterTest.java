/*
 * @(#)UserRepositoryAdapterTest.java
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
package pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.adapter;

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
import pe.bci.banco.ms.seguridad.sesion.auth.fixture.AuthUserFixture;
import pe.bci.banco.ms.seguridad.sesion.user.fixture.UserFixture;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.entity.UserEntity;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.repository.UserJpaRepository;

/**
 * UserRepositoryAdapterTest.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
public class UserRepositoryAdapterTest {

    /** userJpaRepository. */
    @Mock
    private UserJpaRepository userJpaRepository;
    /** userRepositoryAdapter. */
    @InjectMocks
    private UserRepositoryAdapter userRepositoryAdapter;

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
    void testFindByEmail() {
        // GIVEN
        Mockito.when(this.userJpaRepository.findByEmail(ArgumentMatchers.anyString()))
            .thenReturn(Optional.of(UserFixture.getUserEntity()));
        // WHEN
        final var user = this.userRepositoryAdapter.findByEmail(UserFixture.TEST_EMAIL);
        // THEN
        Mockito.verify(this.userJpaRepository, Mockito.times(1))
            .findByEmail(UserFixture.TEST_EMAIL);
        Assertions.assertTrue(user.isPresent());
        Assertions.assertEquals(UserFixture.TEST_EMAIL, user.get().getEmail());
    }

    /**
     * Test.
     */
    @Test
    void testSave() {
        // GIVEN
        Mockito.when(this.userJpaRepository.save(ArgumentMatchers.any(UserEntity.class)))
            .thenReturn(UserFixture.getUserEntity());
        // WHEN
        final var user = this.userRepositoryAdapter.save(AuthUserFixture.getAuthUserRegisterRqEmailExist());
        // THEN
        Mockito.verify(this.userJpaRepository, Mockito.times(1))
            .save(ArgumentMatchers.any(UserEntity.class));
        Assertions.assertEquals(UserFixture.TEST_EMAIL, user.getEmail());
    }

}
