CREATE TABLE Artista(
    id_Artist CHAR(5) PRIMARY KEY,
    firstName VARCHAR(30) NOT NULL,
    secondName VARCHAR(30) NOT NULL,
    birthDate VARCHAR(30) NOT NULL,
    city VARCHAR(30) NOT NULL,
    followers INTEGER NOT NULL,
    nomeDArte VARCHAR(30) NOT NULL
);

CREATE TABLE Album(
    id_Album CHAR(5) PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    songNumber INTEGER NOT NULL
);

CREATE TABLE Singolo(
    id_Single CHAR(5) PRIMARY KEY
);

CREATE TABLE EP(
    id_EP CHAR(5) PRIMARY KEY,
    nameEP VARCHAR(20) NOT NULL
);

CREATE TABLE Pubblica(
    id_Release CHAR(5) PRIMARY KEY,
    releaseDate DATE NOT NULL,
    id_Artist CHAR(5),
    id_Album CHAR(5),
	id_Single CHAR(5),
    id_EP CHAR(5),
    CONSTRAINT FK1 FOREIGN KEY (id_Artist) REFERENCES Artista(id_Artist),
    CONSTRAINT FK2 FOREIGN KEY (id_Album) REFERENCES Album(id_Album),
    CONSTRAINT FK3 FOREIGN KEY (id_Single) REFERENCES Singolo(id_Single),
    CONSTRAINT FK4 FOREIGN KEY (id_EP) REFERENCES EP(id_EP)
);

CREATE TABLE Brano(
    id_Song CHAR(5) PRIMARY KEY,
    songName VARCHAR(30) NOT NULL,
    songDuration INTEGER NOT NULL,
    genere VARCHAR(30) NOT NULL,
    id_Album CHAR(5),
    id_Single CHAR(5),
    id_EP CHAR(5),
    CONSTRAINT FK2 FOREIGN KEY (id_Album) REFERENCES Album(id_Album),
    CONSTRAINT FK3 FOREIGN KEY (id_Single) REFERENCES Singolo(id_Single),
    CONSTRAINT FK4 FOREIGN KEY (id_EP) REFERENCES EP(id_EP)
);

CREATE SEQUENCE public."codicePubblica"
    INCREMENT 1
    START 0
    MINVALUE 0
    MAXVALUE 500
    CACHE 1;