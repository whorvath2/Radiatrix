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
	static <T extends Measurement> Tuple getInstance(final String name, Map<String, T> measurements){

		//Create our own copy of the map, in case the submitted one changes
		final Map<String, T> map = new HashMap<String, T>(measurements);
		
		return new Tuple(){
			public String name(){
				return name;
			}
			public Map<String, T> measurements(){
				return map;
			}
			public int size(){
				return map.size();
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