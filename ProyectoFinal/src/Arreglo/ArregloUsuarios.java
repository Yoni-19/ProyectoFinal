package Arreglo;

import java.util.ArrayList;

import clase.Usuario;

public class ArregloUsuarios{
	
	private ArrayList<Usuario> lista = new ArrayList<>();

    public void registrar(Usuario u) {
        lista.add(u);
    }

    public boolean validar(String usuario, String contraseña) {
        for (Usuario u : lista) {
            if (u.getUsuario().equals(usuario) && u.getContraseña().equals(contraseña)) {
                return true;
            }
        }
        return false;
    }

    public boolean existe(String usuario) {
        for (Usuario u : lista) {
            if (u.getUsuario().equals(usuario)) return true;
        }
        return false;
    }
}
