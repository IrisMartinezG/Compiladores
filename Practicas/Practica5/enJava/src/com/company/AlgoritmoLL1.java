package com.company;

import javax.jws.soap.SOAPBinding;
import java.util.HashMap;
import java.util.Map;

public class AlgoritmoLL1 {
    private GLC gramat=new GLC();
    private  String primeros;
    private int numproducciones;
    private String terminal;
    private Map<String, String> diccionario = new HashMap<String, String>();//TODO cambiar nombre de diccionario, guarda los primeros de toda la gramtica

    public AlgoritmoLL1(){
        primeros="";
        numproducciones=0;
        terminal="";
    }

    public void calcularTablaM(GLC gramatica){
        numproducciones=gramatica.getNumproduccion();
        terminal=gramatica.getTerminal();
        gramat=gramatica;
        int i=0;
        while (i<numproducciones){
            Produccion a=new Produccion();
            a=gramatica.getProduccion(i);
            if(a.getAlpha().charAt(0) == 69 && i==0){
                String resultado=diccionario.get(String.valueOf(a.getNoterminal()));
                if(resultado==null){
                    resultado= calcularSiquiente(a.getNoterminal());
                    resultado=quitaRep(resultado);
                    diccionario.put(String.valueOf(a.getNoterminal()), resultado);
                }else {
                    resultado+= calcularSiquiente(a.getNoterminal());
                    resultado=quitaRep(resultado);
                    diccionario.put(String.valueOf(a.getNoterminal()), resultado);
                }

            }else /*if(a.getAlpha().charAt(0) != 69)*/{
                String resultado=diccionario.get(String.valueOf(a.getNoterminal()));
                if(resultado==null){
                    resultado= calculaPrimero(a.getNoterminal(),a.getAlpha());
                    resultado=quitaRep(resultado);
                    diccionario.put(String.valueOf(a.getNoterminal()), resultado);
                }else {
                    resultado+= calculaPrimero(a.getNoterminal(),a.getAlpha());
                    resultado=quitaRep(resultado);
                    diccionario.put(String.valueOf(a.getNoterminal()), resultado);
                }
            }
            i++;
        }
        System.out.println(diccionario);

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
                    a = gramat.getProduccion(j);
                    String aux=diccionario.get(String.valueOf(a.getNoterminal()));
                    if (a.getNoterminal() == alpha.charAt(i) && aux==null) {//Verificamos que no lo hayamos calculado
                        resultado = resultado + calculaPrimero(a.getNoterminal(), a.getAlpha());
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
            a=gramat.getProduccion(i);
            if(a.getAlpha().charAt(0) == 69 && i==0){//Regla 1
                Siquientes+="$";
                System.out.println("Cumple con la regla 1");
            }else if(a.getAlpha().indexOf(String.valueOf(noterminal))==a.getAlpha().length()-1){//Regla 2
                System.out.printf("Cumple con la regla 2");
                //System.out.printf(a.getAlpha());
            }else if(a.getAlpha().indexOf(String.valueOf(noterminal))!=-1){//Regla 3 y 4
                String[] partes = a.getAlpha().split(String.valueOf(noterminal));
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
}
