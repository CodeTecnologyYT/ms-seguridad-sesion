/*
 * @(#)EncryptProvider.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.encript.provider;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pe.bci.banco.ms.seguridad.sesion.auth.domain.provider.EncryptProviderPort;

/**
 * EncryptProvider.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Component
@RequiredArgsConstructor
public class EncryptProvider implements EncryptProviderPort {

    /** passwordEncoder. */
    private final PasswordEncoder passwordEncoder;

    /**
     * {@inheritDoc}
     */
    public String encrypt(final String password) {
        return passwordEncoder.encode(password);
    }

}
