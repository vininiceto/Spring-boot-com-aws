
CREATE TABLE IF NOT EXISTS person
(
    id         BIGINT       NOT NULL,
    first_name VARCHAR(255) NOT NULL,
    last_name  VARCHAR(255) NOT NULL,
    adress     VARCHAR(255) NOT NULL,
    gender     VARCHAR(6),
    CONSTRAINT pk_person PRIMARY KEY (id)
);