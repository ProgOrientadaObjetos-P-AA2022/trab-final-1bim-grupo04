/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete05;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ArchivoEscrituraCo {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Constructora registro;
    private ArrayList<Constructora> constructoras;

    public ArchivoEscrituraCo(String n) {
        nombreArchivo = n;
        establecerConstructoras();

        try {

            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (constructoras.size() > 0) {
                for (int i = 0; i < constructoras.size(); i++) {
                    establecerRegistro(constructoras.get(i));
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

    public void establecerRegistro(Constructora n) {
        registro = n;
    }

    public void establecerConstructoras() {
        ArchivoLecturaCo co = new ArchivoLecturaCo(nombreArchivo);
        co.establecerConstructoras();
        constructoras = co.obtenerConstructoras();
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Constructora> obtenerPropietarios() {
        return constructoras;
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
