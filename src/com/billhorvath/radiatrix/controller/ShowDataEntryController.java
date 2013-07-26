package com.billhorvath.radiatrix.controller;

import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import java.util.*;
import com.billhorvath.radiatrix.view.*;
import com.billhorvath.radiatrix.types.impl.*;

/**
Closes the window containing the button to which this event handler is added.
*/

public class ShowDataEntryController implements EventHandler<ActionEvent>{
	
	private final DataSetBuilder builder;
	
	/**
		
	*/
	public ShowDataEntryController(DataSetBuilder builder){
		this.builder = builder;
	}
	/**

	@param event The event to be handled.
	*/
	@Override
	public void handle(ActionEvent event){
	
		Node node = (Node)event.getSource();
		Stage stage = (Stage)node.getScene().getWindow();
		DataEntryScene scene = new DataEntryScene(builder);
		try{
			scene.start(stage);
		}
		catch(Exception e){
			PopupMessage.showPopup("Toledo, we have a problem! Time to seek help from the minions. #sharknado", "Aack! I'm melting!", stage);
		}
	}
}

