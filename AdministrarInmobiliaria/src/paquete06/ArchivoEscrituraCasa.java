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
public class ArchivoEscrituraCasa {
    private String nombreArchivo;
    private ObjectOutputStream salida;
    private Casa registro;
    private ArrayList<Casa> casas;
    
    public ArchivoEscrituraCasa(String n) {
        nombreArchivo = n;
        establecerCasas();
        
        try {
            
            salida = new ObjectOutputStream(new FileOutputStream(nombreArchivo));
            if (casas.size() > 0) {
                for (int i = 0; i < casas.size(); i++) {
                    establecerRegistro(casas.get(i));
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
    
    public void establecerRegistro(Casa n) {
        registro = n;
    }
    
    public void establecerCasas() {
        ArchivoLecturaCasa ca = new ArchivoLecturaCasa(nombreArchivo);
        ca.establecerCasa();
        casas = ca.obtenerCasas();
    }
    
    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }
    
    public ObjectOutputStream obtenerSalida() {
        return salida;
    }
    
    public ArrayList<Casa> obtenerCasas() {
        return casas;
    }
    
    public void cerrarArchivo() {
        try {
            if (salida != null) {
                salida.close();
            }
        } 
        catch (IOException ioException) {
            System.out.println("Error al cerrar el archivo");
        } 
    } 
    
}
