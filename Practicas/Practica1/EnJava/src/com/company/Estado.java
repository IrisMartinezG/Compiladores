package com.company;

import java.util.ArrayList;

public class Estado {
    private boolean Final;
    private int Etiqueta;
    private ArrayList<char [] > Transiciones = new ArrayList<char []>();//[destino simbolo]

    public Estado(){
        Final=false;
        Etiqueta=0;
    }

    public void inEstado(int etiqueta,boolean fh){//incializa el estado
        Etiqueta=etiqueta;
        Final=fh;
    }

    /*public void setTransiciones(ArrayList<char[]> trancisiones) {
        Transiciones = trancisiones;
    }*/

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

    public boolean findDestinoSimbolo(){
        int i=0, j=0,k=0;

        while (i<Transiciones.size()){
            char[] a= getTransicion(i);
            char simbolo=a[1];
            System.out.println("el simbolo es "+ simbolo);
            j=0;
            while (j<Transiciones.size()) {
                char[] c = getTransicion(j);
                if (c[1] == simbolo) {
                    k++;
                    System.out.println(a[0] + " " + a[1] + " el simbolo es " + simbolo);
                    if (k == 2)
                        return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }
    /*public String buscarTransicion(char a){
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
    }*/
}
