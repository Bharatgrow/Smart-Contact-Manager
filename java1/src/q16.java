import  java.util.*;

public class q16 {
    public static void main(String[] args) {
        ArrayList<String> al=new ArrayList<>();
        al.add("bharat");
        al.add("mayank");
        al.add("divyansh");
        al.add("anuj");
        al.add("satyam");
        al.add("ram");

        Collections.sort(al,Comparator.comparingInt(String::length));
        System.out.println("Ascending: "+al);

        Collections.sort(al,Comparator.comparingInt(String::length).reversed());
        System.out.println("Descending: "+al);
    }
}
