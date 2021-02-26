//CRUD A MYSQL

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class ConexionMySQLMainApp {
	
	public static Connection conexion;
	

	public static void main(String[] args) {
		
		//Ejercicio 1
		openConnection();
		
		createDB("bd_tiendaInformatica");
		
		createTable("bd_tiendaInformatica","fabricantes","(\r\n"
				+ "	codigo INT AUTO_INCREMENT,\r\n"
				+ "	nombre NVARCHAR(100),\r\n"
				+ "    PRIMARY KEY(codigo)\r\n"
				+ ");");
		createTable("bd_tiendaInformatica","articulos", "(\r\n"
				+ "	codigo INT,\r\n"
				+ "    nombre VARCHAR(100),\r\n"
				+ "    precio INT,\r\n"
				+ "    fabricante INT,\r\n"
				+ "	PRIMARY KEY(codigo),\r\n"
				+ "    FOREIGN KEY(fabricante) REFERENCES fabricantes(codigo)\r\n"
				+ "	ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ");");
		
		insertData("bd_tiendaInformatica","fabricantes",
				" (nombre) VALUES \r\n"
				+ "(\"Fabricante_1\"),\r\n"
				+ "(\"Fabricante_2\"),\r\n"
				+ "(\"Fabricante_3\"),\r\n"
				+ "(\"Fabricante_4\"),\r\n"
				+ "(\"Fabricante_5\"),\r\n"
				+ "(\"Fabricante_6\"),\r\n"
				+ "(\"Fabricante_7\"),\r\n"
				+ "(\"Fabricante_8\"),\r\n"
				+ "(\"Fabricante_9\"),\r\n"
				+ "(\"Fabricante_10\");");
		insertData("bd_tiendaInformatica","articulos",
				" VALUES \r\n"
				+ "(1, 'Articulo_1', 100, 1),\r\n"
				+ "(2, 'Articulo_2', 100, 1),\r\n"
				+ "(3, 'Articulo_3', 200, 1),\r\n"
				+ "(4, 'Articulo_4', 250, 2),\r\n"
				+ "(5, 'Articulo_5', 300, 2),\r\n"
				+ "(6, 'Articulo_6', 100, 3),\r\n"
				+ "(7, 'Articulo_7', 120, 4),\r\n"
				+ "(8, 'Articulo_8', 150, 7),\r\n"
				+ "(9, 'Articulo_9', 400, 9),\r\n"
				+ "(10, 'Articulo_10', 420, 9);");
		
		getValues("bd_tiendaInformatica", "fabricantes",2);
		getValues("bd_tiendaInformatica", "articulos",4);
		
		closeConnection();
		
		
		//Ejercicio 2
		openConnection();
		
		createDB("EMPLEADOS");
		
		createTable("EMPLEADOS","DEPARTAMENTOS","(\r\n"
				+ "Código INT PRIMARY KEY,\r\n"
				+ "Nombre varchar(255) NOT NULL,\r\n"
				+ "Presupuesto INT\r\n"
				+ ");");
		createTable("EMPLEADOS","EMPLEADOS","(\r\n"
				+ "DNI varchar(8) PRIMARY KEY,\r\n"
				+ "Nombre varchar(255) NOT NULL,\r\n"
				+ "Apellidos varchar(255),\r\n"
				+ "Departamento INT,\r\n"
				+ "foreign key (Departamento) references DEPARTAMENTOS (Código)\r\n"
				+ "on delete cascade on update cascade\r\n"
				+ ");");
		
		insertData("EMPLEADOS","DEPARTAMENTOS","VALUES\r\n"
				+ "(04,'RRHH',23000),\r\n"
				+ "(07,'MANTENIMIENTO',40000),\r\n"
				+ "(22,'DESARROLLO',72000),\r\n"
				+ "(14,'INVESTIGACION',54000),\r\n"
				+ "(72,'PUBLICIDAD',60000);");
		insertData("EMPLEADOS","EMPLEADOS","VALUES\r\n"
				+ "('A1111111','Alba','Arroyo',04),\r\n"
				+ "('B2222222','Benito','Berlioz',07),\r\n"
				+ "('C3333333','Carmen','Cantado',22),\r\n"
				+ "('D4444444','Diego','D',22),\r\n"
				+ "('E5555555','Enrique','E',72);");

		getValues("EMPLEADOS","DEPARTAMENTOS",3);
		getValues("EMPLEADOS","EMPLEADOS",4);

		closeConnection();
		
		
		//Ejercicio 3
		openConnection();
		
		createDB("los_almacenes");
		
		createTable("los_almacenes","almacenes","(\r\n"
				+ "	codigo INT AUTO_INCREMENT,\r\n"
				+ "    lugar NVARCHAR(100),\r\n"
				+ "    capacidad INT,\r\n"
				+ "    PRIMARY KEY (codigo)\r\n"
				+ "    );");
		createTable("los_almacenes","cajas","(\r\n"
				+ "    numReferencia CHAR(5),\r\n"
				+ "    contenido  NVARCHAR(100),\r\n"
				+ "    valor INT,\r\n"
				+ "    almacen INT,\r\n"
				+ "    PRIMARY KEY (numReferencia),\r\n"
				+ "    FOREIGN KEY (almacen) REFERENCES almacenes(codigo)\r\n"
				+ "    ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ");");
		
		insertData("los_almacenes","almacenes","(lugar,capacidad) VALUES\r\n"
				+ "(\"Lugar_1\", 10),\r\n"
				+ "(\"bilbao\", 19),\r\n"
				+ "(\"Lugar_3\", 30),\r\n"
				+ "(\"Lugar_4\", 42),\r\n"
				+ "(\"Lugar_5\", 5),\r\n"
				+ "(\"Lugar_6\", 15),\r\n"
				+ "(\"Lugar_7\", 70),\r\n"
				+ "(\"Lugar_8\", 8),\r\n"
				+ "(\"Lugar_9\", 90),\r\n"
				+ "(\"Lugar_10\", 50);");
		insertData("los_almacenes","cajas"," VALUES\r\n"
				+ "\r\n"
				+ "(11, \"Contenido_11\", 10, 1),\r\n"
				+ "(12, \"Contenido_12\", 20, 2),\r\n"
				+ "(13, \"Contenido_13\", 30, 3),\r\n"
				+ "(14, \"Contenido_14\", 400, 4),\r\n"
				+ "(15, \"Contenido_15\", 500, 5),\r\n"
				+ "(16, \"Contenido_16\", 60, 6),\r\n"
				+ "(17, \"Contenido_17\", 70, 7),\r\n"
				+ "(18, \"Contenido_18\", 80, 8),\r\n"
				+ "(19, \"Contenido_19\", 160, 9),\r\n"
				+ "(20, \"Contenido_20\", 200, 10);");
		
		getValues("los_almacenes","almacenes",3);
		getValues("los_almacenes","cajas",4);

		closeConnection();
		
		openConnection();
		
		
		//Ejercicio 4
		openConnection();
		
		createDB("PELÍCULAS_SALAS");
		
		createTable("PELÍCULAS_SALAS","PELICULAS","(\r\n"
				+ "Codigo int auto_increment primary key,\r\n"
				+ "Nombre varchar(255) not null,\r\n"
				+ "CalificacionEdad int\r\n"
				+ ");");
		createTable("PELÍCULAS_SALAS","SALAS","(\r\n"
				+ "Codigo INT auto_increment primary key, \r\n"
				+ "Nombre varchar(255) not null,\r\n"
				+ "Codigo_pelicula int,\r\n"
				+ "foreign key (Codigo_pelicula) references PELICULAS(Codigo)\r\n"
				+ "on delete cascade on update cascade\r\n"
				+ ");");
		
		insertData("PELÍCULAS_SALAS","PELICULAS","(nombre, calificacionEdad) VALUES\r\n"
				+ "	('El Club de la Lucha', 18),\r\n"
				+ "	('Dogville', 18),\r\n"
				+ "	('Del Reves', 0),\r\n"
				+ "	('Donnie Darko', NULL),\r\n"
				+ "	('Piratas del Caribe', 7),\r\n"
				+ "	('Tres Anuncios a las Afueras', 18),\r\n"
				+ "	('Los Vengadores: Infinity War I', 13),\r\n"
				+ "	('Blade Runner 2049', NULL),\r\n"
				+ "	('Dejame entrar', 13),\r\n"
				+ "	('Interestelar', 7);");
		insertData("PELÍCULAS_SALAS","SALAS","(nombre, codigo_pelicula) VALUES\r\n"
				+ "    ('Sala_1', 1),\r\n"
				+ "	('Sala_2', 2),\r\n"
				+ "	('Sala_3', 3),\r\n"
				+ "	('Sala_4', 4),\r\n"
				+ "	('Sala_5', 5),\r\n"
				+ "	('Sala_6', 6),\r\n"
				+ "	('Sala_7', 7),\r\n"
				+ "	('Sala_8', NULL),\r\n"
				+ "	('Sala_9', NULL),\r\n"
				+ "	('Sala_10', 10);");

		getValues("PELÍCULAS_SALAS","PELICULAS",3);
		getValues("PELÍCULAS_SALAS","SALAS",3);

		closeConnection();
		

		//Ejercicio 5
		openConnection();
		
		createDB("bd_directores");
		
		createTable("bd_directores","despachos","(\r\n"
				+ "	numero int,\r\n"
				+ "    capacidad int,\r\n"
				+ "    PRIMARY KEY (numero)\r\n"
				+ ");");
		createTable("bd_directores","directores","(\r\n"
				+ "	DNI varchar(8),\r\n"
				+ "    nomApels varchar(255),\r\n"
				+ "    DNIJefe varchar(8),\r\n"
				+ "    despacho int,\r\n"
				+ "    PRIMARY KEY (DNI),\r\n"
				+ "    FOREIGN KEY (DNIJefe) REFERENCES directores (DNI)\r\n"
				+ "    ON UPDATE CASCADE ON DELETE CASCADE,\r\n"
				+ "    FOREIGN KEY (despacho) REFERENCES despachos (numero)\r\n"
				+ "    ON UPDATE CASCADE ON DELETE CASCADE\r\n"
				+ ");");
		
		insertData("bd_directores","despachos"," values\r\n"
				+ "(10, 50),\r\n"
				+ "(15, 50),\r\n"
				+ "(20, 100),\r\n"
				+ "(25, 150),\r\n"
				+ "(30, 100),\r\n"
				+ "(35, 70),\r\n"
				+ "(40, 55),\r\n"
				+ "(45, 90),\r\n"
				+ "(50, 100),\r\n"
				+ "(55, 210);");
		insertData("bd_directores","directores","(DNI, nomApels, despacho) values\r\n"
				+ "('48653178', 'Alba Alonso', 10),\r\n"
				+ "('12345678', 'Benito Buenafuente', 15),\r\n"
				+ "('78974565', 'Cecilia Castro', 10),\r\n"
				+ "('98765432', 'Diego Devito', 20),\r\n"
				+ "('10236211', 'Enrique Egarritxea', 25),\r\n"
				+ "('46548632', 'Francisca Fernandez', 30),\r\n"
				+ "('89798535', 'Gemma Gallego', 35),\r\n"
				+ "('41564684', 'Hector Hernandez', 40),\r\n"
				+ "('35454882', 'Indira Iovaisha', 45),\r\n"
				+ "('54521201', 'Jacinto Jaramillo', 55);");

		getValues("bd_directores","despachos",2);
		getValues("bd_directores","directores",4);

		closeConnection();
		
		
		//Ejercicio 6
		openConnection();
		
		createDB("PIEZAS_PROVEEDORES");
		
		createTable("PIEZAS_PROVEEDORES","PIEZAS","(\r\n"
				+ "Codigo int auto_increment primary key,\r\n"
				+ "Nombre varchar(255) not null\r\n"
				+ ");");
		createTable("PIEZAS_PROVEEDORES","PROVEEDORES","(\r\n"
				+ "ID char(4) primary key,\r\n"
				+ "Nombre varchar(255) not null\r\n"
				+ ");");
		createTable("PIEZAS_PROVEEDORES","SUMINISTRA","(\r\n"
				+ "Codigo_pieza char(4) references PIEZAS (Codigo),\r\n"
				+ "ID_Proveedor int references PROVEEDORES (ID),\r\n"
				+ "Precio int,\r\n"
				+ "primary key (Codigo_pieza, ID_Proveedor)\r\n"
				+ ");");
		
		insertData("PIEZAS_PROVEEDORES","PIEZAS","(nombre) VALUES\r\n"
				+ "	(\"tornillo pequeño\"),\r\n"
				+ "    (\"tornillo mediano\"),\r\n"
				+ "    (\"tornillo grande\"),\r\n"
				+ "    (\"tuerca pequeña\"),\r\n"
				+ "    (\"tuerca mediana\"),\r\n"
				+ "    (\"tuerca grande\"),\r\n"
				+ "    (\"rueda dentada pequeña\"),\r\n"
				+ "    (\"rueda dentada mediana\"),\r\n"
				+ "    (\"rueda dentada grande\"),\r\n"
				+ "    (\"correa pequeña\");");
		insertData("PIEZAS_PROVEEDORES","PROVEEDORES","(id, nombre) VALUES\r\n"
				+ "    ('0001', \"Proveedor 1\"),\r\n"
				+ "    ('0002', \"Proveedor 2\"),\r\n"
				+ "    ('0003', \"Proveedor 3\"),\r\n"
				+ "    ('0004', \"Proveedor 4\"),\r\n"
				+ "    ('0005', \"Proveedor 5\"),\r\n"
				+ "    ('0006', \"Proveedor 6\"),\r\n"
				+ "    ('0007', \"Proveedor 7\"),\r\n"
				+ "    ('0008', \"Proveedor 8\"),\r\n"
				+ "    ('0009', \"Proveedor 9\"),\r\n"
				+ "    ('0010', \"Proveedor 10\");");
		insertData("PIEZAS_PROVEEDORES","SUMINISTRA","(Codigo_pieza, ID_Proveedor, precio) VALUES\r\n"
				+ "	(1,0001,10),\r\n"
				+ "    (2,0001,20),\r\n"
				+ "    (3,0001,30),\r\n"
				+ "    (4,0001,10),\r\n"
				+ "    (5,0001,20),\r\n"
				+ "    (6,0001,30),\r\n"
				+ "    (7,0002,50),\r\n"
				+ "    (8,0002,75),\r\n"
				+ "    (10,0009,100),\r\n"
				+ "    (10,0010,115);");

		getValues("PIEZAS_PROVEEDORES","PIEZAS",2);
		getValues("PIEZAS_PROVEEDORES","PROVEEDORES",2);
		getValues("PIEZAS_PROVEEDORES","SUMINISTRA",3);

		closeConnection();
		
		
		//Ejercicio 7
		openConnection();
		
		createDB("bd_cientificos");
		
		createTable("bd_cientificos","cientificos","(\r\n"
				+ "	DNI VARCHAR(8),\r\n"
				+ "    nomApels NVARCHAR(255),\r\n"
				+ "    PRIMARY KEY (DNI)\r\n"
				+ ");");
		createTable("bd_cientificos","proyecto","(\r\n"
				+ "    id CHAR(4),\r\n"
				+ "    nombre NVARCHAR(255),\r\n"
				+ "    horas INT,\r\n"
				+ "    PRIMARY KEY (id)\r\n"
				+ ");");
		createTable("bd_cientificos","asignado_a", "(\r\n"
				+ "	cientifico VARCHAR(8),\r\n"
				+ "    proyecto CHAR(4),\r\n"
				+ "    PRIMARY KEY (cientifico, proyecto),\r\n"
				+ "    FOREIGN KEY (cientifico) REFERENCES cientificos (DNI)\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "    FOREIGN KEY (proyecto) REFERENCES proyecto (id)\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ");");
		
		insertData("bd_cientificos","cientificos","VALUES\r\n"
				+ "('12345670', 'Juan José Gonzalez'),\r\n"
				+ "('45362415', 'Enric Carpio'),\r\n"
				+ "('87965820', 'June Orozco'),\r\n"
				+ "('46225178', 'Nerea Iglesias'),\r\n"
				+ "('45648012', 'Maria Concepcion Muriel'),\r\n"
				+ "('74189245', 'Marti García'),\r\n"
				+ "('48663415', 'Driss Calderon'),\r\n"
				+ "('48776011', 'Cintia Pinilla'),\r\n"
				+ "('47878965', 'Carlos Antonio Jimenez'),\r\n"
				+ "('44852148', 'Anselmo Andrade');");
		insertData("bd_cientificos","proyecto","VALUES\r\n"
				+ "('0001', 'Proyecto A', 50),\r\n"
				+ "('0002', 'Proyecto A beta', 70),\r\n"
				+ "('0003', 'Proyecto B', 55),\r\n"
				+ "('0004', 'Proyecto C', 46),\r\n"
				+ "('0005', 'Proyecto D', 48),\r\n"
				+ "('0006', 'Proyecto E', 36),\r\n"
				+ "('0007', 'Proyecto F', 87),\r\n"
				+ "('0008', 'Proyecto G', 23),\r\n"
				+ "('0009', 'Proyecto H', 53),\r\n"
				+ "('0010', 'Proyecto I', 68);");
		
		getValues("bd_cientificos","cientificos",2);
		getValues("bd_cientificos","proyecto",3);
		getValues("bd_cientificos","asignado_a",2);
		
		closeConnection();
		
		
		//Ejercicio 8
		openConnection();
		
		createDB("GRANDES_ALMACENES");
		
		createTable("GRANDES_ALMACENES","PRODUCTOS","(\r\n"
				+ "Codigo int auto_increment primary key,\r\n"
				+ "Nombre varchar(255) not null,\r\n"
				+ "Precio int\r\n"
				+ ");");
		createTable("GRANDES_ALMACENES","CAJEROS","(\r\n"
				+ "Codigo int auto_increment primary key,\r\n"
				+ "NomApels varchar(255)\r\n"
				+ ");");
		createTable("GRANDES_ALMACENES","MAQUINAS_REGISTRADORAS","(\r\n"
				+ "Codigo int auto_increment primary key,\r\n"
				+ "Piso int\r\n"
				+ ");");
		createTable("GRANDES_ALMACENES","VENTA","(\r\n"
				+ "Cod_cajero int references CAJEROS (Codigo),\r\n"
				+ "Cod_maquina int references MAQUINAS_REGISTRADORAS (Codigo),\r\n"
				+ "Cod_producto int references PRODUCTOS (Codigo),\r\n"
				+ "primary key (Cod_cajero, Cod_maquina, Cod_producto)\r\n"
				+ ");");
		
		insertData("GRANDES_ALMACENES","PRODUCTOS","(Codigo,nombre,precio)  values\r\n"
				+ "\r\n"
				+ "	(DEFAULT,'carteras',15),\r\n"
				+ "    (DEFAULT,'zapatos',45),\r\n"
				+ "    (DEFAULT,'camisetas',15),\r\n"
				+ "    (DEFAULT,'pantalones',25),\r\n"
				+ "    (DEFAULT,'gorras',35),\r\n"
				+ "    (DEFAULT,'chanclas',15),\r\n"
				+ "    (DEFAULT,'collares',50),\r\n"
				+ "    (DEFAULT,'gafas',53),\r\n"
				+ "    (DEFAULT,'calcetines',12),\r\n"
				+ "    (DEFAULT,'cinturones',14);");
		insertData("GRANDES_ALMACENES","CAJEROS","(Codigo,NomApels) values\r\n"
				+ "\r\n"
				+ "	(DEFAULT,'Alberto Zambrano'),\r\n"
				+ "    (DEFAULT,'Luis Perez'),\r\n"
				+ "    (DEFAULT,'Ana Fernandez'),\r\n"
				+ "    (DEFAULT,'Raul Farfan'),\r\n"
				+ "    (DEFAULT,'Jose Lito'),\r\n"
				+ "    (DEFAULT,'Carlos Latre'),\r\n"
				+ "    (DEFAULT,'Kimberly Alvarez'),\r\n"
				+ "    (DEFAULT,'Ismael Gonzalez'),\r\n"
				+ "    (DEFAULT,'Marco Rostagno'),\r\n"
				+ "    (DEFAULT,'Kiko Caballero');");
		insertData("GRANDES_ALMACENES","MAQUINAS_REGISTRADORAS","(Codigo,Piso) values\r\n"
				+ "\r\n"
				+ "	(DEFAULT,1),\r\n"
				+ "    (DEFAULT,2),\r\n"
				+ "    (DEFAULT,3),\r\n"
				+ "    (DEFAULT,4),\r\n"
				+ "    (DEFAULT,5),\r\n"
				+ "    (DEFAULT,6),\r\n"
				+ "    (DEFAULT,7),\r\n"
				+ "    (DEFAULT,8),\r\n"
				+ "    (DEFAULT,9),\r\n"
				+ "    (DEFAULT,10);");

		getValues("GRANDES_ALMACENES","PRODUCTOS",3);
		getValues("GRANDES_ALMACENES","CAJEROS",2);
		getValues("GRANDES_ALMACENES","MAQUINAS_REGISTRADORAS",2);
		getValues("GRANDES_ALMACENES","VENTA",3);

		closeConnection();
		
		
		//Ejercicio 9
		openConnection();
		
		createDB("bd_investigadores");
		
		createTable("bd_investigadores","facultad","(\r\n"
				+ "	codigo INT,\r\n"
				+ "    nombre NVARCHAR(100),\r\n"
				+ "    PRIMARY KEY (codigo)\r\n"
				+ ");");
		createTable("bd_investigadores","investigadores","(\r\n"
				+ "	DNI VARCHAR(8),\r\n"
				+ "    nomApels NVARCHAR(255),\r\n"
				+ "    facultad INT,\r\n"
				+ "    PRIMARY KEY (DNI),\r\n"
				+ "    FOREIGN KEY (facultad) REFERENCES facultad (codigo)\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ");");
		createTable("bd_investigadores","equipos","(\r\n"
				+ "	numSerie CHAR(4),\r\n"
				+ "    nombre NVARCHAR(100),\r\n"
				+ "    facultad INT,\r\n"
				+ "    PRIMARY KEY (numSerie),\r\n"
				+ "    FOREIGN KEY (facultad) REFERENCES facultad (codigo)\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ");");
		createTable("bd_investigadores","reserva","(\r\n"
				+ "	DNI VARCHAR(8),\r\n"
				+ "    numSerie CHAR(4),\r\n"
				+ "    comienzo DATETIME,\r\n"
				+ "    fin DATETIME,\r\n"
				+ "    PRIMARY KEY (DNI, numSerie),\r\n"
				+ "    FOREIGN KEY (DNI) REFERENCES investigadores (DNI)\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE,\r\n"
				+ "    FOREIGN KEY (numSerie) REFERENCES equipos (numSerie)\r\n"
				+ "    ON DELETE CASCADE ON UPDATE CASCADE\r\n"
				+ ");");
		
		insertData("bd_investigadores","facultad"," values\r\n"
				+ "(1, 'Facultad de Agronomía'),\r\n"
				+ "(2, 'Facultad de Arquitectura'),\r\n"
				+ "(3, 'Facultad de Ciencias de la Educación'),\r\n"
				+ "(4, 'Facultad de Ciencias Económicas'),\r\n"
				+ "(5, 'Facultad de Química'),\r\n"
				+ "(6, 'Facultad de Ciencias Sociales'),\r\n"
				+ "(7, 'Facultad de Derecho'),\r\n"
				+ "(8, 'Facultad de Educación Física'),\r\n"
				+ "(9, 'Facultad de Filosofía'),\r\n"
				+ "(10, 'Facultad de Humanidades ');");
		insertData("bd_investigadores","investigadores"," values\r\n"
				+ "('85648262', 'Jose Manuel Medrano', 1),\r\n"
				+ "('54647823', 'Jose Antonio Pelaez', 2),\r\n"
				+ "('46543225', 'Elsa Rus', 8),\r\n"
				+ "('68826015', 'Lara Osorio', 4),\r\n"
				+ "('46865330', 'Armando Mohamed', 2),\r\n"
				+ "('45643205', 'Mireia Novo', 3),\r\n"
				+ "('46481887', 'Ander Alcala', 5),\r\n"
				+ "('46304124', 'Aroa Avila', 9),\r\n"
				+ "('66005485', 'Matilde Pérez', 10),\r\n"
				+ "('45642230', 'Dylan Robles', 6);");
		insertData("bd_investigadores","equipos"," values\r\n"
				+ "('0001', 'Equipo1', 2),\r\n"
				+ "('0002', 'Equipo2', 6),\r\n"
				+ "('0003', 'Equipo3', 2),\r\n"
				+ "('0004', 'Equipo4', 7),\r\n"
				+ "('0005', 'Equipo5', 3),\r\n"
				+ "('0006', 'Equipo6', 1),\r\n"
				+ "('0007', 'Equipo7', 9),\r\n"
				+ "('0008', 'Equipo8', 4),\r\n"
				+ "('0009', 'Equipo9', 10),\r\n"
				+ "('0010', 'Equipo10', 1);");
		insertData("bd_investigadores","reserva"," values\r\n"
				+ "('45642230', '0009', '2018-02-20 12:00:00', '2018-01-01 12:00:00'),\r\n"
				+ "('45643205', '0002', '2016-05-12 12:00:00', '2017-01-31 12:00:00'),\r\n"
				+ "('54647823', '0004', '2020-06-13 12:00:00', '2020-07-05 12:00:00'),\r\n"
				+ "('68826015', '0006', '2019-06-29 12:00:00', '2019-08-13 12:00:00'),\r\n"
				+ "('54647823', '0003', '2018-01-03 12:00:00', '2018-04-23 12:00:00'),\r\n"
				+ "('85648262', '0001', '2017-01-20 12:00:00', '2017-03-21 12:00:00'),\r\n"
				+ "('46865330', '0007', '2019-03-10 12:00:00', '2019-05-20 12:00:00'),\r\n"
				+ "('66005485', '0010', '2020-04-17 12:00:00', '2020-05-19 12:00:00'),\r\n"
				+ "('85648262', '0005', '2020-10-10 12:00:00', '2021-01-01 12:00:00'),\r\n"
				+ "('45642230', '0003', '2017-04-25 12:00:00', '2017-06-21 12:00:00');");

		getValues("bd_investigadores","facultad",2);
		getValues("bd_investigadores","investigadores",3);
		getValues("bd_investigadores","equipos",3);
		getValues("bd_investigadores","reserva",4);

		closeConnection();
								
	}

	
	//METODO QUE ABRE LA CONEXION CON SERVER MYSQL
	public static void openConnection() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection("jdbc:mysql://localhost:3306?useTimezone=true&serverTimezone=UTC","root","root");//credenciales temporales
			System.out.println("Server Connected");
			fecha();
			
		}catch(SQLException | ClassNotFoundException ex  ){
			System.out.println("No se ha podido conectar con mi base de datos");
			fecha();
			System.out.println(ex.getMessage());
			
		}
		
	}
		
	//METODO QUE CIERRA LA CONEXION CON SERVER MYSQL
	public static void closeConnection() {
		try {
	
			conexion.close();
			System.out.println("Server Disconnected");
			fecha();
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error cerrando conexion");
			fecha();
		}
	}
	
	//METODO QUE CREA LA BASE DE DATOS
	public static void createDB(String name) {
		try {
			String Query="DROP DATABASE IF EXISTS "+ name;
			Statement st= conexion.createStatement();
			st.executeUpdate(Query);
			
			Query="CREATE DATABASE "+ name;
			st= conexion.createStatement();
			st.executeUpdate(Query);
			System.out.println("DB creada con exito!");
			
		JOptionPane.showMessageDialog(null, "Se ha creado la DB " +name+ " de forma exitosa.");
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error creando la DB.");
		}	
	}

	//METODO QUE CREA TABLAS MYSQL
	public static void createTable(String db,String name, String columnas) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb= conexion.createStatement();
			stdb.executeUpdate(Querydb);
			
			try {
			String Query = "CREATE TABLE " + name + columnas;
			Statement st= conexion.createStatement();
			st.executeUpdate(Query);
			}catch(SQLException ex) {
				System.out.println(ex.getMessage());
				System.out.println("Error de sintaxis del codigo MySQL pasado por cadena.");
			}
			System.out.println("Tabla creada con exito!");
			
		}catch (SQLException ex){
			System.out.println(ex.getMessage());
			System.out.println("Error creando tabla.");
			
		}
		
	}
	
	//METODO QUE INSERTA DATOS EN TABLAS MYSQL
	public static void insertData(String db, String table_name, String datos) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb= conexion.createStatement();
			stdb.executeUpdate(Querydb);
						
			String Query = "INSERT INTO " + table_name + " " + datos;
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Datos almacenados correctamente");;
			
		} catch (SQLException ex ) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error en el almacenamiento");
		}
					
	}
	
	//METODO QUE OBTIENE VALORES MYSQL
	public static void getValues(String db, String table_name, int numColumnas) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb= conexion.createStatement();
			stdb.executeUpdate(Querydb);
						
			String Query = "SELECT * FROM " + table_name;
			Statement st = conexion.createStatement();
			java.sql.ResultSet resultSet;
			resultSet = st.executeQuery(Query);
			
			while (resultSet.next()) {
				System.out.println("");
				for (int j = 1; j <= numColumnas; j++)
					System.out.print(resultSet.getString(j) + " ");
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			System.out.println("Error en la adquisicion de datos");
		}
	
	}
	 
	//METODO QUE LIMPIA TABLAS MYSQL
	public static void deleteRecord(String db, String table_name, String ID) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb= conexion.createStatement();
			stdb.executeUpdate(Querydb);
						
			String Query = "DELETE FROM " + table_name + " WHERE ID = \"" + ID + "\"";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("Registros de tabla ELIMINADOS con exito!");
						
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando el registro especificado");
		}
	}	

	
	//METODO QUE ELIMINA TABLAS MYSQL
	public static void deleteTAbla(String db, String table_name) {
		try {
			String Querydb = "USE "+db+";";
			Statement stdb= conexion.createStatement();
			stdb.executeUpdate(Querydb);
						
			String Query = "DROP TABLE " + table_name + ";";
			Statement st = conexion.createStatement();
			st.executeUpdate(Query);
			
			System.out.println("TABLA ELIMINADA con exito!");
						
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
			JOptionPane.showMessageDialog(null, "Error borrando la tabla");
		}
	}	
	
	
	//METODO QUE MUESTRA FECHA
	public static void fecha() {
		Date date = new Date();
		DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
		System.out.println(" - " + hourdateFormat.format(date));
		}
	
	

}
