/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete03;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class ArchivoLecturaB {

    private ObjectInputStream entrada;
    private ArrayList<Barrio> barrios;
    private String nombreArchivo;
    private String cedula;
    private Barrio barrioBuscado;

    public ArchivoLecturaB(String n) {
        nombreArchivo = n;
        File f = new File(nombreArchivo);
        if (f.exists()) {
            try {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } catch (IOException ioException) {
                System.out.println("Error al abrir el archivo" + ioException);
            }
        }
    }

    public void establecerBarrios() {
        barrios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    barrios.add(registro);
                } catch (EOFException endOfFileException) {
                    break;
                } catch (IOException ex) {
                    System.out.println("Error al leer el archivo");
                } catch (ClassNotFoundException ex) {
                    System.out.println("No se pudo crear el objeto" + ex);
                }
            }
        }

    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerCedula(String n) {
        cedula = n;
    }

    public void establecerBarrioBuscado() {

        // Preguntar
        File f = new File(nombreArchivo);
        System.out.println("5");
        while (true) {
            System.out.println("6");
            if (f.exists()) {

                try {
                    Barrio registro = (Barrio) entrada.readObject();

                    if (registro.obtenerNombre().equals(cedula)) {

                        barrioBuscado = registro;

                        break;
                    }
                } catch (EOFException endOfFileException) {
                    return;
                } catch (IOException ex) {
                    System.out.println("Error al leer el archivo");
                } catch (ClassNotFoundException ex) {
                    System.out.println("No se pudo crear el objeto" + ex);
                }

            }

        }
    }

    public ArrayList<Barrio> obtenerBarrios() {
        return barrios;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerCedula() {
        return cedula;
    }

    public Barrio obtenerBarrioBuscado() {
        return barrioBuscado;
    }

    @Override
    public String toString() {
        String cadena = "Barrios\n";
        for (int i = 0; i < barrios.size(); i++) {
            Barrio b = barrios.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    i + 1,
                    b.obtenerNombre(),
                    b.obtenerReferencia());
        }

        return cadena;
    }

    public void cerrarArchivo() {
        try {
            if (entrada != null) {
                entrada.close();
            }
        } catch (IOException ioException) {
            System.out.println("Error al cerrar el archivo");
        }
    }
}
