package com.billhorvath.radiatrix.types;

/**
Defines a line in a three-dimensional space, and optionally provides a means of rotating that line in space.

All lines are defined by two points, one at each end of the line. By convention, these are called A and B, and are named by {@link EndPoint EndPoint} in this package.

@see EndPoint
@see Point

*/

public interface Line{
	/**
	Returns the point at the end of this line specified by <code>endPoint</code>.
	@return the point at the end of this line specified by <code>endPoint</code>.
	*/
	public Point end(EndPoint endPoint);
	/**
	Returns the point at the middle of this line.
	@return the point at the middle of this line.
	*/
	public Point middle();
	/**
	Rotates this line around fulcrum.
	
	The <code>fulcrum</code> around which the line will be rotated must lie somewhere along the line, either at one of the ends, or somewhere in between. If fulcrum lies outside the line, an IllegalArgumentException should be thrown.
	<p>Returns this line, after the rotation operation has been completed.</p>
	
	@throws IllegalArgumentException if fulcrum is not on this line.
	@throws UnsupportedOperationException if this method is not supported by the implementation.
	@return This line, after the rotation operation has been completed.
	*/
	public Line rotate(Point fulcrum, Rotation rotation);
	/**
	Shifts this entire line along <code>axis</code> by <code>amount</code>. The resulting line will be parallel (in all three dimensions) to where it started.
	*/
	public Line shift(Shift shift);
}