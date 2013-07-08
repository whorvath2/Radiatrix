package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;
import java.util.*;

/**

A simplest-case implementation of a {@link DataSet DataSet}.

@author Bill Horvath II
@version 1.0
*/

public class BasicDataSet<T extends Tuple<? super Measurement>> implements DataSet<T>{

	private final Map<String, Tuple> data = new HashMap<String, Tuple>();
	private final List<T> tuples;
	
	public BasicDataSet(List<T> tuples){
		this.tuples = new ArrayList<T>(tuples);
		for (Tuple tuple : tuples){
			data.put(tuple.name(), tuple);
		}	
	}
	/**
		
	*/
	public static BasicDataSet<? extends Tuple> dataSet(List<? extends Tuple> tuples){
		return new BasicDataSet(tuples);
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

}