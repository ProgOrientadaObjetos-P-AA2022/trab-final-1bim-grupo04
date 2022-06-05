/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete05;

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
public class ArchivoLecturaCo {

    private ObjectInputStream entrada;
    private ArrayList<Constructora> constructoras;
    private String nombreArchivo;
    private String cedula;
    private Constructora constructoraB;

    public ArchivoLecturaCo(String n) {
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

    public void establecerConstructoras() {
        constructoras = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constructoras.add(registro);
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

    public void establecerConstructoraB() {

        File f = new File(nombreArchivo);
        while (true) {
            if (f.exists()) {

                try {
                    Constructora registro = (Constructora) entrada.readObject();

                    if (registro.obtenerID().equals(cedula)) {

                        constructoraB = registro;

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

    public ArrayList<Constructora> obtenerConstructoras() {
        return constructoras;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public String obtenerIdentificador() {
        return cedula;
    }

    public Constructora obtenerConstructoraB() {
        return constructoraB;
    }

    @Override
    public String toString() {
        String cadena = "Constructoras\n";
        for (int i = 0; i < constructoras.size(); i++) {
            Constructora co = constructoras.get(i);
            cadena = String.format("%s(%d) %s-%s\n", cadena,
                    i + 1,
                    co.obtenerNombre(),
                    co.obtenerID());
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
