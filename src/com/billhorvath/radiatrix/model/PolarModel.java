package com.billhorvath.radiatrix.model;

import java.util.*;
import com.billhorvath.radiatrix.*;
import com.billhorvath.radiatrix.types.*;

/**
A class for modeling the data in a Tuple in a two-dimensional polar space.

For each measurement in the tuple, an axis is assigned and named. The axis names, along with the data value along the axis, is mapped in dataPoints().

@author Bill Horvath II
@version 1.0

*/
public class PolarModel<T extends Tuple>{
	
	private final Tuple<Measurement> data;
	private final String name;

	/**
	
	*/
	private PolarModel(Tuple<Measurement> data){
		this.data = data;
		this.name = data.name();
	}
	
	/**
	Returns an instance of PolarModel representing the information in <code>data</code>.
	
	@return An instance of PolarModel representing the information in <code>data</code>.
	*/
	public static PolarModel getInstance(Tuple<? extends Measurement> data){
		return new PolarModel(data);
	}
	
	/**
	Returns the number of axes needed to represent the data in the tuple.
	
	@return The number of axes needed to represent the data.
	*/
	public int numberOfAxes(){
		return data.size();
	}
	/**
	Returns a set containing the name of each data point in the tuple.
	
	@return A set containing the name of each data point in the tuple.
	*/
	public Set<String> axisNames(){
		Set<String> result = new HashSet<String>(data.size());
		List<Measurement> measures = data.measurements();
		for (Measurement measure : measures){
			result.add(measure.name());
		}
		return result;
	}
	
	/**
		
	*/
	public Set<String> axisNamesWithUnits(){
		List<Measurement> measures = data.measurements();
		Set<String> result = new HashSet<String>(measures.size());
		for (Measurement measure : measures){
			String str = measure.name() + " " + measure.unitNameAbbr();
			result.add(str);
		}
		return result;
	}
	
	/**
	Returns a map view of the data in which the keys are the names of the measurements, and the values are the value of the measurements.

	@return A map view of the data in which the keys are the names of the measurements, and the values are the value of the measurements.
		
	*/
	public Map<String, Number> dataPoints(){
		List<Measurement> measures = data.measurements();		
		Map<String, Number> result = new HashMap<String, Number>(measures.size());
		for (Measurement measure: measures){
			result.put(measure.name(), measure.value());
		}
		return result;
	}
	
	/**
	Returns the name of this polar model. The default delegates to the name of the underlying tuple, however subclasses may wish to override this behavior.
	
	@return The name of this polar model.
	*/
	public String name(){
		return name;
	}
}