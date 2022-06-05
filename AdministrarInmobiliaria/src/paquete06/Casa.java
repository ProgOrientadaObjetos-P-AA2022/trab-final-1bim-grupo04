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
    
    public void establecerCostoFinal(){
        costoFinal = precioXm * numMetros;
    }

}
