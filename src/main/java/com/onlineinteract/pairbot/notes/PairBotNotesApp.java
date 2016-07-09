package com.onlineinteract.pairbot.notes;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import com.onlineinteract.pairbot.notes.dto.MonitorDimensions;
import com.onlineinteract.pairbot.notes.utility.MonitorUtility;

/**
 * 
 * @author Gary Black
 */
public class PairBotNotesApp extends Application {

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) {

		MonitorDimensions primaryMonitorDimensions = MonitorUtility
				.getPrimaryMonitorDimensions();
		primaryMonitorDimensions.reduceResolutionBy(100);
		primaryMonitorDimensions.printDimensions();

		primaryStage.setTitle("Hello World");
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setAlwaysOnTop(true);
		primaryStage.setWidth(primaryMonitorDimensions.getWidth());
		primaryStage.setHeight(primaryMonitorDimensions.getHeight());

		Group root = new Group();
		Scene scene = new Scene(root, primaryMonitorDimensions.getWidth(),
				primaryMonitorDimensions.getHeight());
		Button btn = new Button();
		btn.setLayoutX(100);
		btn.setLayoutY(80);
		btn.setText("Hello World");
		btn.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				System.out.println("Hello World");
			}
		});
		root.getChildren().add(btn);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}