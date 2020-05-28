-- Table: public.employee

-- DROP TABLE public.employee;

CREATE TABLE public.employee
(
    id_ bigint,
    name_ character varying(50) COLLATE pg_catalog."default"
)

TABLESPACE pg_default;

ALTER TABLE public.employee
    OWNER to postgres;
    
    
insert into employee values (1,'Davinia');
insert into employee values (2,'Mónica');
insert into employee values (3,'Marta');
insert into employee values (4,'Carlos');