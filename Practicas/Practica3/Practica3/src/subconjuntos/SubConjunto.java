/*
 *Autor: Martinez Gonzalez Iris
 */
package subconjuntos;

import automata.Automata;
import automata.Estado;

import java.util.ArrayList;

public class SubConjunto {
    public void Ecerradura( ArrayList<Integer> conjunto, Automata automata) {
        ArrayList<Integer> conjuntonuevo=new ArrayList<>();
        //buscamos el estado=conjunti[i]
        //buscamos en trasiciones del estado que que como simbolo tengan E
        int i=0;
        while (i < conjunto.size()) {
            Estado aux=automata.getEstado(conjunto.get(i));
            int j=0;
            while (j<aux.buscarDestino('E').size()){
               // System.out.println(aux.buscarDestino('E').get(j));
                conjuntonuevo.add(aux.buscarDestino('E').get(j));
                j++;
            }
            i++;

        }
        System.out.println("Cerradura de "+conjunto+" es "+conjuntonuevo);
    }

    public void Mover(ArrayList<Integer> conjunto, char Simbolo , Automata automata) {
        ArrayList<Integer> conjuntonuevo=new ArrayList<>();
        int i=0;
        while (i < conjunto.size()) {
            Estado aux=automata.getEstado(conjunto.get(i));
            int j=0;
            int aux1=aux.buscarDestino(Simbolo).size();
            ArrayList<Integer> auxlis=aux.buscarDestino(Simbolo);
            while (j<aux1){
                //System.out.println(auxlis.get(j));
                if(!conjuntonuevo.contains(auxlis.get(j))){
                    conjuntonuevo.add(auxlis.get(j));
                }
                j++;
            }
            i++;
        }
        System.out.println("Mover a "+conjunto+" con el Simbolo " +Simbolo+" es "+conjuntonuevo);

    }
}
