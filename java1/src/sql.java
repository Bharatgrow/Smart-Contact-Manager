import java.sql.*;
import java.util.*;
public class sql {
    public static void main(String[] args) {
        try {


            String url="jdbc:mysql://localhost:3306/new";
            String username="root";
            String password="Drc@1234";
            Connection con=DriverManager.getConnection(url,username,password);


           // String query="insert into student(sid,sname,sage) values(?,?,?)";
         /*   String query="update student set sname=? where sid=?";

            PreparedStatement pstmt=con.prepareStatement(query);
            
            Scanner br=new Scanner(System.in);
            /*System.out.println("enter id");
            int id=br.nextInt();
            System.out.println("enter name");
           String s=br.next();
            System.out.println("enter age");
            int age=br.nextInt();


            System.out.println("enter name");
            String s=br.next();


            System.out.println("enter id");
            int id=Integer.parseInt(br.next());
            PreparedStatement pstmt=con.prepareStatement(query);


            pstmt.setString(1,s);

            pstmt.setInt(2,id);


            pstmt.executeUpdate();*/

          String query="select sname from student where sid=2";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()){

                String name=rs.getString("sname");

                System.out.println("name: "+name+"age: ");
            }



        }
        catch (Exception e){
            System.out.println(e);

        }
    }
}
