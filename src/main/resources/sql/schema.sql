CREATE SEQUENCE company_seq
    INCREMENT BY 1
    MINVALUE 1
    START WITH 1
    CACHE 10;

CREATE TABLE company
(
    id      BIGINT PRIMARY KEY UNIQUE DEFAULT nextval('company_seq'),
    name    VARCHAR(255) NOT NULL UNIQUE,
    city    VARCHAR(255) NOT NULL,
    version BIGINT       NOT NULL
);

CREATE SEQUENCE review_seq
    INCREMENT BY 1
    MINVALUE 1
    START WITH 1
    CACHE 10;

CREATE TABLE review (
                        id BIGINT PRIMARY KEY UNIQUE DEFAULT nextval('review_seq'),
                        review TEXT NOT NULL,
                        description TEXT NOT NULL,
                        rating DOUBLE PRECISION NOT NULL,
                        company_id  BIGINT       NOT NULL,
                        CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES company (id)
);

CREATE SEQUENCE job_seq
    INCREMENT BY 1
    MINVALUE 1
    START WITH 1
    CACHE 10;


CREATE TABLE job
(
    id          BIGINT PRIMARY KEY UNIQUE DEFAULT nextval('job_seq'),
    title       VARCHAR(255) NOT NULL UNIQUE,
    description TEXT         NOT NULL,
    min_salary  BIGINT       NOT NULL,
    max_salary  BIGINT       NOT NULL,
    location    VARCHAR(255) NOT NULL,
    version     BIGINT       NOT NULL,
    company_id  BIGINT       NOT NULL,
    CONSTRAINT fk_company FOREIGN KEY (company_id) REFERENCES company (id)
);