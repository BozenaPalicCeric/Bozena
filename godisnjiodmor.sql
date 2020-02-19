drop database if exists godisnjiodmor;
create database godisnjiodmor default character set utf8 collate utf8_croatian_ci;
use godisnjiodmor;

create table zaposlenik (
    sifra int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(50) not null,
    oib char (11),
    email varchar(50) not null,
    datumzaposlenja date not null,
    nadredeni int
);


create table godisnjiodmor (
    sifra int not null primary key auto_increment,
    zaposlenik int not null,
    pocetak_godisnjiodmor date not null,
    kraj_godisnjiodmor date not null,
    odobrenje_nadredeni boolean
);

create table evidencija_godisnjiodmor (
    sifra int not null primary key auto_increment,
    zaposlenik int not null,
    godina year(4) not null,
    broj_dana_godisnjiodmor int not null
    
);

alter table godisnjiodmor add foreign key (zaposlenik) references zaposlenik (sifra);
alter table evidencija_godisnjiodmor add foreign key (zaposlenik) references zaposlenik (sifra);

insert into zaposlenik (ime,prezime,oib,email,datumzaposlenja) values
('Ana', 'Petrović', '93655076673', 'ana.petrovic@gmail.com','2019-01-01'),
('Mirjana', 'Perić', '90355615646', 'mirjana.peric@gmail.com','2019-01-01'),
('Petar', 'Kralj', '36782678217', 'petar.k@gmail.com', '2019-01-02'),
('Marko', 'Marković', '95113596277','markovic@gmail.com', '2019-01-03'),
('Jelena', 'Mikić', '93103467263', 'jmikic@gmail.com', '2019-02-01'),
('Elena', 'Horvat', '90505574665', 'elenah@gmail.com', '2019-02-15'),
('Ivan', 'Knežević', '29058715389', 'ivan.knez@gmail.com', '2019-03-01'),
('Blaž', 'Pavlović', '42565827138' 'blaz.pavlovic@gmail.com', '2019-03-20'),
('Maja', 'Novak', '87534789882', 'majan@gmail.com', '2019-04-01'),
('Igor', 'Tomas', '40602896341', 'tigor@gmail.com', '2019-05-01');

insert into godisnjiodmor (zaposlenik,pocetak_godisnjiodmor,kraj_godisnjiodmor) values
(1,'2019-11-01','2019-11-04'),
(2,'2019-11-05','2019-11-10'),
(3,'2019-12-01','2019-12-10');

insert into evidencija_godisnjiodmor (zaposlenik,godina,broj_dana_godisnjiodmor) values
(1,'2019','20'),
(2,'2019','20'),
(3,'2019','24');







