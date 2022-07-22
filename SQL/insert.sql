insert into cliente(nome, cognome, username, password, email) values
('The', 'Deep', 'TheDeep', 'pass', 'TheDeep@gmail.com');
insert into cliente(nome, cognome, username, password, email) values
('Black', 'Noir', 'BlackNoir', 'pass', 'BlackNoir@gmail.com');
insert into cliente(nome, cognome, username, password, email) values
('Soldier', 'Boy', 'SoldierBoy', 'pass', 'SoldierBoy@gmail.com');


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


insert into ordine(data, indirizzo, totale, status, id_cliente) values
(CURDATE(), 'via Roma, 23', 2000, 'confermato', 1);
insert into ordine(data, indirizzo, totale, id_cliente) values
(CURDATE(), 'via LeManiDalNaso, 50', 2000, 1);
insert into ordine(data, indirizzo, totale, id_cliente) values
(CURDATE(), 'via Milano, 69', 3000, 2);


insert into info_ordine(id_ordine, id_prodotto, quantita) values
(1, 1, 10);
insert into info_ordine(id_ordine, id_prodotto, quantita) values
(1, 3, 10);
insert into info_ordine(id_ordine, id_prodotto, quantita) values
(1, 5, 10);

insert into info_ordine(id_ordine, id_prodotto, quantita) values
(2, 2, 30);
insert into info_ordine(id_ordine, id_prodotto, quantita) values
(2, 4, 30);
insert into info_ordine(id_ordine, id_prodotto, quantita) values
(2, 1, 30);

insert into info_ordine(id_ordine, id_prodotto, quantita) values
(3, 2, 20);
insert into info_ordine(id_ordine, id_prodotto, quantita) values
(3, 4, 20);

commit
