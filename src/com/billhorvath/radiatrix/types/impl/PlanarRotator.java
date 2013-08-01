package com.billhorvath.radiatrix.types.impl;
//TODO: Refactor so that rotation isn't specified in getInstance; rather, rotate(degrees) must be called.
/**
Calculates the final position of a point in a plane after it's been rotated by an arbitrary number of degrees along a circular path in that plane, in which the center of the circle lies on the center of the plane.
*/
public class PlanarRotator{
	
	private static PlanarRotator instance;
	private double startX, startY, degrees, hypotenuse, endX, endY;

	/**
	@param startX The point's starting position along the X axis
	@param startY the point's starting position along the Y axis
	@param degrees The amount to rotate the point around the center of the plane (Z axis), in degrees.
	*/
	private PlanarRotator(double startX, double startY, double degrees){
		recalculate(startX, startY, degrees); //initializes field values
	}
	
	/**
	Calculates the final position of a point in a plane whose initial position is specified by <code>(startX, startY)</code> and has been rotated by <code>degrees</code> degrees.

	@param startX The point's starting position along the X axis
	@param startY the point's starting position along the Y axis
	@param degrees The amount to rotate the point around the center of the plane (Z axis), in degrees.
	@return A PlanarRotator initialized to the submitted values.
	*/
	static PlanarRotator getInstance(double startX, double startY, double degrees){
		if (instance == null) instance = new PlanarRotator(startX, startY, degrees);
		else instance.recalculate(startX, startY, degrees);
		return instance;
	}
	/**
	Sets the field values.
	*/
	private void recalculate(double startX, double startY, double degrees){
		this.startX = startX;
		this.startY = startY;
		this.degrees = Math.toRadians(degrees);

		this.hypotenuse = Math.hypot(startX, startY);
		this.endY = getEndY();
		this.endX = getEndX();
	}
	/**
	Calculates the angle (in radians) between the zero degree line and the line that runs between (0,0) and (startX, startY).	
	*/
	private double firstAngle(){
		double ratio = startY / hypotenuse;
		return Math.asin(ratio);
	}
	/**
	Calculates the value of <code>endY</code> after being rotated by <code>degrees</code> degrees.
	*/
	private double getEndY(){
		double fullAngle = degrees + firstAngle();
		double sine = Math.sin(fullAngle);
		return hypotenuse * sine;
	}
	/**
	Calculates the value of X after rotation.	
	*/
	private double getEndX(){
		double hypSq = hypotenuse * hypotenuse;
		double endYSq = endY * endY;
		return Math.sqrt(hypSq + endYSq);
	}
	/**
	Returns the value of X after rotation.	
	*/
	public double endX(){
		return endX;
	}
	/**
	Returns the value of Y after rotation.
	*/
	public double endY(){
		return endY;
	}
	/**
	Rotates the point by <code>degrees</code> degrees and re-calculates {@link #endX() endX()} and {@link #endY() endY()}. Can be used to repeatedly rotate a point around a circle and calculate it's position in x, y coordinates.
	@return This PlanarRotator instance with endX and endY updated to reflect the new rotation.
	*/
	public PlanarRotator rotate(double degrees){
		//Recalculating using the end point coordinates of the last rotation as the starting point coordinates of the new one.
		this.recalculate(endX, endY, degrees);
		return this;
	}
}