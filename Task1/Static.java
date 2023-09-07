class Student{  
   int rollno;  
   String name;  
   static String college; 
   
    Student(int r, String n, String c){  
        rollno = r;  
        name = n;  
        college = c;
    }   
    void display (){
        System.out.println(rollno+" "+name+" "+college);
    }  
}  
public class Static {
    public static void main(String[] args) {
        Student s = new Student(19, "Dishika", "MEDI");
        Student s2 = new Student(20, "Eka", "IPS");
        s.display();
        s2.display();
    }
}
