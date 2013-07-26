package com.billhorvath.radiatrix.types.impl;

import com.billhorvath.radiatrix.types.*;
import java.util.*;

/**

*/
public class DataSetBuilder<T extends DataSetBuilder<T>>{
	
	private static DataSetBuilder<?> instance;
	private String name;
	private int numTuples;
	private int measurementsPerTuple;
	private List<String> tupleNames;
	private Map<String, String> measureNamesAndAbbr;
	private Map<String, Map<String, Number>> tupleMap;
	
	/**
	
	*/
	private DataSetBuilder(){
		this.name = "";
		this.numTuples = 0;
		this.measurementsPerTuple = 0;
		this.tupleNames = new ArrayList<String>();
		this.measureNamesAndAbbr = new HashMap<String, String>();
		this.tupleMap = new HashMap<String, Map<String, Number>>();
	}
	
	/**
		
	*/
	public static DataSetBuilder<?> create(){
		if (instance == null){
			instance = new DataSetBuilder();
		}
		return instance;
	}
	/**
		
	*/
	public DataSet<Tuple> build(){

		final List<Tuple> data = new ArrayList<Tuple>(numTuples);
		
		final Map<String, Number> maxValues = new HashMap<String, Number>(measurementsPerTuple);
		
		for (String tupleName : tupleMap.keySet()){

			System.out.println("tupleName = " + tupleName);
			
			Map<String, Number> measureMap = tupleMap.get(tupleName);			
			List<Measurement<Number>> measures = new ArrayList<Measurement<Number>>(measurementsPerTuple);
			for (String measureName : measureMap.keySet()){

				String abbrev = measureNamesAndAbbr.get(measureName);
				assert abbrev != null;
				Number value = measureMap.get(measureName);

				Measurement<Number> measurement = MeasurementFactory.getInstance(measureName, "", "", abbrev, MeasurementGroup.UNSPECIFIED, value);
				measures.add(measurement);

				//populate maxValues...
				Number compare = maxValues.get(measureName);
				
				if (compare == null || value.longValue() > compare.longValue()){
					maxValues.put(measureName, value);
				}
			}
			Tuple<Measurement> tuple = TupleFactory.getInstance(tupleName, measures);
			data.add(tuple);
		}

		final String datasetName = this.name;

		return new DataSet<Tuple>(){
			public List<Tuple> data(){
				return data;
			}
			public Tuple get(String tupleName){
				for (Tuple tuple : data){
					if (tuple.name().equals(tupleName)) return tuple;
				}
				assert false;
				return null;
			}
			public Map<String, Number> maxValues(){
				return maxValues;
			}
			public String name(){
				return datasetName;
			}
			public int size(){
				return data.size();
			}
			public void sort(Comparator<Tuple> comparator){
				throw new UnsupportedOperationException();
			}
		};
	}
    /**
    	
    */
    public DataSetBuilder<T> name(String name){
    	this.name = name;
    	return this;
    }
    /**
    	
    */
    public DataSetBuilder<T> size(int numTuples){
    	this.numTuples = numTuples;
    	return this;
    }
    /**
    	
    */
    public DataSetBuilder<T> sizeOfTuples(int measurementsPerTuple){
    	this.measurementsPerTuple = measurementsPerTuple;
    	return this;
    }
    /**
    	
    */
    public DataSetBuilder<T> tupleNames(List<String> tupleNames){
    	this.tupleNames = tupleNames;
    	return this;
    }
    /**
    	
    */
    public DataSetBuilder<T> measurementNamesAndAbbreviations(Map<String, String> measureNamesAndAbbr){
    	this.measureNamesAndAbbr = measureNamesAndAbbr;
    	return this;
    }
    /**
    
    */
    public DataSetBuilder<T> measurements(Map<String, Map<String, Number>> tupleMap){
    	this.tupleMap = tupleMap;
    	return this;
    }
	/**
		
	*/
	public String name(){
		return name;
	}
	/**
		
	*/
	public int measurementsPerTuple(){
		return measurementsPerTuple;
	}
	/**
		
	*/
	public Map<String, String> measureNamesAndAbbr(){
		return measureNamesAndAbbr;
	}
	/**
		
	*/
	public int numberOfTuples(){
		return numTuples;
	}
	/**
		
	*/
	public List<String> tupleNames(){
		return tupleNames;
	}
}