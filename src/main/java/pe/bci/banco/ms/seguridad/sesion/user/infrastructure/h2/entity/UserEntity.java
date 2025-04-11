/*
 * @(#)UserEntity.java
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

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * UserEntity.
 *
 * @author Bryan Rosas.
 * @version 1.0.0, 10-04-2025
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "MSS_USER")
public class UserEntity {

    /** id. */
    @Id
    @Column(name = "ID")
    private UUID id;
    /** name. */
    @Column(name = "NAME")
    private String name;
    /** email. */
    @Column(name = "EMAIL")
    private String email;
    /** password. */
    @Column(name = "PASSWORD")
    private String password;
    /** active. */
    @Column(name = "ACTIVE")
    private Boolean active;
    /** lastLogin. */
    @Column(name = "LAST_LOGIN")
    private LocalDateTime lastLogin;
    /** createdAt. */
    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;
    /** updatedAt. */
    @Column(name = "UPDATED_AT")
    private LocalDateTime updatedAt;
    /** phones. */
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    List<PhoneEntity> phones;

}
