package com.billhorvath.radiatrix.types;

import com.billhorvath.radiatrix.types.impl.*;

/**
Names the two end points used to define a line. By convention, uses A and B.
*/
public enum EndPoint{
	A, B;
	/**
	Calculates a {@link Point Point} that indicates the location of this EndPoint.	
	*/
	public Point location(double X, double Y, double Z){
		return PointFactory.getInstance().point(X, Y, Z);
	}
}
