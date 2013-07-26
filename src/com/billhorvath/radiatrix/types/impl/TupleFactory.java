package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;
import java.util.*;

/**

*/
class TupleFactory{

	/**
	Since this class will never be instantiated, this constructor is empty.
	*/
	private TupleFactory(){}
	
	/**
		
	*/
	static Tuple<Measurement> getInstance(final String name, List<Measurement<Number>> measurements){

		final List<Measurement> measures = new ArrayList<Measurement>(measurements);
		
		return new Tuple<Measurement>(){
			public String name(){
				return name;
			}
			public List<Measurement> measurements(){
				return measures;
			}
			public int size(){
				return measures.size();
			}
		};
	}
	
	/**
	Since this class will never be instantiated, this method will always return -1.	
	@return <code>-1</code>.
	*/
	
	public int hashCode(){
		return -1;
	}
	
	/**
	Since this class will never be instantiated, this method will always return false.
	@return <code>false</code>.
	*/
	
	public boolean equals(Object obj){
		return false;
	}
	
	/**
	Since this class will never be instantiated, this method will always return null.
	@return <code>null</code>.
	*/

	public String toString(){
		return null;
	}
}