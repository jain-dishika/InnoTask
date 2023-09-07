class A{
    static void display(){
        System.out.println("Hello There I am Parent Class");
    }
}
class B extends A{
    static void display(){
        System.out.println("Hello There I am Clild Class");
    }
}
public class StaticOverriding {
    public static void main(String[] args) {
        A a = new B();
        a.display();
        // B b = new B();
        // b.display();
    }
}
