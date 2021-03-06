/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ArchivoEscrituraB {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Barrio registro;
    private ArrayList<Barrio> barrios;

    public ArchivoEscrituraB(String n) {
        nombreArchivo = n;
        establecerBarrios();

        try {

            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (barrios.size() > 0) {
                for (int i = 0; i < barrios.size(); i++) {
                    establecerRegistro(barrios.get(i));
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

    public void establecerRegistro(Barrio n) {
        registro = n;
    }

    public void establecerBarrios() {
        ArchivoLecturaB b = new ArchivoLecturaB(nombreArchivo);
        b.establecerBarrios();
        barrios = b.obtenerBarrios();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Barrio> obtenerBarrios() {
        return barrios;
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
