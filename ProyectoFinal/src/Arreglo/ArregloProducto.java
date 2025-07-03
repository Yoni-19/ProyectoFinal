package Arreglo;

import java.util.ArrayList;

import clase.Producto;

public class ArregloProducto {
private ArrayList<Producto> prod;
//Constructor para inicializar el ArrayList
	public ArregloProducto() {
		prod = new ArrayList<>();
	}

public void Agregar(Producto p) {
	prod.add(p);
}
public String listar() {
    String texto = "";

    // Encabezados
    texto += "Código\tNombre\tPrecio\tStock\n";
    
    // Datos de los productos
    for (Producto p : prod) {
        texto += p.getCodigo() + "\t" + p.getNombre() + "\t" + p.getPrecio() + "\t" 
              + p.getStock() + "\n";
    }
    return texto;
}
public Producto buscar(String cod) {
	for (Producto p : prod) {
		if (p.getCodigo().equals(cod)) {
			return p;
		}
	}
	return null;
}
public Producto buscar(String nombre, boolean buscarPorNombre) {
	for (Producto p : prod) {
		if (p.getNombre().equals(nombre)) {
			return p;
		}
	}
	return null;
}
public boolean eliminar(String cod) {
    for (Producto p : prod) {
        if (p.getCodigo().equals(cod)) {
            prod.remove(p);
            return true;
        }
    }
    return false;
}


}
