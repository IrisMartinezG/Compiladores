/*
 *Autor: Martinez Gonzalez Iris
 */
package automata;

import java.util.ArrayList;

public class Estado {
    private boolean Final;
    private int Etiqueta;
    private ArrayList<char [] > Transiciones = new ArrayList<char []>();//[destino simbolo]

    public Estado(){
        Final=false;
        Etiqueta=0;
    }

    public void inicializarEstado(int etiqueta, boolean fh){//incializa el estado
        Etiqueta=etiqueta;
        Final=fh;
    }


    public void agregarTransicion(char simbolo, int destino) {
        char[] a=new char[2];
        a[0]=Character.forDigit(destino,10);
        a[1]=simbolo;
        Transiciones.add(a);

    }

    public ArrayList<char[]> obtenerTransiciones() {
        return Transiciones;
    }

    public char[] obtenerTransicion(int i){
        return Transiciones.get(i);
    }

    public int obtenerEtiqueta() {
        return Etiqueta;
    }

    public boolean buscarDestinoSimbolo(){
        int i=0, j=0,k=0;

        while (i<Transiciones.size()){
            char[] a= obtenerTransicion(i);
            char simbolo=a[1];
            //System.out.println("el simbolo es "+ simbolo);
            j=0;
            while (j<Transiciones.size()) {
                char[] c = obtenerTransicion(j);
                if (c[1] == simbolo) {
                    k++;
                    //System.out.println(a[0] + " " + a[1] + " el simbolo es " + simbolo);
                    if (k == 2)
                        return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }

    public ArrayList<Integer> buscarDestino(char a){
        int i=0;
        ArrayList<Integer> posibleCamino=new ArrayList<>();
        while (i<Transiciones.size()){
            char [] p=Transiciones.get(i);
            if(p[1]==a){
                posibleCamino.add(Character.getNumericValue(p[0]));
            }
            i++;
        }
        return posibleCamino;
    }
}
