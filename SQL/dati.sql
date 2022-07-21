

create table cliente(
id int auto_increment,
nome varchar(30) not null,
cognome varchar(30) not null,
username varchar(10) not null unique,
password varchar(1000) not null,
email varchar(50) not null unique,
constraint p_id_cliente primary key(id));



create table ordine(
id int auto_increment,
data date not null,
indirizzo varchar(50) not null,
totale double not null,
id_cliente int not null,
constraint p_id_ordine primary key(id),
constraint fk_id_cliente foreign key(id_cliente) references cliente(id) ON DELETE CASCADE ON UPDATE CASCADE);



create table prodotto(
id int auto_increment,
marca varchar(30) not null,
modello varchar(30) not null,
prezzo double not null,
quantita int default 0 check(quantita >= 0),
img varchar(50),
constraint p_id_prodotto primary key(id));



create table info_ordine(
id_ordine int,
id_prodotto int,
quantita int,
constraint p_info_ordine primary key(id_ordine, id_prodotto),
constraint fk_id_ordine foreign key(id_ordine) references ordine(id) on delete cascade,
constraint fk_id_prodotto foreign key(id_prodotto) references prodotto(id) on delete cascade);



