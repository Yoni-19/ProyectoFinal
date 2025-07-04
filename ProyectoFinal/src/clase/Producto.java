package clase;

import java.util.ArrayList;

public class Producto {
	
private String codigo, nombre;
private double precio;
private int stock;

public Producto(String codigo, String nombre, double precio, int stock) {
	
	this.codigo = codigo;
	this.nombre = nombre;
	this.precio = precio;
	this.stock = stock;
}

public String getCodigo() {
	return codigo;
}

public void setCodigo(String codigo) {
	this.codigo = codigo;
}

public String getNombre() {
	return nombre;
}

public void setNombre(String nombre) {
	this.nombre = nombre;
}

public double getPrecio() {
	return precio;
}

public void setPrecio(double precio) {
	this.precio = precio;
}

public int getStock() {
	return stock;
}

public void setStock(int stock) {
	this.stock = stock;
}
private ArrayList<Proveedor> proveedores = new ArrayList<>();

public void agregarProveedor(Proveedor p) {
    if (!proveedores.contains(p)) {
        proveedores.add(p);
    }
}
}
