CREATE TABLE food (
    id_food integer PRIMARY KEY NOT NULL,
    name VARCHAR(40) NOT NULL,
    price int NOT NULL,
    category_of_food json NOT NULL
);

CREATE TABLE category_of_food (
    id_category_food integer PRIMARY KEY NOT NULL,
    name VARCHAR(40) NOT NULL
);
