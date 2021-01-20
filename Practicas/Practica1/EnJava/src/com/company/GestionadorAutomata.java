package com.company;

import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class GestionadorAutomata {
    private Automata automata=new Automata();

    public  GestionadorAutomata(){}

    public Automata getAutomata() {
        return automata;
    }

    public void readFile(String direccion){
        try {
            Scanner input = new Scanner(new File(direccion));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                setInicial(line);
                setFinales(line);
                setTransicion(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setInicial(String line){
        if (line.contains("inicial:")){
            String[] a=line.split("inicial:");
            automata.setEdoInical(Integer.parseInt(a[1]));
        }
    }

    public void setFinales(String line){
        if (line.contains("finales:")){
            String[] a=line.split("finales:");
            if (a[1].contains(",")){
                String[] b=a[1].split(",");
                int i=0;
                while (i<b.length){
                    automata.setFinal(Integer.parseInt(b[i]));
                    i++;
                }

            }else {automata.setFinal(Integer.parseInt(a[1]));}
        }
    }

    public void setTransicion(String line){
        String[] transicion=new String[3];
        if (line.contains("->")){
            String[] a=line.split("->");
            transicion[0]=a[0];
            String[] b=a[1].split(",");
            transicion[1]=b[0];
            transicion[2]=b[1];
            automata.addTransicion(transicion);
        }
    }

}
