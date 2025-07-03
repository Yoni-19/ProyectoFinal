package Arreglo;

import java.util.ArrayList;

import clase.Proveedor;

public class ArregloProveedor {

	 private ArrayList<Proveedor> proveedor;

	    public ArregloProveedor() {
	        proveedor = new ArrayList<>();
	    }

	    public void adicionar(Proveedor p) {
	        proveedor.add(p);
	    }

	    public Proveedor buscarId(String id) {
	        for (Proveedor p : proveedor) {
	            if (p.getId().equals(id)) return p;
	        }
	        return null;
	    }

	    public boolean existeNombre(String nombre) {
	        for (Proveedor p : proveedor) {
	            if (p.getNombre().equals(nombre)) return true;
	        }
	        return false;
	    }

	    public boolean existeTelefono(String telefono) {
	        for (Proveedor p : proveedor) {
	            if (p.getTelefono().equals(telefono)) return true;
	        }
	        return false;
	    }

	    public boolean existeCorreo(String correo) {
	        for (Proveedor p : proveedor) {
	            if (p.getCorreo().equals(correo)) return true;
	        }
	        return false;
	    }

	    public String listar() {
	        String texto = "ID\tNombre\tTeléfono\tCorreo\n";
	        for (Proveedor p : proveedor) {
	            texto += p.getId() + "\t" + p.getNombre() + "\t" + p.getTelefono() + "\t" + p.getCorreo() + "\n";
	        }
	        return texto;
	    }
	    public void eliminar(String id) {
	        for (int i = 0; i < proveedor.size(); i++) {
	            if (proveedor.get(i).getId().equalsIgnoreCase(id)) {
	                proveedor.remove(i);
	                break;
	            }
	        }
	    }
}
