package com.onlineinteract.samples;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItemBuilder;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.RadioMenuItemBuilder;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Menus extends Application{
	
	public static void main(String args[]) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		
		// Start Code
		primaryStage.setTitle("Menus");
		Group root = new Group();
		Scene scene = new Scene(root, 300, 250, Color.WHITE);
		
		// GUI Code
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("File");
		menu.getItems().add(new MenuItem("New"));
		menu.getItems().add(new MenuItem("Save"));
		menu.getItems().add(new SeparatorMenuItem());
		menu.getItems().add(new MenuItem("Exit"));
		menuBar.getMenus().add(menu);
		
		Menu tools = new Menu("Cameras");
		tools.getItems().add(
				CheckMenuItemBuilder.create()
				.text("Show Camer 1")
				.selected(true)
				.build()
				);
		tools.getItems().add(
				CheckMenuItemBuilder.create()
				.text("Show Camer 2")
				.selected(true)
				.build()
				);
		menuBar.getMenus().add(tools);
		
		// Alarm
		Menu alarm = new Menu("Alarm");
		ToggleGroup tGroup = new ToggleGroup();
		RadioMenuItem soundAlarmItem = RadioMenuItemBuilder.create()
		.toggleGroup(tGroup)
		.text("Sound Alarm")
		.build();
		RadioMenuItem stopAlarmItem = RadioMenuItemBuilder.create()
		.toggleGroup(tGroup)
		.text("Alarm Off")
		.selected(true)
		.build();
		alarm.getItems().add(soundAlarmItem);
		alarm.getItems().add(stopAlarmItem);
		Menu contingencyPlans = new Menu("Contingent Plans");
		ToggleGroup tGroup2 = new ToggleGroup();
		contingencyPlans.getItems().add(RadioMenuItemBuilder.create().toggleGroup(tGroup2).text("Self Destruct in T minus 50").selected(true).build());
		contingencyPlans.getItems().add(RadioMenuItemBuilder.create().toggleGroup(tGroup2).text("Turn off the coffee machine").build());
		contingencyPlans.getItems().add(RadioMenuItemBuilder.create().toggleGroup(tGroup2).text("Run for your lives!").build());
		alarm.getItems().add(contingencyPlans);
		menuBar.getMenus().add(alarm);
		
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		root.getChildren().add(menuBar);
		
		// End Code
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
