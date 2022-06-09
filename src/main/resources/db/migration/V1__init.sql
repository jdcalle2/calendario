CREATE TABLE IF NOT EXISTS student (
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  lastName VARCHAR (100) NOT NULL,
  class VARCHAR (100) NOT NULL,
  gender VARCHAR (100) NOT NULL,
  age INT,

PRIMARY KEY (id)

);


CREATE TABLE IF NOT EXISTS teacher (
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  subject VARCHAR (100) NOT NULL,
  class VARCHAR (100) NOT NULL,
  schedule  VARCHAR (100) NOT NULL,
  age INT,

PRIMARY KEY (id)

);


CREATE TABLE IF NOT EXISTS director (
  id SERIAL,
  name VARCHAR (100) NOT NULL,
  office VARCHAR (100) NOT NULL,
  officeHour VARCHAR (100) NOT NULL,
  age INT,


PRIMARY KEY (id)

);

CREATE TABLE IF NOT EXISTS futball (
  id SERIAL,
  nombre VARCHAR (100) NOT NULL,
  hora INT,
  cancha INT



PRIMARY KEY (id)

);