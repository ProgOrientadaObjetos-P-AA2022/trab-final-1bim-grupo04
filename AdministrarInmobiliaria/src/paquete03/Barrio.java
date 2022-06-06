package paquete03;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Barrio implements Serializable {

    private String nombre;
    private String referencia;

    public Barrio(String nom, String r) {
        nombre = nom;
        referencia = r;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerReferencia(String n) {
        referencia = n;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerReferencia() {
        return referencia;
    }

    @Override
    public String toString() {
        String cadena = String.format("%s - %s\n",
                obtenerNombre(),
                obtenerReferencia());
        return cadena;
    }
}
