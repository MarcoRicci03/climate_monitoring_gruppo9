-- codici_operatori definition

-- Drop table

-- DROP TABLE codici_operatori;

CREATE TABLE codici_operatori (
	codice varchar(32) NOT NULL,
	CONSTRAINT codici_operatori_pkey PRIMARY KEY (codice)
);


-- nazioni definition

-- Drop table

-- DROP TABLE nazioni;

CREATE TABLE nazioni (
	country_code bpchar(2) NOT NULL,
	nome_nazione varchar(50) NULL,
	CONSTRAINT nazioni_pkey PRIMARY KEY (country_code)
);


-- stazioni definition

-- Drop table

-- DROP TABLE stazioni;

CREATE TABLE stazioni (
	geoname_id varchar(9) NOT NULL,
	nome varchar(32) NOT NULL,
	country_code bpchar(2) NOT NULL,
	latitudine numeric(8, 5) NOT NULL,
	longitudine numeric(8, 5) NOT NULL,
	CONSTRAINT stazioni_pkey PRIMARY KEY (geoname_id),
	CONSTRAINT stazioni_country_code_fkey FOREIGN KEY (country_code) REFERENCES nazioni(country_code) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- utenti definition

-- Drop table

-- DROP TABLE utenti;

CREATE TABLE utenti (
	id_utente int4 GENERATED ALWAYS AS IDENTITY( INCREMENT BY 1 MINVALUE 1 MAXVALUE 2147483647 START 1 CACHE 1 NO CYCLE) NOT NULL,
	nome varchar(32) NOT NULL,
	cognome varchar(32) NOT NULL,
	username varchar(32) NOT NULL,
	email varchar(50) NOT NULL,
	codice_operatore varchar(32) NOT NULL,
	codice_fiscale bpchar(16) NOT NULL,
	geoname_id varchar(9) NOT NULL,
	"password" bpchar(32) NOT NULL,
	CONSTRAINT utenti_pkey PRIMARY KEY (id_utente),
	CONSTRAINT utenti_unique UNIQUE (username),
	CONSTRAINT utenti_unique_1 UNIQUE (email),
	CONSTRAINT utenti_unique_2 UNIQUE (codice_fiscale),
	CONSTRAINT utenti_codice_operatore_fkey FOREIGN KEY (codice_operatore) REFERENCES codici_operatori(codice) ON DELETE RESTRICT ON UPDATE CASCADE,
	CONSTRAINT utenti_geoname_id_fkey FOREIGN KEY (geoname_id) REFERENCES stazioni(geoname_id) ON DELETE RESTRICT ON UPDATE CASCADE
);


-- aree_interesse definition

-- Drop table

-- DROP TABLE aree_interesse;

CREATE TABLE aree_interesse (
	id_area_interesse int4 NOT NULL,
	nome varchar(32) DEFAULT NULL::character varying NULL,
	geoname_id varchar(9) NOT NULL,
	CONSTRAINT area_interesse_pkey PRIMARY KEY (id_area_interesse, geoname_id),
	CONSTRAINT area_interesse_geoname_id_fkey FOREIGN KEY (geoname_id) REFERENCES stazioni(geoname_id) ON DELETE RESTRICT ON UPDATE CASCADE
);

-- DROP FUNCTION public.before_insert_area_interesse();

CREATE OR REPLACE FUNCTION public.before_insert_area_interesse()
 RETURNS trigger
 LANGUAGE plpgsql
AS $function$
DECLARE
    max_id INT;
BEGIN
    SELECT COALESCE(MAX(id_area_interesse), 0) INTO max_id FROM aree_interesse WHERE geoname_id = NEW.geoname_id;
    NEW.id_area_interesse := max_id + 1;
    RETURN NEW;
END;
$function$
;

-- Table Triggers

create trigger before_insert_area_interesse before
insert
    on
    aree_interesse for each row execute function before_insert_area_interesse();


-- DROP TYPE "enum_valore";

CREATE TYPE "enum_valore" AS ENUM (
	'1',
	'2',
	'3',
	'4',
	'5');

-- previsioni definition

-- Drop table

-- DROP TABLE previsioni;

CREATE TABLE previsioni (
	"data" date NOT NULL,
	geoname_id varchar(9) NOT NULL,
	id_area_interesse int4 NOT NULL,
	id_utente int4 NOT NULL,
	valorevento "enum_valore" NULL,
	notavento varchar(200) DEFAULT NULL::character varying NULL,
	valoreumidita "enum_valore" NULL,
	notaumidita varchar(200) DEFAULT NULL::character varying NULL,
	valorepressione "enum_valore" NULL,
	notapressione varchar(200) DEFAULT NULL::character varying NULL,
	valoretemperatura "enum_valore" NULL,
	notatemperatura varchar(200) DEFAULT NULL::character varying NULL,
	valoreprecipitazioni "enum_valore" NULL,
	notaprecipitazioni varchar(200) DEFAULT NULL::character varying NULL,
	valorealtghiacciai "enum_valore" NULL,
	notaaltghiacciai varchar(200) DEFAULT NULL::character varying NULL,
	valoremassaghiacciai "enum_valore" NULL,
	notamassaghiacciai varchar(200) DEFAULT NULL::character varying NULL,
	CONSTRAINT previsioni_pkey PRIMARY KEY (data, geoname_id, id_area_interesse),
	CONSTRAINT previsioni_geoname_id_id_area_interesse_fkey FOREIGN KEY (geoname_id,id_area_interesse) REFERENCES aree_interesse(geoname_id,id_area_interesse) ON DELETE CASCADE ON UPDATE CASCADE,
	CONSTRAINT previsioni_id_utente_utenti_id_utente_fkey FOREIGN KEY (id_utente) REFERENCES utenti(id_utente) ON DELETE RESTRICT ON UPDATE CASCADE
);
CREATE INDEX fki_f ON previsioni USING btree (id_utente);
CREATE INDEX fki_utenti_fk ON previsioni USING btree (id_utente);