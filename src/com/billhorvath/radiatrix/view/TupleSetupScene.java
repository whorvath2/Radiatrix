package com.billhorvath.radiatrix.view;

import com.billhorvath.radiatrix.types.*;
import com.billhorvath.radiatrix.controller.*;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.scene.layout.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.beans.property.*;
import javafx.beans.value.*;
import java.util.*;

/**

*/

public class TupleSetupScene extends Application{

	private final String name;
	private final int numMeasures, numTuples;
	
	/**

	*/
	public TupleSetupScene(String name, int numMeasures, int numTuples){
		this.name = name;
		this.numMeasures = numMeasures;
		this.numTuples = numTuples;
	}

	/**
	
	*/
    @Override
    public void start(final Stage stage) throws Exception {
    	Platform.runLater(new Runnable(){
    		public void run(){
				Text title = new Text("Tuple measurement units for " + name);
				VBox vbox = VBoxBuilder.create()
					.padding(new Insets(0, 10, 0, 10))
					.spacing(10)
					.alignment(Pos.CENTER)
					.style("-fx-background-color: pink; -fx-padding: 10; -fx-border-style: solid; -fx-border-width: 2px; -fx-border-color: black;")
					.build();
				ObservableList<Node> children = vbox.getChildren();
				children.add(title);
				
				final Map<TextField, TextField> dataNamesAndUnits = new HashMap<TextField, TextField>(numMeasures);
				for (int i = 0; i < numMeasures; i++){
					HBox hbox = HBoxBuilder.create()
						.padding(new Insets(0, 10, 0, 10))
						.spacing(10)
						.alignment(Pos.TOP_LEFT)
						.build();
					final String num = String.valueOf(i + 1);
					Text name = new Text("Name of measure number " + num + ": ");
					final TextField nameField = new TextField();
					hbox.getChildren().add(name);
					hbox.getChildren().add(nameField);
					
					Text text = new Text("Abbreviated unit name for measure number " + String.valueOf(i) + ": ");
					hbox.getChildren().add(text);
					final TextField abbrField = new TextField();
					
					dataNamesAndUnits.put(nameField, abbrField);
					
					hbox.getChildren().add(abbrField);
					children.add(hbox);
				}
				Button button = new Button("Next Step");
				button.setOnAction(new TupleSetupButtonController(name, numTuples, dataNamesAndUnits));
				children.add(button);
				
				Group group = new Group();
				ScrollPane pane = ScrollPaneBuilder.create()
					.fitToWidth(true)
					.fitToHeight(true)
					.prefViewportHeight(Dimensions.MEDIUM.height())
					.prefViewportWidth(Dimensions.MEDIUM.width())
					.content(vbox)
					.build();
				group.getChildren().add(pane);
				stage.setTitle("Tuple Setup");
				stage.setScene(new Scene(group, Dimensions.MEDIUM.width(), Dimensions.MEDIUM.height()));
				stage.show();
    		}
    	});
    }
}