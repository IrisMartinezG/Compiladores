package lector;
import gramatica.GLC;

import java.io.File;
import java.util.Scanner;

public class Lector {
    private GLC gramatica=new GLC();

    public Lector(){

    }

    public void leerArchivo(String direccion){
        try {
            Scanner input = new Scanner(new File(direccion));
            while (input.hasNextLine()) {
                String line = input.nextLine();
                establecerProducciones(line);
                //System.out.println(line);
            }
            input.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void establecerProducciones(String line){
        char a=line.charAt(0);
        if(!gramatica.validarInical()){
            gramatica.establecerInicial(a);
        }
        for(int i=0;i<line.length();i++){
            a=line.charAt(i);
            gramatica.agregarTerminal(a);
            gramatica.agregarNoTerminal(a);
        }
        String[] partes = line.split("->");
        a=partes[0].charAt(0);
        gramatica.agregarProduccion(a, partes[1]);
        //gramatica.getProduccion(0);
    }

    public GLC obtenerGramatica() {
        return gramatica;
    }

}
