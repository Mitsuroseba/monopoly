--
-- PostgreSQL database dump
--

-- Dumped from database version 9.0.3
-- Dumped by pg_dump version 9.0.3
-- Started on 2011-11-17 00:00:27

SET statement_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = off;
SET check_function_bodies = false;
SET client_min_messages = warning;
SET escape_string_warning = off;

--
-- TOC entry 312 (class 2612 OID 11574)
-- Name: plpgsql; Type: PROCEDURAL LANGUAGE; Schema: -; Owner: postgres
--

CREATE OR REPLACE PROCEDURAL LANGUAGE plpgsql;


ALTER PROCEDURAL LANGUAGE plpgsql OWNER TO postgres;

SET search_path = public, pg_catalog;

--
-- TOC entry 1506 (class 1259 OID 24874)
-- Dependencies: 5
-- Name: statsuseridseq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE statsuseridseq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.statsuseridseq OWNER TO postgres;

--
-- TOC entry 1813 (class 0 OID 0)
-- Dependencies: 1506
-- Name: statsuseridseq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('statsuseridseq', 1, false);


SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 1507 (class 1259 OID 24876)
-- Dependencies: 1787 1788 1789 1790 1791 5
-- Name: stats; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE stats (
    id bigint DEFAULT nextval('statsuseridseq'::regclass) NOT NULL,
    user_id bigint NOT NULL,
    game_count integer DEFAULT 0 NOT NULL,
    victory_count integer DEFAULT 0 NOT NULL,
    leave_count integer DEFAULT 0 NOT NULL,
    points integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.stats OWNER TO postgres;

--
-- TOC entry 1504 (class 1259 OID 24855)
-- Dependencies: 5
-- Name: useridseq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE useridseq
    START WITH 0
    INCREMENT BY 1
    MINVALUE 0
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.useridseq OWNER TO postgres;

--
-- TOC entry 1814 (class 0 OID 0)
-- Dependencies: 1504
-- Name: useridseq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('useridseq', 0, false);


--
-- TOC entry 1505 (class 1259 OID 24857)
-- Dependencies: 1785 1786 5
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id bigint DEFAULT nextval('useridseq'::regclass) NOT NULL,
    email character varying NOT NULL,
    pass character varying(33) NOT NULL,
    nickname character varying(20) NOT NULL,
    sex boolean NOT NULL,
    avatar character varying(260) DEFAULT 'default.jpg'::character varying NOT NULL
);


ALTER TABLE public.users OWNER TO postgres;

--
-- TOC entry 1807 (class 0 OID 24876)
-- Dependencies: 1507
-- Data for Name: stats; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY stats (id, user_id, game_count, victory_count, leave_count, points) FROM stdin;
\.


--
-- TOC entry 1806 (class 0 OID 24857)
-- Dependencies: 1505
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (id, email, pass, nickname, sex, avatar) FROM stdin;
\.


--
-- TOC entry 1804 (class 2606 OID 24885)
-- Dependencies: 1507 1507
-- Name: statsid; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY stats
    ADD CONSTRAINT statsid PRIMARY KEY (id);


--
-- TOC entry 1795 (class 2606 OID 24870)
-- Dependencies: 1505 1505
-- Name: unicemail; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT unicemail UNIQUE (email);


--
-- TOC entry 1797 (class 2606 OID 24868)
-- Dependencies: 1505 1505
-- Name: unicnickname; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT unicnickname UNIQUE (nickname);


--
-- TOC entry 1800 (class 2606 OID 24866)
-- Dependencies: 1505 1505
-- Name: userpk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT userpk PRIMARY KEY (id);


--
-- TOC entry 1792 (class 1259 OID 24872)
-- Dependencies: 1505
-- Name: emailindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX emailindex ON users USING btree (email);


--
-- TOC entry 1801 (class 1259 OID 24891)
-- Dependencies: 1507
-- Name: fki_user_idfk; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE INDEX fki_user_idfk ON stats USING btree (user_id);


--
-- TOC entry 1802 (class 1259 OID 24892)
-- Dependencies: 1507
-- Name: idindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX idindex ON stats USING btree (id);


--
-- TOC entry 1793 (class 1259 OID 24873)
-- Dependencies: 1505
-- Name: nicknameindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX nicknameindex ON users USING btree (nickname);


--
-- TOC entry 1798 (class 1259 OID 24871)
-- Dependencies: 1505
-- Name: useridindex; Type: INDEX; Schema: public; Owner: postgres; Tablespace: 
--

CREATE UNIQUE INDEX useridindex ON users USING btree (id);


--
-- TOC entry 1805 (class 2606 OID 24886)
-- Dependencies: 1799 1507 1505
-- Name: user_idfk; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY stats
    ADD CONSTRAINT user_idfk FOREIGN KEY (user_id) REFERENCES users(id) MATCH FULL ON UPDATE CASCADE ON DELETE CASCADE;


--
-- TOC entry 1812 (class 0 OID 0)
-- Dependencies: 5
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2011-11-17 00:00:28

--
-- PostgreSQL database dump complete
--

