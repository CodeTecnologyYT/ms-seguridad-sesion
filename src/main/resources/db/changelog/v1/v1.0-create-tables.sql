-- Creacion de la tabla de usuarios
CREATE TABLE MSS_USER
(
    ID         VARCHAR(255) NOT NULL PRIMARY KEY COMMENT 'UUID del usuario',
    NAME       VARCHAR(255) NOT NULL COMMENT 'Nombre del usuario',
    EMAIL      VARCHAR(255) NOT NULL COMMENT 'Correo electrónico',
    PASSWORD   VARCHAR(255) NOT NULL COMMENT 'Contraseña encriptada',
    ACTIVE     BOOLEAN   DEFAULT TRUE COMMENT 'Estado activo/inactivo',
    LAST_LOGIN TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Ultimo inicio de sesión',
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de creación',
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha de modificación'
);
-- Creacion de la tabla de phone
CREATE TABLE MSS_PHONE
(
    ID           VARCHAR(255) NOT NULL PRIMARY KEY COMMENT 'UUID del telefono',
    ID_USER      VARCHAR(255) NOT NULL COMMENT 'UUID del usuario',
    PHONE_NUMBER VARCHAR(255) NOT NULL COMMENT 'Número de teléfono',
    TYPE         VARCHAR(50)  NOT NULL COMMENT 'Tipo de teléfono (Móvil, Fijo)',
    CITY_CODE    VARCHAR(10)  NOT NULL COMMENT 'Codigo de ciudad',
    COUNTRY_CODE VARCHAR(10)  NOT NULL COMMENT 'Codigo de pais',
    ACTIVE       BOOLEAN   DEFAULT TRUE COMMENT 'Estado activo/inactivo',
    CREATED_AT   TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Fecha de creación',
    UPDATED_AT   TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'Fecha de modificación'
);
-- Creacion de la tabla de historial de login
CREATE TABLE MSS_HISTORY_LOGIN
(
    ID         VARCHAR(255) NOT NULL PRIMARY KEY COMMENT 'UUID del historial de login',
    EMAIL      VARCHAR(255) NOT NULL COMMENT 'Correo electrónico',
    LOGIN_TIME TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT 'Ultimo inicio de sesión',
    IP_ADDRESS VARCHAR(255) NOT NULL COMMENT 'Dirección IP del usuario'
);
