CREATE TABLE food (
    idFood VARCHAR(40) PRIMARY KEY NOT NULL,
    name VARCHAR(40) NOT NULL,
    price VARCHAR(40) NOT NULL,
    categoryOfFood json NOT NULL
);

CREATE TABLE category_of_food (
    id_category_food VARCHAR(40) PRIMARY KEY NOT NULL,
    name VARCHAR(40) NOT NULL
);
