/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Malva
 * Created: 6 de out. de 2022
 */

CREAT DATBASE IF NOT EXISTS estacionamento;
USE estacionamentINCREMENT,

CREAT TABLE vaga (

idVaga int NOT NULL AUTO_INCREMENT,
numero int NOT NULL,
rua  varchar(100) NOT NULL,
obliqua boolean NOT NULL,
PRIMARY KEY (idVaga));

