package negocio;

import netscape.javascript.JSObject;

import java.io.*;
import java.lang.reflect.Array;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Subscriptor extends Thread {
    ServerSocket server;
    Socket socket;
    InputStream entrada;
    PrintStream salida;
    String host, puerto;
    String Brokerhost;
    int Brokerpuerto;
    Cultivo cultivo;
    private String Name;
    private String Apellido;
    private List<String> interes = new ArrayList<>(30);

    @Override
    public void run(){

        System.out.println("Cliente :" + this.Name);
        this.Suscribirse();
        BufferedReader entrada;
        try {
            server = new ServerSocket(Integer.parseInt(this.puerto));
            socket = new Socket();
            while(true)
            {
                socket = server.accept(); // acepta la conexion al realizarse
                System.out.println("Noticia Recibida");
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                System.out.println(entrada.readLine());
            }




        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void Suscribirse() {
        try {
            System.out.println("Subscriptor: conectando al host: " + this.Brokerhost + "por el puerto:" + this.Brokerpuerto);


            socket = new Socket(this.Brokerhost, this.Brokerpuerto);
            entrada = socket.getInputStream();
            ObjectOutputStream obj = new ObjectOutputStream(socket.getOutputStream());
            salida = new PrintStream(socket.getOutputStream());
            salida.println("subs");
            obj.writeObject(this);




        }catch (IOException e){
            System.out.println("no se pudo esblecer conexion");

        }
    }


    /**
     Constructor de la clase.
     @param host Direccion del servidor.
     @param puerto Puerto del servidor
     @param numero Numero que se desea procesar
     */
    public Subscriptor(String host, String puerto, String numero, List<String> s,Cultivo c, String nom, String Ap)
    {
            System.out.println("Cliente: numero = " + numero);
         //   System.out.println("Cliente: suma = " + new String(b));
            this.host=host;
            this.puerto=puerto;
            this.cultivo=c;
            this.interes=s;
            this.Name=nom;
            this.Apellido=Ap;
            this.Brokerhost="192.168.0.12";
            this.Brokerpuerto=9000;

    }

    public List<String> getInteres() {
        return interes;
    }
}
