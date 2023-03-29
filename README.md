# DATABASE SAMPLE TEMPLATE


CREATE DATABASE jdbc_task_1;

CREATE TABLE countries(
    id SERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL ,
    population INTEGER NOT NULL
);

CREATE TABLE cities (
    id SERIAL PRIMARY KEY ,
    name VARCHAR(50) NOT NULL ,
    countries_id INTEGER REFERENCES countries(id)
);

CREATE TABLE mayor(
    id SERIAL PRIMARY KEY,
    name VARCHAR (50) NOT NULL ,
    age INTEGER NOT NULL DEFAULT 18,
    cities_id INTEGER REFERENCES cities(id)
);

INSERT INTO countries(name, population)
VALUES ('Kyrgyzstan', 7400000),
       ('Kazakhstan', 17200000),
       ('Belarus', 12800000),
       ('Russia', 120000000),
       ('USA', 366600000);

INSERT INTO cities(name, countries_id)
VALUES ('Kansas', 5),
       ('Detroit', 5),
       ('Bishkek', 1),
       ('Osh', 1),
       ('Astana', 2),
       ('Almaty', 2),
       ('Moscow',4),
       ('Omsk', 4),
       ('Minsk', 3),
       ('Brest', 3);

DROP TABLE cities CASCADE;
-- Inserted wrong data

INSERT INTO mayor(name, age, cities_id)
VALUES ('Adam', 32, 1),
       ('John', 44, 2),
       ('Aibek', 54, 3),
       ('Bakyt', 46, 4),
       ('Altay', 34, 5),
       ('Erbolot', 43, 6),
       ('Sergey', 33, 7),
       ('Oleg', 55, 8),
       ('Voyka', 27, 9),
       ('Batya', 44, 10);

ALTER TABLE mayor RENAME TO mayors;
