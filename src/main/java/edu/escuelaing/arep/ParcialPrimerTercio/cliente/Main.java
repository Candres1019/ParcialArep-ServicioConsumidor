package edu.escuelaing.arep.ParcialPrimerTercio.cliente;

import java.io.DataInputStream;

public class Main {

    private static String valor;
    private static String funcion;

    public static void main(String[] args) {
        DataInputStream in = new DataInputStream(System.in);
        try{
            System.out.println("Valor : ");
            valor = in.readLine();
            System.out.println("Funcion : ");
            funcion = in.readLine();
            ApiMainConnection apiMainConnection = new ApiMainConnection();
            System.out.println("Resultado" + apiMainConnection.getResultado(valor, funcion));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
