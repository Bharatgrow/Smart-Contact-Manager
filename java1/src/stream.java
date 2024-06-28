/*import java.util.*;
import java.util.stream.Collectors;

class product{
    int id,price;
    String name;
    public product(int id ,String name,int price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
 class stream {
    public static void main(String[]args){
        List<product>al=new ArrayList<product>();
        al.add(new product(1,"envy",250));
        al.add(new product(5,"paris",658));
        al.add(new product(3,"wildstone",2780));
        List<Integer> any= al.stream()
                .filter(p->p.price>500)
                .map(p->p.price)
                .collect(Collectors.toList());
        System.out.println(any);



    }
}*/

/*import java.util.stream.*;
class JavaStreamExample {
    public static void main(String[] args){
        Stream.iterate(1, element->element+1)
                .filter(element->element%5==0)
                .limit(5)
                .forEach(System.out::println);
    }
}*/
/*interface anyone{
    default void me(){
        System.out.println("just");
    }
    void him(String str);
}
 class stream implements anyone{
    public void him(String str){
        System.out.println(str);
    }

     public static void main(String[] args) {
         stream s=new stream();
         s.him("I");
         s.me();
     }

}*/
import java.util.*;
import java.util.stream.Collectors;

class anyone{
    int id,price;
    String name;
    public anyone(int id,String name,int price){
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
public class stream{
    public static void main(String[] args) {
        List<anyone>al=new ArrayList<>();
        al.add(new anyone(1,"mayank",600));
        al.add(new anyone(5,"stayam",700));
        al.add(new anyone(3,"divyamsh",500));
        List<Integer>li=al.stream()
                .map(p-> p.price)
                .collect(Collectors.toList());
        System.out.println(li);
    }

}
