/*
 * Autor: Martinez Gonzalez Iris
 *
 */

package automata;

public class AFN extends Automata {

    public AFN(Automata A){
        this.EdoFinales=A.EdoFinales;
        this.EdoInical=A.EdoInical;
        this.Estados=A.Estados;
        this.numestados=A.numestados;
        this.Simbolo=A.Simbolo;

    }

    public void acceptarCadena(String a){

    }



}
