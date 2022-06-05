package paquete06;

import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author reroes
 */
public class Departamento {

    private Propietario propietario;
    private double precioXm;
    private double numMetros;
    private double alicuota;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private String nomEdificio;
    private String ubiEdificio;
    private Constructora constructora;

    public Departamento(Propietario p, double pre, double numM, double ali,
            Barrio b, Ciudad c, String ne, String ue, Constructora con) {
        propietario = p;
        precioXm = pre;
        numMetros = numM;
        alicuota = ali;
        barrio = b;
        ciudad = c;
        nomEdificio = ne;
        ubiEdificio = ue;
        constructora = con;
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

    public void establecerAliCuota(double c) {
        alicuota = c;
    }

    public void establecerCostoFinal() {
        costoFinal = ((numMetros * precioXm) + (alicuota * 12));
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

    public void establecerNomEdificio(String c) {
        nomEdificio = c;
    }

    public void establecerUbiEdificio(String c) {
        ubiEdificio = c;
    }

    public Propietario obtenerPropietario() {
        return propietario;
    }

    public double obtenerPrecioXm() {
        return precioXm;
    }

    public double obtenerNumMetros() {
        return numMetros;
    }

    public double obtenerAlicuota() {
        return alicuota;
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

    public Constructora obtenerConstructora() {
        return constructora;
    }

    public String obtenerNomEdificio() {
        return nomEdificio;
    }

    public String obtenerUbiEdificio() {
        return ubiEdificio;
    }

}
