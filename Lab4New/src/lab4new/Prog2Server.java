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
public class Prog2Server {
    public static void main(String args[]) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
 
            DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
            
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            System.out.println(sentence);
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String sendSentence = br.readLine();
            sendData = sendSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,port);
            serverSocket.send(sendPacket);
    }
}
