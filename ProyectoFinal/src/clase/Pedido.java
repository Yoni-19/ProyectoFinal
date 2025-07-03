package clase;

public class Pedido {
	private int idPedido;
    private String idCliente;

    public Pedido(int idPedido, String idCliente) {
        this.idPedido = idPedido;
        this.idCliente = idCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public String getIdCliente() {
        return idCliente;
    }
}

