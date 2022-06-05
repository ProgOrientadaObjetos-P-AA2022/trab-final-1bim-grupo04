package paquete03;

/**
 *
 * @author reroes
 */
public class Barrio {

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

}
