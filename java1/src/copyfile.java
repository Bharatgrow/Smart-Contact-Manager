/*import java.io.*;
import java.text.*;
public class copyfile {
    public static void main(String[] args) {
        File f1=new File("any");
        long time1=f1.lastModified();
        DateFormat df=new SimpleDateFormat();
        System.out.println("modified time is: "+df.format(time1));
    }
}*/
/*import java.io.*;
public class copyfile {
    public static void main(String[] args) {
        boolean one;
        try{
            File file=new File("one");
            one=file.setReadOnly();
            System.out.println("is file raead only"+one);

            one=file.canWrite();
            System.out.println("file write"+one);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}*/
import java.io.*;
public class copyfile {
    public static void main(String[] args)throws Exception{
        File f1=new File("any");
        if(f1.isHidden()){
            System.out.println("hidden");
        }
        else
            System.out.println("not hidden");

    }
}