/*
 * @(#)AuthUserRegisterRs.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * AuthUserRegisterRs.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthUserRegisterRs {

    /** id. */
    private UUID id;
    /** created. */
    private LocalDateTime created;
    /** modified. */
    private LocalDateTime modified;
    /** lastLogin. */
    private LocalDateTime lastLogin;
    /** token. */
    private String token;
    /** isactive. */
    private Boolean isactive;

}
