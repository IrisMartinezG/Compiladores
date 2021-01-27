/*
 * Autor: Martinez Gonzalez Iris
 *
 */

package automata;

import java.util.ArrayList;

public class Automata {
    protected String Simbolo;
    protected ArrayList<Integer> EdoFinales = new ArrayList<Integer>();
    protected int EdoInical;
    protected int numestados;//aux
    protected ArrayList<Estado> Estados= new ArrayList<Estado>();


    public Automata(){
        Simbolo="";
        EdoInical=0;
        numestados=0;
    }

    public void establecerEdoInical(int edoInical) {
        EdoInical = edoInical;
    }

    public void establecerFinal(int afinal){//evitar repatidas
        if(afinal>0){
            EdoFinales.add(afinal);
        }
    }

    public ArrayList<Estado> obtenerEstados() {
        return Estados;
    }

    public void agregarSimbolo(String a){
        if(!Simbolo.contains(a) && !a.contains("E"))
            Simbolo+=a;
    }

    public int obtenerEdoInical() {
        return EdoInical;
    }

    public String obtenerSimbolo() {
        return Simbolo;
    }

    public void agregarEstado(String[] info){
        numestados++;
        //0 mi etiqueta , 1 destino , 2 el simbolo
        Estado a=new Estado();
        if(EdoFinales.contains(Integer.parseInt(info[0]))){
            a.inicializarEstado(Integer.parseInt(info[0]),true);
        }else {a.inicializarEstado(Integer.parseInt(info[0]),false);}
        a.agregarTransicion(info[2].charAt(0),Integer.parseInt(info[1]));
        Estados.add(numestados-1,a);
    }

    public boolean validarEstado(int origen){
        int i=0;
        Estado a=new Estado();
        while (i<Estados.size()){
            a= Estados.get(i);
            if(a.obtenerEtiqueta()==origen){
                return true;
            }
            i++;
        }
        return false;
    }

    public Estado obtenerEstado(int etiq){
        Estados.size();
        int i=0;
        Estado a= new Estado();
        while (i<Estados.size()){
            a= Estados.get(i);
            if(a.obtenerEtiqueta()==etiq){
                break;
            }
            i++;
        }
        return a;
    }

    public void agregarTransicion(String[] info){
        this.agregarSimbolo(info[2]);
        if(validarEstado(Integer.parseInt(info[0]))){
            Estado a=new Estado();
            a= obtenerEstado(Integer.parseInt(info[0]));
            // 2 simbolo    1 destino
            a.agregarTransicion(info[2].charAt(0),Integer.parseInt(info[1]));

        }else {
            agregarEstado(info);
        }
    }

    public boolean esAFN(){
        int i=0;
        Estado a= new Estado();
        while (i<Estados.size()){
            a= Estados.get(i);
            if(a.buscarDestinoSimbolo()){
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
            if(a.buscarDestinoSimbolo()){
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
