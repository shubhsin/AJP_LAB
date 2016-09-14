class ThreadMethod extends Thread {
  Thread t;
  String name;
  String description;
  ThreadMethod(String nam,String desc) {
    description = desc;
    name = nam;
  }

  public void run() {
    System.out.println("Running "+name);
    try {
    System.out.println(name);
    for(int i = 0; i <5; i++) {
            System.out.println("Thread: " + description + ", " + i);
            Thread.sleep(50);
         }
    }
    catch(Exception e) {
      System.out.println(name+" Interrupted "+e);
    }
    System.out.println(name+" exited");
  }

  public void start(){
    System.out.println("Starting "+name);
    if (t == null) {
      t = new Thread (this,name);
      t.start ();
    }
  }
}

class multhread {
  public static void main(String[] args) {
    ThreadMethod AppleThread = new ThreadMethod("Apple","Apple innovates");
    AppleThread.start();
    ThreadMethod SamsungThread = new ThreadMethod("Samsung","Samsung copies");
    SamsungThread.start();
  }
}
