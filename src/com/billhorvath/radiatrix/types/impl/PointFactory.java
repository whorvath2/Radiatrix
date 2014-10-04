package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;

/**
A factory class for generating {@link Point points}.

@see Point
*/
public class PointFactory{

	private static PointFactory instance;
	/**
	Returns an instance of PointFactory.
	
	@return an instance of PointFactory.
	*/
	public static PointFactory getInstance(){
		if (instance == null) instance = new PointFactory();
		return instance;
	}
	/**
	Creates a mutable copy of <code>startingPoint</code>.
	
	@param startingPoint The initial location of the point in space.
	@return a mutable copy of <code>startingPoint</code>.
	*/
	public Point copy(Point startingPoint){
		return point(startingPoint.x(), startingPoint.y(), startingPoint.z());
	}
	/**
	Creates a mutable point at the specified location in space. The point implements both the shift and rotate methods.
	@param x The initial location of the point along the X axis.
	@param Y The initial location of the point along the Y axis.
	@param Z The initial location of the point along the Z axis.
	@return A point whose initial position is at x, y, z.
	
	*/
	public Point point(final double x, final double y, final double z){

		return new Point(){

			private double X = x;
			private double Y = y;
			private double Z = z;
			
			@Override
			public double x(){
				return X;
			}
			@Override
			public double y(){
				return Y;
			}
			@Override
			public double z(){
				return Z;
			}
			@Override
			public Point shift(Shift shifter){
				this.X += shifter.distance(Axis.X);
				this.Y += shifter.distance(Axis.Y);
				this.Z += shifter.distance(Axis.Z);
				return this;
			}
			/**
				
			*/
			@Override
			public Point rotate(Rotation rotation){
				this.rotate(Axis.X, rotation.degrees(Axis.X));
				this.rotate(Axis.Y, rotation.degrees(Axis.Y));
				this.rotate(Axis.Z, rotation.degrees(Axis.Z));
				return this;
			}
			/**
				
			*/
			private void rotate(Axis axis, double degrees){

				double startX, startY;
				
				switch(axis){
					case X:{
						startX = Z;
						startY = Y;
						PlanarRotator rotator = PlanarRotator.getInstance(startX, startY, degrees);
						this.Z = rotator.endX();
						this.Y = rotator.endY();
					}	
					case Y:{
						startX = X;
						startY = Z;
						PlanarRotator rotator = PlanarRotator.getInstance(startX, startY, degrees);
						this.X = rotator.endX();
						this.Z = rotator.endY();
					}
					case Z:{
						startX = X;
						startY = Y;
						PlanarRotator rotator = PlanarRotator.getInstance(startX, startY, degrees);
						this.X = rotator.endX();
						this.Y = rotator.endY();
					}
					default:{
						assert false : "Holy crap! You've created ANOTHER rip in the space-time continuum!";
						throw new IllegalStateException("Undefined axis of rotation.");
					}
				}
			}
		};
	}
	/**
	Creates an immutable copy of <code>startingPoint</code>.		
	*/
	public Point immutableCopy(Point startingPoint){
		return immutablePoint(startingPoint.x(), startingPoint.y(), startingPoint.z());
	}
	/**
	Creates an immutable instance of point at position (x, y, z); i.e. the shift and rotate operations are not supported.
	
	@return an immutable instance of point at position (x, y, z).
	
	*/
	public Point immutablePoint(final double x, final double y, final double z){
		return new Point(){

			private double X = x;
			private double Y = y;
			private double Z = z;
			
			@Override
			public double x(){
				return X;
			}
			@Override
			public double y(){
				return Y;
			}
			@Override
			public double z(){
				return Z;
			}
			@Override
			public Point shift(Shift shifter){
				assert false;
				throw new UnsupportedOperationException("This point instance is immutable, and cannot be shifted.");
			}
			@Override
			public Point rotate(Rotation rotation){
				assert false;
				throw new UnsupportedOperationException("This point instance is immutable, and cannot be rotated.");
			}
		};		
	}

}