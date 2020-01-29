CREATE TABLE Artista(
    id_Artist CHAR(5) PRIMARY KEY,
    firstName VARCHAR(30) NOT NULL,
    secondName VARCHAR(30) NOT NULL,
    birthDate DATE NOT NULL,
    city VARCHAR(30) NOT NULL,
    followers INTEGER NOT NULL
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

CREATE TABLE Publica(
    id_Release CHAR(5) PRIMARY KEY,
    releaseDate DATE NOT NULL,
    id_Artist CHAR(5),
    id_Album CHAR(5),
	id_Single CHAR(5),
    id_EP CHAR(5),
    CONSTRAINT FK1 FOREIGN KEY (id_Artist) REFERENCES Artist(id_Artist),
    CONSTRAINT FK2 FOREIGN KEY (id_Album) REFERENCES Album(id_Album),
    CONSTRAINT FK3 FOREIGN KEY (id_Single) REFERENCES Single(id_Single),
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
    CONSTRAINT FK3 FOREIGN KEY (id_Single) REFERENCES Single(id_Single),
    CONSTRAINT FK4 FOREIGN KEY (id_EP) REFERENCES EP(id_EP)
);