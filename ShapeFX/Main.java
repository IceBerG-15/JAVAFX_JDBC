package shapesfx;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.application.Application;
import javafx.scene.shape.*;
import javafx.scene.paint.Color;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		//line creation
		Line l = new Line();
		l.setStartX(100);
		l.setEndX(300);
		l.setStrokeWidth(10.0);
		//rectangle creation
		Rectangle r = new Rectangle();
		r.setX(100);
		r.setY(100);
		r.setWidth(100);
		r.setHeight(100);
		r.setFill(Color.rgb(150, 0, 255));
		//circle creation
		Circle c = new Circle();
		c.setCenterX(150);
		c.setRadius(50);
		c.setFill(Color.rgb(150, 0, 200));
		//arc creation
		Arc arc = new Arc();
		arc.setCenterX(300.0f); 
		arc.setCenterY(150.0f); 
		arc.setRadiusX(90.0f); 
		arc.setRadiusY(90.0f); 
		arc.setStartAngle(40.0f); 
		arc.setLength(239.0f); 
		arc.setType(ArcType.ROUND);
		arc.setFill(Color.rgb(150, 0, 240));
		//polygon creation
		Polygon hexagon = new Polygon();
		hexagon.getPoints().addAll(new Double[]{        
				   200.0, 50.0, 
				   400.0, 50.0, 
				   450.0, 150.0,          
				   400.0, 250.0, 
				   200.0, 250.0,                   
				   150.0, 150.0, 
				});
		hexagon.setFill(Color.rgb(150, 0, 220));
		GridPane root = new GridPane();
		root.addRow(0, l);
		root.addRow(1, r);
		root.addRow(2, c);
		root.addRow(3, arc);
		root.addRow(4, hexagon);
		Scene scene = new Scene(root,600,600);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
