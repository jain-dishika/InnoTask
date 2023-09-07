public class OverLoading {
    OverLoading(){
        System.out.println("HELLO THERE");
    }
    OverLoading(int x, String b){
        System.out.println(x + " upto " + b);
    }
    public static void main(String[] args) {
        OverLoading over = new OverLoading(100, "GO THERE");
        // over.display();
        // over.display(1000, "LOVE YOU");
    }
}
