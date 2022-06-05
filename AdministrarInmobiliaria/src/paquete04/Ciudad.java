package paquete04;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Ciudad implements Serializable {

    private String nombre;
    private String provincia;

    public Ciudad(String nom, String p) {
        nombre = nom;
        provincia = p;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerProvincia(String n) {
        provincia = n;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerProvincia() {
        return provincia;
    }

    @Override
    public String toString() {
        String cadena = String.format("%s - %s\n",
                obtenerNombre(),
                obtenerProvincia());
        return cadena;
    }

}
