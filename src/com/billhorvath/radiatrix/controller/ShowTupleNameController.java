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

public class ShowTupleNameController implements Initializable{

	@FXML
	private Button nextStep;

	@FXML
	private TextField dataSetName, measurementsPerTuple, numberOfTuples;
	
	/**
		
	*/
	@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
        assert nextStep != null : "fx:id=\"nextStep\" was not injected: check FXML file 'DatasetCharacteristicsScene.fxml'.";
        // initialize your logic here: all @FXML variables will have been injected
		nextStep.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){

				Node node = (Node)event.getSource();
				Stage stage = (Stage)node.getScene().getWindow();

            	String name = dataSetName.getText();
            	String measures = measurementsPerTuple.getText();
            	String number = numberOfTuples.getText();
            	
            	int numMeasurements = 0;
            	int numTuples = 0;
            	
            	try{
            		numMeasurements = Integer.parseInt(measures);
            	    numTuples = Integer.parseInt(number);
            	    if (numMeasurements <= 0 || numTuples <= 0) throw new Exception("One of the numbers is not a positive integer.");
            	}
            	catch(Exception e){
            		PopupMessage.showPopup(
            			"Both the number of measurements and the number\nof tuples must be positive integer values, e.g. \"42\"",
						"Got it! Thanks!", stage);
					return;
            	}
            	
            	DataSetBuilder builder = DataSetBuilder.create()
            		.name(name)
            		.size(numTuples)
            		.sizeOfTuples(numMeasurements);
            	TupleNamingScene ts = new TupleNamingScene(builder);
            	try{
            		ts.start(stage);
            	}
            	catch(Exception e){
            		PopupMessage.showPopup("Wow, I wasn't able to show the next window! You might want to call in the minions on this one", "Ten-Four!", stage);
            	}
            }
        });
    }
}
