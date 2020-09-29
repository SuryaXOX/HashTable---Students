import java.util.Scanner;

public class StartProgram {

  public static void main(String[] args) {
    System.out.println();
    if(!onStart()) {
      return;
    }
    Scanner scnr = new Scanner(System.in);
    getNewStudent(scnr);
  }
  
  public static boolean onStart() {
    System.out.println(" [Loading students from file]");
    try{
      StoreStudents.setUpClass();
    }catch(java.io.FileNotFoundException e) {
      System.out.println("Store Students Error");
      return false;
    }
    
    System.out.println("   Student data file loaded");
    
    System.out.println("   " + Student.getStudentTable().size() + " students in table");
    System.out.println();
    System.out.println(" [Running StudentTestCode.java]");
    
    
    //StudentTestCode.runTests();
    
    
    System.out.println("   Tests not set up yet");
    System.out.println();
    
    System.out.println(" [List of example IDs]");
    System.out.println("   908172309 - Andrew");
    System.out.println("   908170182 - Jackson");
    System.out.println("   908170182 - Mary");
    System.out.println();

//    try{
//      MakeStudents.doOnStartUp();
//    }catch(java.io.IOException e) {
//      System.out.println("Make Students Error");
//      return false;
//    }
    
    return true;
  }
  
  public static void onClose() {
    //maybe use this
  }

  public static void getNewStudent(Scanner scnr) {
    String id = null;
    Student stud = null;
    FrontEnd.tellIdPrompt();
    do {
      id = null;
      while (id == null) {
        id = FrontEnd.doIdPrompt(scnr);
      }
    } while ((stud = Student.getStudent(id)) == null);
    FrontEnd.doOptionsPrompt(scnr, stud);
  }

}
