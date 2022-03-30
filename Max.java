import java.sql.*;
public class Max {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/employees";
        String user="root";
        String password="Naman@code22";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con=DriverManager.getConnection(url, user, password); 
            Statement st=con.createStatement(); 
            ResultSet rs=st.executeQuery("Select dept_no,max(salary) from dept_emp,salaries" + 
                                    " where dept_emp.emp_no = salaries.emp_no group by dept_no");
            while(rs.next()){ 
                System.out.println("Department_no: "+ rs.getString(1)+" Max_Salary: "+ rs.getInt(2));
            }
            con.close(); 
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
