package gramatica;

public class Produccion {
    private char noterminal;
    private String alpha;
    private int numproduccion;

    public Produccion(){
        numproduccion=0;
        alpha="";
    }

    public void iniciaProduccion(char no_t, String cuerpo, int num) {
        alpha=alpha+cuerpo;
        numproduccion=num;
        noterminal=no_t;
        //System.out.println(noterminal+" "+alpha+" "+numproduccion);
    }

    public void getall() {
        System.out.println(noterminal+" "+alpha+" "+numproduccion);
    }

    public String obtenerAlpha() {
        return alpha;
    }

    public char obtenerNoterminal() {
        return noterminal;
    }
}
