/*
 * Autor: Martinez Gonzalez Iris
 *
 */
package automata;

public class AFD extends Automata {

    public AFD(Automata A){
        this.EdoFinales=A.EdoFinales;
        this.EdoInical=A.EdoInical;
        this.Estados=A.Estados;
        this.numestados=A.numestados;
        this.Simbolo=A.Simbolo;

    }

    public void acceptaCadena(String a){

    }


}
