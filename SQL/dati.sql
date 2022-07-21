drop table if exists cliente cascade;

create table cliente(
id int auto_increment,
nome varchar(30) not null,
cognome varchar(30) not null,
username varchar(10) not null unique,
password varchar(1000) not null,
email varchar(50) not null unique,
constraint p_id_cliente primary key(id));