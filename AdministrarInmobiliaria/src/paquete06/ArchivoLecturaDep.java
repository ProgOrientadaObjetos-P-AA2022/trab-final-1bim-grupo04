/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete06;

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
public class ArchivoLecturaDep {

    private ObjectInputStream entrada;
    private ArrayList<Departamento> departamentos;
    private String nombreArchivo;

    public ArchivoLecturaDep(String n) {
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

    public void establecerDepartamento() {
        departamentos = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamentos.add(registro);
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

    public ArrayList<Departamento> obtenerDep() {
        return departamentos;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "Propietarios\n";
        for (int i = 0; i < departamentos.size(); i++) {
            cadena = String.format("%s(%d) Informacion del Departamento\n"
                    + "PROPIETARIO\n"
                    + "\tNombres: %s "
                    + "Apellidos: %s "
                    + "Identificacion: %s\n"
                    + "ESPECIFICACIONES\n"
                    + "\tNombre Edificio: %s "
                    + "Ubicación en el Edificio: %s\n"
                    + "\tPrecio por metro cuadrado: %.2f "
                    + "Numero de metros cuadrados: %.2f\n"
                    + "\tValor Alícuota Mensual: %.2f "
                    + "Costo final: %.2f\n"
                    + "BARRIO\n"
                    + "\tNombre Barrio: %s "
                    + "Referencia%s\n"
                    + "CIUDAD\n"
                    + "\tNombre Ciudad: %s "
                    + "Nombre Provincia: %s\n"
                    + "CONSTRUCTORA\n"
                    + "\tNombre Constructora: %s "
                    + "ID Empresa: %s\n",
                    cadena,
                    (i + 1),
                    departamentos.get(i).obtenerPropietario().obtenerNombre(),
                    departamentos.get(i).obtenerPropietario().obtenerApellido(),
                    departamentos.get(i).obtenerPropietario().obtenerCedula(),
                    departamentos.get(i).obtenerNomEdificio(),
                    departamentos.get(i).obtenerUbiEdificio(),
                    departamentos.get(i).obtenerPrecioXm(),
                    departamentos.get(i).obtenerNumMetros(),
                    departamentos.get(i).obtenerAlicuota(),
                    departamentos.get(i).obtenerCostoFinal(),
                    departamentos.get(i).obtenerBarrio().obtenerNombre(),
                    departamentos.get(i).obtenerBarrio().obtenerReferencia(),
                    departamentos.get(i).obtenerCiudad().obtenerNombre(),
                    departamentos.get(i).obtenerCiudad().obtenerProvincia(),
                    departamentos.get(i).obtenerConstructora().obtenerNombre(),
                    departamentos.get(i).obtenerConstructora().obtenerID());

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
