package com.onlineinteract.samples;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Reflection;
import javafx.scene.paint.Color;
import javafx.scene.shape.CubicCurve;
import javafx.scene.shape.CubicCurveBuilder;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.EllipseBuilder;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.QuadCurveBuilder;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.Shape;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ChangingTextFonts extends Application{

	public static void main(String args[]) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("Chapter 1-4 Changing Text Fonts");
		Group root = new Group();
		Scene scene = new Scene(root, 550, 250, Color.WHITE);
		
		// Serif with drop shadow
		Text text2 = new Text(50, 50, "Hello my bb from JavaFX GUI Library :)");
		Font serif = Font.font("Serif", 30);
		text2.setFont(serif);
		text2.setFill(Color.RED);
		text2.setOpacity(.75f);
		DropShadow dropShadow = new DropShadow();
		dropShadow.setOffsetX(12.0f);
		dropShadow.setOffsetY(12.0f);
		dropShadow.setColor(Color.rgb(50, 50, 50, 1));
		text2.setEffect(dropShadow);
		root.getChildren().add(text2);
		
		// SanSerif
		Text text3 = new Text(50, 100, "JavaFX 2.0: Intro. by Example");
		Font sanSerif = Font.font("SanSerif", 30);
		text3.setFont(sanSerif);
		text3.setFill(Color.BLUE);
		root.getChildren().add(text3);
		
		// Dialog
		Text text4 = new Text(50, 150, "JavaFX 2.0: Intro. by Example");
		Font dialogFont = Font.font("Dialog", 30);
		text4.setFont(dialogFont);
		text4.setFill(Color.rgb(0, 255, 0));
		root.getChildren().add(text4);
		
		// Monospaced
		Text text5 = new Text(50, 200, "JavaFX 2.0: Intro. by Example");
		Font monoFont = Font.font("Monospaced", 30);
		text5.setFont(monoFont);
		text5.setFill(Color.BLACK);
		root.getChildren().add(text5);
		Reflection refl = new Reflection();
		refl.setFraction(0.8f);
		text5.setEffect(refl);
		
		// CubicCurve
		CubicCurve cubicCurve = CubicCurveBuilder.create()
		.startX(50).startY(75) // start pt (x1,y1)
		.controlX1(80).controlY1(-25) // control pt1
		.controlX2(110).controlY2(175) // control pt2
		.endX(140).endY(75) // end pt (x2,y2)
		.strokeType(StrokeType.CENTERED).strokeWidth(1)
		.stroke(Color.BLACK)
		.strokeWidth(3)
		.fill(Color.WHITE)
		.build();
		root.getChildren().add(cubicCurve);
		// Ice cream
		Path path = new Path();
		MoveTo moveTo = new MoveTo();
		moveTo.setX(50);
		moveTo.setY(150);
		
		QuadCurveTo quadCurveTo = new QuadCurveTo();
		quadCurveTo.setX(150);
		quadCurveTo.setY(150);
		quadCurveTo.setControlX(100);
		quadCurveTo.setControlY(50);
		LineTo lineTo1 = new LineTo();
		lineTo1.setX(50);
		lineTo1.setY(150);
		LineTo lineTo2 = new LineTo();
		lineTo2.setX(100);
		lineTo2.setY(275);
		LineTo lineTo3 = new LineTo();
		lineTo3.setX(150);
		lineTo3.setY(150);
		path.getElements().add(moveTo);
		path.getElements().add(quadCurveTo);
		path.getElements().add(lineTo1);
		path.getElements().add(lineTo2);
		path.getElements().add(lineTo3);
		path.setTranslateY(30);
		path.setStrokeWidth(3);
		path.setStroke(Color.BLACK);
		root.getChildren().add(path);
		
		// QuadCurve create a smile
		QuadCurve quad =QuadCurveBuilder.create()
		.startX(50)
		.startY(50)
		.endX(150)
		.endY(50)
		.controlX(125)
		.controlY(150)
		.translateY(path.getBoundsInParent().getMaxY())
		.strokeWidth(3)
		.stroke(Color.BLACK)
		.fill(Color.WHITE)
		.build();
		
		root.getChildren().add(quad);
		
		// outer donut
		Ellipse bigCircle = EllipseBuilder.create()
		.centerX(100)
		.centerY(100)
		.radiusX(50)
		.radiusY(75/2)
		.translateY(quad.getBoundsInParent().getMaxY())
		.strokeWidth(3)
		.stroke(Color.BLACK)
		.fill(Color.WHITE)
		.build();
		
		// donut hole
		Ellipse smallCircle = EllipseBuilder.create()
		.centerX(100)
		.centerY(100)
		.radiusX(35/2)
		.radiusY(25/2)
		.build();
		
		// make a donut
		Shape donut = Path.subtract(bigCircle, smallCircle);
		// orange glaze
		donut.setFill(Color.rgb(255, 200, 0));
		
		// add drop shadow
		DropShadow dropShadow2 = new DropShadow();
		dropShadow2.setOffsetX(2.0f);
		dropShadow2.setOffsetY(2.0f);
		dropShadow2.setColor(Color.rgb(50, 50, 50, .588));
		donut.setEffect(dropShadow2);
		
		// move slightly down
		// donut.setTranslateY(quad.getBoundsInParent().getMinY() + 30);
		
		root.getChildren().add(donut);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

}
