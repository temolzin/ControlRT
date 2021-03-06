PGDMP         2                u           reportetecnico    9.6.4    9.6.4 S    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            �           1262    16402    reportetecnico    DATABASE     �   CREATE DATABASE reportetecnico WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Spanish_Mexico.1252' LC_CTYPE = 'Spanish_Mexico.1252';
    DROP DATABASE reportetecnico;
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            �           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    3                        3079    12387    plpgsql 	   EXTENSION     ?   CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;
    DROP EXTENSION plpgsql;
                  false            �           0    0    EXTENSION plpgsql    COMMENT     @   COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';
                       false    1            �           1247    16404    parcial    TYPE     ;   CREATE TYPE parcial AS ENUM (
    '1',
    '2',
    '3'
);
    DROP TYPE public.parcial;
       public       postgres    false    3            �            1259    16411    admin    TABLE     �   CREATE TABLE admin (
    matricula bigint NOT NULL,
    nombre character varying(30),
    ap_pat character varying(25),
    ap_mat character varying(25),
    password character varying(20),
    telefono bigint,
    correo character varying(50)
);
    DROP TABLE public.admin;
       public         postgres    false    3            �            1259    16414    alumno    TABLE     �  CREATE TABLE alumno (
    matricula bigint NOT NULL,
    nombre character varying(30),
    ap_pat character varying(25),
    ap_mat character varying(25),
    password character varying(20),
    telefono bigint,
    correo character varying(50),
    proyecto character varying(50),
    division character varying(5),
    carrera text,
    periodocuatrimestral character varying(80),
    id_asesorind integer NOT NULL,
    id_asesoraca bigint
);
    DROP TABLE public.alumno;
       public         postgres    false    3            �            1259    16420    alumno_id_asesorind_seq    SEQUENCE     y   CREATE SEQUENCE alumno_id_asesorind_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.alumno_id_asesorind_seq;
       public       postgres    false    3    186            �           0    0    alumno_id_asesorind_seq    SEQUENCE OWNED BY     E   ALTER SEQUENCE alumno_id_asesorind_seq OWNED BY alumno.id_asesorind;
            public       postgres    false    187            �            1259    16422 	   asesoraca    TABLE     �   CREATE TABLE asesoraca (
    matricula bigint NOT NULL,
    nombre character varying(30),
    ap_pat character varying(25),
    ap_mat character varying(25),
    correo character varying(50),
    telefono bigint,
    password character varying(20)
);
    DROP TABLE public.asesoraca;
       public         postgres    false    3            �            1259    16425    matriculaind    SEQUENCE     �   CREATE SEQUENCE matriculaind
    START WITH 10000
    INCREMENT BY 1
    MINVALUE 100
    MAXVALUE 999999
    CACHE 1
    CYCLE;
 #   DROP SEQUENCE public.matriculaind;
       public       postgres    false    3            �            1259    16427 	   asesorind    TABLE     L  CREATE TABLE asesorind (
    id_asesorind integer DEFAULT nextval('matriculaind'::regclass) NOT NULL,
    nombre character varying(30),
    ap_pat character varying(25),
    ap_mat character varying(25),
    empresa character varying(35),
    correo character varying(50),
    telefono bigint,
    password character varying(20)
);
    DROP TABLE public.asesorind;
       public         postgres    false    189    3            �            1259    16431    asesorind_id_asesorind_seq    SEQUENCE     |   CREATE SEQUENCE asesorind_id_asesorind_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 1   DROP SEQUENCE public.asesorind_id_asesorind_seq;
       public       postgres    false    3    190            �           0    0    asesorind_id_asesorind_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE asesorind_id_asesorind_seq OWNED BY asesorind.id_asesorind;
            public       postgres    false    191            �            1259    16433    avancesalumno    TABLE     �   CREATE TABLE avancesalumno (
    id_avance integer NOT NULL,
    matriculaalumno bigint NOT NULL,
    nosemana integer NOT NULL,
    avance text
);
 !   DROP TABLE public.avancesalumno;
       public         postgres    false    3            �            1259    16439    avancesalumno_id_avance_seq    SEQUENCE     }   CREATE SEQUENCE avancesalumno_id_avance_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.avancesalumno_id_avance_seq;
       public       postgres    false    192    3            �           0    0    avancesalumno_id_avance_seq    SEQUENCE OWNED BY     M   ALTER SEQUENCE avancesalumno_id_avance_seq OWNED BY avancesalumno.id_avance;
            public       postgres    false    193            �            1259    16441    evaluacionaca    TABLE     �   CREATE TABLE evaluacionaca (
    id_evaluacionaca integer NOT NULL,
    matriculaalumno bigint NOT NULL,
    id_asesoraca bigint,
    parcial parcial NOT NULL,
    saber integer,
    hacer integer,
    ser integer
);
 !   DROP TABLE public.evaluacionaca;
       public         postgres    false    3    496            �            1259    16444 "   evaluacionaca_id_evaluacionaca_seq    SEQUENCE     �   CREATE SEQUENCE evaluacionaca_id_evaluacionaca_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.evaluacionaca_id_evaluacionaca_seq;
       public       postgres    false    194    3            �           0    0 "   evaluacionaca_id_evaluacionaca_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE evaluacionaca_id_evaluacionaca_seq OWNED BY evaluacionaca.id_evaluacionaca;
            public       postgres    false    195            �            1259    16446    evaluacionind    TABLE     �   CREATE TABLE evaluacionind (
    id_evaluacionind integer NOT NULL,
    matriculaalumno bigint NOT NULL,
    id_asesorind integer NOT NULL,
    parcial parcial NOT NULL,
    saber integer,
    hacer integer,
    ser integer
);
 !   DROP TABLE public.evaluacionind;
       public         postgres    false    3    496            �            1259    16449    evaluacionind_id_asesorind_seq    SEQUENCE     �   CREATE SEQUENCE evaluacionind_id_asesorind_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.evaluacionind_id_asesorind_seq;
       public       postgres    false    3    196            �           0    0    evaluacionind_id_asesorind_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE evaluacionind_id_asesorind_seq OWNED BY evaluacionind.id_asesorind;
            public       postgres    false    197            �            1259    16451 "   evaluacionind_id_evaluacionind_seq    SEQUENCE     �   CREATE SEQUENCE evaluacionind_id_evaluacionind_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 9   DROP SEQUENCE public.evaluacionind_id_evaluacionind_seq;
       public       postgres    false    3    196            �           0    0 "   evaluacionind_id_evaluacionind_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE evaluacionind_id_evaluacionind_seq OWNED BY evaluacionind.id_evaluacionind;
            public       postgres    false    198            �            1259    16453    observacionesaca    TABLE     �   CREATE TABLE observacionesaca (
    id_observacionaca integer NOT NULL,
    matriculaalumno bigint,
    id_asesoraca bigint NOT NULL,
    nosemana integer NOT NULL,
    observacionaca text
);
 $   DROP TABLE public.observacionesaca;
       public         postgres    false    3            �            1259    16459 &   observacionesaca_id_observacionaca_seq    SEQUENCE     �   CREATE SEQUENCE observacionesaca_id_observacionaca_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.observacionesaca_id_observacionaca_seq;
       public       postgres    false    3    199            �           0    0 &   observacionesaca_id_observacionaca_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE observacionesaca_id_observacionaca_seq OWNED BY observacionesaca.id_observacionaca;
            public       postgres    false    200            �            1259    16461    observacionesind    TABLE     �   CREATE TABLE observacionesind (
    id_observacionind integer NOT NULL,
    matriculaalumno bigint,
    id_asesorind integer NOT NULL,
    nosemana integer NOT NULL,
    observacionind text
);
 $   DROP TABLE public.observacionesind;
       public         postgres    false    3            �            1259    16467 !   observacionesind_id_asesorind_seq    SEQUENCE     �   CREATE SEQUENCE observacionesind_id_asesorind_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 8   DROP SEQUENCE public.observacionesind_id_asesorind_seq;
       public       postgres    false    201    3            �           0    0 !   observacionesind_id_asesorind_seq    SEQUENCE OWNED BY     Y   ALTER SEQUENCE observacionesind_id_asesorind_seq OWNED BY observacionesind.id_asesorind;
            public       postgres    false    202            �            1259    16469 &   observacionesind_id_observacionind_seq    SEQUENCE     �   CREATE SEQUENCE observacionesind_id_observacionind_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.observacionesind_id_observacionind_seq;
       public       postgres    false    3    201            �           0    0 &   observacionesind_id_observacionind_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE observacionesind_id_observacionind_seq OWNED BY observacionesind.id_observacionind;
            public       postgres    false    203            
           2604    16553    alumno id_asesorind    DEFAULT     l   ALTER TABLE ONLY alumno ALTER COLUMN id_asesorind SET DEFAULT nextval('alumno_id_asesorind_seq'::regclass);
 B   ALTER TABLE public.alumno ALTER COLUMN id_asesorind DROP DEFAULT;
       public       postgres    false    187    186                       2604    16554    avancesalumno id_avance    DEFAULT     t   ALTER TABLE ONLY avancesalumno ALTER COLUMN id_avance SET DEFAULT nextval('avancesalumno_id_avance_seq'::regclass);
 F   ALTER TABLE public.avancesalumno ALTER COLUMN id_avance DROP DEFAULT;
       public       postgres    false    193    192                       2604    16555    evaluacionaca id_evaluacionaca    DEFAULT     �   ALTER TABLE ONLY evaluacionaca ALTER COLUMN id_evaluacionaca SET DEFAULT nextval('evaluacionaca_id_evaluacionaca_seq'::regclass);
 M   ALTER TABLE public.evaluacionaca ALTER COLUMN id_evaluacionaca DROP DEFAULT;
       public       postgres    false    195    194                       2604    16556    evaluacionind id_evaluacionind    DEFAULT     �   ALTER TABLE ONLY evaluacionind ALTER COLUMN id_evaluacionind SET DEFAULT nextval('evaluacionind_id_evaluacionind_seq'::regclass);
 M   ALTER TABLE public.evaluacionind ALTER COLUMN id_evaluacionind DROP DEFAULT;
       public       postgres    false    198    196                       2604    16557    evaluacionind id_asesorind    DEFAULT     z   ALTER TABLE ONLY evaluacionind ALTER COLUMN id_asesorind SET DEFAULT nextval('evaluacionind_id_asesorind_seq'::regclass);
 I   ALTER TABLE public.evaluacionind ALTER COLUMN id_asesorind DROP DEFAULT;
       public       postgres    false    197    196                       2604    16558 "   observacionesaca id_observacionaca    DEFAULT     �   ALTER TABLE ONLY observacionesaca ALTER COLUMN id_observacionaca SET DEFAULT nextval('observacionesaca_id_observacionaca_seq'::regclass);
 Q   ALTER TABLE public.observacionesaca ALTER COLUMN id_observacionaca DROP DEFAULT;
       public       postgres    false    200    199                       2604    16559 "   observacionesind id_observacionind    DEFAULT     �   ALTER TABLE ONLY observacionesind ALTER COLUMN id_observacionind SET DEFAULT nextval('observacionesind_id_observacionind_seq'::regclass);
 Q   ALTER TABLE public.observacionesind ALTER COLUMN id_observacionind DROP DEFAULT;
       public       postgres    false    203    201                       2604    16560    observacionesind id_asesorind    DEFAULT     �   ALTER TABLE ONLY observacionesind ALTER COLUMN id_asesorind SET DEFAULT nextval('observacionesind_id_asesorind_seq'::regclass);
 L   ALTER TABLE public.observacionesind ALTER COLUMN id_asesorind DROP DEFAULT;
       public       postgres    false    202    201            �          0    16411    admin 
   TABLE DATA               W   COPY admin (matricula, nombre, ap_pat, ap_mat, password, telefono, correo) FROM stdin;
    public       postgres    false    185   Gf       �          0    16414    alumno 
   TABLE DATA               �   COPY alumno (matricula, nombre, ap_pat, ap_mat, password, telefono, correo, proyecto, division, carrera, periodocuatrimestral, id_asesorind, id_asesoraca) FROM stdin;
    public       postgres    false    186   �f       �           0    0    alumno_id_asesorind_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('alumno_id_asesorind_seq', 1, false);
            public       postgres    false    187            �          0    16422 	   asesoraca 
   TABLE DATA               [   COPY asesoraca (matricula, nombre, ap_pat, ap_mat, correo, telefono, password) FROM stdin;
    public       postgres    false    188   �h       �          0    16427 	   asesorind 
   TABLE DATA               g   COPY asesorind (id_asesorind, nombre, ap_pat, ap_mat, empresa, correo, telefono, password) FROM stdin;
    public       postgres    false    190   �i       �           0    0    asesorind_id_asesorind_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('asesorind_id_asesorind_seq', 1, true);
            public       postgres    false    191            �          0    16433    avancesalumno 
   TABLE DATA               N   COPY avancesalumno (id_avance, matriculaalumno, nosemana, avance) FROM stdin;
    public       postgres    false    192   �j       �           0    0    avancesalumno_id_avance_seq    SEQUENCE SET     B   SELECT pg_catalog.setval('avancesalumno_id_avance_seq', 4, true);
            public       postgres    false    193            �          0    16441    evaluacionaca 
   TABLE DATA               m   COPY evaluacionaca (id_evaluacionaca, matriculaalumno, id_asesoraca, parcial, saber, hacer, ser) FROM stdin;
    public       postgres    false    194   Kk       �           0    0 "   evaluacionaca_id_evaluacionaca_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('evaluacionaca_id_evaluacionaca_seq', 16, true);
            public       postgres    false    195            �          0    16446    evaluacionind 
   TABLE DATA               m   COPY evaluacionind (id_evaluacionind, matriculaalumno, id_asesorind, parcial, saber, hacer, ser) FROM stdin;
    public       postgres    false    196   �k       �           0    0    evaluacionind_id_asesorind_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('evaluacionind_id_asesorind_seq', 1, false);
            public       postgres    false    197            �           0    0 "   evaluacionind_id_evaluacionind_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('evaluacionind_id_evaluacionind_seq', 10, true);
            public       postgres    false    198            �           0    0    matriculaind    SEQUENCE SET     7   SELECT pg_catalog.setval('matriculaind', 10004, true);
            public       postgres    false    189            �          0    16453    observacionesaca 
   TABLE DATA               o   COPY observacionesaca (id_observacionaca, matriculaalumno, id_asesoraca, nosemana, observacionaca) FROM stdin;
    public       postgres    false    199   5l       �           0    0 &   observacionesaca_id_observacionaca_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('observacionesaca_id_observacionaca_seq', 8, true);
            public       postgres    false    200            �          0    16461    observacionesind 
   TABLE DATA               o   COPY observacionesind (id_observacionind, matriculaalumno, id_asesorind, nosemana, observacionind) FROM stdin;
    public       postgres    false    201   �l       �           0    0 !   observacionesind_id_asesorind_seq    SEQUENCE SET     I   SELECT pg_catalog.setval('observacionesind_id_asesorind_seq', 1, false);
            public       postgres    false    202            �           0    0 &   observacionesind_id_observacionind_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('observacionesind_id_observacionind_seq', 1, true);
            public       postgres    false    203                       2606    16480    admin admin_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY admin
    ADD CONSTRAINT admin_pkey PRIMARY KEY (matricula);
 :   ALTER TABLE ONLY public.admin DROP CONSTRAINT admin_pkey;
       public         postgres    false    185    185                       2606    16482    alumno alumno_pkey 
   CONSTRAINT     P   ALTER TABLE ONLY alumno
    ADD CONSTRAINT alumno_pkey PRIMARY KEY (matricula);
 <   ALTER TABLE ONLY public.alumno DROP CONSTRAINT alumno_pkey;
       public         postgres    false    186    186                       2606    16484    asesoraca asesoraca_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY asesoraca
    ADD CONSTRAINT asesoraca_pkey PRIMARY KEY (matricula);
 B   ALTER TABLE ONLY public.asesoraca DROP CONSTRAINT asesoraca_pkey;
       public         postgres    false    188    188                       2606    16486    asesorind asesorind_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY asesorind
    ADD CONSTRAINT asesorind_pkey PRIMARY KEY (id_asesorind);
 B   ALTER TABLE ONLY public.asesorind DROP CONSTRAINT asesorind_pkey;
       public         postgres    false    190    190                       2606    16488     avancesalumno avancesalumno_pkey 
   CONSTRAINT     n   ALTER TABLE ONLY avancesalumno
    ADD CONSTRAINT avancesalumno_pkey PRIMARY KEY (matriculaalumno, nosemana);
 J   ALTER TABLE ONLY public.avancesalumno DROP CONSTRAINT avancesalumno_pkey;
       public         postgres    false    192    192    192                       2606    16490     evaluacionaca evaluacionaca_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY evaluacionaca
    ADD CONSTRAINT evaluacionaca_pkey PRIMARY KEY (matriculaalumno, parcial);
 J   ALTER TABLE ONLY public.evaluacionaca DROP CONSTRAINT evaluacionaca_pkey;
       public         postgres    false    194    194    194                        2606    16492     evaluacionind evaluacionind_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY evaluacionind
    ADD CONSTRAINT evaluacionind_pkey PRIMARY KEY (matriculaalumno, parcial);
 J   ALTER TABLE ONLY public.evaluacionind DROP CONSTRAINT evaluacionind_pkey;
       public         postgres    false    196    196    196            "           2606    16494 &   observacionesaca observacionesaca_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY observacionesaca
    ADD CONSTRAINT observacionesaca_pkey PRIMARY KEY (id_asesoraca, nosemana);
 P   ALTER TABLE ONLY public.observacionesaca DROP CONSTRAINT observacionesaca_pkey;
       public         postgres    false    199    199    199            $           2606    16496 &   observacionesind observacionesind_pkey 
   CONSTRAINT     q   ALTER TABLE ONLY observacionesind
    ADD CONSTRAINT observacionesind_pkey PRIMARY KEY (id_asesorind, nosemana);
 P   ALTER TABLE ONLY public.observacionesind DROP CONSTRAINT observacionesind_pkey;
       public         postgres    false    201    201    201            %           2606    16497    alumno alumno_id_asesoraca_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY alumno
    ADD CONSTRAINT alumno_id_asesoraca_fkey FOREIGN KEY (id_asesoraca) REFERENCES asesoraca(matricula);
 I   ALTER TABLE ONLY public.alumno DROP CONSTRAINT alumno_id_asesoraca_fkey;
       public       postgres    false    186    188    2072            &           2606    16502    alumno alumno_id_asesorind_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY alumno
    ADD CONSTRAINT alumno_id_asesorind_fkey FOREIGN KEY (id_asesorind) REFERENCES asesorind(id_asesorind);
 I   ALTER TABLE ONLY public.alumno DROP CONSTRAINT alumno_id_asesorind_fkey;
       public       postgres    false    190    186    2074            '           2606    16507 0   avancesalumno avancesalumno_matriculaalumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY avancesalumno
    ADD CONSTRAINT avancesalumno_matriculaalumno_fkey FOREIGN KEY (matriculaalumno) REFERENCES alumno(matricula);
 Z   ALTER TABLE ONLY public.avancesalumno DROP CONSTRAINT avancesalumno_matriculaalumno_fkey;
       public       postgres    false    192    2070    186            (           2606    16512 -   evaluacionaca evaluacionaca_id_asesoraca_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY evaluacionaca
    ADD CONSTRAINT evaluacionaca_id_asesoraca_fkey FOREIGN KEY (id_asesoraca) REFERENCES asesoraca(matricula);
 W   ALTER TABLE ONLY public.evaluacionaca DROP CONSTRAINT evaluacionaca_id_asesoraca_fkey;
       public       postgres    false    194    188    2072            )           2606    16517 0   evaluacionaca evaluacionaca_matriculaalumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY evaluacionaca
    ADD CONSTRAINT evaluacionaca_matriculaalumno_fkey FOREIGN KEY (matriculaalumno) REFERENCES alumno(matricula);
 Z   ALTER TABLE ONLY public.evaluacionaca DROP CONSTRAINT evaluacionaca_matriculaalumno_fkey;
       public       postgres    false    2070    194    186            *           2606    16522 -   evaluacionind evaluacionind_id_asesorind_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY evaluacionind
    ADD CONSTRAINT evaluacionind_id_asesorind_fkey FOREIGN KEY (id_asesorind) REFERENCES asesorind(id_asesorind);
 W   ALTER TABLE ONLY public.evaluacionind DROP CONSTRAINT evaluacionind_id_asesorind_fkey;
       public       postgres    false    190    2074    196            +           2606    16527 0   evaluacionind evaluacionind_matriculaalumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY evaluacionind
    ADD CONSTRAINT evaluacionind_matriculaalumno_fkey FOREIGN KEY (matriculaalumno) REFERENCES alumno(matricula);
 Z   ALTER TABLE ONLY public.evaluacionind DROP CONSTRAINT evaluacionind_matriculaalumno_fkey;
       public       postgres    false    186    2070    196            ,           2606    16532 3   observacionesaca observacionesaca_id_asesoraca_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY observacionesaca
    ADD CONSTRAINT observacionesaca_id_asesoraca_fkey FOREIGN KEY (id_asesoraca) REFERENCES asesoraca(matricula);
 ]   ALTER TABLE ONLY public.observacionesaca DROP CONSTRAINT observacionesaca_id_asesoraca_fkey;
       public       postgres    false    199    2072    188            -           2606    16537 6   observacionesaca observacionesaca_matriculaalumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY observacionesaca
    ADD CONSTRAINT observacionesaca_matriculaalumno_fkey FOREIGN KEY (matriculaalumno) REFERENCES alumno(matricula);
 `   ALTER TABLE ONLY public.observacionesaca DROP CONSTRAINT observacionesaca_matriculaalumno_fkey;
       public       postgres    false    199    186    2070            .           2606    16542 3   observacionesind observacionesind_id_asesorind_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY observacionesind
    ADD CONSTRAINT observacionesind_id_asesorind_fkey FOREIGN KEY (id_asesorind) REFERENCES asesorind(id_asesorind);
 ]   ALTER TABLE ONLY public.observacionesind DROP CONSTRAINT observacionesind_id_asesorind_fkey;
       public       postgres    false    190    2074    201            /           2606    16547 6   observacionesind observacionesind_matriculaalumno_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY observacionesind
    ADD CONSTRAINT observacionesind_matriculaalumno_fkey FOREIGN KEY (matriculaalumno) REFERENCES alumno(matricula);
 `   ALTER TABLE ONLY public.observacionesind DROP CONSTRAINT observacionesind_matriculaalumno_fkey;
       public       postgres    false    186    2070    201            �   x   x�3254643 �!���9U�y
�%U���A�9)�y��9�ə�ŜE��%���Ʀ�F�f��%P��%���9z���\&�&���9I�E%�@��9�s3�R�`�A�3�Ek� �
,�      �     x���Kn�0�ףS�����XA� 6Z��&�b,�6�P�w�eQ��XIY��H��D����?� ��֨�Sa*��$��m�w����4��$�X��`�������:+H��T-א�p3[\ݮy���m���_r�B����X��Q�J�Q�8����'[�A� #/I��B.\$,QRmw���o���@9��em���n֫Ϸ���A������!Ȝ(a���r����Eq�;��C�1�9��k��8�`��`�KR�s��Y1���upMJ)����l���Y����'���'�%/]S�h$*�O�8N�F{|na��+ԅ;�I�Q��PH>�]q�%i�%ׁ�6����.�-�g�MY���j�������܂;�2�Bķ��rEV�Q����aҕ���v_D�U!����z�}����v�^`�c���l�-�۰U�+T��
����/qz�ۻc�������!��\V�r;,¤ڣv�c��S�4q���P����΍8�y�����      �   �   x�e����@���à,lH�CלB Q�X�
9��H�NTt�y1�#������ߌMlb,���Kwj��e/ΎR��y�K�$�bkbcD�Ȍ'�;m��o
�yT�5���)N��I�Yj�������'���̄��W����/�&�4��F���������B.��a������a��ʯ���ʤ %���@�uo�=0�QE/q�d�      �   �   x�]�Mj�0����@��D��k�:?�tQ�f*�D i�<�o�3�b���0��y�x�BT���/�_�Á��{��u���P6ΟlS�!��9�r"��LS )R��+)!qQeU������>�aB��ԐG译�yy�	��{��m��]l�#9��������VJM�6;�2�+��7���3}���}��8����f�8�oL��B�.����4����()�?�>+���z�      �   c   x�=�1
�0 ��y�4m����%�L��|���z��g𰶮��.#bI���$i�lC�K��g"�?�ҫ��#,nqo�m��)&�xL�� �F      �   p   x�m���0C��0'	-���sIS�'UH|<�m�歏�����j��uw�N�{MX/J��#�3�\NB}���]�2K�iӵ�#5u�N�Bc�y�7�U��ٝ����3)�      �   Z   x�e�Q
� ���0#i�ͻ����E��BBy���@B�o�Cc��QX�1ƀ[Yq��������B�b�Qj�:V�hN�g6z/3� l�      �   n   x�M�;
�0D��Sx��M�`/��D�"�QD���k�L1�C@Ɩ�M0��R(&)b�c\ڌ���S���e�گF��k��/p��砹F�%�X��v�(	{��7�!n      �   '   x�3�425464304��44000�4�t�L������ Z>�     