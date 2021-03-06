/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete02;

import java.io.Serializable;

/**
 *
 * @author reroes
 */
public class Propietario implements Serializable {

    private String nombre;
    private String apellido;
    private String cedula;

    public Propietario(String nom, String ape, String ced) {
        nombre = nom;
        apellido = ape;
        cedula = ced;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public void establecerApellido(String n) {
        apellido = n;
    }

    public void establecerCedula(String n) {
        cedula = n;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public String obtenerApellido() {
        return apellido;
    }

    public String obtenerCedula() {
        return cedula;
    }

    @Override
    public String toString() {
        String cadena = String.format("%s - %s - %s\n",
                 obtenerNombre(),
                obtenerApellido(),
                obtenerCedula());
        return cadena;
    }

}
