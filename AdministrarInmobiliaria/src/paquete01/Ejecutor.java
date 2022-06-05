/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;
import java.util.Scanner;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import paquete06.Casa;
import paquete06.Departamento;

/**
 *
 * @author reroes
 */
public class Ejecutor {
    
    Scanner sc = new Scanner(System.in);
    
        String nomEdificio;
        String ubiEdificio;
        Propietario propietario;
        Barrio barrio;
        Ciudad ciudad;
        Constructora constructora;
        double precioXm;
        double numMetros;
        
        int numCuartos;

    public static void main(String[] args) {
        Ejecutor obj = new Ejecutor();
        int opc;
        do{
            opc = obj.menu();
            switch (opc) {
                case 1:
                    
            }
        }while (opc != 0);
        
    }
    
    public int menu() {
        
        int op;
        System.out.println("Ingrese el número correspondiente a la opción: ");
        System.out.println("[1].Ingresar nueva Casa:               ");
        System.out.println("[2].Ingresar nuevo Departamento:       ");
        System.out.println("[3].Ingresar nuevo Propietario:        ");
        System.out.println("[4].Ingresar nuevo Barrio:             ");
        System.out.println("[5].Ingresar nueva Ciudad:             ");
        System.out.println("[6].Ingresar nueva Constructora:       ");
        System.out.println("[7].Observar Listas:                   ");
        System.out.println("[0].Salir del Programa:                ");

        op = sc.nextInt();
       
        return op;
    }
    


}
