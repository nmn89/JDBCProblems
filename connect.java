import java.sql.*;
import java.util.*;
public class connect {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/employees";
        String user="root";
        String password="Naman@code22";
        TreeMap<String,Integer> table = new TreeMap<String,Integer>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con=DriverManager.getConnection(url, user, password); 
            Statement st=con.createStatement(); 
            ResultSet rs=st.executeQuery("Select e.dept_no,sum(salary) from salaries s INNER JOIN dept_emp e" +
                 " ON e.emp_no=s.emp_no INNER JOIN dept_manager m ON m.emp_no = s.emp_no group by m.dept_no");
            while(rs.next()){ 
                String id = rs.getString(1);
                int sal = rs.getInt(2);
                table.put(id,sal);
            }
            for(Map.Entry<String,Integer> a : table.entrySet()){
                System.out.println(a.getKey()+" "+a.getValue());
            }
            con.close(); 
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}