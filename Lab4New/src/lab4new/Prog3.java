/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4new;
import java.net.*;
import java.io.*;
/**
 *
 * @author student
 */
public class Prog3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            InetAddress address = InetAddress.getByName("www.apple.com");
            System.out.println("IP : " + address);
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Local : "+localAddress);
        }catch(Exception e) {
            System.out.println("Could not find host");
        }
        try{
        URL url=new URL("http://www.google.com/");
        URLConnection urlcon=url.openConnection();
        InputStream stream=urlcon.getInputStream();
        int i;
            while((i=stream.read())!=-1){
                System.out.print((char)i);
            }
            }catch(Exception e){System.out.println(e);}
    }
}
