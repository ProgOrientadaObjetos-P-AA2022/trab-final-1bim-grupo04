/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

/**
 *
 * @author reroes
 */
public class Constructora {

    private String nombreConstructora;
    private String id;

    public Enfermero(String nom, String i) {
        nombreConstructora = nom;
        id = i;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerID(String n) {
        id = n;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerID() {
        return id;
    }

}
