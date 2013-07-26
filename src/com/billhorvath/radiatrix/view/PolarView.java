package com.billhorvath.radiatrix.view;

import com.billhorvath.radiatrix.types.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.*;
import javafx.collections.*;
import java.util.*;

/**

*/
class PolarView{
	
	private static PolarView instance;
	private final Map<String, Number> maxValues;
	private final double degreesPerSlice;
	private static Color color = Color.BLUE;
	private static double shift = 0D;

	/**
	
	@param tuple A map representation of a tuple, in which the keys are the measurements, and the values are the maximum values of a scale against which the measurement ratios will be calculated and plotted.
	
	*/
	private PolarView(Map<String, Number> maxValues){
		this.maxValues = maxValues;
		assert maxValues.size() > 0 : "maxValues is empty!";
		this.degreesPerSlice = (360 / maxValues.size());
	}
	
	/**
		
	*/
	static PolarView getInstance(Map<String, Number> maxValues){
		instance = new PolarView(maxValues);
		return instance;
	}
	/**
		
	*/
	Node getView(Tuple tuple){
		//Iterate through the measures in the tuple, calculate ratio of measure.value() to corresponding maxValue, calculate line, draw line, add line to node, return entire node.
		Group result = new Group();
		ObservableList<Node> children = result.getChildren();
		List<Measurement> measures = new ArrayList<Measurement>(tuple.measurements());
		int n = 0;
		for (Measurement measure : measures){
			String name = measure.name();
			Number max = maxValues.get(name);
			assert (max.doubleValue() > 0) : "max.doubleValue is less than or equal to zero: " + max.doubleValue();
			double ratio = measure.value().doubleValue() / max.doubleValue();
			assert ratio <= 1;
			children.add(getLine(n, ratio, shift));
			n++;
		}
		shift += 15;
		return result;
	}
	/**
		
	*/
	Node getLine(int count, double ratio, double shift){
		double hypoteneuse = ratio * Dimensions.CIRCLE.radius();
		
		Line line = new Line();
		line.setStartX(Dimensions.CIRCLE.x() + shift);
		line.setStartY(Dimensions.CIRCLE.y() + shift);
		
		double angle = degreesPerSlice * count;
		
		double endY = Dimensions.CIRCLE.y();
		double endX = Dimensions.CIRCLE.x();
		double xMod = 0;
		double yMod = 0;
		if (angle == 360) angle = 0;
		
		if (angle == 0){
			yMod = 0;
			xMod = 1;
		}
		else if (angle == 90){
			yMod = -1;
			xMod = 0;
		}
		else if (angle == 180){
			yMod = 0;
			xMod = -1;
		}
		else if (angle == 270){
			yMod = 1;
			xMod = 0;
		}
		else{		
			if (angle > 0 && angle < 90){
				yMod = -1;
				xMod = 1;
			}
			else if (angle > 90 && angle < 180){
				xMod = -1;
				yMod = -1;
			}
			else if (angle > 180 && angle < 270){
				xMod = -1;
				yMod = 1;
			}
			else if (angle > 270 && angle < 360){
				xMod = 1;
				yMod = 1;
			}
		}

		angle = Math.toRadians(angle);
		
		double cosine = Math.abs(Math.cos(angle));
		endX = (cosine * hypoteneuse) * xMod;
		endX += Dimensions.CIRCLE.x() + shift;

		double sine = Math.abs(Math.sin(angle));
		endY = (sine * hypoteneuse) * yMod;
		endY += Dimensions.CIRCLE.y() + shift;

		line.setEndX(endX);
		line.setEndY(endY);
		line.setStroke(color);
		return line;
	}
}