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
        Servidor s= new Servidor();
        s.ReadPropaganda();
        for (Propaganda p : s.ads){
            System.out.println( p.getId() + "----" +p.getTema()+"----"+p.getCategoria() + "----"+p.getAd());

        }

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
    public void ReadPropaganda(){
        try{
            FileReader f=new FileReader("fuentes.txt");
            BufferedReader b= new BufferedReader(f);
            int cont=0;
            int id;
            String tema = null;
            String categoria = null;
            String text;

            String linea= b.readLine();
            while (linea!= null){
                String aux=linea;

                if(aux.contains("-"))
                {
                    StringTokenizer token= new StringTokenizer(aux, "-");
                    tema=token.nextToken();
                    categoria=token.nextToken();

                }
                StringBuilder sb = new StringBuilder();
                linea = b.readLine();
                while(!linea.contains("*")){

                    sb.append(linea);
                    linea = b.readLine();

                }
                text=sb.toString();
                linea = b.readLine();
                cont++;
                if(tema!= null && categoria!=null){
                    Propaganda p= new Propaganda(cont,tema,categoria,text);
                    ads.add(p);
                }else{
                    System.out.println("Error al crear noticia");
                }



            }

        }catch (Exception e){
                System.out.println("Error en el archivo");
        }
    }
}
