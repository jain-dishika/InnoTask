package Task2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.*;

class Employee{
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;
    public String toString(){
        return "id : "+ id + " name : " + name + " age : " + age + " gender : " +  gender + " department : " + department + " yearOfJoining : " + yearOfJoining + " salary : " + salary;
    }
    int getAge(){
        return age;
    }
    int getId(){
        return id;
    }
    int getYearOfJoining(){
        return yearOfJoining;
    }
    String getGender(){
        return gender;
    } 
    String getName(){
        return name;
    } 
    String getDepartment(){
        return department;
    } 
    double getSalary(){
        return salary;
    }
    Employee(){}
    Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary){
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }
    void noOfEmployee(List<Employee> list){
        long male = list.stream().filter(x->x.gender=="Male").collect(Collectors.toList()).size();
        long female = list.stream().filter(x->(x.gender).equals("Female")).collect(Collectors.toList()).size();
        
        System.out.println("Total number of males" + " " + male);
        System.out.println("Total number of females" + " " + female);
    }
    void alldepartment(List<Employee> list){
        list.stream().map(x->x.department).collect(Collectors.toList()).forEach(y->System.out.println(y));
    }
    void average(List<Employee> list){
        double male = list.stream().filter(x->x.gender=="Male").mapToInt(Employee::getAge).average().orElse(0.0);
        double female = list.stream().filter(x->x.gender=="Female").mapToInt(Employee::getAge).average().orElse(0.0);

        System.out.println("Average of males" + " " + male);
        System.out.println("Average of females" + " " + female);
    }
    void Max(List<Employee> list){
        double male = list.stream().mapToDouble(Employee::getSalary).max().orElse(0.0);
        System.out.println("Highest Paid Salary" + " " + male);
    }
    void joiningYear(List<Employee> list){
        list.stream().filter(x->x.yearOfJoining > 2015).collect(Collectors.toList()).forEach(y->System.out.println(y.name));
    }
    void departmentCount(List<Employee> list){
        Map<String, Long> departmentCounts = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        departmentCounts.forEach((department, count) -> {
            System.out.println("Department: " + department + ", Count: " + count);
        });
    }
    void avgSalaryDepartment(List<Employee> list){
        Map<String, Double> departmentAverageSalaries = list.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        departmentAverageSalaries.forEach((department, count) -> {
            System.out.println("Department: " + department + ", Average Salary: " + count);
        });
    }
    void yougestEmployee(List<Employee> list){
        Optional<Employee> youngestMaleInProductDev  = list.stream().filter(x->x.department=="Product Development" && x.gender=="Male").min((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
        // double female = list.stream().filter(x->x.gender=="Female").mapToInt(Employee::getAge).average().orElse(0.0);

        if (youngestMaleInProductDev.isPresent()) {
            Employee youngestEmployee = youngestMaleInProductDev.get();
            System.out.println("Youngest Male Employee in Product Development:");
            System.out.println("Name: " + youngestEmployee.getName());
            System.out.println("Department: " + youngestEmployee.getDepartment());
            System.out.println("Gender: " + youngestEmployee.getGender());
            System.out.println("Age: " + youngestEmployee.getAge());
        } else {
            System.out.println("No youngest male employee found in the Product Development department.");
        }
    }
    void genderNumber(List<Employee> list){
        Map<String, Long> counter= list.stream().filter(x-> x.department == "Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
         counter.forEach((gender, count) -> {
            System.out.println("Gender : " + gender + ", Count: " + count);
        });
    }
    void avgGenderSalary(List<Employee> list){
        double male = list.stream().filter(x->x.gender=="Male").mapToDouble(Employee::getSalary).average().orElse(0.0);
        double female = list.stream().filter(x->x.gender=="Female").mapToDouble(Employee::getSalary).average().orElse(0.0);

        System.out.println("Average Salary of males" + " " + male);
        System.out.println("Average Salary of females" + " " + female);
    }
    void avgSalary(List<Employee> list){
        double sal = list.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
        double Total = list.stream().mapToDouble(Employee::getSalary).sum();
        System.out.println("Average Salary of Organisation" + " " + sal);
        System.out.println("Total Salary of Organisation" + " " + Total);
    }
    void seprateEmployee(List<Employee> list){
        List<Employee> Young  =  list.stream().filter(x->x.age <=25).collect(Collectors.toList());
        List<Employee> Old  = list.stream().filter(x->x.age > 25).collect(Collectors.toList());
        System.out.println("Young Employees are : ");
        Young.forEach(y->System.out.println(y));
        System.out.println("Old Employees are : ");
        Old.forEach(y->System.out.println(y));
    }
    void OldestEmployee(List<Employee> list){
        Optional<Employee> OldEmployee  = list.stream().max((e1, e2) -> Integer.compare(e1.getAge(), e2.getAge()));
         if (OldEmployee.isPresent()) {
            Employee OlderEmployee = OldEmployee.get();
            System.out.println(OlderEmployee.name + " is the Oldest Employee in the organisation");
            System.out.println("His age is : " + OlderEmployee.age);
            System.out.println("He belongs to : " + OlderEmployee.department + " department");
        }
    }
    void employeeWrtDepartment(List<Employee> list){
        Map<String, List<String>> employeeName = list.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.mapping(Employee::getName, Collectors.toList())));
        employeeName.forEach((department, names)->{
            System.out.println("In Department " + department + " there are following employees");
            names.forEach(x->System.out.println(x));
        });
    }
}
public class Dbms{
    public static void main(String[] args){
        Employee em = new Employee();
        List<Employee> list=new ArrayList<Employee>(); 
        list.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        list.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        list.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        list.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        list.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        list.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        list.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        list.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        list.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        list.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        list.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        list.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        list.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        list.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        list.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        list.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        list.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        // em.noOfEmployee(list);
        // em.alldepartment(list);
        // em.average(list);
        // em.Max(list);
        // em.joiningYear(list);
        // em.departmentCount(list);
        // em.avgSalaryDepartment(list);
        // em.yougestEmployee(list);
        // em.genderNumber(list);
        // em.avgGenderSalary(list);
        // em.avgSalary(list);
        // em.seprateEmployee(list);
        // em.OldestEmployee(list);
        em.employeeWrtDepartment(list);
        
    }
}