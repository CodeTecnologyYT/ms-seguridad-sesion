/*
 * @(#)PhoneEntity.java
 *
 * Copyright (c) BCI (Chile). All rights reserved.
 *
 * All rights to this product are owned by BCI and may only
 * be used under the terms of its associated license document. You may NOT
 * copy, modify, sublicense, or distribute this source file or portions of
 * it unless previously authorized in writing by BCI.
 * In any event, this notice and the above copyright must always be included
 * verbatim with this file.
 */
package pe.bci.banco.ms.seguridad.sesion.user.infrastructure.h2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * PhoneEntity.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "MSS_PHONE")
public class PhoneEntity {

    /** id. */
    @Id
    @Column(name = "ID")
    private UUID id;
    /** phoneNumber. */
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    /** typePhone. */
    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private TypePhone typePhone;
    /** cityCode. */
    @Column(name = "CITY_CODE")
    private String cityCode;
    /** countryCode. */
    @Column(name = "COUNTRY_CODE")
    private String countryCode;
    /** active. */
    @Column(name = "ACTIVE")
    private Boolean active;
    /** createdAt. */
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    /** updatedAt. */
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
    /** user. */
    @ManyToOne
    @JoinColumn(name = "ID_USER", nullable = false)
    private UserEntity user;

}
