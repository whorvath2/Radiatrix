package com.billhorvath.radiatrix.controller;

import java.net.*;
import java.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import javafx.collections.*;
import com.billhorvath.radiatrix.types.*;
import com.billhorvath.radiatrix.view.*;
import com.billhorvath.radiatrix.types.impl.*;

/**

*/

public class ShowTupleSetupController implements EventHandler<ActionEvent>{
	
	private final DataSetBuilder builder;
	
	public ShowTupleSetupController(DataSetBuilder builder){
		this.builder = builder;
	}
	/**

	@param event The event to be handled.
	*/
	@Override
	public void handle(ActionEvent event){
	
		Node node = (Node)event.getSource();
		Stage stage = (Stage)node.getScene().getWindow();
		TupleSetupScene scene = new TupleSetupScene(builder);
		try{
			scene.start(stage);
		}
		catch(Exception e){
			PopupMessage.showPopup("Ack! I couldn't open the next window! Send out the distress call!", "Yes Sir!", stage);
		}
	}
}
