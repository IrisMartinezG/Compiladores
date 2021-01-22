package com.company;

import java.io.*;
import java.util.Scanner;

public class GestionadorAutomata {
    private Automata automata=new Automata();

    public  GestionadorAutomata(){}

    public Automata getAutomata() {
        return automata;
    }

    public void readFile(String direccion){
       /* try {
            Scanner input = new Scanner(new File(direccion));
            while (input.hasNextLine()) {
                System.out.println("--------"+input.nextLine());
                setInicial(input.nextLine());
                setFinales(input.nextLine());
                setTransicion(input.nextLine());
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File (direccion);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while((linea=br.readLine())!=null){
                System.out.println(linea);
                setInicial(linea);
                setFinales(linea);
                setTransicion(linea);
            }

        }
        catch(Exception e){
            e.printStackTrace();
        }finally{
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta
            // una excepcion.
            try{
                if( null != fr ){
                    fr.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
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
            //System.out.println(">>>>"+transicion[0]+" "+transicion[1]+" "+transicion[2]+" ");
            automata.addTransicion(transicion);
        }
    }

    public void guardarEn(String direccion, Automata A){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);

            pw.println("inicial:"+A.getEdoInical());
            pw.println("finales:"+A.getEdoFinales());

            int i=0;
            System.out.println(A.getEstados().size());

            while (i<A.getEstados().size()){
                int j=0;
                Estado aux=A.getEstados().get(i);
                System.out.println("Estado "+i+" :"+aux.getEtiqueta());
                System.out.println(aux.getTransiciones().size());
                while (j<aux.getTransiciones().size()){
                    char[] v=aux.getTransicion(j);
                    System.out.println("    Transicion "+j+" :"+v[0]+v[1]);
                    pw.println(aux.getEtiqueta()+"->"+v[0]+","+v[1]);
                    j++;
                }
                i++;
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

}
