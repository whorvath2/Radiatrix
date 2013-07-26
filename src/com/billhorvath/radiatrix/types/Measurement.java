package com.billhorvath.radiatrix.types;

/**
An individual measurement taken against a particular unit scale. A measurement is composed of a numerical value representing the number of units, and a string representing the name of the units themselves. Examples: 4 inches, 2.1 grams, 1.21 gigawatts.
@author Bill Horvath II
@version 1.0
*/

public interface Measurement<T extends Number>{
	/**
	Returns the name of this particular measurement. This name should be unique within any particular {@link Tuple tuple}.
	*/
	String name();
	
	/**
	Returns the name of a single unit on this measurement's scale. E.g., inch, pound, ohm, etc.

	@return the name of a single unit on this measurement's scale.
	*/
	String unitNameSingular();

	/**
	Returns the name of a group of units on this measurement's scale. E.g., inches, pounds, ohms, etc.

	@return the name of a group of units on this measurement's scale.
	*/
	String unitNamePlural();

	/**
	Returns the abbreviated form of the units on this measurement's scale. E.g., in., lb., Ω, etc.	
	
	@return the abbreviated form of the units on this measurement's scale.
	*/
	String unitNameAbbr();
	
	/**
	Returns the type of this measurement, which determines to what other units of measure this measurement may be converted. For example, if this measurement is of type LENGTH, it can be converted to another measurement of type LENGTH, such as from inches to centimeters.
	*/
	public MeasurementGroup group();
	
	/**
	Returns the value of the measurement as measured along an ordinal scale; i.e., a data point. If the unit of measure underlying the scale of this measurement is not proportional (i.e., <code>this.scale().unitOfMeasure() == false</code>), Y should be of type Integer, BigInteger, or Byte. If the unit of measure is nominal, this method should throw an IllegalStateException.
	
	@return The value of the measurement in the units specified by units().
	*/
	public T value();
}