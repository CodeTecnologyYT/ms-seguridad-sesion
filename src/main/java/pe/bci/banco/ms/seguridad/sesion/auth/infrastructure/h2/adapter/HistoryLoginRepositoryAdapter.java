/*
 * @(#)HistoryLoginRepositoryAdapter.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.h2.adapter;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.repository.HistoryLoginRepositoryPort;
import pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.h2.entity.HistoryLoginEntity;
import pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.h2.mapper.HistoryLoginMapper;
import pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.h2.repository.HistoryLoginJpaRepository;

/**
 * HistoryLoginRepositoryAdapter.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 11-04-2025
 */
@Component
@RequiredArgsConstructor
public class HistoryLoginRepositoryAdapter implements HistoryLoginRepositoryPort {

    /** historyLoginJpaRepository. */
    private final HistoryLoginJpaRepository historyLoginJpaRepository;
    /** historyLoginMapper. */
    private final HistoryLoginMapper historyLoginMapper = Mappers.getMapper( HistoryLoginMapper.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(final String username, final String ipAddress, final LocalDateTime loginTime) {
        this.historyLoginJpaRepository.save(
            this.historyLoginMapper.toHistoryLoginEntity(username, ipAddress, loginTime)
        );
    }

}
