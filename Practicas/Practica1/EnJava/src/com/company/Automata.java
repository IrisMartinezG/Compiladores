package com.company;

import java.util.ArrayList;

public class Automata {
    private String Simbolo;
    private ArrayList<Integer> EdoFinales = new ArrayList<Integer>();
    private int EdoInical;
    private int numestados;//aux
    private ArrayList<Estado> Estados= new ArrayList<Estado>();

    public Automata(){
        Simbolo="";
        EdoInical=0;
        numestados=0;
    }

    public void setEdoInical(int edoInical) {
        EdoInical = edoInical;
    }

    public void setFinal(int afinal){//evitar repatidas
        if(afinal>0){
            EdoFinales.add(afinal);
        }
    }

    public ArrayList<Estado> getEstados() {
        return Estados;
    }

    public void setSimbolo(String a){
        if(!Simbolo.contains(a) && !a.contains("E"))
            Simbolo+=a;
    }

    public int getEdoInical() {
        return EdoInical;
    }

    public String getSimbolo() {
        return Simbolo;
    }

    public void addEstado(String[] info){
        numestados++;
        //0 mi etiqueta , 1 destino , 2 el simbolo
        Estado a=new Estado();
        if(EdoFinales.contains(Integer.parseInt(info[0]))){
            a.inEstado(Integer.parseInt(info[0]),true);
        }else {a.inEstado(Integer.parseInt(info[0]),false);}
        a.addTransicion(info[2].charAt(0),Integer.parseInt(info[1]));
        Estados.add(numestados-1,a);
    }

    public boolean valEstado(int origen){
        Estados.size();
        int i=0;
        Estado a=new Estado();
        while (i<Estados.size()){
            a= Estados.get(i);
            //System.out.println("***"+a.getEtiqueta());
            if(a.getEtiqueta()==origen){
                return true;
            }
            i++;
        }
        return false;
    }

    public Estado getEstado(int etiq){
        Estados.size();
        int i=0;
        Estado a= new Estado();
        while (i<Estados.size()){
            a= Estados.get(i);
            if(a.getEtiqueta()==etiq){
                break;
            }
            i++;
        }
        return a;
    }

    public void addTransicion(String[] info){
        this.setSimbolo(info[2]);
        if(valEstado(Integer.parseInt(info[0]))){
            Estado a=new Estado();
            a= getEstado(Integer.parseInt(info[0]));
            // 2 el simbolo, 1 destino
            a.addTransicion(info[2].charAt(0),Integer.parseInt(info[1]));
        }else {
            addEstado(info);
        }
    }

    public boolean acepta(String cadena){
        //Simbre iniciamos con el inicial
        if(getEdoInical()>0){
            Estado a=getEstado(getEdoInical());
            System.out.println(a.getEtiqueta());
            int i=0;
            //while(i<cadena.length()){
                //if(a.buscarTransicion(cadena.charAt(i))) {
                String posibleCamino=a.buscarTransicion(cadena.charAt(i));
                System.out.println(posibleCamino);
                    //break;
                //}
                //i++;
            //}

            return true;
        }
        return false;
    }
}
