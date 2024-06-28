import java.util.*;
public class stringjoiner {
    public static void main(String[] args) {
        StringJoiner sj=new StringJoiner(",");
        sj.add("cp");
        sj.add("ab");
        sj.add("dc");
        sj.add("pc");
        System.out.println(sj);
    }
}
