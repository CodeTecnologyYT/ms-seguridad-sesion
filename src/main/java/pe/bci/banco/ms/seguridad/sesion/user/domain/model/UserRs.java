/*
 * @(#)UserRs.java
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
package pe.bci.banco.ms.seguridad.sesion.user.domain.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * UserRs.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRs {

    /** id. */
    private UUID id;
    /** name. */
    private String name;
    /** email. */
    private String email;
    /** password. */
    private String password;
    /** active. */
    private Boolean active;
    /** lastLogin. */
    private LocalDateTime lastLogin;
    /** createdAt. */
    private LocalDateTime createdAt;
    /** updatedAt. */
    private LocalDateTime updatedAt;
    /** phones. */
    List<PhoneRs> phones;

}
