package algoritmoll1;

import gramatica.GLC;
import gramatica.Produccion;
import tablaLL1.TablaM;

import java.util.ArrayList;
import java.util.HashMap;

public class AlgoritmoLL1 {
    private GLC gramat=new GLC();
    private  String primeros;
    private int numproducciones;
    private String terminal;
    private String noterminal;
    String[][] tablaaux;
    private TablaM tablaM;
    private HashMap<String, String> diccionario = new HashMap<String, String>();//TODO cambiar nombre de diccionario, guarda los primeros de toda la gramtica


    public AlgoritmoLL1(){
        primeros="";
        numproducciones=0;
        terminal="";
    }

    public void calcularTablaM(GLC gramatica){
        numproducciones=gramatica.obtenerNumproduccion();
        terminal=gramatica.obtenerTerminal();
        noterminal=gramatica.obtenerNoterminal();
        gramat=gramatica;
        //tablaaux=new TablaM(noterminal.length()+1,terminal.length()+2);
        //tablaaux.inicilizarTablaM(terminal,noterminal);
        tablaaux=new String[gramatica.obtenerNoterminal().length()+1][terminal.length()+2];
//--------------------------------------------------------------------------------
        int j=0;String auxs="";
        tablaaux[0][0]="- ";
        int r=0;
        while (r<terminal.length()){
            tablaaux[0][r+1]=terminal.charAt(r)+" ";
            r++;
        }
        tablaaux[0][r+1]="$ ";
        r=0;
        while (r<gramatica.obtenerNoterminal().length()){
            tablaaux[r+1][0]=gramatica.obtenerNoterminal().charAt(r)+" ";
            int r1=1;
            while (r1<terminal.length()+2){
                tablaaux[r+1][r1]="";
                r1++;
            }
            r++;
        }
//--------------------------------------------------------------------------------
        int i=0;
        while (i<numproducciones){
            Produccion a=new Produccion();
            a=gramatica.obtenerProduccion(i);
            if(a.obtenerAlpha().charAt(0) == 69 && i==0){
                String resultado=diccionario.get(String.valueOf(a.obtenerNoterminal()));
                if(resultado==null){
                    resultado= calcularSiquiente(a.obtenerNoterminal());
                    resultado=quitaRep(resultado);
                    diccionario.put(String.valueOf(a.obtenerNoterminal()), resultado);

                    agregarelemntoTablaLL1(resultado,i,a.obtenerNoterminal());


                }else {
                    resultado+= calcularSiquiente(a.obtenerNoterminal());
                    resultado=quitaRep(resultado);
                    diccionario.put(String.valueOf(a.obtenerNoterminal()), resultado);

                    agregarelemntoTablaLL1(resultado,i,a.obtenerNoterminal());

                }

            }else {
                String resultado=diccionario.get(String.valueOf(a.obtenerNoterminal()));
                if(resultado==null){
                    resultado= calculaPrimero(a.obtenerNoterminal(),a.obtenerAlpha());
                    resultado=quitaRep(resultado);
                    diccionario.put(String.valueOf(a.obtenerNoterminal()), resultado);

                    agregarelemntoTablaLL1(resultado,i,a.obtenerNoterminal());


                }else {
                    resultado+= calculaPrimero(a.obtenerNoterminal(),a.obtenerAlpha());
                    resultado=quitaRep(resultado);
                    diccionario.put(String.valueOf(a.obtenerNoterminal()), resultado);
                    agregarelemntoTablaLL1(resultado,i,a.obtenerNoterminal());

                }
            }
            i++;
        }
        System.out.println(diccionario);
        //System.out.println(auxs);
        j=0;
        while (j<gramatica.obtenerNoterminal().length()+1){
            int k=0;
            while (k<terminal.length()+2){
                System.out.printf("|   "+tablaaux[j][k]+"   |");
                k++;
            }
            System.out.println("-");
            j++;
        }
    }

    public String calculaPrimero(char noterminal , String alpha){
        String resultado ="";
        int i=0,j=0;
        while (i<alpha.length()) {
            if (97 <= alpha.charAt(i) && alpha.charAt(i) <= 122 || alpha.charAt(i) == 69) {//Terminal
                resultado = resultado + alpha.charAt(i);
                break;
            } else if (65 <= alpha.charAt(i) && alpha.charAt(i) <= 90) {//No terminal
                //leeemos otra vez toda la gramatica
                while (j < numproducciones) {
                    Produccion a = new Produccion();
                    a = gramat.obtenerProduccion(j);
                    String aux=diccionario.get(String.valueOf(a.obtenerNoterminal()));
                    if (a.obtenerNoterminal() == alpha.charAt(i) && aux==null) {//Verificamos que no lo hayamos calculado
                        resultado = resultado + calculaPrimero(a.obtenerNoterminal(), a.obtenerAlpha());
                    }else if (aux!=null){
                        resultado = resultado + aux;
                    }
                    j++;
                }
            }
            i++;
        }
        return resultado;
    }

    public String calcularSiquiente(char noterminal){
        int i =0;
        String Siquientes="";
        while (i<numproducciones){
            Produccion a=new Produccion();
            a=gramat.obtenerProduccion(i);
            if(a.obtenerAlpha().charAt(0) == 69 && i==0){//Regla 1
                Siquientes+="$";
                System.out.println("Cumple con la regla 1");
            }else if(a.obtenerAlpha().indexOf(String.valueOf(noterminal))==a.obtenerAlpha().length()-1){//Regla 2
                System.out.printf("Cumple con la regla 2");
                //System.out.printf(a.getAlpha());
            }else if(a.obtenerAlpha().indexOf(String.valueOf(noterminal))!=-1){//Regla 3 y 4
                String[] partes = a.obtenerAlpha().split(String.valueOf(noterminal));
                String aux=calculaPrimero(noterminal,partes[1]);
                if(aux.indexOf("E")!=-1){//Regla 4
                    //calculamos siguiente de a.getnoterminal()
                    System.out.printf("Cumple con la regla 4----");
                }else {
                    Siquientes+=aux;
                }
            }

            i++;
        }
        return Siquientes;

    }

    private String quitaRep(String cadena){
        int tam=cadena.length();
        String aux1="";
        int i=0;
        while(i<tam){
            if(aux1.indexOf(String.valueOf(cadena.charAt(i)))==-1){
                aux1+=String.valueOf(cadena.charAt(i));

            }
            i++;
        }
       return aux1;

    }

    private void agregarelemntoTablaLL1(String resultado, int numproducion, char Noterminal){
        int r=0;
        while (r<noterminal.length()){
            if(tablaaux[r+1][0].charAt(0)==Noterminal){
                int r1=0;//a bc
                while (r1<resultado.length()){
                    System.out.println("********");
                    int r2=0;
                    while (r2<terminal.length()){
                        //System.out.println("-*-"+tablaaux[0][r2+1].charAt(0)+" *** "+resultado.charAt(r1));
                        if(tablaaux[0][r2+1].charAt(0)==resultado.charAt(r1) && !tablaaux[r+1][r2+1].contains(numproducion+1+"")){
                            tablaaux[r+1][r2+1]+=numproducion+1+",";
                            //tablaM.agregarElmento(r+1,r2+1,numproducion+1);
                        }
                        r2++;
                    }
                    r1++;
                }
            }
            r++;
        }

    }


}
