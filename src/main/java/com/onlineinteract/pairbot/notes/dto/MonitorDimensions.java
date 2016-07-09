package com.onlineinteract.pairbot.notes.dto;

public class MonitorDimensions {

	private int height;
	private int width;
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	
	public void reduceResolutionBy(int noOfPixels) {
		setWidth(this.width - noOfPixels);
		setHeight(this.height - noOfPixels);
	}
	
	public void printDimensions() {
		System.out.println("Monitor dimensions are:");
		System.out.println("Width:" + getWidth());
		System.out.println("Height:" + getHeight());
		System.out.println();
	}
}
