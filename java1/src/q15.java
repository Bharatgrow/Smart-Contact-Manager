import java.util.*;
public class q15 {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();

        String b=a.substring(4);
        System.out.println(b);

        Scanner sc1=new Scanner(System.in);
        String c=sc1.nextLine();

        String d=a.concat(b).concat(c);
        System.out.println(d);

        if(a.length()-c.length()<=1)
        {
            System.out.println(true);
        }
        else
            System.out.println(false);



    }
}
