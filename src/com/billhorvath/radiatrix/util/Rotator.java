package com.billhorvath.radiatrix.util;

/**
Calculates the final position of a point in a plane after it's been rotated by an arbitrary number of degrees.
*/
class Rotator{
	
	private static Rotator instance;
	private double startX, startY, rotation, hypotenuse, endX, endY;

	/**
	@param startX The point's starting position along the X axis
	@param startY the point's starting position along the Y axis
	@param rotation The amount to rotate the point around the center of the plane (Z axis), in degrees.
	
	*/
	private Rotator(double startX, double startY, double rotation){
		recalculate(startX, startY, rotation); //initializes field values
	}
	
	/**
	Calculates the final position of a point in a plane whose initial position is specified by <code>(startX, startY)</code> and has been rotated by <code>rotation</code> degrees.
	*/
	static Rotator getInstance(double startX, double startY, double rotation){
		if (instance == null) instance = new Rotator(startX, startY, rotation);
		else instance.recalculate(startX, startY, rotation);
		return instance;
	}
	/**
	Sets the field values. Note that rotation is specified to be submitted in degrees, but is calculated in radians.
	*/
	private void recalculate(double startX, double startY, double rotation){
		this.startX = startX;
		this.startY = startY;
		this.rotation = Math.toRadians(rotation);

		this.hypotenuse = hypotenuse();
		this.endY = getEndY();
		this.endX = getEndX();
	}
	/**
	Calculates the hypotenuse of a lawn drawn from the starting point to the center (0,0) of the plane. 	
	*/
	private double hypotenuse(){
		return Math.hypot(startX, startY);
	}
	/**
	Calculates the angle (in radians) between the zero degree line and the line that runs between (0,0) and (startX, startY).	
	*/
	private double firstAngle(){
		double ratio = startY / hypotenuse;
		return Math.asin(ratio);
	}
	/**
	Calculates the value of <code>endY</code> after being rotated by <code>rotation</code> degrees.
	*/
	private double getEndY(){
		double fullAngle = rotation + firstAngle();
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
}