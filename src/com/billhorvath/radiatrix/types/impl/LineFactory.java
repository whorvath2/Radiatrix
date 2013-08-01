package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;
import com.billhorvath.radiatrix.util.*;

/**
A factory class for creating {@link Line Line} instances.

@see Line
*/
public class LineFactory{
	
	private static LineFactory instance;

	/**
	Clients must use the getInstance() method to obtain a LineFactory instance.
	*/
	private LineFactory(){}
	
	/**
	Creates an instance of LineFactory (if needed) and returns it.	
	*/
	static LineFactory getInstance(){
		//We'll use a singleton instance for memory efficiency. If it creates performance issues down the road, this is easy to change...
		if (instance == null) instance = new LineFactory();
		return instance;
	}
	/**
	Creates a mutable instance of {@link Line Line} with endpoints <code>a</code> and <code>b</code>.
	*/
	public Line line(final Point a, final Point b){
		
		return new Line(){
		
			private Point A = PointFactory.getInstance().copy(a);
			private Point B = PointFactory.getInstance().copy(b);

			@Override
			public Point end(EndPoint endPoint){
				switch(endPoint){
					case A: return A;
					case B: return B;
					default:{
						assert false: "Holy crap! A line with an undefined endpoint. Wow.";
						throw new IllegalStateException("Unspecified EndPoint type.");
					}
				}
			}
			@Override
			public Point middle(){
				double d1 = A.x();
				double d2 = B.x();
				double x = (d1 - d2) / 2;
				
				d1 = A.y();
				d2 = B.y();
				double y = (d1 - d2) / 2;
				
				d1 = A.z();
				d2 = B.z();
				double z = (d1 - d2) / 2;
				
				return PointFactory.getInstance().point(x, y, z);
			}
			@Override
			public Line rotate(Point fulcrum, Rotation rotation){
				this.A = Rotator.getInstance(A).rotateAround(fulcrum, rotation);
				this.B = Rotator.getInstance(B).rotateAround(fulcrum, rotation);
				return this;
				
			}
			@Override
			public Line shift(Shift shift){
				A.shift(shift);
				B.shift(shift);
				return this;
			}	
		};
	}
}