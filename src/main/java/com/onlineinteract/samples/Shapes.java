package com.onlineinteract.samples;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.LinearGradientBuilder;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.RadialGradientBuilder;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineBuilder;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.RectangleBuilder;
import javafx.stage.Stage;

public class Shapes extends Application{
	
	public static void main(String args[]) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		primaryStage.setTitle("Shapes");
		Group root = new Group();
		Scene scene = new Scene(root, 550, 500, Color.WHITE);
		
		Ellipse ellipse = new Ellipse(100, 50 + 70/2, 50, 70/2);
		RadialGradient gradient1 = RadialGradientBuilder.create()
		.focusAngle(0)
		.focusDistance(.1)
		.centerX(80)
		.centerY(45)
		.radius(120)
		.proportional(false)
		.cycleMethod(CycleMethod.NO_CYCLE)
		.stops(new Stop(0, Color.RED), new Stop(1, Color.BLACK))
		.build();
		ellipse.setFill(gradient1);
		root.getChildren().add(ellipse);
		
		Line blackLine = LineBuilder.create()
				.startX(170)
				.startY(30)
				.endX(20)
				.endY(140)
				.fill(Color.BLACK)
				.strokeWidth(10.0f)
				.translateY(ellipse.prefHeight(-1) + ellipse.getLayoutY() + 10)
				.build();
		root.getChildren().add(blackLine);

		Rectangle rectangle = RectangleBuilder.create()
				.x(50)
				.y(50)
				.width(100)
				.height(70)
				.translateY(ellipse.prefHeight(-1) + ellipse.getLayoutY() + 10)
				.build();
		
		LinearGradient linearGrad = LinearGradientBuilder.create()
				.startX(50)
				.startY(50)
				.endX(50)
				.endY(50 + rectangle.prefHeight(-1) + 25)
				.proportional(false)
				.cycleMethod(CycleMethod.NO_CYCLE)
				.stops( new Stop(0.1f, Color.rgb(255, 200, 0, .784)),
				new Stop(1.0f, Color.rgb(0, 0, 0, .784)))
				.build();
		rectangle.setFill(linearGrad);
		root.getChildren().add(rectangle);
		
		Rectangle roundRect = RectangleBuilder.create()
				.x(50)
				.y(50)
				.width(100)
				.height(70)
				.arcWidth(20)
				.arcHeight(20)
				.translateY(ellipse.prefHeight(-1) +
				ellipse.getLayoutY() +
				10 +
				rectangle.prefHeight(-1) +
				rectangle.getLayoutY() + 10)
				.build();
				LinearGradient cycleGrad = LinearGradientBuilder.create()
				.startX(50)
				.startY(50)
				.endX(70)
				.endY(70)
				.proportional(false)
				.cycleMethod(CycleMethod.REFLECT)
				.stops(new Stop(0f, Color.rgb(0, 255, 0, .784)),
				new Stop(1.0f, Color.rgb(0, 0, 0, .784)))
				.build();
				roundRect.setFill(cycleGrad);
				root.getChildren().add(roundRect);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
