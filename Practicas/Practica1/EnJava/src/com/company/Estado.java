package com.company;

import java.util.ArrayList;

public class Estado {
    private boolean Final;
    private int Etiqueta;
    private ArrayList<char [] > Transiciones = new ArrayList<char []>();
    //private int[] Tansicion= new int[2];// Transicion[0]: destino, Transicion[1]; simbolo

    public Estado(){

    }

    public void inEstado(int etiqueta,boolean fh){
        Etiqueta=etiqueta;
        Final=fh;
    }

    public void setTransiciones(ArrayList<char[]> trancisiones) {
        Transiciones = trancisiones;
    }

    public void addTransicion(char simbolo, int destino) {
        char[] a=new char[2];
        a[0]=Character.forDigit(destino,10);
        a[1]=simbolo;
        Transiciones.add(a);
    }

    public ArrayList<char[]> getTransiciones() {
        return Transiciones;
    }

    public char[] getTransicion(int i){
        return Transiciones.get(i);
    }

    public int getEtiqueta() {
        return Etiqueta;
    }

    public String buscarTransicion(char a){
        int i=0;
        String posibleCamino="";
        System.out.println("Buscando la letra "+a);
        while (i<Transiciones.size()){
            char [] p=Transiciones.get(i);
            System.out.println("--Transicion a "+p[0]+" con "+ p[1]);
            if(p[1]==a || p[1]=='E'){
                System.out.println("---Lo tiene en la t "+i);
                posibleCamino+=p[0];
            }
            i++;
        }
        return posibleCamino;
    }
}
