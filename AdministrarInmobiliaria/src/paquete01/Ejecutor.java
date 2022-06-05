/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;
import java.util.Scanner;

/**
 *
 * @author reroes
 */
public class Ejecutor {
    
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
    }
    
    public int menu() {
        int op;
        System.out.println("Ingrese el número correspondiente");
        System.out.println("Crear Propietario[1] : ");
        System.out.println("Suma de Matriz             [2] : ");
        System.out.println("Resta de Matriz            [3] : ");
        System.out.println("Multiplicacion por escalar [4] : ");
        System.out.println("Transpuesta de una Matriz  [5] : ");
        System.out.println("Salir           [0] : ");
        op = sc.nextInt();
        return op;
    }

}
