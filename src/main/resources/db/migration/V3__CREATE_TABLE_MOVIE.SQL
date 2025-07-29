CREATE TABLE movie (
    id serial PRIMARY KEY,
    title varchar(255) NOT NULL,
    release_date date,
    description text,
    rating numeric,
    created_date timestamp,
    update_date timestamp
 );