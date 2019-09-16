package negocio;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Broker {

    private String host;
    private int puerto;
    private List<Subscriptor> subscriptores;
    private List<Servidor> publicadores;
    private List<Propaganda> propa;
    //private InetAddress ipBalanceador;
    private List<String> temas;
    private String broadcast;
    private boolean esServidor;
    private Socket socket;


    public Broker(String host, String puerto, ArrayList<String> temas, Socket socket)
    {
        try
        {
            this.host= host;
            this.puerto = Integer.parseInt(puerto);
            this.subscriptores = new ArrayList<>(10);
            this.publicadores = new ArrayList<>(10);
           // this.ipBalanceador = InetAddress.getByName("127.0.0.1");
            this.temas = temas;
           // this.brokers = brokers;
            this.broadcast = "255.255.255.255";
           // this.esServidor = esServidor;
            this.socket = new Socket(host, this.puerto);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public String toString()
    {
        return "Broker con IP: " + this.host + " y puerto:" + this.puerto;
    }

    public void run(){
        try{
            // Cambiar el constructor y el metodo run por un main, que reciba como argumentos los parametro del constructor

            ServerSocket ser=new ServerSocket(this.puerto);
            socket = new Socket();
            BufferedReader entrada;
            ObjectInputStream obj;
            String aux;

            while(true)
            {
                socket = ser.accept(); // acepta la conexion al realizarse
                System.out.println("Conexion establecida");
                entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                aux=entrada.readLine();
                System.out.println(aux);
                obj= new ObjectInputStream(socket.getInputStream());
                if (aux.equalsIgnoreCase("server")){

                    Servidor s=(Servidor) obj.readObject();
                    agregarServ(s);
                }else{
                    if (aux.equalsIgnoreCase("subs")){
                        Subscriptor su= (Subscriptor) obj.readObject();
                        agregarSubs(su);
                    }
                }
            }

        }catch (IOException | ClassNotFoundException e){

        }


    }

    private void agregarSubs(Subscriptor su) {

        System.out.println("-----------------Agregando al nuevo cliente:------------");
        System.out.println(su.getName());
        System.out.println("--------------------------------------------------------");
        this.subscriptores.add(su);
    }

    private void agregarServ(Servidor s) {
        System.out.println("-----------------Agregando al nuevo servidor:------------");
        //System.out.println(subscriptor.getName()); //se necesita agregar otro atributo al servidor, algo que lo identifique
        System.out.println("--------------------------------------------------------");
        this.publicadores.add(s);
    }



   /*public void addBroker(Broker broker)
    {
        System.out.println("-----------------Agregando al nuevo broker:------------");
        System.out.println(broker.toString());
        System.out.println("--------------------------------------------------------");
        this.brokers.add(broker);
    }
    */
    public void enviarBroadcast(String data)
    {
        try
        {
            Socket socketBroadcast = new Socket(this.broadcast, this.puerto);
            DataOutputStream salida = new DataOutputStream(socketBroadcast.getOutputStream());
            if (salida != null)
                salida.writeBytes(data);
            salida.close();
            socketBroadcast.close();
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    //esto solo va a servir incluyendo el atributo nuevo en servidor, para que puedan diferenciarse unos de otros
	/*public static boolean servidorRegistrado (String name)
	{
		for (Servidor publicador : this.publicadores)
			if (publicador.getName() == name)
				return true;
		return false;
	}*/

    public void broadcastAClientes(String data)
    {
		/*
		 * primera parte del metodo no lo entiendo en el de google
		 *

		for (Subscriptor subscriptor : this.subscriptores)
			for (String interes : subscriptor.getInteres()) //falta crear el metodo getInteres en subscriptor
			{
				System.out.println("interes: " + interes);

			}

		*/
    }


}