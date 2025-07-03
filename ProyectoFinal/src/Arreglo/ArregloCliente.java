package Arreglo;

import java.util.ArrayList;

import clase.Cliente;
import clase.Pedido;

public class ArregloCliente {
	private ArrayList<Cliente> clientes = new ArrayList<>();

    public void agregar(Cliente c) {
        clientes.add(c);
    }

    public Cliente buscar(String id) {
        for (Cliente c : clientes) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

 
    
    public void eliminar(String id) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equalsIgnoreCase(id)) {
                clientes.remove(i);
                break;
            }
        }
    }
}