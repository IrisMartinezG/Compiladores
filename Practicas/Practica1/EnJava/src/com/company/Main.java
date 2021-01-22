package com.company;

public class Main {

    public static void main(String[] args) {

        GestionadorAutomata prueba=new GestionadorAutomata();
        prueba.readFile("C:\\Users\\end user\\Documents\\Yoni\\ESCOM\\7mo Semestre Escom\\Compiladores\\compiladores\\Practicas\\Practica1\\EnJava\\src\\com\\company\\prueba.af");
        //GestionadorCadenas p=new GestionadorCadenas();
        Automata a= prueba.getAutomata();
        prueba.guardarEn("a.af",a);
        //p.setAlfabeto(a.getSimbolo());

        


    }
}
