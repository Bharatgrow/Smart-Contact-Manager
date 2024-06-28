/*interface method{
    void any();
}
class sa1{
    public static void jam(){
        System.out.println("anything");
    }

    public static void main(String[] args) {
        method m=sa1::jam;
        m.any();
    }
}*/
/*public class method {
    public static void jam(){
        System.out.println("anyone");
    }

    public static void main(String[] args) {
        Thread t1=new Thread(method::jam);
        t1.start();
    }
}*/
import java.util.*;
import java.util.function.BiFunction;

class any{
    Scanner sc=new Scanner(System.in);
    int a=sc.nextInt();
    Scanner sc1=new Scanner(System.in);
    int b=sc1.nextInt();
    public static int one(int a,int b){
        return a+b;
    }

}
public class method {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer>add= any::one;
        int result= add.apply(10,20);
        System.out.println(result);
    }
}