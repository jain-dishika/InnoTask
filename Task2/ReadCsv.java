package Task2;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.*;
import java.util.Optional;
import java.util.Comparator;

class Student{
    int id;
    int class_id;
    int marks;
    int age;
    String name;
    String gender;
    Student(){}
    Student(int id, String name, int class_id, int marks, String gender, int age){
        this.id = id;
        this.name = name;
        this.class_id = class_id;
        this.marks = marks;
        this.gender = gender;
        this.age = age;
    }
    public String toString(){
        return "id : "+ id + " name : " + name + " class_id : " + class_id + " marks : " +  marks + " gender : " +  gender + " age : " +  age; 
    }
    int getMarks(){
        return marks;
    }
    int getClassId(){
        return class_id;
    }
    int getId(){
        return id;
    }
    String getGender(){
        return gender;
    }
    String getName(){
        return name;
    }
    void number(List<Student> list2){
        list2.stream().filter(x->x.marks < 50).collect(Collectors.toList()).forEach(y->System.out.println(y.name + " have been failed with the marks " + y.marks));
        List<Student> pass = list2.stream().filter(x->x.marks >= 50).collect(Collectors.toList());

        Optional<Student> first = pass.stream().max((e1, e2) -> Integer.compare(e1.getMarks(), e2.getMarks()));

        if (first.isPresent()) {
            Student achiever = first.get();
            System.out.println("First achiever : " + achiever.getName() + " With " + achiever.getMarks() + " marks");
        } else {
            System.out.println("No Achiever");
        }

        Optional<Student> thirdAchiever = list2.stream().distinct().sorted(Comparator.comparing(Student::getMarks).reversed()).skip(2).findFirst(); // Get the first (i.e., third highest)
        
        if (thirdAchiever.isPresent()) {
            Student thirdHighest = thirdAchiever.get();
            System.out.println("Third highest achiever: " + thirdHighest.getName() + " with " + thirdHighest.getMarks() + " marks.");
        } else {
            System.out.println("No third highest achiever found.");
        }
    }
    void passDisplay(List<Student> list1){
        list1.stream().filter(x->x.age>20).collect(Collectors.toList()).forEach(y->System.out.println(y.name));
    }

}
class Address{
    int id;
    int pinCode;
    int student_id;
    String city;
    public String toString(){
        return "id : "+ id + " pincode : " + pinCode + " student_id : " + student_id + " city : " +  city; 
    }
    int getStudentId(){
        return student_id;
    }
    int getPinCode(){
        return pinCode;
    }
    String getCity(){
        return city;
    }
    Address(){}
    Address(int id, int pinCode, String city, int student_id){
        this.id = id;
        this.pinCode = pinCode;
        this.city = city;
        this.student_id = student_id;
    }
    void pinDisplay(List<Address> list2){
        list2.stream().filter(x->x.pinCode == 482002 && x.city.equals("indore")).collect(Collectors.toList()).forEach(y->System.out.println(y));
    }
    void cityDisplay(List<Address> list2){
        list2.stream().filter(x->x.id == 1 && x.city.equals("indore")).collect(Collectors.toList()).forEach(y->System.out.println(y));
    }
}
class ClassSystem{
    ClassSystem(){}
    int id;
    String name;
    int getId(){
        return id;
    } 
    String getName(){
        return name;
    }  
    public String toString(){
        return "id : "+ id + " name : " + name; 
    } 
    ClassSystem(int id, String name){
        this.id = id;
        this.name = name;
    }
}
public class ReadCsv {
    public static void main(String[] args) throws Exception{
        List<Student> list1 = new ArrayList<Student>();
        Student stud = new Student();

        List<Address> list2 = new ArrayList<Address>();
        // Address add = new Address();

        List<ClassSystem> list3 = new ArrayList<ClassSystem>();
        // ClassSystem smCLass = new ClassSystem();

        Scanner st = new Scanner(new File("D:\\JAVA\\CSV\\Student.csv"));  
        Scanner ad = new Scanner(new File("D:\\JAVA\\CSV\\Address.csv"));  
        Scanner cls = new Scanner(new File("D:\\JAVA\\CSV\\Class.csv"));  
   
        while (st.hasNext()){
            // System.out.println(st.next()); 
            String  [] kids = st.nextLine().split(",") ; 
            list1.add(new Student(Integer.parseInt(kids[0]), kids[1], Integer.parseInt(kids[2]), Integer.parseInt(kids[3]), kids[4], Integer.parseInt(kids[5])));
        }   
        st.close();
        // stud.passDisplay(list1);
        // stud.number(list1);

        while (ad.hasNext()){ 
            String [] place = ad.nextLine().split(",") ; 
            list2.add(new Address(Integer.parseInt(place[0]), Integer.parseInt(place[1]), place[2], Integer.parseInt(place[3])));
            // System.out.println(ad.next()); 
        }  
        ad.close(); 
        // add.pinDisplay(list2);
        // add.cityDisplay(list2);

        while (cls.hasNext()){
            String  [] Class = cls.nextLine().split(",") ; 
            list3.add(new ClassSystem(Integer.parseInt(Class[0]), Class[1]));
            // System.out.println(cls.next()); 
        }
        cls.close();   

        // pincode(list1, list2, 482002);
        // cityFilter(list1, list2, "indore");
        // passStudents(list1, list2);
        // failStudents(list1, list2);
        // classA(list1, list3);
        // remove(list1, list2, 5);
        female1to9(list1);
    }
    static void pincode(List<Student> list1, List<Address> list2, int pin_Code){
        List<Student> newPin = list1.stream().filter(s-> list2.stream().anyMatch(a->a.getStudentId()==s.getId() && a.getPinCode()==pin_Code)).collect(Collectors.toList());
        newPin.forEach(y->System.out.println(y.name));
    }

    static void cityFilter(List<Student> list1, List<Address> list2, String city){
        List<Student> newCity = list1.stream().filter(s-> list2.stream().anyMatch(a->a.getStudentId()==s.getId() && a.getCity().equals(city) && s.gender.equals("F"))).collect(Collectors.toList());
        newCity.forEach(y->System.out.println(y.name));
    }

    static void passStudents(List<Student> list1, List<Address> list2){
        List<Student> newCity = list1.stream().filter(s-> list2.stream().anyMatch(a->a.getStudentId()==s.getId() && s.getMarks() >= 50 && a.city.equals("indore"))).collect(Collectors.toList());
        newCity.forEach(y->System.out.println(y.name));
    }

    static void failStudents(List<Student> list1, List<Address> list2){
        List<Student> newCity = list1.stream().filter(s-> list2.stream().anyMatch(a->a.getStudentId()==s.getId() && s.getMarks() < 50 && a.pinCode==452002)).collect(Collectors.toList());
        newCity.forEach(y->System.out.println(y.name));
    }
    static void classA(List<Student> list1, List<ClassSystem> list3){
        Map<String, Integer> classBased = list3.stream().collect(Collectors.toMap(ClassSystem::getName, ClassSystem::getId));
        System.out.println(classBased);
        Integer val = classBased.get("A");
        // System.out.println(val);
        List<Student> newStud = list1.stream().filter(s-> s.class_id==val).collect(Collectors.toList());
        newStud.forEach(y->System.out.println(y.name));
    }
    static void remove(List<Student> list1, List<Address> list2, int removeId){
        list1.removeIf(x->x.getId() == removeId);
        list2.removeIf(x->x.getStudentId() == removeId);
        System.out.println(list1);
        // System.out.println(list2);
    }
    static void female1to9(List<Student> list1){
        list1.stream().filter(student -> student.getGender().equalsIgnoreCase("F")).limit(4).collect(Collectors.toList()).forEach(y->System.out.println(y));
    }

}

