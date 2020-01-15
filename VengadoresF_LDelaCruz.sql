--LDelaCruz
drop table "VENGF"."PROFESIONAL";
drop table "VENGF"."SERVICIO";
drop table "VENGF"."CLIENTE" ;

--SEQUENCIAS
drop sequence "VENGF"."SERV_SEQ";
drop sequence "VENGF"."SERV_TIPO_SEQ";
drop sequence "VENGF"."CLIENTE_SEQ";
drop sequence "VENGF"."PROFESIONAL_SEQ";

-- tables
-- Table: CLIENTE
CREATE TABLE CLIENTE (
    CODCLIE integer  NOT NULL,
    NOMBCLIE varchar2(50)  NULL,
    ESTCLIE varchar2(1)  DEFAULT 'A' NULL,
    CONSTRAINT CLIENTE_pk PRIMARY KEY (CODCLIE)
) ;

-- Table: PROFESIONAL
CREATE TABLE PROFESIONAL (
    CODPROF integer  NOT NULL,
    TIPPROF varchar2(100)  NULL,
    PREPROF varchar2(10)  NULL,
    ESTPROF varchar2(1)  DEFAULT 'A' NULL,
    CONSTRAINT PROFESIONAL_pk PRIMARY KEY (CODPROF)
) ;

-- Table: SERVICIO
CREATE TABLE SERVICIO (
    CODSERV integer  NOT NULL,
    CODCLIE integer  NOT NULL,
    CODPROF integer  NOT NULL,
    CODTIPSERV integer  NOT NULL,
    TOTPRESERV varchar2(10)  NULL,
    CONSTRAINT SERVICIO_pk PRIMARY KEY (CODSERV)
) ;

-- Table: TIPO_SERV
CREATE TABLE TIPO_SERV (
    CODTIPSERV integer  NOT NULL,
    NOMTIPSERV varchar2(100)  NULL,
    SUBTIPSERV varchar2(50)  NULL,
    PRETIPSERV varchar2(10)  NULL,
    ESTTIPSERV varchar2(10)  NULL,
    BARTIPSERV varchar2(10)  NULL,
    INSTIPSERV varchar2(10)  NULL,
    CONSTRAINT TIPO_SERV_pk PRIMARY KEY (CODTIPSERV)
) ;

-- foreign keys
-- Reference: SERVICIO_CLIENTE (table: SERVICIO)
ALTER TABLE SERVICIO ADD CONSTRAINT SERVICIO_CLIENTE
    FOREIGN KEY (CODCLIE)
    REFERENCES CLIENTE (CODCLIE);

-- Reference: SERVICIO_PROFESIONAL (table: SERVICIO)
ALTER TABLE SERVICIO ADD CONSTRAINT SERVICIO_PROFESIONAL
    FOREIGN KEY (CODPROF)
    REFERENCES PROFESIONAL (CODPROF);

-- Reference: SERVICIO_TIPO_SERV (table: SERVICIO)
ALTER TABLE SERVICIO ADD CONSTRAINT SERVICIO_TIPO_SERV
    FOREIGN KEY (CODTIPSERV)
    REFERENCES TIPO_SERV (CODTIPSERV);

-- sequences
-- Sequence: Cliente_Seq
CREATE SEQUENCE Cliente_Seq
      START WITH 1
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 100000;

-- Sequence: Profesional_Seq
CREATE SEQUENCE Profesional_Seq
      START WITH 1
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 100000;

-- Sequence: Serv_Seq
CREATE SEQUENCE Serv_Seq
      START WITH 1
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 100000;

-- Sequence: Serv_Tipo_Seq
CREATE SEQUENCE Serv_Tipo_Seq
      START WITH 1
      INCREMENT BY 1
      MINVALUE 1
      MAXVALUE 100000;

CREATE TRIGGER "CLIENTE_TRG"
   before insert on "CLIENTE"
   for each row
begin 
   if inserting then
      if :NEW."CODCLIE" is null then
         select Cliente_Seq.nextval into :NEW."CODCLIE" from dual;
      end if;
   end if;
end;

CREATE TRIGGER "PROFESIONAL_TRG"
   before insert on "PROFESIONAL"
   for each row
begin 
   if inserting then
      if :NEW."CODPROF" is null then
         select Profesional_Seq.nextval into :NEW."CODPROF" from dual;
      end if;
   end if;
end;

CREATE TRIGGER "SERVICIO_TIPO_TRG"
   before insert on "TIPO_SERV"
   for each row
begin 
   if inserting then
      if :NEW."CODTIPSERV" is null then
         select Serv_Tipo_Seq.nextval into :NEW."CODTIPSERV" from dual;
      end if;
   end if;
end;

CREATE TRIGGER "SERVICIO_TRG"
   before insert on "SERVICIO"
   for each row
begin 
   if inserting then
      if :NEW."CODSERV" is null then
         select Serv_Seq.nextval into :NEW."CODSERV" from dual;
      end if;
   end if;
end;


-- End of file.




