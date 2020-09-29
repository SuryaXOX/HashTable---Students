// --== CS400 File Header Information ==--
// Name: Surya Santhan Thenarasu 
// Email: thenarasu@wisc.edu
// Team: BG
// Role: Test Engineer
// TA: Brianna Cochran
// Lecturer: Florian Heimerl
// Notes to Grader: <optional extra notes>
//test file
import java.util.NoSuchElementException;
import java.util.Scanner;
public class StudentTestCode {
//Student s = new Student("Amy", 5, true, "948255356");
//s.getStudentTable();
//studentTable.put("ammu", s);
//   
 
  //StoreStudents.setUpClass();
   
   public static boolean testaddmoney() {
  
    Student s = null;
    s = Student.getStudent("15");
    s.addMoney(2);
    if(s.getBalance()!=12.7)
    {
      System.out.print("Test failed");
    
        return false;
    }
    
   s = Student.getStudent("16");
    s.addMoney(2);
    if(s.getBalance()!=13.13)
    {
      System.out.print("Test failed");
    
        return false;
    }
    
    s = Student.getStudent("17");
    s.addMoney(2);
    if(s.getBalance()!=9.03)
    { System.out.print("Test failed");
        return false;
    }
    s = Student.getStudent("40");
    s.addMoney(2);
    if(s.getBalance()!=5.31)
    { System.out.print("Test failed");
        return false;
    }
    s = Student.getStudent("84");
    s.addMoney(2);
    if(s.getBalance()!=13.8)
    { System.out.print("Test failed");
        return false;
    }
    
        System.out.print("Test passed");
        return true;
  }
    
    
  
  
  
public static boolean testdeductmoney() {
    
  Student s = null;
  s = Student.getStudent("21");
  s.deductMoney(2);
  if(s.getBalance()!=6.49)
    {
    System.out.print("Test failed");
      return false;
    }
  
 s = Student.getStudent("32");
 s.deductMoney(2);
  if(s.getBalance()!=5.53)
  {
    System.out.print("Test failed");
  
      return false;
  }
  s = Student.getStudent("56");
  s.deductMoney(2);
  if(s.getBalance()!=0.07)
  {
    System.out.print("Test failed");
      return false;
  }
  s = Student.getStudent("71");
  s.deductMoney(2);
  if(s.getBalance()!=6.93)
   
    {
    System.out.print("Test failed");
    
      return false;
    }
  s = Student.getStudent("98");
  s.deductMoney(2);
  if(s.getBalance()!=4.5)
  {
    System.out.print("Test failed");
      return false;
  }   
      
      System.out.print("Test passed");
  return true;
  }
  
  
  
public static boolean testgetStudent() {
  
Student s = null;
  try {
    s = Student.getStudent("12");
  }catch(java.util.NoSuchElementException e) {
    System.out.println("Can't find student with that ID, please re-try: ");
    System.out.print("Test failed");//student not in table
    return false;
  }
  System.out.print("Test passed");
  return true;
  

}
  
public static boolean testdoIdPrompt() {

  //You have to pass in a Scanner obj with the String of the id as input
  Scanner scnr = new Scanner(System.in);
  
   FrontEnd f = new FrontEnd();
     int idlength= Integer.parseInt(f.doIdPrompt(scnr));
     if(idlength!=9)
     { System.out.print("Test failed");
       return false; 
     }
       System.out.print("Test passed");
 return true;

}


  
  public static void runTests() {

    System.out.println("   Add money test: " + testaddmoney());
    System.out.println("   Deduct money test: " + testdeductmoney());
    System.out.println("   Get student test: " + testgetStudent());
    System.out.println("   Get student with ID test: " + testdoIdPrompt());

}

}
