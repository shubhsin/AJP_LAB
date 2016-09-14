package lab1;

public class Employee {
  int salary;
  String name;

  Employee(String n) {
    name = n;
    salary = 20000;
  }

  public void salaryChange(int amt) {
    if (amt >salary) {
      int change = amt - salary;
      System.out.println("Salary increased by "+change);
    }
    else {
      int change = salary - amt;
      System.out.println("Salary decreased by "+change);
    }
  }

  public void empQuit() {
    salary = 0;
  }

  public int getInfo() {
    return salary;
  }
}
