package com.billhorvath.radiatrix.controller;

import com.billhorvath.radiatrix.types.*;

import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import java.util.*;
import com.billhorvath.radiatrix.view.*;
import com.billhorvath.radiatrix.types.impl.*;

/**

*/

public class ShowRadiatrixController implements EventHandler<ActionEvent>{
	
	private final DataSetBuilder builder;
	
	/**
	
	*/
	public ShowRadiatrixController(DataSetBuilder builder){
		this.builder = builder;
	}	
	/**

	@param event The event to be handled.
	*/
	@Override
	public void handle(ActionEvent event){
	
		Node node = (Node)event.getSource();
		Stage stage = (Stage)node.getScene().getWindow();
		RadiatrixScene radiatrix = RadiatrixScene.getInstance(stage);
		radiatrix.view(builder);
	}
}