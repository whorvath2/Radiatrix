package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;
import java.util.*;

/**

A simplest-case implementation of a {@link DataSet DataSet}.

@author Bill Horvath II
@version 1.0
*/

public class BasicDataSet<T extends Tuple> implements DataSet<T>{

	private final Map<String, Tuple> data;
	private final Map<String, Number> maxValues;
	private final List<T> tuples;
	private final String name;
	
	private BasicDataSet(String name, List<T> tuples){
		this.name = name;
		this.tuples = new ArrayList<T>(tuples);
		this.data = new HashMap<String, Tuple>();
		for (Tuple tuple : tuples){
			data.put(tuple.name(), tuple);
		}
		this.maxValues = new HashMap<String, Number>(size());

		for (Tuple tuple : tuples){
		
			List<Measurement> measures = tuple.measurements();

			for (Measurement measure : measures){
				Number compare = measure.value();
				assert compare != null;
				
				String measureName = measure.name();
				Number num = maxValues.get(measureName);
				//TO-DO: Give deeper thought to whether long is correct...
				if (num == null || num.longValue() < compare.longValue()){
					maxValues.put(measureName, compare);
				}
			}
		}
	}
	/**
	Creates a DataSet instance initialized to contain tuples.	
	*/
	public static BasicDataSet<Tuple> dataSet(String name, List<Tuple> tuples){
		return new BasicDataSet(name, tuples);
	}
	/**
	Returns a particular tuple in this dataset.
	*/
	public Tuple get(String name){
		return data.get(name);
	}

	/**
	Returns a list view of the tuples in this dataset.
	*/
	public List<T> data(){
		return new ArrayList<T>(tuples);
	}
	/**
	Returns the number of tuples in this dataset.
	*/
	public int size(){
		return data.size();
	}
	/**
	Sorts the tuples in this dataset according to the order specified by <code>comparator</code>.
	*/
	public void sort(Comparator<T> comparator){
		Collections.sort(tuples, comparator);
	}
	/**
	Returns the name of this dataset.	
	*/
	public String name(){
		return this.name;
	}
	/**
	Calculates the max values of each measurement across the tuples in this data set, and maps the field names to the max values.
	
	For example, if the raw data returned from value() on each measurement of three tuples was as follows:
				One Two	Three
	Tuple 1:	11	15	2
	Tuple 2:	5	12	2.1
	Tuple 3:	10	4	2.4
	
	The map would be as follows:
	
	Key		Value
	One		11
	Two		15
	Three	2.4
	
	*/
	public Map<String, Number> maxValues(){
		return new HashMap<String, Number>(maxValues);
	}
}