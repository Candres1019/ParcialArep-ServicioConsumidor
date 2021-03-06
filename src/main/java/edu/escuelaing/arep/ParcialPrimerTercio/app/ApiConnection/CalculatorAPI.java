package edu.escuelaing.arep.ParcialPrimerTercio.app.ApiConnection;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Clase del Caluclator API que va a consumir los servicios del servidor que hace calculos
 *
 * @author Andres Mateo Calderon Ortega.
 */
public class CalculatorAPI implements CalculatorConsumer {

    private static final String URI = "https://andrescalderonservidorcalc.herokuapp.com/calculador?";
    private static final String valorP = "valor=";
    private static final String funcionP = "funcion=";

    /**
     * Metodo que consulta el sin, cos o tan.
     *
     * @param valor   - valor a consumir.
     * @param funcion - funcion a calcular.
     * @return resultado del calculo.
     */
    @Override
    public String getResultado(String valor, String funcion) {
        try {

            URL url = new URL(URI + valorP + valor + "&" + funcionP + funcion);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setUseCaches(false);
            connection.setDoOutput(true);

            /*connection.getOutputStream();*/

            InputStream is = connection.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = rd.readLine()) != null) {
                response.append(line);
            }
            rd.close();

            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error al momento de realizar la consulta, intente de nuevo.";
        }
    }

}
