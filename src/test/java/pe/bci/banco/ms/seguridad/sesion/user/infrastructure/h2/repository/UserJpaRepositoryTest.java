/*
 * @(#)UserJpaRepositoryTest.java
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
package pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import pe.bci.banco.ms.seguridad.sesion.user.fixture.UserFixture;

/**
 * UserJpaRepositoryTest.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@DataJpaTest
@Sql("classpath:sql/v1/v1.0-insert-data.sql")
class UserJpaRepositoryTest {

    /** userJpaRepository. */
    @Autowired
    private UserJpaRepository userJpaRepository;

    /**
     * Test.
     */
    @Test
    void testFindByEmail() {
        // GIVEN
        final var email = UserFixture.TEST_EMAIL;
        // WHEN
        final var userEntity = userJpaRepository.findByEmail(email);
        // THEN
        Assertions.assertTrue(userEntity.isPresent());
    }

}
