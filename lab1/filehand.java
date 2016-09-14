import java.io.*;
class filehand {
  public static void main(String[] args) throws Exception{
    System.out.println("Give the file a name");
    InputStreamReader r=new InputStreamReader(System.in);
    BufferedReader br=new BufferedReader(r);
    String fileName=br.readLine();
    try{
    FileWriter fw = new FileWriter(fileName);
    fw.write("Apple will release the new iPhone in September,2017");
    fw.close();
    }
    catch (Exception e) {
      System.out.println(e);
    }
    try{
    FileReader fr = new FileReader(fileName);
    int i;
    while((i=fr.read())!=-1)
      System.out.print((char)i);
    fr.close();
    }
    catch(Exception e) {
      System.out.println(e);
    }

  }
}
