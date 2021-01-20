package com.company;
import java.io.File;
import java.util.Scanner;

public class Lector {
    private GLC gramatica=new GLC();

    public Lector(){

    }

    public void readFile(String direccion){
        try {
            Scanner input = new Scanner(new File(direccion));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                setProduccion(line);
                //System.out.println(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void setProduccion(String line){
        char a=line.charAt(0);
        if(!gramatica.valInical()){
            gramatica.setInicial(a);
        }
        for(int i=0;i<line.length();i++){
            a=line.charAt(i);
            gramatica.addTerminal(a);
            gramatica.addNoTerminal(a);
        }
        String[] partes = line.split("->");
        a=partes[0].charAt(0);
        gramatica.addProduccion(a, partes[1]);
        //gramatica.getProduccion(0);
    }

    public GLC getGramatica() {
        return gramatica;
    }

}
