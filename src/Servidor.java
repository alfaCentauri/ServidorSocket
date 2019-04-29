/*
 * Servidor.java.
 * Licencia GNU.
 */
import java.io.*;
import java.net.*;
/**Clase para comunicar java en red usando sockets.
 *@author Ingeniero en Computación: Ricardo Presilla.
 *@version 1.0.
 */
public class Servidor {
    /**Indica el puerto de conexión.*/
    private int PUERTO=5000;
    /**Es el servicio de red.*/
    private ServerSocket servidor;
    /**Es el objeto que maneja el protocolo TCP.*/
    private Socket cliente;
    private OutputStream salida;
    /**Datos que son enviados al cliente.*/
    private DataOutputStream datos;
    /**/
    private int cantidad;
    /***/
    private InputStream entrada;
    private DataInputStream datos2;
    /*Constructor de la clase servidor, inicia el servicio.*/
    public Servidor(){
        try{
            servidor= new ServerSocket(PUERTO);
            System.out.println("El puerto de comunicación es "+PUERTO);
            //Limita los clientes a 3
            for(int numClientes=0; numClientes<3; numClientes++){
                cliente= servidor.accept();
                System.out.println("Atiendo al cliente # "+String.valueOf(numClientes));
                salida=cliente.getOutputStream();
                datos= new DataOutputStream(salida);
                datos.writeUTF("Hola cliente # "+String.valueOf(numClientes));
            }
            System.out.println("Demasiados clientes por hoy.");
        }catch(Exception ex){
            System.out.println("Error en la comunicación.\n"+ex.getMessage());
        }
    }
    /*Constructor de la clase servidor, inicia el servicio para una cantidad determinada de usuarios.*/
    public Servidor(int cant){
        cantidad=cant;
        try{
            servidor= new ServerSocket(PUERTO);
            cliente= servidor.accept();
            salida=cliente.getOutputStream();
            datos= new DataOutputStream(salida);
        }catch(Exception ex){
            System.out.println("Error en la comunicación.\n"+ex.getMessage());
        }
    }
    /**Este método finaliza el servicio del socket.
     *@return Regresa verdadero si se cierra el servicio, sino regresa falso.
     */
    public boolean FinalizaComunicacion(){
        try{
            datos.close();
            salida.close();
            cliente.close();
            servidor.close();
        }catch(Exception ex){
            System.out.println("Error en el cierre de la comunicación.\n"+ex.getMessage());
            return false;
        }
        return true;
    }
    /**Este método envia una cadena de caracter al cliente conectado al servicio.
     *@param cadena Tipo String, almacena la información ha enviar.
     *@return Regresa verdadero si efectua la operación sino regresa falso.
     */
    public boolean Enviar(String cadena){
        try{
            datos.writeUTF(cadena);
        }catch(Exception ex){
            System.out.println("Error en el cierre de la comunicación.\n"+ex.getMessage());
            return false;
        }
        return true;
    }
    /**Este método recibe una cadena del cliente conectado al servicio.*/
    public String Recibir(){
        String linea="";
        try{
            entrada= cliente.getInputStream();
            datos2= new DataInputStream(entrada);
            linea=datos2.readUTF();
        }catch(Exception ex){
            System.out.println("Error en el cierre de la comunicación.\n"+ex.getMessage());
            return null;
        }
        return linea;
    }
}
