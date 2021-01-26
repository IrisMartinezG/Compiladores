/*
 * Autor: Martinez Gonzalez Iris
 *
 */

package automata;

import java.util.ArrayList;

public class Automata {
    private String Simbolo;//el alfabeto qeu tiene el automata
    private ArrayList<Integer> EdoFinales = new ArrayList<Integer>();
    private int EdoInical;
    private int numestados;//aux: aumenta cada vez que se agrega un nuevo estado
    private ArrayList<Estado> Estados= new ArrayList<Estado>();


    public Automata(){
        Simbolo ="";
        EdoInical=0;
        numestados=0;
    }

    public void establecerEdoInicial(int edoInical) {
        EdoInical = edoInical;
    }

    public void establecerFinal(int afinal){//TODO:evitar repatidas
        if(afinal>0){
            EdoFinales.add(afinal);
        }
    }

    public ArrayList<Estado> obtenerEstados() {
        return Estados;
    }

    public void establecerAlfabeto(String a){
        if(!Simbolo.contains(a) && !a.contains("E"))
            Simbolo+=a;
    }

    public int obtenerEdoInicial() {
        return EdoInical;
    }

    public String obtenerSimbolo() {
        return Simbolo;
    }

    public void agregarEstado(String[] info){
        numestados++;
        //0 mi etiqueta , 1 destino , 2 el simbolo
        Estado a=new Estado();
        if(EdoFinales.contains(Integer.parseInt(info[0]))){//checamos si es final o no
            a.Estado(Integer.parseInt(info[0]),true);
        }else {a.Estado(Integer.parseInt(info[0]),false);}
        a.agregarEstado(info[2].charAt(0),Integer.parseInt(info[1]));
        Estados.add(numestados-1,a);
    }

    public boolean validarEstado(int etiqueta){
        int i=0;
        Estado a=new Estado();
        while (i<Estados.size()){
            a= Estados.get(i);
            if(a.obtenerEtiqueta()==etiqueta){
                return true;
            }
            i++;
        }
        return false;
    }

    public Estado obtenerEstado(int etiqueta){
        Estados.size();
        int i=0;
        Estado a= new Estado();
        while (i<Estados.size()){
            a= Estados.get(i);
            if(a.obtenerEtiqueta()==etiqueta){
                break;
            }
            i++;
        }
        return a;
    }

    public void agregarTransicion(String[] info){
        this.establecerAlfabeto(info[2]);
        //vemos si ya existe el estado
        if(validarEstado(Integer.parseInt(info[0]))){
            Estado a=new Estado();
            a= obtenerEstado(Integer.parseInt(info[0]));
            // 2 simbolo    1 destino
            a.agregarEstado(info[2].charAt(0),Integer.parseInt(info[1]));

        }else {
            agregarEstado(info);
        }
    }

    public void eliminarTransicion(int origen, int destino, char simbolo){

    }

    public boolean esAFN(){
        int i=0;
        Estado a= new Estado();
        while (i<Estados.size()){
            a= Estados.get(i);
            if(a.validarDestinoSimbolo()){
                return true;
            }
            i++;
        }
        return false;
    }

    public boolean esAFD(){
        int i=0;
        Estado a= new Estado();
        while (i<Estados.size()){
            a= Estados.get(i);
            if(a.validarDestinoSimbolo()){
                return false;
            }
            i++;
        }
        return true;
    }

    public String obtenerEdoFinales() {
        String finales="";int i=0;
        while (i<EdoFinales.size()){
            if(i==EdoFinales.size()-1) {
                finales += EdoFinales.get(i);
            }else{
                finales += EdoFinales.get(i) + ",";
            }
            i++;
        }
        return finales;
    }

}
