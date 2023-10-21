package question20;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.event.EventHandler;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}
	@Override
	public void start(Stage primaryStage){
		primaryStage.setTitle("SLOPE FINDING ");
		Label l1 = new Label("Enter Point-1 x1 coordinate: ");
		Label l2 = new Label("Enter Point-1 y1 coordinate: ");
		Label l3 = new Label("Enter Point-2 x2 coordinate: ");
		Label l4 = new Label("Enter Point-2 y2 coordinate: ");
		Label l5 = new Label("Slope: ");
		TextField tf1 = new TextField();
		TextField tf2 = new TextField();
		TextField tf3 = new TextField();
		TextField tf4 = new TextField();
		TextField tf5 = new TextField();
		Button b1 = new Button("Submit");
		EventHandler<MouseEvent> event_1= new EventHandler<MouseEvent>(){
				@Override
				public void handle(MouseEvent e)
				{
					double slope;
					double x1,x2,y1,y2;
					x1=Double.parseDouble(tf1.getText());
					y1=Double.parseDouble(tf2.getText());
					x2=Double.parseDouble(tf3.getText());
					y2=Double.parseDouble(tf4.getText());
					slope=(y2-y1)/(x2-x1);
					tf5.setText(Double.toString(slope));
				}
			};
		b1.addEventFilter(MouseEvent.MOUSE_CLICKED, event_1); 
		
		GridPane root = new GridPane();
		root.addRow(0, l1, tf1);
		root.addRow(1, l2, tf2);
		root.addRow(2, l3, tf3);
		root.addRow(3, l4, tf4);
		root.addRow(4, l5, tf5);
		root.addRow(5, b1);
		Scene scene = new Scene(root,400,400);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
