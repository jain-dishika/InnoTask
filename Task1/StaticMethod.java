class Student{  
    int rollno;  
    String name;  
    static String college = "ITS";  

    static void change(){  
        college = "BBDIT";  
    }  

    Student(int r, String n){  
        rollno = r;  
        name = n;  
    }  
    void display(){
        System.out.println(rollno+" "+name+" "+college);
    }  
}  

public class StaticMethod {
    public static void main(String[] args) {
        Student S = new Student(19, "Dishika");
        // S.change();
        S.display();
    }
}
