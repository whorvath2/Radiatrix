package com.billhorvath.radiatrix.types;

import java.util.*;

/**
A collection of related measurements (i.e., data points), sorted according to some defined order. For example, a series of measurements of a person's height might be sorted according to the time they were taken.

The purpose for sorting the data in the Tuple is for comparison across Tuples (see {@link DataSet DataSet}). Note that the data are not necessarily of the same scale or unit of measure. For example, the tuple might contain a persons weight, height, and age, sorted in that order arbitrarily.

@author Bill Horvath II
@version 1.0

*/

public interface Tuple<T extends Measurement>{
	/**
	Returns a string that will uniquely identify this tuple in a {@link DataSet DataSet}.
	*/
	public String name();

	/**
	Returns a list containing the measured data points in this tuple.
	*/
	public List<T> measurements();
	
	/**
	Returns the number of measurements in this tuple. If this tuple were represented as a row in a table, this would be the number of columns in the table.
	
	@return the number of measurements in this tuple.
	*/
	public int size();
}
