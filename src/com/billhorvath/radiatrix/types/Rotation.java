package com.billhorvath.radiatrix.types;

/**
Provides a means of defining a rotation in 3D space by specifying the degrees of rotation around all three axes.
*/

public interface Rotation{

	/**
	Returns the number of degrees of rotation around the specified axis.
	
	@return the degrees of rotation around the specified axis.
	*/
	public double degrees(Axis axis);
}