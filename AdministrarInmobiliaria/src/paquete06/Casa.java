package paquete06;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author reroes
 */
public class Casa {

    private Propietario propietario;
    private double precioXm;
    private double numMetros;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private Constructora constructora;
    private int numCuartos;

    public Casa(Propietario p, double pre, double numM, Barrio b,
            Ciudad c, Constructora con, int nc) {
        propietario = p;
        precioXm = pre;
        numMetros = numM;
        barrio = b;
        ciudad = c;
        constructora = con;
        numCuartos = nc;
    }

    public void establecerPropietario(Propietario c) {
        propietario = c;
    }

    public void establecerPrecioXm(double c) {
        precioXm = c;
    }

    public void establecerNumMetros(double c) {
        numMetros = c;
    }

    public void establecerCostoFinal() {
        costoFinal = precioXm * numMetros;
    }

    public void establecerBarrio(Barrio c) {
        barrio = c;
    }

    public void establecerCiudad(Ciudad c) {
        ciudad = c;
    }

    public void establecerConstructora(Constructora c) {
        constructora = c;
    }

    public void establecerNumCuartos(int c) {
        numCuartos = c;
    }

    public Propietario obtenerPropietario() {
        return propietario;
    }

    public double obtenerPrecioMetroCuadrado() {
        return precioXm;
    }

    public double obtenerNumeroMetrosCuadrados() {
        return numMetros;
    }

    public double obtenerCostoFinal() {
        return costoFinal;
    }

    public Barrio obtenerBarrio() {
        return barrio;
    }

    public Ciudad obtenerCiudad() {
        return ciudad;
    }

    public int obtenerNumeroCuartos() {
        return numCuartos;
    }

    public Constructora obtenerConstructoras() {
        return constructora;
    }

    @Override
    public String toString() {

        String cadena = String.format("PROPIETARIO\n"
                + "Nombres: %s Apellidos: %s - Identificacion: %s\n"
                + "Precio metro cuadrado: %.2f Numero metros Cuadrados: %.2f  Numero Cuartos: %d Costo final: %.2f\n"
                + "BARRIO\n"
                + "Nombre barrio: %s Referencia: %s\n"
                + "CIUDAD\n"
                + "Nombre Ciudad: %s Nombre Provincia: %s \n"
                + "CONSTRUCTORA\n"
                + "Nombre Constructora: %s Id Empresa: %s\n",
                 propietario.obtenerNombre(),
                propietario.obtenerApellido(),
                propietario.obtenerCedula(),
                obtenerPrecioMetroCuadrado(),
                obtenerNumeroMetrosCuadrados(),
                obtenerNumeroCuartos(),
                costoFinal,
                barrio.obtenerNombre(),
                barrio.obtenerReferencia(),
                ciudad.obtenerNombre(),
                ciudad.obtenerProvincia(),
                constructora.obtenerNombre(),
                constructora.obtenerID());

        return cadena;
    }

}
