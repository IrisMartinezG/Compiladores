package tablaLL1;

public class TablaM {
    private int terminales;
    private int noterminales;
    private String[][] tablaM;

    public TablaM(int tamfilas, int tamcolumnas){
        noterminales=tamfilas;
        terminales=tamcolumnas;
        tablaM=new String[noterminales+1][terminales+2];

    }

    public void inicilizarTablaM(String terminales, String noterminales){
        int j=0;String auxs="";
        tablaM[0][0]="- ";
        int r=0;
        while (r<terminales.length()){
            tablaM[0][r+1]=terminales.charAt(r)+" ";
            r++;
        }
        tablaM[0][r+1]="$ ";
        r=0;
        while (r<noterminales.length()){
            tablaM[r+1][0]=noterminales.charAt(r)+" ";
            int r1=1;
            while (r1<terminales.length()+2){
                tablaM[r+1][r1]="";
                r1++;
            }
            r++;
        }

    }

    public String[][] obtenerTablaM() {
        return tablaM;
    }

    public void establecerTablaM(String[][] tablaM) {
        this.tablaM = tablaM;
    }

    public int getNoterminales() {
        return noterminales;
    }

    public int getTerminales() {
        return terminales;
    }

    public String[][] getTablaM() {
        return tablaM;
    }

    public void agregarElmento(int columna,int fila, int elemento){
        tablaM[fila][columna]+=elemento+"/";

    }
}
