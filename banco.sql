CREATE DATABASE projeto_herois;

CREATE TABLE super_heroi (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    nome_real VARCHAR(100),
    poder VARCHAR(150) NOT NULL,
    universo VARCHAR(100) NOT NULL
);