package com.onlineinteract.pairbot.notes.utility;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import com.onlineinteract.pairbot.notes.dto.MonitorDimensions;

public class MonitorUtility {
	
	public static MonitorDimensions getPrimaryMonitorDimensions() {
		GraphicsEnvironment g = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = g.getScreenDevices();
		System.out.println("Primary monitor resolution is:");
		System.out.println("Width:" + devices[0].getDisplayMode().getWidth());
		System.out.println("Height:" + devices[0].getDisplayMode().getHeight());
		System.out.println();

		MonitorDimensions monitorDimensions = new MonitorDimensions();
		monitorDimensions.setHeight(devices[0].getDisplayMode().getHeight());
		monitorDimensions.setWidth(devices[0].getDisplayMode().getWidth());

		return monitorDimensions;
	}
	
	@SuppressWarnings("unused")
	private static void getScreenResolutions() {
		GraphicsEnvironment g = GraphicsEnvironment
				.getLocalGraphicsEnvironment();
		GraphicsDevice[] devices = g.getScreenDevices();

		System.out.println("Number of devices = " + devices.length);

		for (int i = 0; i < devices.length; i++) {
			System.out.println("Device " + i + ":");
			System.out.println("Width:"
					+ devices[i].getDisplayMode().getWidth());
			System.out.println("Height:"
					+ devices[i].getDisplayMode().getHeight());
			System.out.println();
		}
	}
}
