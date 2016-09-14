
interface AppleInterface {
    default void doiPhone() {
      System.out.println("iPhone");
    }
}

interface BadSamsung {
    default void doiPhone(String s) {
      System.out.println(s);
    }
}

class multinh implements AppleInterface,BadSamsung {
  public static void main(String[] args) {
    multinh m1 = new multinh();
    m1.doiPhone(); // default method called
    m1.doiPhone("We always copy the latest iPhone - Samsung"); // Will call BadSamsung with string param
  }
}
