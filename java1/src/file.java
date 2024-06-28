/*import java.io.*;
public class file {
    public static void main(String[] args) {
        File file=new File("first file.txt");
        boolean result;
        try{
            result=file.createNewFile();
            if(result){
                System.out.println("file created"+file.getPath());

            }
            else
                System.out.println("not created");
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
    }
}*/
/*import java.util.*;
import java.io.*;
public class file {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("eneter file name: ");
            String name = sc.nextLine();

            FileOutputStream fos=new FileOutputStream(name,true);
            System.out.println("enter file content:");
            String str=sc.nextLine()+"\n";
            byte[]b=str.getBytes();
            fos.write(b);
            fos.close();
            System.out.println("file saved");

        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}*/
/*import java.io.FileReader;
class FileReaderExample {
    public static void main(String args[])throws Exception{
        FileReader fr=new FileReader("testout");
        int i;
        while((i=fr.read())!=-1)
            System.out.print((char)i);
        fr.close();
    }
}*/
//file write

/*import java.io.*;
public class file {
    public static void main(String[] args) {
        try{
            FileWriter fw=new FileWriter("testout");
            fw.write("anything");
            fw.flush();
            fw.close();



        }
        catch (Exception e)
        {
            System.out.println("errror"+e);
        }
        System.out.println("success");
    }
}*/
//delete file

/*import java.io.*;
public class file {
    public static void main(String[] args) {
        try{
            File f=new File("testout");
          if(  f.delete()){


                System.out.println("succerss" + f.getName());
            }
          else
              System.out.println("fail");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }
}*/
/*import java.io.File;
import java.io.IOException;
class DeleteTextFileExample
{
    public static void main(String[] args)
    {
        try
        {
            File file = new File("F:\\newfile.txt");             //creates a file instance
            file.deleteOnExit();                 //deletes the file when JVM terminates
            System.out.println("Done");
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}*/
