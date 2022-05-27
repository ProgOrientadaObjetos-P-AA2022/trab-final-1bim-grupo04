/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

/**
 *
 * @author reroes
 */
public class Ciudad {
    
    private String nombre;
    private String provincia;

    public Ciudad(String nom, String p) {
        nombre = nom;
        provincia = r;
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
    
}
