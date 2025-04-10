-- Creacion de la tabla de usuarios
CREATE TABLE MSS_USER
(
    ID         VARCHAR(255) NOT NULL PRIMARY KEY COMMENT 'UUID del usuario',
    EMAIL      VARCHAR(255) NOT NULL COMMENT 'Correo electrónico',
    PASSWORD   VARCHAR(255) NOT NULL COMMENT 'Contraseña encriptada',
    ACTIVE     BOOLEAN   DEFAULT TRUE COMMENT 'Estado activo/inactivo',
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de creación',
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha de modificación'
);
-- Creacion de la tabla de phone
CREATE TABLE MSS_PHONE
(
    ID           VARCHAR(255) NOT NULL PRIMARY KEY COMMENT 'UUID del telefono',
    ID_USER      VARCHAR(255) NOT NULL COMMENT 'UUID del usuario',
    NUMBER_PHONE VARCHAR(255) NOT NULL COMMENT 'Número de teléfono',
    TYPE         VARCHAR(50)  NOT NULL COMMENT 'Tipo de teléfono (Móvil, Fijo)',
    CITYCODE     VARCHAR(10)  NOT NULL COMMENT 'Codigo de ciudad',
    COUNTRYCODE  VARCHAR(10)  NOT NULL COMMENT 'Codigo de pais',
    ACTIVE       BOOLEAN   DEFAULT TRUE COMMENT 'Estado activo/inactivo',
    CREATED_AT   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de creación',
    UPDATED_AT   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha de modificación'
);
