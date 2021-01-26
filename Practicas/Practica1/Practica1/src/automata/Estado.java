/*
 * Autor: Martinez Gonzalez Iris
 *
 */

package automata;

import java.util.ArrayList;

public class Estado {
    private boolean Final;
    private int Etiqueta;
    private ArrayList<char [] > Transiciones = new ArrayList<char []>();//[destino,simbolo]

    public Estado(){
        Final=false;
        Etiqueta=0;
    }

    public void Estado(int etiqueta, boolean fh){//incializa el estado
        Etiqueta=etiqueta;
        Final=fh;
    }

    public void agregarEstado(char simbolo, int destino) {
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

    /*Método que valida si el estado tiene más de 1 transición con el mismo simbolo*/
    public boolean validarDestinoSimbolo(){
        int i=0, j=0,k=0;
        while (i<Transiciones.size()){
            char[] a= obtenerTransicion(i);
            char simbolo=a[1];
            j=0;
            while (j<Transiciones.size()) {
                char[] c = obtenerTransicion(j);
                if (c[1] == simbolo) {
                    k++;
                    if (k == 2)
                        return true;
                }
                j++;
            }
            i++;
        }
        return false;
    }


}
