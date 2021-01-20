package com.company;

public class Main {

    public static void main(String[] args) {
        Lector exGramatica=new Lector();
        //cambiar direccion en linux
        exGramatica.readFile("C:\\Users\\end user\\Documents\\Yoni\\ESCOM\\7mo Semestre Escom\\Compiladores\\compiladores\\Practicas\\Practica5\\enJava\\src\\com\\company\\prueba.txt");
        GLC gram=new GLC();
        gram= exGramatica.getGramatica();
        AlgoritmoLL1 m =new AlgoritmoLL1();
        m.calcularTablaM(gram);
    }
}
