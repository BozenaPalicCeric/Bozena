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

insert into zaposlenik (ime,prezime,email,datumzaposlenja) values
('Ana', 'Petrović', 'ana.petrovic@gmail.com','2019-01-01'),
('Mirjana', 'Perić', 'mirjana.peric@gmail.com','2019-01-01'),
('Marko', 'Marković', 'markovic@gmail.com', '2019-01-03');

insert into godisnjiodmor (zaposlenik,pocetak_godisnjiodmor,kraj_godisnjiodmor) values
(1,'2019-11-01','2019-11-04'),
(2,'2019-11-05','2019-11-10'),
(3,'2019-12-01','2019-12-10');

insert into evidencija_godisnjiodmor (zaposlenik,godina,broj_dana_godisnjiodmor) values
(1,'2019','20'),
(2,'2019','20'),
(3,'2019','24');







