package com.billhorvath.radiatrix.types;
/**
An enumeration of types of {@link Measurement Measurements}. Different <code>measurements</code> of the same MeasurementGroup may be converted to one another. 

@author Bill Horvath II
@version 1.0
*/

public enum MeasurementGroup{
	LENGTH, 
	AREA,
	VOLUME,
	VELOCITY,
	MASS,
	TIME,
	ENERGY,
	WORK,
	CONSTANT
}