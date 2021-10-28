create schema reto_5;
use reto_5;
create table director 
(
DIR_NOMBRE varchar(45) not null primary key,
DIR_NACIONALIDAD varchar(45) not null
);
insert into director values ("Hayo Miyazaki", "japones");
insert into director values ("Joss Whedon", "estadounidense");
insert into director values ("Christopher Nolan", "estadounidense");
insert into director values ("Bong Joon-ho", "coreano");
insert into director values ("Vincent Ward", "neozelandes");
create table PELICULAS
(
PELI_NOMBRE varchar(40) not null primary key,
PELI_RESUMEN varchar(400) not null,
PELI_AÑO int not null,
PELI_DIRECTOR varchar(40) not null,
FOREIGN KEY (PELI_DIRECTOR) REFERENCES DIRECTOR (DIR_NOMBRE)
);
INSERT INTO PELICULAS (PELI_NOMBRE, PELI_RESUMEN,PELI_AÑO,PELI_DIRECTOR)
VALUES ("Los Vengadores", "Pelicula de superheroes basada en Marvel Comics. Nick Fury director de SHIELD recluta a Tony Stark, Steve Rogers, Bruce Banner y Thor para forma un equipo y evitar que Loki, hermano de Thor, se apodere de la tierra", 2012, "Joss Whedon"), 
("Interestelar", "Pelicula de ciencia fición, donde la humanidad lucha por sobrevivir. La pelicula cuenta una historia de un grupo de astronautas que viajana traves de un agujero de gusano en busca de un nuevo hogar.", 2014, "Christopher Nolan"),
("El viaje de Chihiro", "Pelicula de animación japonesa. Es la historia de una niña de 12 años, quien se ve atrapada por un mundo mágico y sobrenatural, teniendo como misión buscar su libertad y la de sus padres y regresar al mundo real.", 2001, "Hayo Miyazaki"),
("Parasitos", "Pelicula de drama, suspenso y humor negro. Toca temas como las diferencias sociales y vulnerabilidad del espiritu humano", 2019, "Bong Joon-ho"),
("Mas alla de los sueños", "Pelicula de drama, narra una historia trágica de una familia,
 donde el padre va en busca de sus esposa al mas allá para recuperarla.", 1998, "Vincent Ward");
create table series
(
SERIE_TITULO varchar(50) not null primary key,
SER_CAPITULOS INT not null,
SER_TEMPORADAS INT NOT NULL 
);
INSERT INTO SERIES values('The walking dead',153,11);
INSERT INTO SERIES values('Viaje a las estrellas: la serie original',80,3);
INSERT INTO SERIES values('Glow',30,3);
INSERT INTO SERIES values('La casa de papel',31,4);
INSERT INTO SERIES values('Friends',236,10);
INSERT INTO SERIES values('Arrow',170,8);
INSERT INTO SERIES values('The big bang theory',279,12);
INSERT INTO SERIES values('Vikingos',79,6);
create table usuarios
(
USER_ALIAS varchar (45) not null primary key,
USER_NOMBRE varchar(45) not null,
USER_APELLIDO varchar(45) not null,
USER_EMAIL varchar(45) not null,
USER_CONTRASEÑA varchar(45) not null,
USER_TELEFONO bigint  null,
USER_NACIMIENTO varchar(45) null
);
insert into usuarios values('lucky','Pedro','Perez','user@gmail.com','123456',3125469878,'22-noviembre-1999');
insert into usuarios values('malopez','Maria','Lopez','user2@gmai.com','12345',32547855544,'12-enero-2005');
insert into usuarios values('diva','Ana','Diaz','user3@gmail.com','1234',3206547896,'27-marzo-2001');
insert into usuarios values('dreamer','Luis','Rojas','user4@gmail.com','123',3152796999,'15-abril-2004');
insert into usuarios values('ninja','Andres','Cruz','user5@gmai.com','user123',3207445025,'14-enero-2000');
insert into usuarios values('neon','Nelson','Ruiz','user6@gmail.com','user12345',3101000110,'24-diciembre-2004');
insert into usuarios values('rose','Claudia','Mendez','user7@gmail.com','contraseña123',3206696996,'1-enero-1998');
insert into usuarios values('green','Jorge','Rodriguez','user7@gmail.com','hola123',3200011122,'27-septiembre,1986');
create table Transmisiones_peliculas
(
USER_ALIAS varchar (45) not null,
USER_VI_PELICULA varchar(45)null,
USER_FECHA_HORA varchar (60)not null,
foreign key (USER_ALIAS) references usuarios(USER_ALIAS),
foreign key (USER_VI_PELICULA) references peliculas(PELI_NOMBRE)
);
insert into Transmisiones_peliculas (USER_ALIAS,USER_VI_PELICULA,USER_FECHA_HORA) values ("lucky","Los Vengadores","2017-10-25 20:00:00"); 
insert into Transmisiones_peliculas (USER_ALIAS,USER_VI_PELICULA,USER_FECHA_HORA) values ("lucky","Parasitos",'2019-03-15 18:30:00');
insert into Transmisiones_peliculas (USER_ALIAS,USER_VI_PELICULA,USER_FECHA_HORA) values ("malopez","Los Vengadores",'2018-05-20 20:30:00');
insert into Transmisiones_peliculas (USER_ALIAS,USER_VI_PELICULA,USER_FECHA_HORA)values ("diva","Interestelar",'2019-05-20 20:30:00');
insert into Transmisiones_peliculas (USER_ALIAS,USER_VI_PELICULA,USER_FECHA_HORA)values ("diva","El viaje de Chihiro",'2018-06-22 21:30:00');
insert into Transmisiones_peliculas(USER_ALIAS,USER_VI_PELICULA,USER_FECHA_HORA)values("green","Interestelar",'2020-01-10 17:30:20');
insert into Transmisiones_peliculas (USER_ALIAS,USER_VI_PELICULA,USER_FECHA_HORA) values("green","Parasitos",'2020-02-15 20:30:20');
insert into Transmisiones_peliculas (USER_ALIAS,USER_VI_PELICULA,USER_FECHA_HORA)values("green","Mas alla de los sueños",'2020-03-17 18:30:20');
create table Transmisiones_series
(
USER_ALIAS varchar (45) not null,
USER_VI_SERIE varchar(45)null,
USER_FECHA_HORA varchar (60)not null,
foreign key (USER_ALIAS) references usuarios(USER_ALIAS),
foreign key (USER_VI_SERIE) references series(SERIE_TITULO)
);
insert into Transmisiones_series (USER_ALIAS,USER_VI_SERIE,USER_FECHA_HORA)values ("lucky","La casa de papel",'2019-05-20 20:30:00');
insert into Transmisiones_series (USER_ALIAS,USER_VI_SERIE,USER_FECHA_HORA) values ("malopez","La casa de papel",'2020-01-20 20:30:00');
insert into Transmisiones_series (USER_ALIAS,USER_VI_SERIE,USER_FECHA_HORA)values("diva","The walking dead",'2020-03-17 15:30:20');
insert into Transmisiones_series (USER_ALIAS,USER_VI_SERIE,USER_FECHA_HORA) values("dreamer","The walking dead",'2020-03-17 15:30:20');
insert into Transmisiones_series (USER_ALIAS,USER_VI_SERIE,USER_FECHA_HORA) values("dreamer","Viaje a las estrellas: la serie original",'2020-04-10 18:30:20');
insert into Transmisiones_series (USER_ALIAS,USER_VI_SERIE,USER_FECHA_HORA)values("ninja","Glow",'2020-02-17 20:30:20');
insert into Transmisiones_series (USER_ALIAS,USER_VI_SERIE,USER_FECHA_HORA)values("ninja","La casa de papel",'2020-02-20 16:30:20');
insert into Transmisiones_series (USER_ALIAS,USER_VI_SERIE,USER_FECHA_HORA) values("ninja","Arrow",'2020-03-27 18:30:20');
insert into Transmisiones_series (USER_ALIAS,USER_VI_SERIE,USER_FECHA_HORA)values("rose","Friends",'2020-03-20 21:30:20');
select * from series;

