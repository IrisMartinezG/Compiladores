/*
 * Autor: Martinez Gonzalez Iris
 *
 */

package gestionador;
import automata.Automata;
import automata.Estado;

import java.io.*;

public class GestionadorAutomata {
    private Automata automata=new Automata();

    public  GestionadorAutomata(){}

    public Automata getAutomata() {
        return automata;
    }

    public void leerArchivo(String direccion){
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
                establecerInicial(linea);
                establecerFinales(linea);
                agregarTransicion(linea);
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

    public void establecerInicial(String line){
        if (line.contains("inicial:")){
            String[] a=line.split("inicial:");
            automata.establecerEdoInical(Integer.parseInt(a[1]));
        }
    }

    public void establecerFinales(String line){
        if (line.contains("finales:")){
            String[] a=line.split("finales:");
            if (a[1].contains(",")){
                String[] b=a[1].split(",");
                int i=0;
                while (i<b.length){
                    automata.establecerFinal(Integer.parseInt(b[i]));
                    i++;
                }

            }else {automata.establecerFinal(Integer.parseInt(a[1]));}
        }
    }

    public void agregarTransicion(String line){
        String[] transicion=new String[3];
        if (line.contains("->")){
            String[] a=line.split("->");
            transicion[0]=a[0];
            String[] b=a[1].split(",");
            transicion[1]=b[0];
            transicion[2]=b[1];
            //System.out.println(">>>>"+transicion[0]+" "+transicion[1]+" "+transicion[2]+" ");
            automata.agregarTransicion(transicion);
        }
    }

    public void guardarEn(String direccion, Automata A){
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(direccion);
            pw = new PrintWriter(fichero);

            pw.println("inicial:"+A.obtenerEdoInical());
            pw.println("finales:"+A.obtenerEdoFinales());

            int i=0;
            System.out.println(A.obtenerEstados().size());

            while (i<A.obtenerEstados().size()){
                int j=0;
                Estado aux=A.obtenerEstados().get(i);
                System.out.println("Estado "+i+" :"+aux.obtenerEtiqueta());
                System.out.println(aux.obtenerTransiciones().size());
                while (j<aux.obtenerTransiciones().size()){
                    char[] v=aux.obtenerTransicion(j);
                    System.out.println("    Transicion "+j+" :"+v[0]+v[1]);
                    pw.println(aux.obtenerEtiqueta()+"->"+v[0]+","+v[1]);
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
