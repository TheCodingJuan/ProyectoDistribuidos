package negocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Interfaz {
    public static List<Subscriptor> clientes= new ArrayList<>(100);
    public static void main(String args[]){

        GenerarSuscriptores();

    }

    public static void GenerarSuscriptores(){
        try{
            FileReader f=new FileReader("Usuarios.txt");
            BufferedReader b= new BufferedReader(f);
            String Nombre = null;
            String Apellido = null;
            String clima,ub,tipoDeP,host,puerto,in;
            List<String> s=new ArrayList<>(30);
            int tamaño,precio;

            String linea= b.readLine();
            while (linea!= null){
                String aux=linea;
                aux = linea;
                StringTokenizer token = new StringTokenizer(aux, "-");
                Nombre = token.nextToken();
                Apellido = token.nextToken();
                linea = b.readLine();
                aux = linea;
                token = new StringTokenizer(aux, "-");
                puerto = token.nextToken();
                host = token.nextToken();
                linea = b.readLine();
                aux = linea;
                token = new StringTokenizer(aux, "-");
                clima = token.nextToken();
                tipoDeP = token.nextToken();
                ub = token.nextToken();
                tamaño = Integer.parseInt(token.nextToken());
                precio = Integer.parseInt(token.nextToken());
                linea = b.readLine();
                aux = linea;
                token = new StringTokenizer(aux, "-");
                while (!token.hasMoreElements()) {
                    in = token.nextToken();
                    s.add(in);
                }
                Cultivo cul = new Cultivo(clima, ub, tipoDeP, precio, tamaño);
                Subscriptor sus = new Subscriptor(host, puerto, "2", s, cul, Nombre, Apellido);

                clientes.add(sus);
                sus.start();
                linea=b.readLine();
                linea=b.readLine();

            }

        }catch (Exception e){
            System.out.println("Error en el archivo");
        }
    }

}
