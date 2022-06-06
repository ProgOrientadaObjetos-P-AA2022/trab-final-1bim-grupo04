/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ArchivoEscrituraDep {

    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Departamento registro;
    private ArrayList<Departamento> dep;

    public ArchivoEscrituraDep(String n) {
        nombreArchivo = n;
        establecerDep();

        try {

            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (dep.size() > 0) {
                for (int i = 0; i < dep.size(); i++) {
                    establecerRegistro(dep.get(i));
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

    public void establecerRegistro(Departamento n) {
        registro = n;
    }

    public void establecerDep() {
        ArchivoLecturaDep d = new ArchivoLecturaDep(nombreArchivo);
        d.establecerDepartamento();
        dep = d.obtenerDep();
        
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public ArrayList<Departamento> obtenerDep() {
        return dep;
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
