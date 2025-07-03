-- CREACIÓN DE BASE DE DATOS
CREATE DATABASE MINIMARKET;
USE MINIMARKET;

-- TABLAS

CREATE TABLE Producto (
    cod_Prod VARCHAR(10) PRIMARY KEY,
    nom_Prod VARCHAR(50) NOT NULL,
    precio DECIMAL(10,2) NOT NULL,
    stock INT NOT NULL
);

CREATE TABLE Proveedor (
    id_Prov VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    telefono VARCHAR(15),
    correo VARCHAR(50)
);

CREATE TABLE Cliente (
    id_Cli VARCHAR(10) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    apellido VARCHAR(50) NOT NULL,
    productoDeseado VARCHAR(50),
    cantidad INT NOT NULL
);

CREATE TABLE Pedido (
    id INT AUTO_INCREMENT PRIMARY KEY,
    id_Cli VARCHAR(10),
    detalle TEXT NOT NULL,
    montoTotal DECIMAL(10,2)
);

CREATE TABLE Usuario (
    nombre VARCHAR(50) PRIMARY KEY,
    contrasena VARCHAR(100) NOT NULL
);

-- PROCEDIMIENTOS ALMACENADOS

-- PRODUCTO

CREATE PROCEDURE sp_ListarProductos()
SELECT * FROM Producto;


CREATE PROCEDURE sp_InsertarProducto(
    cod VARCHAR(10),
    nom VARCHAR(50),
    pre DECIMAL(10,2),
    stock INT
)
INSERT INTO Producto (cod_Prod, nom_Prod, precio, stock)
VALUES (cod, nom, pre, stock);


CREATE PROCEDURE sp_ModificarPrecio(
    cod VARCHAR(10),
    nuevoPrecio DECIMAL(10,2)
)
UPDATE Producto SET precio = nuevoPrecio WHERE cod_Prod = cod;


CREATE PROCEDURE sp_AgregarStockProducto(
    cod VARCHAR(10),
    cantidad INT
)
UPDATE Producto SET stock = stock + cantidad WHERE cod_Prod = cod;

CREATE PROCEDURE sp_ReducirStockProducto(
    IN cod VARCHAR(10),
    IN cantidad INT
)
UPDATE Producto
SET stock = stock - cantidad
WHERE cod_Prod = cod;


CREATE PROCEDURE sp_EliminarProducto(cod VARCHAR(10))
DELETE FROM Producto WHERE cod_Prod = cod;


CREATE PROCEDURE sp_BuscarProductoPorCodigo(cod VARCHAR(10))
SELECT * FROM Producto WHERE cod_Prod = cod;


CREATE PROCEDURE sp_BuscarProductoPorNombre(nom VARCHAR(50))
SELECT * FROM Producto WHERE nom_Prod = nom;


-- PROVEEDOR
CREATE PROCEDURE sp_InsertarProveedor(
    id VARCHAR(10),
    nom VARCHAR(50),
    tel VARCHAR(15),
    email VARCHAR(50)
)
INSERT INTO Proveedor (id_Prov, nombre, telefono, correo)
VALUES (id, nom, tel, email);

CREATE PROCEDURE sp_EliminarProveedor(cod VARCHAR(10))
DELETE FROM Proveedor WHERE id_Prov = cod;


CREATE PROCEDURE sp_ListarProveedores()
SELECT * FROM Proveedor;

CREATE PROCEDURE sp_BuscarProveedor(id VARCHAR(10))
SELECT * FROM Proveedor WHERE id_Prov = id;

-- CLIENTE
CREATE PROCEDURE sp_InsertarClientePedidoSimple(
    id VARCHAR(10),
    nom VARCHAR(50),
    ape VARCHAR(50),
    prod VARCHAR(50),
    cantidad INT 
)

INSERT INTO Cliente (id_Cli, nombre, apellido, productoDeseado, cantidad)
VALUES (id, nom, ape, prod, cantidad);


CREATE PROCEDURE sp_EliminarCliente(id VARCHAR(10))
DELETE FROM Cliente WHERE id_Cli = id;


CREATE PROCEDURE sp_ListarCliente()
SELECT * FROM Cliente;

CREATE PROCEDURE sp_BuscarCliente(id VARCHAR(10))
SELECT * FROM Cliente WHERE id_Cli = id;

-- USUARIO
CREATE PROCEDURE sp_InsertarUsuario(
    IN nom VARCHAR(50),
    IN pass VARCHAR(100)
)

INSERT INTO Usuario (nombre, contrasena)
VALUES (nom, pass);


CREATE PROCEDURE sp_VerificarUsuario(
    IN nom VARCHAR(50),
    IN pass VARCHAR(100)
)
SELECT * FROM Usuario
WHERE nombre = nom AND contrasena = pass;


CREATE PROCEDURE sp_ListarUsuarios()
SELECT * FROM Usuario;


-- DATOS DE PRUEBA OPCIONALES

-- Productos
INSERT INTO Producto VALUES('P01','CEBOLLA','5.30',0);
INSERT INTO Producto VALUES('P02','LECHE','7.84',0);
INSERT INTO Producto VALUES('P03','TOMATE','2.30',0);
INSERT INTO Producto VALUES('P04','CARNE','10.20',0);
INSERT INTO Producto VALUES('P05','ZANAHORIA','4.90',0);
CALL sp_InsertarProducto('P06','SANDIA','12.40',14);
CALL sp_AgregarStockProducto('P06',30);
CALL sp_ModificarPrecio('P03',5.40);

-- Proveedores
INSERT INTO Proveedor VALUES('PR01','AAA','98745632','aaa@gmail.com');
INSERT INTO Proveedor VALUES('PR02','BBB','98745636','bbb@gmail.com');
INSERT INTO Proveedor VALUES('PR03','CCC','98745647','ccc@gmail.com');
INSERT INTO Proveedor VALUES('PR04','DDD','98745698','ddd@gmail.com');
CALL sp_InsertarProveedor('PR05','EEE','98745666','EEE@gmail.com');

-- Usuarios
INSERT INTO Usuario VALUES('PEPE','1234');

-- Clientes de ejemplo
CALL sp_InsertarClientePedidoSimple('C01','CARLOS','JIMENEZ','ATÚN',20);