/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete02;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ArchivoEscrituraP {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Propietario registro;
    private ArrayList<Propietario> propietarios;

    public ArchivoEscrituraP(String n) {
        nombreArchivo = n;
        establecerPropietarios();

        try {

            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (propietarios.size() > 0) {
                for (int i = 0; i < propietarios.size(); i++) {
                    establecerRegistro(propietarios.get(i));
                    establecerSalida();
                }
            }

        } catch (IOException IOexception) {
            System.out.println("Error al abrir el archivo");
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registro);
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo");
        }
    }

    public void establecerRegistro(Propietario n) {
        registro = n;
    }

    public void establecerPropietarios() {
        ArchivoLecturaP p = new ArchivoLecturaP(nombreArchivo);
        p.establecerPropietarios();
        propietarios = p.obtenerPropietarios();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Propietario> obtenerPropietarios() {
        return propietarios;
    }

    public ObjectOutputStream obtenerSalida() {
        return salida;
    }

    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } catch (IOException ioException) {
            System.out.println("Error al cerrar el archivo");
        }
    }

}
