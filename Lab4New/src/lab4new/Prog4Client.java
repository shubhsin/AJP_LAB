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
public class Prog4Client {
    public static void main(String args[]) {
        
        Socket clientSocket = null;
        DataOutputStream outToServer;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try{
            clientSocket = new Socket("localhost",2000);
        }catch(Exception e){}
        while(true){
        try{    
        String sentence;
        String modifiedSentence;
        outToServer = new DataOutputStream(clientSocket.getOutputStream());
  
        //BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String uinp = br.readLine();
        outToServer.writeUTF(uinp);
        DataInputStream inFromServer = new DataInputStream(clientSocket.getInputStream());
        sentence = (String)inFromServer.readUTF();
        System.out.println(sentence);
        }
        catch(Exception e){}
        }
    }
}
