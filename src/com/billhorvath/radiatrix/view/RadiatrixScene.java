package com.billhorvath.radiatrix.view;

import com.billhorvath.radiatrix.types.*;
import com.billhorvath.radiatrix.types.impl.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.collections.*;
import java.util.*;

/**

*/
public class RadiatrixScene{
	
	private static RadiatrixScene instance;
	private final Stage stage;

	/**
	
	*/
	private RadiatrixScene(Stage stage){
		this.stage = stage;
	}
	
	/**
		
	*/
	public static RadiatrixScene getInstance(Stage stage){
		if (instance == null){
			instance = new RadiatrixScene(stage);
		}
		return instance;
	}
	/**
		
	*/
	public void view(DataSetBuilder builder){
		DataSet dataSet = builder.build();
		
		
		
		
		PolarView polar = PolarView.getInstance(dataSet.maxValues());
		List<Tuple> data = dataSet.data();
		Group root = new Group();
		ObservableList<Node> children = root.getChildren();
		for (Tuple tuple : data){
			Node node = polar.getView(tuple);
			children.add(node);
			//Add a layer with this node...
		}
		stage.setTitle("Radiatrix of " + dataSet.name());
		stage.setScene(new Scene(root, Dimensions.MEDIUM.width(), Dimensions.MEDIUM.height()));
		stage.show();
	}
}