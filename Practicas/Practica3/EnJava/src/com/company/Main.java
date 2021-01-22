package com.company;

import java.util.ArrayList;
import java.util.SortedMap;

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
            SubConjuntos b=new SubConjuntos();
            //b.Ecerradura(conjuntonuevo, a);
            b.Mover(conjuntonuevo,'b',a);
        }
        //p.setAlfabeto(a.getSimbolo());

    }
}
