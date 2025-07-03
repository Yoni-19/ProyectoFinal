package clase;

public class Proveedor extends Persona{

	private String telefono;
    private String correo;

    public Proveedor(String id, String nombre, String telefono, String correo) {
        super(id, nombre);
        this.telefono = telefono;
        this.correo = correo;
    }

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}
    
}
