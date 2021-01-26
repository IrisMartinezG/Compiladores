/*
*Autor: Martinez Gonzalez Iris
*/
package prueba;
import automata.*;
import gestionador.*;
import subconjuntos.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        GestionadorAutomata prueba=new GestionadorAutomata();
        prueba.readFile("prueba.af");
        //GestionadorCadenas p=new GestionadorCadenas();
        Automata a= prueba.getAutomata();
        //System.out.println(a.esAFN());
        ArrayList<Integer> conjuntonuevo=new ArrayList<>();
        conjuntonuevo.add(1);
        conjuntonuevo.add(2);
        conjuntonuevo.add(3);
        conjuntonuevo.add(4);
        if(a.esAFN()){
            SubConjunto b=new SubConjunto();
            b.Ecerradura(conjuntonuevo, a);
            b.Mover(conjuntonuevo,'b',a);
        }
    }

}
