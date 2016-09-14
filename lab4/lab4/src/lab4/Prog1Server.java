/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4;
import java.io.*;
import java.net.*;

/**
 *
 * @author student
 */
public class Prog1Server {
    public static void main(String[] args) throws Exception{
        String clientSentence;
        String capitalizedSentence;
        
        ServerSocket welcomeSocket = new ServerSocket(2000);
            Socket connectionSocket = welcomeSocket.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream inFromClient = new DataInputStream(connectionSocket.getInputStream());
            clientSentence = inFromClient.readUTF();
            capitalizedSentence = clientSentence.toUpperCase() +'\n';
            System.out.println(clientSentence);
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
            String outp = br.readLine();
            outToClient.writeUTF(outp);
            connectionSocket.close();
        
    }
}
