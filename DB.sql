CREATE DATABASE `agenda`;

use agenda;

CREATE TABLE `materias` (
	`id` int(11) NOT NULL auto_increment,
    `codigo` varchar(6) UNIQUE NOT NULL,
    `nombre` varchar(64) Not NULL,
    `semestre` int(1) NOT NULL,
    `hora_inicio` time NOT Null,
    `hora_fin` time NOT NULL,
    `dias` set('Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo') NOT NULL,
    `aula` int(3) NOT NULL,
    `promedio` double,
    `maestro` varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE `evaluaciones` (
    `id` int(11) NOT NULL auto_increment,
    `materia` varchar(6) NOT NULL,
    `evaluacion` varchar(32) NOT NULL,
    `porcentaje` double NOT NULL,
    `calificacion` double NOT NULL,
    `calificacion_total` double NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `tareas` (
	`id` int(11) NOT NULL auto_increment,
    `materia` varchar(6) NOT NULL,
    `tarea` varchar(64) NOT NULL,
    `fecha_entrega` date NOT NULL,
    `fecha_recordatorio`date,
    `recordatorio_enviado` boolean,
    PRIMARY KEY(`id`)
);
