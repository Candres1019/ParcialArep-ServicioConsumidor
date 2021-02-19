package edu.escuelaing.arep.ParcialPrimerTercio.cliente;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Conexion con servidor fachada para consumo de apis
 *
 * @author Andres Mateo Calderon Ortega.
 */
public class ApiMainConnection {

    private static final String URI = "https://andrescalderonservidorconsumid.herokuapp.com/consumidor?";
    private static final String valorP = "valor=";
    private static final String funcionP = "funcion=";

    /**
     * Metodo que consulta el sin, cos o tan.
     *
     * @param valor   - valor a consumir.
     * @param funcion - funcion a calcular.
     * @return resultado del calculo.
     */
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
