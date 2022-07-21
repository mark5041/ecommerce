insert into cliente(nome, cognome, username, password, email) values
('The', 'Deep', 'TheDeep', 'pass', 'TheDeep@gmail.com');
insert into cliente(nome, cognome, username, password, email) values
('Black', 'Noir', 'BlackNoir', 'pass', 'BlackNoir@gmail.com');
insert into cliente(nome, cognome, username, password, email) values
('Soldier', 'Boy', 'SoldierBoy', 'pass', 'SoldierBoy@gmail.com');

commit

insert into prodotto(marca, modello, prezzo) values
("Apple", "iPhone 13", "1200");
insert into prodotto(marca, modello, prezzo) values
("Samsung", "S20", "800");
insert into prodotto(marca, modello, prezzo) values
("ASUS", "VivoBook Pro 17", "1400");
insert into prodotto(marca, modello, prezzo) values
("Apple", "MacBook Pro", "2000");
insert into prodotto(marca, modello, prezzo) values
("Apple", "iPad", "1000");

commit

insert into ordine(data, indirizzo, totale, id_cliente) values
(CURDATE(), 'via Roma, 23', 2000, 1);
insert into ordine(data, indirizzo, totale, id_cliente) values
(CURDATE(), 'via Milano, 69', 3000, 2);

commit

