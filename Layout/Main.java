package layout;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class Main extends Application{
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	@Override
	public void init()
	{
		try
		{
			String driver = "oracle.jdbc.driver.OracleDriver";;
			String jdbc_url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String pwd = "dickfuck#1";
			Class.forName(driver);
			con = DriverManager.getConnection(jdbc_url,user,pwd);
			stmt = con.createStatement();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception{
		primaryStage.setTitle("LAYOUT ");
		Label l1 = new Label("Name");
		Label l2 = new Label("Roll no.");
		Label l3 = new Label("Student Type");
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		Button b1 = new Button("Insert");
		Button b2 = new Button("Reset");
		EventHandler<MouseEvent> event_1= new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent e)
				{
					System.out.println("inserted");
					String sql = "insert into layout values('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"')";
					System.out.println(sql);
					try
					{
						stmt = con.createStatement();
						stmt.executeUpdate(sql);
						rs = stmt.executeQuery("select * from layout");
						while(rs.next())
						{
							String n = rs.getString("name");
							String r = rs.getString("roll");
							String t = rs.getString("type");
							System.out.println(n+" "+r+" "+t);
						}
						
					}
					catch(Exception ex)
					{
						System.out.println(ex);
					}
					
					
				}
			};
		EventHandler<MouseEvent> event_2= new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent e)
				{
					System.out.println("reset");
					tf1.setText("");
					tf2.setText("");
					tf3.setText("");
				}
			};
		b1.addEventFilter(MouseEvent.MOUSE_CLICKED, event_1); 
		b2.addEventFilter(MouseEvent.MOUSE_CLICKED, event_2);
		
		GridPane root = new GridPane();
		root.addRow(0, l1, tf1);
		root.addRow(1, l2, tf2);
		root.addRow(2, l3, tf3);
		root.addRow(3, b1, b2);
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	@Override
	public void stop() throws Exception
	{
		rs.close();
		stmt.close();
		con.close();
	}
	public static void main(String[] args) {
		launch(args);

	}

}
