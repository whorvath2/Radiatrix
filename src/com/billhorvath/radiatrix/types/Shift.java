package com.billhorvath.radiatrix.types;

/**
Provides a means of defining a shift of position in 3D space by specifying the distance to shift along any of the axes. <p>Instances of shift should return a distance in all three dimensions specified by Axis, even if the shift is 0 along one or more of those dimensions.</p>
*/

public interface Shift{

	/**
	Returns the distance to shift along the specified <code>axis</code>.
	
	@return the distance to shift along the specified <code>axis</code>.
	*/
	public double distance(Axis axis);
}