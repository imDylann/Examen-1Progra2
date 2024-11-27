Create database TallerCapacitacion;
use TallerCapacitacion;
create table Taller(
id int primary key auto_increment not null,
nombre varchar(250),
fecha Date,
lugar varchar(250),
correo varchar(250)
);
 create table Participantes(
 cedula  varchar(50)  primary key,
 nombre varchar(250),
 telefono int,
 correo varchar(100) null
 );
 create table inscripcion(
 id int  primary key auto_increment not null,
taller int,
participante varchar(50),
fecha Date,
asistencia bit,
constraint fk foreign key(participante) references participantes(cedula),
foreign key(taller) references taller(id)
);
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateInscripcion`(IN `idP` INT, IN `tallerP` INT, IN `participanteP` VARCHAR(250), IN `fecha` DATE, IN `asistenciaP` BIT)
INSERT INTO inscripcion(id,taller,participante,fecha,asistencia) values(idP,tallerP,participanteP,fecha,asistenciaP)$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateParticipante`(IN `cedulaP` VARCHAR(250), IN `nombreP` VARCHAR(250), IN `fechaP` DATE, IN `telefonoP` INT, IN `correoP` VARCHAR(100))
INSERT into participantes(cedula,nombre,fecha,correo)VALUES(cedulaP,nombreP,fechaP,telefonoP,correoP)$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `CreateTaller`(IN `idP` INT, IN `nombreP` VARCHAR(250), IN `telefonoP` INT, IN `correoP` VARCHAR(100))
INSERT INTO taller(id,nombre,telefono,correo)VALUES(idP,nombreP,telefonoP,correoP)$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteInscripcion`(IN `idP` INT)
DELETE FROM inscripcion where id = ip$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteParticipantes`(IN `cedulaP` VARCHAR(250))
delete from participantes where cedula = cedulaP$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `DeleteTaller`(IN `idP` INT)
Delete from taller where id = idP$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadInscripcionAll`()
SELECT *FROM inscripcion$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadInscripcionforID`(IN `idP` INT)
SELECT *FROM inscripcion WHERE id = idP$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadParticipantesAll`()
SELECT *from participantes$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadPaticipantesforID`(IN `idP` VARCHAR(250))
SELECT *FROM participantes WHERE cedula = idP$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadTallerAll`()
SELECT *FROM taller$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `ReadTallerforID`(IN `idP` INT)
SELECT *FROM taller WHERE id = idP$$
DELIMITER ;