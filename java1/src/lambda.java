//@FunctionalInterface

/*interface lambda{
    void say();
}
    class lambda1{
        public static void main(String[] args) {
            Sayable s=()->{
                System.out.println("anything");
            };
            s.say();

        }
    }

   */
/*interface lambda{
   public String s(String name);
}

 class LambdaExpressionExample4 {
    public static void main(String[] args) {

        // Lambda expression with single parameter.
        lambda s1 = (name) -> {
            return "hello"+name;
        };
        System.out.println(s1.s("bharat"));
    }
}*/
/*interface lambda{
    public int ab(int a,int b);

}
class tm{
    public static void main(String[] args) {
        lambda s1=( a, b)->(a+b);{
        System.out.println(s1.ab(10,20));};
    }
}*/
/*import java.util.*;
class lambda extends Thread{
    public static void main(String[] args) {
        ArrayList<String>al=new ArrayList<>();
        al.add("bharat");
        al.add("mayank");
        al.add("staym");
        al.add("divyansh");
        al.add("harsh");
        al.forEach((n)->{
            System.out.println(n);
        });


        }

    }*/
//@FunctionalInterface
/*interface lambda{
    public String ab(String name);
}
class any{
    public static void main(String[] args) {
        lambda s=(name)->{
            String str="any";
            String str1=str+name;
            return str1;


        };
        System.out.println(s.ab("thing"));
    }
}*/

/*public class lambda {
    public static void main(String[] args) {
        Runnable r2=()->{
            for (int i=0;i<5;i++){
            System.out.println("everything ok");
                }

        };
        Thread th=new Thread(r2);
        th.start();

    }
}*/
import java.util.*;
class sa{
    int id;
    String name;
    int price;
    public sa(int id,String name,int price){
        super();
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
public class lambda {
    public static void main(String[] args) {
        ArrayList<sa> al=new ArrayList<>();
        al.add(new sa(1,"java",80));
        al.add(new sa(3,"c++",70));
        al.add(new sa(2,"python",90));
        Collections.sort(al,(p1,p2)->{
            return p1.name.compareTo(p2.name);
        });
for(sa p:al){
    System.out.println(p.id+""+p.name+""+p.price);
}
    }
}

