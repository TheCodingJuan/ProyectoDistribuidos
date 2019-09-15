package negocio;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Servidor
{
    //lista de todas las propagandas en el sistema
    private List<Propaganda> ads = new ArrayList<>(33);

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
        ReadPropaganda();

       /*try
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
        }*/

    }
    public static   void ReadPropaganda(){
        try{
            FileReader f=new FileReader("fuentes.txt");
            BufferedReader b= new BufferedReader(f);

            int id;
            String tema;
            String categoria;
            String text;

            String linea= b.readLine();
            while (linea!= null){
                String aux=linea;

                if(aux.contains("-"))
                {
                    StringTokenizer token= new StringTokenizer(aux, "-");
                    tema=token.nextToken();
                    categoria=token.nextToken();
                    System.out.println(tema);
                    System.out.println(categoria);
                    System.out.println(linea);
                }
                while(!linea.contains("*")){
                    StringBuilder sb = new StringBuilder();
                    sb.append(linea);
                    sb.append(System.lineSeparator());
                    linea = b.readLine();
                    System.out.println(sb.toString());
                }
                linea = b.readLine();



            }

        }catch (Exception e){

        }
    }
}
