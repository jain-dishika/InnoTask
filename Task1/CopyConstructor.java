public class CopyConstructor {
    int a;
    String b;
    CopyConstructor(int d){
        a = d;
        b = "Dishika";
    }
    CopyConstructor(CopyConstructor x){
        a = x.a;
        b = x.b;
    }
    public static void main(String[] args) {
        CopyConstructor cc = new CopyConstructor(8);
        CopyConstructor cc2 = new CopyConstructor(cc);
        System.out.println(cc2.a + " " + cc2.b);

    }
}
