import java.io.*;
import java.net.*;
/**
 * Clase para el cliente de la comunicación con socket.
 * @author Ingeniero Ricardo Presilla ricardopresilla@gmail.com.
 * @version 1.0.
 */
public class Cliente {
    /**Almacena el host.*/
    private String host="localhost";
    /**Almacena el puerto de comunicación.*/
    private int puerto=5000;
    /**Almacena el socket.*/
    private Socket socket1;
    /***/
    private InputStream entrada;
    /**Almacena los datos recibidos.*/
    private DataInputStream datos;
    /**Constructor.*/
    public Cliente(){
        try{
            socket1=new Socket(host,puerto);
            entrada= socket1.getInputStream();
            datos= new DataInputStream(entrada);
            System.out.println(datos.readUTF());
        }catch(Exception ex){
            System.out.println("Error en el cierre de la comunicación.\n"+ex.getMessage());
        }
    }
    /**Este método finaliza el servicio del socket.
     *@return Regresa verdadero si se cierra el servicio, sino regresa falso.
     */
    public boolean FinalizaComunicacion(){
        try{
            datos.close();
            entrada.close();
            socket1.close();
        }catch(Exception ex){
            System.out.println("Error en el cierre de la comunicación.\n"+ex.getMessage());
            return false;
        }
        return true;
    }
}
