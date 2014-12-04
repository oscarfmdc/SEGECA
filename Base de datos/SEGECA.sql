SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `SEGECA` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `SEGECA` ;

CREATE TABLE IF NOT EXISTS `SEGECA`.`CCC` (
`nombre_CCC` varchar(100) not null,
`presidente` varchar(20),
`secretario` varchar(20),
`administrador` varchar(20),

primary key (`nombre_CCC`))

ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SEGECA`.`Agenda` (
`cod_agenda` int not null auto_increment,
`fecha` varchar(15) not null,
`lugar` varchar(20),
`proposito` varchar(100),
`participantes` varchar(1000),
`hora_inicio` varchar(10),
`hora_fin` varchar(10),
`ccc` varchar(100) not null,

primary key (`cod_agenda`),foreign key(`ccc`) references `SEGECA`.`CCC`(`nombre_CCC`))

ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SEGECA`.`Acta` (
`cod_acta` int not null auto_increment,
`agenda` int not null,
`ausencias` varchar(100),
`resultados` varchar(100),

primary key (`cod_acta`),foreign key(`agenda`) references `SEGECA`.`Agenda`(`cod_agenda`))

ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SEGECA`.`PC` (
`cod_PC` int not null auto_increment,
`email` varchar(100),
`motivo` varchar(500),
`descripcion` varchar(500),
`prioridad` varchar(100),
`fecha` varchar(10),
`agenda` int,
`estado` enum ('aceptada','rechazada','aplazada','pendiente','implantada','retirada'),
`CCC` varchar(100),
`valoracion` varchar(100),
`documentos` varchar(100),

primary key (`cod_PC`))

ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `SEGECA`.`Personas` (
`nick`varchar(30) not null,
`nombre` varchar(100),
`email` varchar(100),
`CCC` varchar(100) not null,
`telefono` int not null,
`permisos` varchar(100),
`contraseña` varchar(100),

primary key (`nick`),
foreign key(`CCC`) references `SEGECA`.`CCC`(`nombre_CCC`))

ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

/*use `SEGECA`;
insert into `SEGECA`.`CCC` (`miembros`,`administrador`,`secretario`,`nombre_CCC`,`presidente`) values ('GestorPC', 'GestorPC', 'GestorPC', 'Gestión de PC', 'GestorPC');
insert into `CCC` set miembros='GestorPC', administrador='GestorPC', secretario='GestorPC', nombre_CCC='Gestión de PC', presidente='GestorPC';
insert into `CCC` set miembros='Juan Guillermo Noelia Javier Sandra', administrador='Noelia', secretario='Guillermo', nombre_CCC='Desarrollo', presidente='Juan';
insert into `Personas` set nick='Sandra', telefono=916257361, email='varelapatino@ejemplo.com', CCC='Desarrollo', nombre='Sandra Varela';
insert into `Personas` set nick='Javier', telefono=324767388, email='sanzgomez@ejemplo.com', CCC='Desarrollo', nombre='Javier Sanz';
insert into `Personas` set nick='Noelia', telefono=675324512, email='noe77@ejemplo.com', CCC='Desarrollo', nombre='Noelia Valdemoro';
insert into `Personas` set nick='Guillermo', telefono=467239872, email='guisen@ejemplo.com', CCC='Desarrollo', nombre='Guillermo Senoseaín';
insert into `Personas` set nick='Juan', telefono=783652932, email='juan@ejemplo.com', CCC='Desarrollo', nombre='Juan Quintero';
insert into `Agenda` set lugar='', participantes='', fecha='', proposito='Agenda por defecto', hora_inicio='', hora_fin='', ccc='Gestión de PC';
insert into `Agenda` set lugar='Sede (Sala de reuniones 2ª planta)', participantes='Todo el comité', fecha='2014-03-22', proposito='Revisar posible error de diseño en BBDD', hora_inicio='09:30:00', hora_fin='11:00:00', ccc='Desarrollo';
insert into `Agenda` set lugar='Sede (Sala de reuniones 2ª planta)', participantes='Todo el comité', fecha='2014-10-10', proposito='Reunión rutinaria', hora_inicio='13:00:00', hora_fin='13:30:00', ccc='Desarrollo';
insert into `PC` set fecha='2014-03-24', prioridad='Alta', cod_PC='', valoracion='', agenda=2, descripcion='Resulta que...', motivo='Posible error de diseño en BBDD', documentos='', estado='implantada', email='usuario1@ejemplo.com', CCC='Desarrollo';
insert into `PC` set fecha='2014-10-08', prioridad='', cod_PC='', valoracion='', agenda=1, descripcion='Parece que falta en la interfaz la forma de...', motivo='Funcionalidad Interfaz', documentos='', estado='pendiente', email='usuario2@ejemplo.com', CCC='Gestión de PC';
insert into `Acta` set resultados='Reconocido el error de diseño en la base de datos. Se procede a su correción.', cod_acta='', ausencias='Sandra', agenda=2;
*/
