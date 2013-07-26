package com.billhorvath.radiatrix.types;
/**
An enumeration of types of {@link Measurement Measurements}. Different <code>measurements</code> of the same MeasurementGroup may be converted to one another. 

<code>MAX_VALUE</code> is a special MeasurementGroup used to mark measurement instances that simply contain the name of a measure and its maximum value in a particular {@link DataSet DataSet}. I.e., measurements in the <code>MAX_VALUE</code> group will only contain a name and a value, and that name will only have relevance inside the context of a particular dataset instance.

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
	CONSTANT,
	MAX_VALUE,
	UNSPECIFIED
}