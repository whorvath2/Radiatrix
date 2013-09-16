package com.billhorvath.radiatrix.view;

import javafx.scene.*;
import javafx.fxml.*;
import com.billhorvath.radiatrix.*;

/**

*/
public enum SceneResource{
	OPENING_SCENE("OpeningScene.fxml"),
	DATASET_SETUP("DatasetCharacteristicsScene.fxml"),
	TUPLES_SETUP("TupleCharacteristicsScene.fxml");
	
	private final String fileName;
	
	/**
		
	*/
	SceneResource(String fileName){
		this.fileName = fileName;
		System.out.println("fileName = " + fileName);
	}
	/**
		
	*/
	public String fileName(){
		return fileName;
	}
	/**
		
	*/
	public Group group(){
		try{
			Parent parent = FXMLLoader.load(Radiatrix.class.getResource("resources/" + fileName));
			return new Group(parent);
		}
		catch(Exception e){
			e.printStackTrace();
			assert false;
		}
		return null;
	}
}