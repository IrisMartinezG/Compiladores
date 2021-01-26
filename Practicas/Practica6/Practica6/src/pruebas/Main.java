package pruebas;

import algoritmoll1.AlgoritmoLL1;
import gramatica.GLC;
import lector.Lector;

public class Main {

    public static void main(String[] args) {
        Lector exGramatica=new Lector();
        //cambiar direccion en linux
        exGramatica.leerArchivo("prueba.txt");
        GLC gram=new GLC();
        gram= exGramatica.obtenerGramatica();
        AlgoritmoLL1 m =new AlgoritmoLL1();
        m.calcularTablaM(gram);
    }
}
