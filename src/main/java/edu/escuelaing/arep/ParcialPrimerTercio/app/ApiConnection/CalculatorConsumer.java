package edu.escuelaing.arep.ParcialPrimerTercio.app.ApiConnection;

public interface CalculatorConsumer {

    /**
     * Metodo que consulta el sin, cos o tan.
     *
     * @param valor   - valor a consumir.
     * @param funcion - funcion a calcular.
     * @return resultado del calculo.
     */
    String getResultado(String valor, String funcion);

}
