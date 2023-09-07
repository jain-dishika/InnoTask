// public class Constructor {
//     int data;

//     // Constructor(char s){
//     //     System.out.println("Your Bike is love" + s);
//     // }
//     public static void main(String[] args) {
//         char s = 'y';
//         Constructor c1 = new Constructor();
//         System.out.println(c1.data + " " + s);
//     }
// }

public class Constructor {
    // Attributes (instance variables)
    String name;
    int age;

    // This class has no constructor defined explicitly.

    // Method to display information about the person
    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Creating an object of the Person class using the default constructor
        Constructor c1 = new Constructor();

        // Setting attributes using dot notation
        c1.name = "John";
        c1.age = 30;

        // Calling the displayInfo method to print the person's information
        c1.displayInfo();
    }
}
