// 
public class Main{
    public static void main(String[] args) {
        System.out.println("This is the main method with String[] args.");
        main(5);
    }
    // Overloaded main method with a different parameter
    public static void main(int number) {
        System.out.println("This is the overloaded main method with int parameter.");
    }
}
