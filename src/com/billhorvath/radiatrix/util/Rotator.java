package com.billhorvath.radiatrix.util;

import com.billhorvath.radiatrix.types.*;
import com.billhorvath.radiatrix.types.impl.*;

/**

*/
public class Rotator{
	
	private static Rotator instance;
	private Point startingPoint;	

	/**

	*/
	private Rotator(Point startingPoint){
		this.setStartingPoint(startingPoint);
	}
	
	/**
	Calculates the final position of a point in a plane whose initial position is specified by <code>(startX, startY)</code> and has been rotated by <code>rotation</code> degrees.

	@param startingPoint The point this <code>rotator</code> will rotate.
	@return A Rotator initialized to the submitted values.
	*/
	public static Rotator getInstance(Point startingPoint){
		if (instance == null) instance = new Rotator(startingPoint);
		else instance.setStartingPoint(startingPoint);
		return instance;
	}
	/**
		
	*/
	private void setStartingPoint(Point startingPoint){
		this.startingPoint = startingPoint;
	}
	/**
	Calculates the new three-dimensional position of <code>startingPoint</code> after having been rotated by the degrees specified in <code>rotation</code> around an arbitrary point specified by <code>inSpace</code>.
	@return <code>startingPoint</code> after it has been rotated by <code>rotation</code> degrees around <code>inSpace</code>.
	*/
	public Point rotateAround(Point inSpace, Rotation rotation){
		Point result = PointFactory.getInstance().copy(startingPoint);
		double x = inSpace.x();
		double y = inSpace.y();
		double z = inSpace.z();
		Shift shiftZeroPoint = PointShifter.getInstance(x, y, z);
		Shift shiftBack = PointShifter.getInstance(-1 * x, -1 * y, -1 * z);
		
		result.shift(shiftZeroPoint)
			.rotate(rotation)
			.shift(shiftBack);
		return result;
	}
}