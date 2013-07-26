package com.billhorvath.radiatrix.types;

import java.util.*;

/**
A collection of Tuples; i.e., a (nominally tabular) set of data.

The contract for this interface specifies that any particular data set must contain tuples of the same size, and with commonly-named measurements, so that the data across tuples may be compared. That is to say, each tuple should have the same number of measurements, and each measurement should have the same name as the comparable measurement in any other tuple in the set.

Graphically, this is how a dataset should look:

	Dataset
		Tuple 1				Tuple 2				Tuple 3
			Measurement A		Measurement A		Measurement A
			Measurement B		Measurement B		Measurement B
			Measurement C		Measurement C		Measurement C

Note: Implementations of this interface may allow for missing measurements; however the missing measurement must be represented in some fashion in the data set.

@author Bill Horvath II
@version 1.0

*/

public interface DataSet<T extends Tuple>{
	/**
	Returns the name of this dataset.	
	*/
	public String name();
	/**
	Returns a particular tuple in this dataset.
	*/
	public Tuple get(String name);
	/**
	Returns a list view of the tuples in this dataset.
	*/
	public List<T> data();
	/**
	Returns the number of tuples in this dataset.
	*/
	public int size();
	/**
	Sorts the tuples in this dataset according to <code>comparator</code>.
	*/
	public void sort(Comparator<T> comparator);
	/**
	Looks at each measure within the tuples in the set, and returns a map in which the keys are the measure names, and the values are the maximum value of that measure across all of the same measures in the tuple.
	*/
	public Map<String, Number> maxValues();
}