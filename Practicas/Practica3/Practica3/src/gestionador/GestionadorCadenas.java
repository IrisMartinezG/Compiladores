/*
 * Autor: Martinez Gonzalez Iris
 *
 */

package gestionador;

import java.util.Random;

public class GestionadorCadenas {
    private String alfabeto;

    public GestionadorCadenas(){
        alfabeto="";
    }

    public void establecerAlfabeto(String alfabeto) {
        this.alfabeto = alfabeto;
    }

    public String obtenerAlfabeto() {
        return alfabeto;
    }

    public String generarCadena(){
        //randum en java
        Random rnd = new Random();
        int tam=8;
        String cadena="";
        while (tam>0){
            cadena+=alfabeto.charAt(rnd.nextInt(alfabeto.length()));
            tam--;
        }
        return cadena;
    }
}
