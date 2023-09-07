class A{
    void display(){
        System.out.println("HELLO MOTO");
    }
}
class B extends A{
    void display(){
        System.out.println("HELLO DISHI");
    }
}
public class Overriding {
    public static void main(String[] args) {
        A a = new A();
        // B b = new A();
        a.display();
    }
}
