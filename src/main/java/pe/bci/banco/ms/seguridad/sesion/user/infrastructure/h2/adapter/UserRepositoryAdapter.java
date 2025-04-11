/*
 * @(#)UserRepositoryAdapter.java
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
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.model.AuthUserRegisterRq;
import pe.bci.banco.ms.seguridad.sesion.user.domain.model.UserRs;
import pe.bci.banco.ms.seguridad.sesion.user.domain.repository.UserRepositoryPort;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.mapper.UserMapper;
import pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.repository.UserJpaRepository;

/**
 * UserRepositoryAdapter.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Component
@RequiredArgsConstructor
public class UserRepositoryAdapter implements UserRepositoryPort {

    /** userJpaRepository. */
    private final UserJpaRepository userJpaRepository;
    /** userMapper. */
    private final UserMapper userMapper = Mappers.getMapper(UserMapper.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<UserRs> findByEmail(final String email) {
        return this.userJpaRepository.findByEmail(email)
            .map(userMapper::entityToResponse);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UserRs save(final AuthUserRegisterRq userRequest) {
        final var userEntity = this.userMapper.requestToEntity(userRequest);
        userEntity.setPhones(userEntity.getPhones().stream()
            .map(p -> {
                p.setUser(userEntity);
                return p;
            }).toList());
        return this.userMapper.entityToResponse(this.userJpaRepository.save(userEntity));
    }

}
