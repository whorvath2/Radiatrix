package com.billhorvath.radiatrix.controller;

import com.billhorvath.radiatrix.types.*;

import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import java.util.*;

/**

*/

public class RadiatrixShowDisplayController implements EventHandler<ActionEvent>{
	
	private DataSet<Tuple> dataset; 

	/**
	
	*/
	public RadiatrixShowDisplayController(DataSet<Tuple> dataset){
		this.dataset = dataset;
	}	
	/**

	@param event The event to be handled.
	*/
	@Override
	public void handle(ActionEvent event){
	
		Node node = (Node)event.getSource();
		Stage stage = (Stage)node.getScene().getWindow();
// 		RadiatrixDisplay scene = new RadiatrixDisplay(dataset);
// 		scene.start(stage);
	}
}