package com.billhorvath.radiatrix.types;

/**
Defines a point in a three-dimensional (x, y, z) space, and optionally provides means of manipulating that point, including:
	<ul>
		<li>Rotating the point around any of the three axes.</li>
		<li>Shifting the point along any of the three axes.</li>
	</ul>
	
@see Axis

*/
public interface Point{
	/**
	The location of this point along the x axis of the 3D space. By convention, the x axis is oriented such that it is horizontal to the perspective of the user; I.e., a line drawn along the x axis would appear to the user to go from the left of her field of view to the right.
	@return The location of this point along the x axis of the 3D space.
	*/
	public double x();
	/**
	The location of this point along the y axis of the 3D space. By convention, the y axis is oriented such that it is vertical to the perspective of the user; I.e., a line drawn along the y axis would appear to the user to go from the bottom of her field of view to the top.
	@return The location of this point along the y axis of the 3D space.
	*/
	public double y();
	/**
	The location of this point along the z axis of the 3D space. By convention, the z axis is oriented such that the perspective of the user lies along it; I.e., a line drawn along the z axis would parallel the user's point of view.
	@return The location of this point along the z axis of the 3D space.
	*/
	public double z();
	/**
	Moves this point by the distance and direction specified in <code>shift</code> (optional operation.) 
	<p>Point classes that do not implement this method should throw an UnsupportedOperationException when this method is called.</p>
	@throws UnsupportedOperationException if this method is not implemented.
	@return This point, after it has been shifted by the distance and direction specified by <code>shift</code>.
	*/
	public Point shift(Shift shift);
	/**
	Rotates this point around the axis and by the degrees defined by <code>rotation</code> (optional operation.) Returns this point, after it has been rotated.
	<p>Implementers of this method should rotate the point relative to (0, 0, 0).</p>
	<p>Point classes that do not implement this method should throw an UnsupportedOperationException when this method is called.</p>
	@return This point, after it has been rotated.
	*/
	public Point rotate(Rotation rotation);
}