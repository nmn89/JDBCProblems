import java.util.*;
import java.sql.*;

public class LongServing {
    public static void main(String[] args) {
        try{
            TreeMap<Integer,String> table = new TreeMap<>();
            String url="jdbc:mysql://localhost:3306/employees";
            String user ="root";
            String password="Naman@code22";
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url, user, password);
            Statement st=con.createStatement();
            ResultSet rs =st.executeQuery("Select e.emp_no,t.title,DateDiff(e.to_date,e.from_date),DateDiff(t.to_date,t.from_date)"+
                                          " from dept_emp e, titles t where e.emp_no = t.emp_no;");
            while(rs.next()){
                String data = "Employee:"+rs.getInt(1)+" Title:"+rs.getString(2)+" Title_Duration:"+rs.getInt(4);
                table.put(rs.getInt(3),data);
            }                                   
            con.close();
            System.out.println(table.get(table.lastKey()));
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}