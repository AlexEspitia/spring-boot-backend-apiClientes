/* Populate tabla ciudades */
INSERT INTO ciudades (id,nombre ) VALUES(1,'Bogota' );
INSERT INTO ciudades (id,nombre ) VALUES(2,'Cali' );
INSERT INTO ciudades (id,nombre ) VALUES(3,'Medellin');
INSERT INTO ciudades (id,nombre ) VALUES(4,'Armenia');
INSERT INTO ciudades (id,nombre ) VALUES(5,'Pereira');
INSERT INTO ciudades (id,nombre ) VALUES(6,'Manizales');
INSERT INTO ciudades (id,nombre ) VALUES(7,'Barranquilla');
INSERT INTO ciudades (id,nombre) VALUES(8,'Santa Martha');


/* Populate tabla clientes */
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(1,'Andres', 'Guzman', 'profesor@bolsadeideas.com', '2018-01-01');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(2,'Mr. John', 'Doe', 'john.doe@gmail.com', '2018-01-02');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(3,'Lina', 'Torres', 'linus.torvalds@gmail.com', '2018-01-03');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(4,'Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '2018-01-04');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(5,'Erich', 'Gamma', 'erich.gamma@gmail.com', '2018-02-01');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(6,'Richard', 'Helm', 'richard.helm@gmail.com', '2018-02-10');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(7,'Ralph', 'Johnson', 'ralph.johnson@gmail.com', '2018-02-18');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(8,'John', 'Parra', 'john.vlissides@gmail.com', '2018-02-28');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(1,'Dr. James', 'Gosling', 'james.gosling@gmail.com', '2018-03-03');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(2,'Magma', 'Lee', 'magma.lee@gmail.com', '2018-03-04');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(3,'Tornado', 'Roe', 'tornado.roe@gmail.com', '2018-03-05');
INSERT INTO clientes (ciudad_id, nombre, apellido, email, fecha) VALUES(4,'Jairi', 'Doe', 'jane.doe@gmail.com', '2018-03-06');


INSERT INTO usuarios (username, password, enabled, nombre, apellido, email ) VALUES('alex','$2a$10$lzSLx6bhX2tGQKQCsdRW/etmjgx0Nxb5.A9xnF44mkLkfC.f8yLyW',1,'Alexander','torres','alextorres@gmail.com');
INSERT INTO usuarios (username, password, enabled, nombre, apellido, email ) VALUES('admin','$2a$10$ZiVkafds6m2xH3u2tf/Ohe8CuatuS0ZSqXrmIbFWiRhZNJEN70Byi',1,'Alex','Gómez','alex@gmail.com');

INSERT INTO roles (nombre) VALUES('ROLE_USER');
INSERT INTO roles (nombre) VALUES('ROLE_ADMIN');

INSERT INTO usuarios_roles (usuario_id, role_id ) VALUES(1,1);
INSERT INTO usuarios_roles (usuario_id, role_id ) VALUES(2,2);
INSERT INTO usuarios_roles (usuario_id, role_id ) VALUES(2,1);

/* Populate tabla productos */
INSERT INTO productos (nombre, precio, fecha) VALUES('PORTATIL ACER A315-56-31KC - INTEL CORE I3 1005G1 - 8GB DDR4 - 256GB SSD - PANTALLA 15,6 HD - NO DVD - WINDOWS 11 - SHALE BLACK', 1500000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('PORTATIL ACER NITRO AN51-57-53J2 - INTEL CORE I5 11400H - 8GB DDR4 - 512GB SSD - PANT 15,6 FHD - NO DVD - GEFORCE GTX 1650 4GB GDDR6 - WIN 11 - SHALE BLACK', 3600000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('PORTATIL ASUS X415EA-EB1811W - INTEL PENTIUM GOLD 7505 - 8GB DDR4 - 256GB SSD - PANTALLA 14 FHD - NO DVD - WINDOWS 11 - TRANSPARENT SILVER', 1250000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('PORTATIL ASUS X415JA-BV2198 - INTEL CORE I3 1005G1 - 4GB DDR4 - 256GB SSD - PANTALLA 14 HD - NO DVD - ENDLESS - SLATE GREY', 1400000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('PORTATIL ASUS M1402IA-EK094 - AMD RYZEN 5 4600H - 8GB DDR4 - 512GB SSD - PANTALLA 14 FHD - NO DVD - KEEP OS - QUIET BLUE', 1990000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('PORTATIL ASUS K513EA-BQ1796 - INTEL CORE I5 1135G7 - 8GB DDR4 - 512GB SSD - PANTALLA 15,6 FHD - NO DVD - ENDLESS - TRANSPARENT SILVER ', 2500000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('PORTATIL ASUS X515EA-BQ2601 - INTEL CORE I7 1165G7 - 8GB DDR4 - 512GB SSD - PANTALLA 15,6 FHD - NO DVD - HDMI - ENDLESS - SLATE GREY ', 3000000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('CELULAR MOTO E20 - PANTALLA 6.5 - OCTA CORE (1,6GHZ / 1,2GHZ) - 32GB - MEMORIA 2GB - DOBLE CAMARA - ANDROID 11 - LEC HUELLA - DUAL SIM - 4G LTE - GRIS', 450000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('CELULAR MOTO E22I - PANTALLA 6,5 - OCTA CORE 2,3GHZ / 1,8GHZ - 64GB - MEMORIA 2GB - DOBLE CAMARA - ANDROID 12 - LEC HUELLA - DUAL SIM - 4G LTE - BLANCO $', 520000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('CELULAR SAMSUNG A03 CORE SM-A032M - PANTALLA 6,5 - OCTA CORE 1,6GHZ/ 1,2GHZ - 32GB - MEMORIA 2GB - DOBLE CAMARA - ANDROID 11 - DUAL SIM - 4G - VERDE', 450000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('CELULAR SAMSUNG A03S SM-A037M - PANT 6,5 - OCTA CORE 2,3GHZ/ 1,8GHZ - 64GB - MEMORIA 4GB - TRIPLE CAMARA - ANDROID 11 - DUAL SIM +4G - NEGRO', 600000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('CELULAR XIAOMI REDMI A1 - PANTALLA 6,5 - QUAD CORE 2,0GHZ - 32GB - MEM 2GB - DOBLE CAMARA - ANDROID GO - SINGLE SIM - 4G LTE - NEGRO', 400000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('CELULAR XIAOMI REDMI 10A - PANTALLA 6,5 - OCTA CORE 2,0GHZ - 64GB - MEM 3GB - TRIPLE CAMARA - ANDROID 11 - DUAL SIM - 4G LTE - BLUE ', 599000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('CELULAR XIAOMI REDMI NOTE 11S - PANTALLA 6,4 - OCTA CORE 2,0GHZ - 128GB - MEMORIA 8GB - CUATRO CAMARAS - ANDROID 11 - DUAL SIM - 4G LTE - AZUL OCASO', 1100000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('TELEVISOR LED SAMSUNG 32 T4300 - HD - SMART TV - TDT -UN32T4300AKXZL', 870000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('TABLET LENOVO TB-8505X - PANTALLA 8.0 - QUAD CORE 2.0GHZ - 32GB - MEMORIA 2GB - ANDROID 9.0 - DOBLE CAMARA - 4G LTE - GRIS PLATINO ', 520000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('TODO EN UNO HP 22-DD2004LA - INTEL CELERON J4025 - 4GB DDR4 - 256GB SSD - PANTALLA 21,5 FHD - NO DVD - HDMI - FREEDOS - NEGRO - 693C9LA#ABM', 1230000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('PC DELL OPTIPLEX UFF 3090 - INTEL CORE I3 1115G4 - 8GB DDR4 - 1 TERA - NO DVD + MONITOR 18,5 - UBUNTU - O309UFI3S81TUBP3W ( IVA INCLUIDO )', 1700000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('IMPRESORA CANON G3110 RECARGA CONTINUA - MULTIFUNCIONAL - WIFI', 760000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('VIDEO PROYECTOR EPSON POWERLITE E20 - 3400 LUMENS - RESOLUCION XGA - HDMI', 2800000, now());
INSERT INTO productos (nombre, precio, fecha) VALUES('MOUSE INALAMBRICO TRUST PRIMO - 1600DPI - BLANCO MATE - TIPO DE CONECTOR USB', 45000, now());

/* Creamos facturas */
INSERT INTO facturas (descripcion, observacion, cliente_id, fecha) VALUES(' Equipos para oficina', null, 1, now());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 8);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 19);

INSERT INTO facturas (descripcion, observacion, cliente_id, fecha) VALUES('Accesorios para oficina', 'para las secretarias', 1, now());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 21);












