package edu.escuelaing.arep.ParcialPrimerTercio.app;

import com.google.gson.Gson;
import edu.escuelaing.arep.ParcialPrimerTercio.app.ApiConnection.CalculatorAPI;

import static spark.Spark.*;

/**
 * @author Andres Mateo Calderon Ortega
 * <p>
 * Servicio fachada para realizar calculos.
 */
public class SparkWebConsumerServiceApp {
    /**
     * Metodo main de la clase SparkWebService
     *
     * @param args - args
     */
    public static void main(String[] args) {
        CalculatorAPI calculatorAPI = new CalculatorAPI();
        port(getPort());
        init();
        get("/consumidor", (request, response) -> {
            response.type("application/json");
            String valor = request.queryParams("valor");
            String funcion = request.queryParams("funcion");
            String resultado = calculatorAPI.getResultado(valor, funcion);
            return resultado;
        });
    }


    /**
     * Metodo para obtener el puerto por el cual el servidor se va a ejecutar
     *
     * @return - Puerto por donde correr spark
     */
    static int getPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
