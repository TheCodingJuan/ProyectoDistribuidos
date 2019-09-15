package negocio;

import netscape.javascript.JSObject;

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Subscriptor extends Thread {
    Socket socket;
    InputStream entrada;
    OutputStream salida;
    Cultivo cultivo;
    private String Name;
    private String Apellido;
    private List<String> interes = new ArrayList<>(30);

    @Override
    public void run(){

        System.out.println("Cliente :" + this.Name);
    }



    /**
     Constructor de la clase.
     @param host Direccion del servidor.
     @param puerto Puerto del servidor
     @param numero Numero que se desea procesar
     */
    public Subscriptor(String host, String puerto, String numero, List<String> s,Cultivo c, String nom, String Ap)
    {
       // try
        //{
            System.out.println("Subscriptor: conectando al host: " + host + "por el puerto:" + puerto);

           // socket = new Socket(host, Integer.parseInt(puerto));
           // entrada = socket.getInputStream();
         //   salida = socket.getOutputStream();
         //   salida.write(numero.getBytes());

         //   byte[] b = new byte[10];
          //  entrada.read(b);

            System.out.println("Cliente: numero = " + numero);
         //   System.out.println("Cliente: suma = " + new String(b));
            this.cultivo=c;
            this.interes=s;
            this.Name=nom;
            this.Apellido=Ap;
       // }
      //  catch (IOException e)
        //{
         //   System.out.println("Ha ocurrido una excepcion no esperada...");
         //   e.printStackTrace();
       // }
    }

}
