package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;

/**
A utility class for stamping out instances of {@link Measurement Measurement}.
*/
public class MeasurementFactory{
	
	/**
	Since this class will never be instantiated, this constructor is empty.
	*/
	private MeasurementFactory(){}
	
	/**
	Returns an instance of {@link Measurement Measurement} with field values corresponding to the submitted paramaters.
	*/
	public static <N extends Number> Measurement<N> getInstance(final String name, final String unitName, final String unitNamePl, final String unitNameAbbr, final N number){
		
		return new Measurement<N>(){
			public String name(){
				return name;
			}
			public String unitNameSingular(){
				return unitName;
			}
			public String unitNamePlural(){
				return unitNamePl;
			}
			public String unitNameAbbr(){
				return unitNameAbbr;
			}
			public N value(){
				return number;
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