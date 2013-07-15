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
	Returns an instance of {@link Measurement Measurement} with field values corresponding to the submitted paramaters, and that does not support conversion to other measurements of the same group.
	*/
	public static <N extends Number> Measurement<N> getUnconvertibleInstance(final String unitName, final String unitNamePl, final String unitNameAbbr, final MeasurementGroup group, final N number){
		
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
	Returns an instance of {@link Measurement Measurement} with just the unit name abbreviation specified.
	*/
	public static <N extends Number> Measurement<N> abbrInstance(final String unitNameAbbr){
		return new Measurement<N>(){
		
			/**
			This method is not implemented.
			@throws UnsupportedOperationException in all circumstances.
			*/
			public String unitNameSingular(){
				throw new UnsupportedOperationException("This measurement instance does not have a singular unit name.");
			}
			/**
			This method is not implemented.
			@throws UnsupportedOperationException in all circumstances.
			*/
			public String unitNamePlural(){
				throw new UnsupportedOperationException("This measurement instance does not have a plural unit name.");
			}
			/**
			Returns the abbreviated name of the units of this measurement.
			@return the abbreviated name of the units of this measurement.
			*/
			public String unitNameAbbr(){
				return unitNameAbbr;
			}
			/**
			This method is not implemented.
			@throws UnsupportedOperationException in all circumstances.
			*/
			public MeasurementGroup group(){
				throw new UnsupportedOperationException("This measurement instance does not have a group.");
			}
			/**
			This method is not implemented.
			@throws UnsupportedOperationException in all circumstances.
			*/
			public N value(){
				throw new UnsupportedOperationException("This measurement instance does not have a value.");
			}
			/**
			This method is not implemented.
			@throws UnsupportedOperationException in all circumstances.
			*/
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