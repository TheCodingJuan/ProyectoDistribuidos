package negocio;

import netscape.javascript.JSObject;

import java.io.*;
import java.net.*;

public class Subscriptor
{
    Socket socket;
    InputStream entrada;
    OutputStream salida;
    Cultivo cultivo;

    public static void main(String args[])
    {
        if (args.length >= 3 && args.length < 8)
        {
            //new Cliente(args[0], args[1], args[2]);
        }
        else
        {
            System.out.println("Uso: java Cliente [HOST] [PUERTO] [CATEGORIA] (entre 1 y 5)");
            System.exit(0);
        }
    }

    /**
     Constructor de la clase.
     @param host Direccion del servidor.
     @param puerto Puerto del servidor
     @param numero Numero que se desea procesar
     */
    public Subscriptor(String host, String puerto, String numero)
    {
        try
        {
            System.out.println("Subscriptor: conectando al host: " + host + "por el puerto:" + puerto);

            socket = new Socket(host, Integer.parseInt(puerto));
            entrada = socket.getInputStream();
            salida = socket.getOutputStream();
            Tuple tp = new
            salida.write(numero.getBytes());

            byte[] b = new byte[10];
            entrada.read(b);

            System.out.println("Cliente: numero = " + numero);
            System.out.println("Cliente: suma = " + new String(b));
        }
        catch (IOException e)
        {
            System.out.println("Ha ocurrido una excepcion no esperada...");
            e.printStackTrace();
        }
    }
}
