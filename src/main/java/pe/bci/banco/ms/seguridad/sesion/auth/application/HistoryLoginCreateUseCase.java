/*
 * @(#)HistoryLoginCreateUseCase.java
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

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.repository.HistoryLoginRepositoryPort;

/**
 * HistoryLoginCreateUseCase.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 11-04-2025
 */
@Component
@RequiredArgsConstructor
public class HistoryLoginCreateUseCase implements IHistoryLoginCreateUseCase{

    /** historyLoginRepositoryPort. */
    private final HistoryLoginRepositoryPort historyLoginRepositoryPort;

    @Override
    public void createHistoryLogin(final String username, final String ipAddress, final LocalDateTime loginTime) {
        this.historyLoginRepositoryPort.save(username, ipAddress, null);
    }

}
