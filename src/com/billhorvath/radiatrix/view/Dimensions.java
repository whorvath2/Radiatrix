package com.billhorvath.radiatrix.view;

/**
Provides the dimensions of various windows used in Radiatrix displays.
*/

public enum Dimensions{
	/**
		
	*/
	SMALL(750, 300, 0, 0, 0),
	MEDIUM(1000, 400, 0, 0, 0),
	LARGE(1300, 520, 0, 0, 0),
	CIRCLE(0, 0, 300, 300, 100);
	
	private final int width, height, x, y, radius;
	
	Dimensions(int width, int height, int x, int y, int radius){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		this.radius = radius;
	}
	/**
		
	*/
	public int width(){
		return width;
	}
	/**
		
	*/
	public int height(){
		return height;
	}
	/**
		
	*/
	public int x(){
		return x;
	}
	/**
		
	*/
	public int y(){
		return y;
	}
	/**
		
	*/
	public int radius(){
		return radius;
	}
}