create table if not exists doctor (
    id serial,
    nombre varchar(45) not null,
    especialidad varchar(50) not null,
    primary key (id)
    );

create table if not exists paciente (
    id serial,
    nombre varchar(45) not null,
    edad int not null,
    iddoctor int not null,
    primary key (id),
    FOREIGN KEY (iddoctor) REFERENCES doctor(id)
    );