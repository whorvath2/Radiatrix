package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;

/**
Provides a default implementation of Shift for moving a point along any of three axes.

*/
public class PointShifter implements Shift{

	private static PointShifter instance;
	private final PointFactory factory;
	private double shiftX, shiftY, shiftZ;

	/**
	
	*/
	private PointShifter(double shiftX, double shiftY, double shiftZ){
		this.factory = PointFactory.getInstance();
		this.shiftX = shiftX;
		this.shiftY = shiftY;
		this.shiftZ = shiftZ;
	}
	
	/**
	Returns a PointShifter instance.
	
	@param shiftX The distance the point will move along the X axis.
	@param shiftY The distance the point will move along the Y axis.
	@param shiftZ The distance the point will move along the Z axis.
	
	*/
	public static PointShifter getInstance(double shiftX, double shiftY, double shiftZ){

		if (instance == null) instance = new PointShifter(shiftX, shiftY, shiftZ);
		else{ 
			instance.shiftX = shiftX;
			instance.shiftY = shiftY;
			instance.shiftZ = shiftZ;
		}
		return instance;
	}
	/**
	Returns the distance by which the point will be shifted along <code>axis</code>.
	@param axis The axis along which the point will be shifted.
	@return A double value representing the distance the point will be shifted along the axis in question.
	*/
	public double distance(Axis axis){
		switch(axis){
			case X:{
				return shiftX;
			}
			case Y:{
				return shiftY;
			}
			case Z:{
				return shiftZ;
			}
			default:{
				assert false: "Unspecified axis.";
				throw new IllegalStateException("Unspecified axis in PointShifter.");
			}
		}
	}	
}