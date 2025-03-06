DROP TABLE IF EXISTS client_movie;
DROP TABLE IF EXISTS movie_actor;
DROP TABLE IF EXISTS client;
DROP TABLE IF EXISTS movie;
DROP TABLE IF EXISTS actor;

CREATE TABLE client (
    id SERIAL PRIMARY KEY,
    userName VARCHAR(25) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL  --  armazenar um hash da senha
);


CREATE TABLE movie (
    id SERIAL PRIMARY KEY,
    title VARCHAR(50) NOT NULL,
    duration INT NOT NULL,
    released DATE NOT NULL,
    price DECIMAL(10,2) NOT NULL
);


CREATE TABLE actor (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL
);


CREATE TABLE client_movie (
    id SERIAL PRIMARY KEY,
    id_client INT NOT NULL,
    id_movie INT NOT NULL,
    purchase_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_client) REFERENCES client(id) ON DELETE CASCADE,
    FOREIGN KEY (id_movie) REFERENCES movie(id) ON DELETE CASCADE
);


CREATE TABLE movie_actor (
     id SERIAL PRIMARY KEY,
     id_movie INT NOT NULL,
     id_actor INT NOT NULL,
     FOREIGN KEY (id_movie) REFERENCES movie(id) ON DELETE CASCADE,
     FOREIGN KEY (id_actor) REFERENCES actor(id) ON DELETE CASCADE
);
