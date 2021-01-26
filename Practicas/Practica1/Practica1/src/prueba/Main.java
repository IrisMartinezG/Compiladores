/*
*Autor: Martinez Gonzalez Iris
*/
package prueba;
import automata.*;
import gestionador.*;
public class Main {
    public static void main(String[] args) {

        GestionadorAutomata prueba=new GestionadorAutomata();
        prueba.leerArchivo("prueba.af");
        //GestionadorCadenas p=new GestionadorCadenas();
        Automata a= prueba.obtenerAutomata();
        prueba.guardarEn("a.af",a);
        //p.setAlfabeto(a.getSimbolo());
    }

}
