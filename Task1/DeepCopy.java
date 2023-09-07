class ABC{
    int x  = 30;
}
public class DeepCopy {    
    public static void main(String argvs[]){  
        ABC obj1 = new ABC();  
        ABC obj2 = new ABC();    
        obj2.x = 6;   
        System.out.println("The value of x is: " + obj2.x + " " + obj1);  
    } 
}
