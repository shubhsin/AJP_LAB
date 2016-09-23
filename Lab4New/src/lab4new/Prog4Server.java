/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4new;
import java.io.*;
import java.net.*;
/**
 *
 * @author student
 */
public class Prog4Server {
    public static void main(String args[]) {
        String clientSentence;
        String capitalizedSentence;
        ServerSocket welcomeSocket;
        Socket connectionSocket = null;
        try{
            welcomeSocket = new ServerSocket(2000);
            connectionSocket = welcomeSocket.accept();
        }catch(Exception e){}
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            
            while(true){
            try{
            DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
            clientSentence = inFromClient.readUTF();
            capitalizedSentence = clientSentence.toUpperCase() +'\n';
            System.out.println(clientSentence);
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            String outp = br.readLine();
            outToClient.writeUTF(outp);
            }
            catch(Exception e){}
            }
            }           
            
    }
