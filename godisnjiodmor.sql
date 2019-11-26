drop database if exists godisnjiodmor;
create database godisnjiodmor default character set utf8;
use godisnjiodmor;

create table zaposlenik (
    sifra int not null primary key auto_increment,
    ime varchar(50) not null,
    prezime varchar(50) not null,
    oib char (11) null,
    email varchar(50) not null,
    datumzaposlenja date not null,
    nadredeni int not null
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
    godina date not null,
    broj_dana_godisnjiodmor int not null
    
);


alter table godisnjiodmor add foreign key (zaposlenik) references zaposlenik (sifra);
alter table evidencija_godisnjiodmor add foreign key (zaposlenik) references zaposlenik (sifra);

