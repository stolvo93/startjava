CREATE DATABASE robots
    WITH ENCODING 'UTF8'
    LC_COLLATE = 'ru_RU.UTF-8'
    LC_CTYPE = 'ru_RU.UTF-8'
    TEMPLATE template0;

\c robots;

DROP TABLE IF EXISTS jaegers;

CREATE TABLE jaegers (
    id          SERIAL PRIMARY KEY,
    model_name  VARCHAR(50),
    mark        VARCHAR(50),
    height      FLOAT,
    weight      SMALLINT,
    status      VARCHAR(50),
    origin      VARCHAR(150),
    launch      SMALLINT,
    kaiju_kill  SMALLINT
);

\ir 'populate.sql'
\ir 'queries.sql'