/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

import java.io.*;
import java.net.*;
/**
 *
 * @author edwin
 */
public class Cliente{
    Socket sc;
    DataOutputStream output;
    DataInputStream input;
    String mensajeServer;

    public void startCliente(){
        try{
            sc = new Socket("127.0.0.1", 5000);
        }catch(Exception e){
            System.out.println("Error con la conexion del servidor");
        }
    }
    
    public void sendMessage(String message) throws IOException{
        output = new DataOutputStream(sc.getOutputStream());
        output.writeUTF(message);//enviamos mensaje
    }
    public String receiveMessage() throws IOException{
         input = new DataInputStream(sc.getInputStream());
         mensajeServer = input.readUTF();//Leemos respuesta
        return mensajeServer;
    }
}