package Task2;
import java.io.File;
import java.util.Scanner;

public class ReadCsv {
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(new File("D:\\codes\\JAVA\\CSV\\Student.csv"));  
        sc.useDelimiter(" , ");   
        while (sc.hasNext()){  
            System.out.print(sc.next()); 
        }   
        sc.close();
    }
}

