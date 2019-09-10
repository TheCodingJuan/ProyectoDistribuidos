package negocio;

import java.io.*;
import java.net.*;

public class Servidor
{
    //constructor por defecto.
    public Servidor() {}

    /**
     Metodo estatico Main, aqui comienza la ejecucion del programa servidor.<BR>
     Los parametros de entrada son:<BR>
     java Servidor [PUERTO]
     @param args Arreglo con los parametros de entrada (ver mas arriba)
     */
    public static void main(String args[])
    {
        try
        {
            if(args.length != 1)
            {
                System.out.println("debe ingresar un puerto... ");
                System.out.println("uso:\t java Servidor [PUERTO]");
                System.exit(0);
            }


            int port = Integer.parseInt(args[0]);
            ServerSocket ss = new ServerSocket( port );   // ServerSocket que escucha el puerto

            System.out.println("ThreadServer: Esperando Conexiones... ");
            System.out.println("*********************************************");

            while(true)
            {

                Socket socket = ss.accept( );   // acepta la conexion al realizarse
                Hilos h = new Hilos(socket);
                Thread t = new Thread(h);
                t.start();     // inicializa este nuevo Thread
            }
        }
        catch (Exception e)
        {
            System.out.println("Ha ocurrido una excepcion no esperada...");
            e.printStackTrace();
        }
    }



}
