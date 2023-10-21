package question18;
import java.util.Scanner;
import java.sql.*;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException,SQLException{
		// jdbc setup
		String driver = "oracle.jdbc.driver.OracleDriver";;
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = System.getenv("user");
		String pwd = System.getenv("password");
		Class.forName(driver);
		Connection con = DriverManager.getConnection(jdbc_url,user,pwd);
		Statement stmt = con.createStatement();
		Scanner sc = new Scanner(System.in);
		String reg_no;
		String name;
		long contact;
		String blood_grp;
		String student_type;
		String willingness;
		System.out.println("enter size- ");
		int size = sc.nextInt();
		sc.nextLine();
		for(int i=0;i<size;i++)
		{
			System.out.println("enter student "+(i+1)+" details-");
			// asking user for student data
			System.out.println("enter register number: ");
			reg_no = sc.nextLine();
			System.out.println("enter name: ");
			name = sc.nextLine();
			System.out.println("enter blood group: ");
			blood_grp = sc.nextLine();
			System.out.println("enter student-type(hosteller,day-scholer): ");
			student_type = sc.nextLine();
			System.out.println("enter willingness(yes,no): ");
			willingness = sc.nextLine();
			System.out.println("enter contact: ");
			contact = sc.nextLong();
			
			String sql = "insert into industrial_visit values('"+reg_no+"','"+name+"',"+contact+",'"+blood_grp+"','"+student_type+"','"+willingness+"')";
			// updating value in the database.
			stmt.executeUpdate(sql);  
		}
		// getting the student details from the database who are willing to go.
		ResultSet rs = stmt.executeQuery("select * from industrial_visit where willingness='yes'");
		System.out.println("Student details who are willing to go are: ");
		while(rs.next())
		{
			System.out.println(rs.getString("reg_no")+" "+rs.getString("name")+" "+rs.getLong("contact")+" "+rs.getString("blood_grp")+" "+rs.getString("student_type")+" "+rs.getString("willingness"));
		}
		
		// closing all the necessary things.
		rs.close();
		stmt.close();
		con.close();
		sc.close();
	}

}
