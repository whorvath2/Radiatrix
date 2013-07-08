package com.billhorvath.radiatrix.model;

import java.util.*;
import com.billhorvath.radiatrix.*;
import com.billhorvath.radiatrix.types.*;

/**
A class for modeling the information in a {@link DataSet DataSet} for use in a Radiatrix.

This class provides a map of polar models, keyed to the name of each model in question. The name may represent samples from a group of individuals or items, multiple samples taken from the same person or item over time, or some other series.
@author Bill Horvath II
@version 1.0
*/
public class DataSetModel<T extends Tuple<? super Measurement>>{
	
	private static DataSetModel instance;
	private final DataSet<T> dataSet;

	/**
	Default constructor that assigns the dataset.
	*/
	private DataSetModel(DataSet<T> dataSet){
		this.dataSet = dataSet;
	}
	
	/**
	A static factory method for obtaining an instance of DataSetModel.
	*/
	static DataSetModel getInstance(DataSet<? extends Tuple<? extends Measurement>> dataSet){
		instance = new DataSetModel(dataSet);
		return instance;
	}
	/**
	Returns the number of tuples in the data set this model represents.
	
	@return the number of tuples in the data set this model represents.
	*/
	public int size(){
		return dataSet.size();
	}
	/**
	Returns a map of {@link PolarModel PolarModels} that represent the data in each tuple contained in the dataset. The map is indexed by the name of each tuple.
	
	@return a map of {@link PolarModel PolarModels} that represent the data in each tuple contained in the dataset.
	*/
	public Map<String, PolarModel> dataModels(){
		List<Tuple> data = new ArrayList<Tuple>(dataSet.data());
		Map<String, PolarModel> result = new HashMap<String, PolarModel>(data.size());
		for (Tuple tuple : data){
			result.put(tuple.name(), PolarModel.getInstance(tuple));
		}
		return result;
	}
}