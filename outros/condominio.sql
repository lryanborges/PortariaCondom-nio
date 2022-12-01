CREATE DATABASE IF NOT EXISTS condominio;
USE condominio;

CREATE TABLE IF NOT EXISTS Morador_Principal (
	Id INTEGER AUTO_INCREMENT NOT NULL,
    CPF VARCHAR (11) NOT NULL,
    Nome VARCHAR(60) NOT NULL,
    Apartamento INTEGER NOT NULL,
    Bloco VARCHAR(11) NOT NULL,
    Categoria VARCHAR(60) NOT NULL,
    RG VARCHAR (60) NOT NULL,
    Nascimento VARCHAR(20) NOT NULL,
    Email VARCHAR(60) NOT NULL,
    TelefoneResidencial VARCHAR (20),
    TelefoneComercial VARCHAR(20),
    Celular VARCHAR(20) NOT NULL,
    PodeZap BOOLEAN,
    PRIMARY KEY (Id, Apartamento)
);

CREATE TABLE IF NOT EXISTS Empregado (
	Id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Cargo VARCHAR(60) NOT NULL,
    Nome VARCHAR(60) NOT NULL, 
    Turno VARCHAR (60) NOT NULL,
    RG VARCHAR(60) NOT NULL,
    Id_MoradorP INTEGER NOT NULL,
    Apartamento INTEGER NOT NULL,
    FOREIGN KEY(Id_MoradorP, Apartamento) REFERENCES Morador_Principal(Id, Apartamento)
);

CREATE TABLE Morador_Secundario (
	Id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Parentesco VARCHAR(60),
    Nascimento VARCHAR(20),
    Nome VARCHAR(60),
    Id_MoradorP INTEGER NOT NULL,
    Apartamento INTEGER NOT NULL,
    FOREIGN KEY(Id_MoradorP, Apartamento) REFERENCES Morador_Principal(Id, Apartamento)
);

CREATE TABLE Veiculo (
	Id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Marca VARCHAR(60),
    Modelo VARCHAR(60),
    Cor VARCHAR(20),
    Placa VARCHAR(20),
    Id_MoradorP INTEGER NOT NULL,
    Apartamento INTEGER NOT NULL,
    FOREIGN KEY(Id_MoradorP, Apartamento) REFERENCES Morador_Principal(Id, Apartamento)
);

CREATE TABLE Animal (
	Id INTEGER AUTO_INCREMENT NOT NULL PRIMARY KEY,
    Especie VARCHAR(20),
    Nome VARCHAR(60),
    Raca VARCHAR(20),
    Cor VARCHAR(20),
    Id_MoradorP INTEGER NOT NULL,
    Apartamento INTEGER NOT NULL,
    FOREIGN KEY(Id_MoradorP, Apartamento) REFERENCES Morador_Principal(Id, Apartamento)
);

    