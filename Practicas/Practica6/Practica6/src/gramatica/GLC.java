package gramatica;

import java.util.*;

public class    GLC {
    private String terminal;
    private String noterminal;
    private ArrayList<Produccion> producciones = new ArrayList<Produccion>();
    private char inicial;
    private int numproduccion=0;

    public GLC(){
        terminal="";
        noterminal="";
        numproduccion=0;
    }

    public void agregarProduccion(char no_t, String cuerpo){
        numproduccion++;
        Produccion a= new Produccion();
        a.iniciaProduccion(no_t,cuerpo,numproduccion);
        producciones.add(numproduccion-1,a);
    }

    public Produccion obtenerProduccion(int num){
        Produccion b= new Produccion();
        b=producciones.get(num);
        return  b;
    }

    public void agregarNoTerminal(char a){
        if(65<=a && a<=90 && a!=69){
            if(0>noterminal.indexOf(a)) {
                this.noterminal=noterminal+String.valueOf(a);
            }
        }
    }

    public void agregarTerminal(char a){
        if(97<=a && a<=122){
            if(0>terminal.indexOf(a)){
                this.terminal=terminal+String.valueOf(a);
            }
        }

    }

    public boolean validarInical(){
        boolean sn=false;
        if(65<=inicial && inicial<=90 && inicial!=69){
            sn=true;
        }
        return sn;
    }

    public char getInicial() {
        return inicial;
    }

    public void establecerInicial(char inicial) {
        this.inicial = inicial;
    }

    public int obtenerNumproduccion() {
        return numproduccion;
    }

    public String obtenerNoterminal(){
        return noterminal;
    }

    public String obtenerTerminal(){
        return  terminal;
    }
}
