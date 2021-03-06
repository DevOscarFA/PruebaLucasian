--Crear la tabla Administrador
CREATE TABLE ADMINISTRADOR (
  ID            NUMBER(5)    NOT NULL,
  CODIGO        VARCHAR2(20)  NOT NULL,
  NOMBRE        VARCHAR2(200)  NOT NULL,
  COD_TP_ID     VARCHAR2(2)  NOT NULL,
  NRO_ID        VARCHAR2(50)  NOT NULL,
  NATURALEZA    VARCHAR2(20)  NOT NULL,
  MULTIPLE_ARP  NUMBER(1)  NOT NULL,
  FSP           NUMBER(1)  NOT NULL,
  FUSIONADA     NUMBER(1)  NOT NULL,
  FECHA_FUSION  DATE  NOT NULL
);

--Se crea la llave primaria 
ALTER TABLE ADMINISTRADOR ADD (
CONSTRAINT PK_ADMINISTRADOR_ID PRIMARY KEY (ID));

--Se crea la secuencia
CREATE SEQUENCE SQ_ADMINISTRADOR START WITH 1;

--Se ingresan registros de prueba
INSERT INTO ADMINISTRADOR
(
    ID,
    CODIGO,
    NOMBRE,
    COD_TP_ID,
    NRO_ID,
    NATURALEZA,
    MULTIPLE_ARP,
    FSP,
    FUSIONADA,
    FECHA_FUSION
) 
    VALUES 
(
    SQ_ADMINISTRADOR.NextVal,
    'Q1',
    'OSCAR',
    'NI',
    '10709',
    'MIXTA',
    1,
    0,
    1,
    TO_DATE('15062017', 'ddmmyyyy')
);
