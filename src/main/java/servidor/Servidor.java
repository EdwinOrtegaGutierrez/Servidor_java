/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servidor;

import java.io.*;
import java.net.*;
/**
 *
 * @author edwin
 */

public class Servidor{
    ServerSocket sc;
    Socket so;
    DataOutputStream output;
    DataInputStream input;
    String messageClient;

    public void startServidor(){
        try{
            sc = new ServerSocket(5000);
            so = new Socket();
            System.out.println("Servidor en linea");
            so = sc.accept();
            System.out.println("Cliente conectado");
        }catch(Exception e){
            System.out.println("\nError en la conexion. " + e);
        }
    }
    public void sendMessage(String message) throws IOException{
        output = new DataOutputStream(so.getOutputStream());
        output.writeUTF(message);//enviamos mensaje
    }
    public String receiveMessage() throws IOException{
        input = new DataInputStream(so.getInputStream());
         messageClient = input.readUTF();
        return messageClient;
    }
    public static void main(String[] args){
        Servidor server = new Servidor();
        server.startServidor();
    }
}