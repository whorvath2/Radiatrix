package com.billhorvath.radiatrix.view;

import com.billhorvath.radiatrix.types.*;
import javafx.scene.shape.*;
import javafx.scene.*;
import java.util.*;

/**

*/
class PolarViewer{
	
	private final Map<Measurement, Double> tuple;
	private final double degreesPerSlice;

	/**
	
	@param tuple A map representation of a tuple, in which the keys are the measurements, and the values are the maximum values of a scale against which the measurements will be plotted.
	
	*/
	private PolarViewer(Map<Measurement, Double> tuple){
		this.tuple = tuple;
		this.degreesPerSlice = (360 / tuple.size());
	}
	
	/**
		
	*/
	static PolarViewer getInstance(Map<Measurement, Double> tuple){
		return new PolarViewer(tuple);
	}
	/**
	Returns the viewable node that displays the data in the tuple.	
	*/
	Node getNode(){
		Circle circle = new Circle(Dimensions.CIRCLE.x(), Dimensions.CIRCLE.y(), Dimensions.CIRCLE.radius());
// 		double diameter = (2 * radius * Math.PI);
		return null;
	}
	/**
		
	*/
	Node getLine(int count){
		Line line = new Line();
		line.setStartX(Dimensions.CIRCLE.x());
		line.setStartY(Dimensions.CIRCLE.y());
		
		double angle = degreesPerSlice * count;
		
		
		line.setEndX(100.0f);
		line.setEndY(100.0f);
		return line;
	}
}