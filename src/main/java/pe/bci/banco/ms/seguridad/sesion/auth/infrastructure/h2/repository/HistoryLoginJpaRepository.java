/*
 * @(#)HistoryLoginJpaRepository.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.h2.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.h2.entity.HistoryLoginEntity;

/**
 * HistoryLoginJpaRepository.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 11-04-2025
 */
public interface HistoryLoginJpaRepository extends JpaRepository<HistoryLoginEntity, UUID> {
}