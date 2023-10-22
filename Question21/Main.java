package question21;

import java.sql.*;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.event.EventHandler;

public class Main extends Application{
	Connection con;
	Statement stmt;
//	ResultSet rs;
	
	@Override
	public void init()
	{
		String driver = "oracle.jdbc.driver.OracleDriver";;
		String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = System.getenv("user");
		String pwd = System.getenv("password");
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(jdbc_url,user,pwd);
			stmt = con.createStatement();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	@Override
	public void start(Stage primaryStage)
	{
		primaryStage.setTitle("Industrial Visit ");
		GridPane root = new GridPane();
		Label l1 = new Label("Enter Registration number: ");
		Label l2 = new Label("Enter Name: ");
		Label l3 = new Label("Enter Contact Number: ");
		Label l4 = new Label("Enter Blood group: ");
		Label l5 = new Label("Enter Student type (hosteller/day-scholer): ");
		Label l6 = new Label("Enter Willingness (yes/no): ");
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		TextField tf5 = new TextField();
		TextField tf6 = new TextField();
		Button b1 = new Button("Submit");
		Button b2 = new Button("Reset");
		EventHandler<MouseEvent> event_1= new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent e)
				{
					String reg_no = tf1.getText();
					String name = tf2.getText();
					long contact = Long.parseLong(tf3.getText());
					String blood_grp = tf4.getText();
					String student_type = tf5.getText();
					String willingness = tf6.getText();
					String sql = "insert into industrial_visit values('"+reg_no+"','"+name+"',"+contact+",'"+blood_grp+"','"+student_type+"','"+willingness+"')";
					// updating value in the database.
					try {
						stmt.executeUpdate(sql);
					}
					catch(Exception except) {
						System.out.println(except);
					}
					Label l7 = new Label("Record Entered!!");
					root.addRow(7, l7);
				}
			};
		EventHandler<MouseEvent> event_2= new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent e)
				{
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
					tf4.setText("");
					tf5.setText("");
					tf6.setText("");
					Label l7 = new Label("Reset Done!!");
					root.addRow(7, l7);
				}
			};
		b1.addEventFilter(MouseEvent.MOUSE_CLICKED, event_1); 
		b2.addEventFilter(MouseEvent.MOUSE_CLICKED, event_2); 
		
		
		root.addRow(0, l1, tf1);
		root.addRow(1, l2, tf2);
		root.addRow(2, l3, tf3);
		root.addRow(3, l4, tf4);
		root.addRow(4, l5, tf5);
		root.addRow(5, l6, tf6);
		root.addRow(6, b1, b2);
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void stop()
	{
		try {
//			rs.close();
			stmt.close();
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
