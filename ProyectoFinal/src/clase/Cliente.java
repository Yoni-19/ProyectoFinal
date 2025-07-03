package clase;

import java.util.ArrayList;

public class Cliente extends Persona{
	private String apellido;
    private ArrayList<Pedido> pedidos;

    public Cliente(String id, String nombre, String apellido) {
        super(id, nombre);
        this.apellido = apellido;
        this.pedidos = new ArrayList<>();
    }

    public String getApellido() {
        return apellido;
    }

    public void agregarPedido(Pedido p) {
        pedidos.add(p);
    }

    public ArrayList<Pedido> getPedidos() {
        return pedidos;
    }
}

