package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;

/**
A utility class for stamping out instances of {@link Measurement Measurement}.
*/
class MeasurementFactory{
	
	/**
	Since this class will never be instantiated, this constructor is empty.
	*/
	private MeasurementFactory(){}
	
	/**
	Returns an instance of {@link Measurement Measurement} with field values corresponding to the submitted paramaters, and that does not support conversion to other measurements of the same group.
	*/
	static <N extends Number> Measurement<N> getUnconvertibleInstance(final String unitName, final String unitNamePl, final String unitNameAbbr, final N number, final MeasurementGroup group){
		
		return new Measurement<N>(){
			public String unitNameSingular(){
				return unitName;
			}
			public String unitNamePlural(){
				return unitNamePl;
			}
			public String unitNameAbbr(){
				return unitNameAbbr;
			}
			public MeasurementGroup group(){
				return group;
			}
			public N value(){
				return number;
			}
			public Measurement<N> convert(Measurement<N> otherMeasure){
				throw new UnsupportedOperationException("This measurement instance cannot be converted.");
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