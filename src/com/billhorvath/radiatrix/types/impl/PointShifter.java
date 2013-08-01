package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;

/**

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