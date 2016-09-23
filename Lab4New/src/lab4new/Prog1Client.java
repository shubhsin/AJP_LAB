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
public class Prog1Client {
    public static void main(String argv[]) throws Exception{
        String sentence;
        String modifiedSentence;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost",2000);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        //BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String uinp = br.readLine();
        outToServer.writeUTF(uinp);
        
        DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
        
        sentence = (String)inFromServer.readUTF();
        System.out.println(sentence);
        
        
        clientSocket.close();
        
    }
}
