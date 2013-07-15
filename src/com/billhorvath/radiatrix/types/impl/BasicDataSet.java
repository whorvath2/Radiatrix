package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;
import java.util.*;

/**

A simplest-case implementation of a {@link DataSet DataSet}.

@author Bill Horvath II
@version 1.0
*/

public class BasicDataSet<T extends Tuple> implements DataSet<T>{

	private final Map<String, Tuple> data = new HashMap<String, Tuple>();
	private final List<T> tuples;
	private final String name;
	
	private BasicDataSet(String name, List<T> tuples){
		this.name = name;
		this.tuples = new ArrayList<T>(tuples);
		for (Tuple tuple : tuples){
			data.put(tuple.name(), tuple);
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
}