import java.util.*;
class bharat{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String bh=sc.next();
        System.out.println("String 1: "+bh);

        Scanner sc1=new Scanner(System.in);
        String bh1=sc1.next();
        System.out.println("String 2: "+bh1);
        String str3=bh+bh1;


         if (bh.length()<bh1.length()) {

            System.out.println(bh+""+bh1.substring(bh1.length()-bh.length()));

        }
        else if (bh.length()>bh1.length()){
             System.out.println(bh.substring(bh.length()-bh1.length())+""+bh1);
        }
        else
             System.out.println(str3);




    }
}
