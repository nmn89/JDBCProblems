import java.sql.*;
public class title {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/employees";
        String user="root";
        String password="Naman@code22";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            Connection con=DriverManager.getConnection(url, user, password); 
            Statement st=con.createStatement(); 
            ResultSet rs=st.executeQuery("Select Title, AVG(Salary) from Titles, Salaries" +
                                         " where Titles.emp_no = Salaries.emp_no GROUP BY Title");
            while(rs.next()){ 
                System.out.println("Title: "+rs.getString(1)+" Average_Salary: "+rs.getInt(2));
            }
            con.close(); 
        } 
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
