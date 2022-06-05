package paquete05;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Constructora implements Serializable {

    private String nombreConstructora;
    private String id;

    public Constructora(String nom, String i) {
        nombreConstructora = nom;
        id = i;
    }

    public void establecerNombre(String n) {
        nombreConstructora = n;
    }

    public void establecerID(String n) {
        id = n;
    }

    public String obtenerNombre() {
        return nombreConstructora;
    }

    public String obtenerID() {
        return id;
    }

    @Override
    public String toString() {
        String cadena = String.format("%s - %s\n",
                obtenerNombre(),
                obtenerID());
        return cadena;
    }

}
