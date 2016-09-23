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
public class Prog2Client {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        DatagramSocket clientSocket = new DatagramSocket();
        InetAddress IPAddress = InetAddress.getByName("localhost");
        
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        
        String sentence = br.readLine();
        sendData = sentence.getBytes();
        
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,9876);
        clientSocket.send(sendPacket);
        
        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println(modifiedSentence);
        clientSocket.close();
    }
}
