/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.util.Scanner;
import paquete02.*;
import paquete03.*;
import paquete04.*;
import paquete05.*;
import paquete06.*;

/**
 *
 * @author reroes
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        
        //Datos por teclado
        String nomEdificio;
        String ubiEdificio;
        Propietario propietario;
        Barrio barrio;
        Ciudad ciudad;
        Constructora constructora;
        
        //calculos
        double precioXm;
        double numMetros;
        int op;
        int numCuartos;

        do {
            op = menu();
            switch (op) {
                //Casa
                case 1:
                    propietario = encontrarPropietarioB();
                    barrio = encontrarBarrioBuscado();
                    ciudad = encontrarCiudadBuscada();
                    constructora = encontrarConstructoraB();
                    System.out.println("Ingrese el valor del metro cuadrado: ");
                    precioXm = entrada.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados de la casa: ");
                    numMetros = entrada.nextDouble();
                    System.out.println("Ingrese el numero de cuartos de la casa: ");
                    numCuartos = entrada.nextInt();
                    Casa casa = new Casa(precioXm, numMetros, numCuartos,
                            propietario, barrio, ciudad, constructora);
                    casa.establecerCostoFinal();
                    ArchivoEscrituraCasa archivocasa
                            = new ArchivoEscrituraCasa("datos/casas.dat");
                    archivocasa.establecerRegistro(casa);
                    archivocasa.establecerSalida();
                    break;
                case 2:
                    propietario = encontrarPropietarioB();
                    barrio = encontrarBarrioBuscado();
                    ciudad = encontrarCiudadBuscada();
                    constructora = encontrarConstructoraB();
                    System.out.println("Ingrese el precio por metro cuadrado: ");
                    precioXm = entrada.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados: ");
                    numMetros = entrada.nextDouble();
                    System.out.println("Ingrese valor alicuota mensual: ");
                    Double valorAlicuota = entrada.nextDouble();
                    entrada.nextLine();
                    System.out.println("Ingrese el nombre del edificio: ");
                    nomEdificio = entrada.nextLine();
                    System.out.println("Ingrese la ubicacion en el edificio: ");
                    ubiEdificio = entrada.nextLine();
                    Departamento departamento = new Departamento(propietario,
                            precioXm, numMetros, valorAlicuota, barrio, ciudad,
                            nomEdificio, ubiEdificio, constructora);
                    departamento.establecerCostoFinal();
                    ArchivoEscrituraDep archivodepar
                            = new ArchivoEscrituraDep("datos/departamentos.dat");
                    archivodepar.establecerRegistro(departamento);
                    archivodepar.establecerSalida();
                    break;
                case 3:
                    System.out.println("Ingrese nombres del propietario: ");
                    String nombresPropietario = entrada.nextLine();
                    System.out.println("Ingrese apellidos del propietario: ");
                    String apellidosPropietario = entrada.nextLine();
                    System.out.println("Ingrese identificacion del propietario(dni): ");
                    String identificacionPropietario = entrada.nextLine();
                    propietario
                            = new Propietario(nombresPropietario,
                                    apellidosPropietario,
                                    identificacionPropietario);
                    ArchivoEscrituraP archivop
                            = new ArchivoEscrituraP("datos/propietarios.dat");
                    System.out.println(propietario);
                    archivop.establecerRegistro(propietario);
                    archivop.establecerSalida();
                    break;
                case 4:
                    System.out.println("Ingrese nombre del barrio: ");
                    String nombre = entrada.nextLine();
                    System.out.println("Ingrese referencia del barrio: ");
                    String referencia = entrada.nextLine();
                    barrio = new Barrio(nombre, referencia);
                    ArchivoEscrituraB archivob
                            = new ArchivoEscrituraB("datos/barrios.dat");
                    System.out.println(archivob.toString());
                    archivob.establecerRegistro(barrio);
                    archivob.establecerSalida();
                    break;
                case 5:
                    System.out.println("Ingrese nombre de la ciudad: ");
                    String nombreCiudad = entrada.nextLine();
                    System.out.println("Ingrese nombre de la provincia: ");
                    String provincia = entrada.nextLine();
                    ciudad = new Ciudad(nombreCiudad, provincia);
                    ArchivoEscrituraC archivociu
                            = new ArchivoEscrituraC("datos/ciudades.dat");
                    archivociu.establecerRegistro(ciudad);
                    archivociu.establecerSalida();
                    break;
                case 6:

                    System.out.println("Ingrese nombre de la constructora: ");
                    String nombreConstructora = entrada.nextLine();
                    System.out.println("Ingrese id de la constructora:");
                    String idEmpresa = entrada.nextLine();
                    Constructora c1 = new Constructora(nombreConstructora, idEmpresa);
                    ArchivoEscrituraCo archivocons = new ArchivoEscrituraCo("datos/constructoras.dat");
                    archivocons.establecerRegistro(c1);
                    archivocons.establecerSalida();
                    break;
                case 7:
                    do {
                        op = menu2();
                        mostrar(op);
                    } while (op != 0);
                    op = 7;
                    break;
                case 0:
                    System.out.println("Fin del programa");
            }
        } while (op != 0);

    }

    public static int menu() {
        Scanner entrada1 = new Scanner(System.in);
        int op;
        System.out.println("1.Ingresar nueva Casa:");
        System.out.println("2.Ingresar nuevo Departamento:");
        System.out.println("3.Ingresar nuevo Propietario:");
        System.out.println("4.Ingresar nuevo Barrio:");
        System.out.println("5.Ingresar nueva Ciudad:");
        System.out.println("6.Ingresar nueva Constructora:");
        System.out.println("7.Observar Listas:");
        System.out.println("0.Salir del Programa:");

        op = entrada1.nextInt();

        return op;
    }

    public static int menu2() {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("1.Observar Lista de casas:");
        System.out.println("2.Observar Lista de departamentos:");
        System.out.println("3.Observar Lista de propietarios:");
        System.out.println("4.Observar Lista de barrios:");
        System.out.println("5.Observar Lista de ciudades:");
        System.out.println("6.Observar Lista de constructoras:");
        System.out.println("0.Regresar menu anterior:");
        op = sc.nextInt();
        return op;
    }

    public static Propietario encontrarPropietarioB() {
        Scanner entrada = new Scanner(System.in);
        String identificacion;
        String nombres;
        String apellidos;
        String nombreArchivo = "datos/propietarios.dat";
        System.out.println("Ingrese identifiacion del propietario: ");
        identificacion = entrada.nextLine();

        Propietario propietarioEncontrado; //declaro la variable

        ArchivoLecturaP lecturaP = new ArchivoLecturaP(nombreArchivo);  //objeto para buscar en

        lecturaP.establecerCedula(identificacion);

        lecturaP.establecerPropietarioBuscado();

        propietarioEncontrado = lecturaP.obtenerPropietarioBuscado();

        if (propietarioEncontrado != null) {
            System.out.printf("Propietario encontrado %s\n",
                    propietarioEncontrado);
            return propietarioEncontrado;
        } else {
            System.out.println("No se ha encontrado ese propietario,"
                    + " ingrese nuevo propietario");
            System.out.println("Ingrese nombres del propietario: ");
            nombres = entrada.nextLine();
            System.out.println("Ingrese apellidos del propietario: ");
            apellidos = entrada.nextLine();
            System.out.println("Ingrese identificacion del propietario: ");
            identificacion = entrada.nextLine();
            Propietario propietario
                    = new Propietario(nombres, apellidos, identificacion);
            ArchivoEscrituraP archivop = new ArchivoEscrituraP(nombreArchivo);
            archivop.establecerRegistro(propietario);
            archivop.establecerSalida();
            return propietario;
        }
    }

    public static Barrio encontrarBarrioBuscado() {
        Scanner sc = new Scanner(System.in);
        String nombreBarrio;
        String referencia;
        String nombreArchivo = "datos/barrios.dat";
        System.out.println("Ingrese nombre del barrio: ");
        nombreBarrio = sc.nextLine();
        Barrio barrioEncontrado;
        ArchivoLecturaB lecturaB = new ArchivoLecturaB(nombreArchivo);
        lecturaB.establecerCedula(nombreBarrio);
        lecturaB.establecerBarrioBuscado();
        barrioEncontrado = lecturaB.obtenerBarrioBuscado();
        if (barrioEncontrado != null) {
            System.out.printf("Barrio encontrado %s\n", barrioEncontrado);
            return barrioEncontrado;
        } else {
            System.out.println("No se ha encontrado ese barrio, ingrese nuevo barrio");
            System.out.println("Ingrese nombre del barrio: ");
            nombreBarrio = sc.nextLine();
            System.out.println("Ingrese referencia: ");
            referencia = sc.nextLine();
            Barrio barrio = new Barrio(nombreBarrio, referencia);
            ArchivoEscrituraB archivob = new ArchivoEscrituraB(nombreArchivo);
            archivob.establecerRegistro(barrio);
            archivob.establecerSalida();
            return barrio;
        }
    }

    public static Ciudad encontrarCiudadBuscada() {
        Scanner sc = new Scanner(System.in);
        String nombreCiudad;
        String nombreProvincia;
        String nombreArchivo = "datos/ciudades.dat";
        System.out.println("Ingrese nombre ciudad: ");
        nombreCiudad = sc.nextLine();
        Ciudad ciudadEncontrada;
        ArchivoLecturaC lecturaC = new ArchivoLecturaC(nombreArchivo);
        lecturaC.establecerCedula(nombreCiudad);
        lecturaC.establecerCiudadBuscada();
        ciudadEncontrada = lecturaC.obtenerCiudadBuscada();
        if (ciudadEncontrada != null) {
            System.out.printf("Ciudad encontrada %s\n", ciudadEncontrada);
            return ciudadEncontrada;
        } else {
            System.out.println("No se ha encontrado esa ciudad, ingrese nueva ciudad");
            System.out.println("Ingrese nombre de la ciudad: ");
            nombreCiudad = sc.nextLine();
            System.out.println("Ingrese nombre de la provincia: ");
            nombreProvincia = sc.nextLine();
            Ciudad ciudad = new Ciudad(nombreCiudad, nombreProvincia);
            ArchivoEscrituraC archivociu = new ArchivoEscrituraC(nombreArchivo);
            archivociu.establecerRegistro(ciudad);
            archivociu.establecerSalida();
            return ciudad;
        }
    }

    public static Constructora encontrarConstructoraB() {
        Scanner entrada = new Scanner(System.in);
        String nombreConstructora;
        String idEmpresa;
        String nombreArchivo = "datos/constructoras.dat";
        System.out.println("Ingrese id de la constructora: ");
        idEmpresa = entrada.nextLine();
        Constructora constructoraEncontrada;
        ArchivoLecturaCo lecturaCo = new ArchivoLecturaCo(nombreArchivo);
        lecturaCo.establecerCedula(idEmpresa);
        lecturaCo.establecerConstructoraB();
        constructoraEncontrada = lecturaCo.obtenerConstructoraB();
        if (constructoraEncontrada != null) {
            System.out.printf("Constructora encontrada %s\n",
                    constructoraEncontrada);
            return constructoraEncontrada;
        } else {
            System.out.println("No se ha encontrado esa constructora,"
                    + " ingrese nueva constructora");
            System.out.println("Ingrese nombre constructora: ");
            nombreConstructora = entrada.nextLine();
            System.out.println("Ingrese id constructora: ");
            idEmpresa = entrada.nextLine();
            Constructora constructora
                    = new Constructora(nombreConstructora, idEmpresa);
            ArchivoEscrituraCo archivoco
                    = new ArchivoEscrituraCo(nombreArchivo);
            archivoco.establecerRegistro(constructora);
            archivoco.establecerSalida();
            return constructora;
        }
    }

    public static void mostrar(int op2) {
        switch (op2) {
            case 1:
                ArchivoLecturaCasa lecturac
                        = new ArchivoLecturaCasa("datos/casas.dat");
                lecturac.establecerCasa();
                System.out.printf("%s", lecturac.toString());
                lecturac.cerrarArchivo();
                break;
            case 2:
                ArchivoLecturaDep lecturad
                        = new ArchivoLecturaDep("datos/departamentos.dat");
                lecturad.establecerDepartamento();
                System.out.printf("%s", lecturad.toString());
                lecturad.cerrarArchivo();
                break;
            case 3:
                ArchivoLecturaP lecturap
                        = new ArchivoLecturaP("datos/propietarios.dat");
                lecturap.establecerPropietarios();
                System.out.printf("%s", lecturap.toString());
                lecturap.cerrarArchivo();
                break;
            case 4:
                ArchivoLecturaB lecturab
                        = new ArchivoLecturaB("datos/barrios.dat");
                lecturab.establecerBarrios();
                System.out.printf("%s", lecturab.toString());
                lecturab.cerrarArchivo();
                break;
            case 5:
                ArchivoLecturaC lecturaciu
                        = new ArchivoLecturaC("datos/ciudades.dat");
                lecturaciu.establecerCiudades();
                System.out.printf("%s", lecturaciu.toString());
                lecturaciu.cerrarArchivo();
                break;
            case 6:
                ArchivoLecturaCo lecturaco
                        = new ArchivoLecturaCo("datos/constructoras.dat");
                lecturaco.establecerConstructoras();
                System.out.printf("%s", lecturaco.toString());
                lecturaco.cerrarArchivo();
                break;
        }

    }

}
