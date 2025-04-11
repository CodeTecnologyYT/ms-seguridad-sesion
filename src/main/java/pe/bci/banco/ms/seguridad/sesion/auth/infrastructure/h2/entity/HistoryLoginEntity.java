/*
 * @(#)HistoryLoginEntity.java
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
package pe.bci.banco.ms.seguridad.sesion.auth.infrastructure.h2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * HistoryLoginEntity.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 11-04-2025
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "MSS_HISTORY_LOGIN")
public class HistoryLoginEntity {

    /** id. */
    @Id
    @Column(name = "ID", nullable = false)
    private UUID id;
    /** email. */
    @Column(name = "EMAIL", nullable = false)
    private String email;
    /** loginTime. */
    @Column(name = "LOGIN_TIME", nullable = false)
    private LocalDateTime loginTime;
    /** ipAddress. */
    @Column(name = "IP_ADDRESS", nullable = false)
    private String ipAddress;


}
