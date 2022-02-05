CREATE TABLE category_of_food (
    id_category_food integer PRIMARY KEY NOT NULL,
    name VARCHAR(40) NOT NULL
);

CREATE TABLE food (
    id_food integer PRIMARY KEY NOT NULL,
    name VARCHAR(40) NOT NULL,
    price integer NOT NULL,
    category_of_food_id integer,
    FOREIGN KEY (category_of_food_id) REFERENCES category_of_food (id_category_food)
);

