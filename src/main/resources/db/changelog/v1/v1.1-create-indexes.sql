-- Creamos un indice para la tabla MSS_USER para buscar por correo electrónico
CREATE INDEX IDX_MSS_USER_EMAIL ON MSS_USER (EMAIL);

-- Creamos un indice para la tabla MSS_USER para buscar por numero de telefono
CREATE INDEX IDX_MSS_USER_PHONE ON MSS_PHONE (PHONE_NUMBER);

-- Creamos un indice para la tabla MSS_PHONE para buscar por id de usuario y numero de telefono
CREATE INDEX IDX_MSS_USER_PHONE_IDUSER ON MSS_PHONE (ID_USER, PHONE_NUMBER);