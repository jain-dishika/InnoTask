
class ABC{
    int x  = 30;
}
public class shallow {
    public static void main(String argvs[]){  
        ABC obj1 = new ABC();  
        ABC obj2 = obj1;    
        obj2.x = 6;   
        System.out.println("The value of x is: " + obj1.x);  
    }  
}
