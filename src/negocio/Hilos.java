package negocio;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 Clase utilizada para atender mas de un cliente a la vez.<BR>
 Luego de recibir un cliente, realiza el calculo de la sumatoria
 */
public class Hilos implements Runnable
{
    private Socket socket;

    //constructor completo, para instanciar a Hilos como se requiere, de manera que cargue todas las posibles
    //propagandas en memoria.
    public Hilos(Socket s)
    {
        socket = s;
    }

    /**
     Metodo run, con este metodo se inicia el hilo.
     */
    public void run()
    {
        try
        {
            System.out.println("ThreadServer: Ha llegado una nueva conexion...");
            //deja en "entrada" lo que el cliente le envio
            InputStream entrada = socket.getInputStream();
            byte[] b = new byte[10];
            int lenght = entrada.read(b);
            int valor = Integer.parseInt(new String(b, 0, lenght));
            /*
            if(suma > 0)
            {
                System.out.println("ThreadServer: valor precalculado");
                System.out.println("ThreadServer: numero  = " + valor);
                System.out.println("ThreadServer:   suma  = " + suma);
                System.out.println("*********************************************");
            }
            else
            {
                System.out.println("ThreadServer: numero  = " + valor);
                System.out.println("ThreadServer:   suma  = " + suma);
                System.out.println("*********************************************");
            }

            String temp = Integer.toString(suma);
            OutputStream salida = socket.getOutputStream();
            salida.write(temp.getBytes());*/
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return;
        }
    }
}