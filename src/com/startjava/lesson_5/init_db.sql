CREATE DATABASE robots;

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