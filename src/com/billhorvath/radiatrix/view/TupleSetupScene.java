package com.billhorvath.radiatrix.view;

import com.billhorvath.radiatrix.types.*;
import com.billhorvath.radiatrix.types.impl.*;
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

	private final DataSetBuilder builder;
	
	/**

	*/
	public TupleSetupScene(DataSetBuilder builder){
		this.builder = builder;
	}

	/**
	
	*/
    @Override
    public void start(final Stage stage) throws Exception {
    	Platform.runLater(new Runnable(){
    		public void run(){

				Button button = new Button("Next Step");

				Text title = new Text("Tuple measurement units for " + builder.name());
				VBox vbox = VBoxBuilder.create()
					.padding(new Insets(0, 10, 0, 10))
					.spacing(10)
					.alignment(Pos.CENTER)
					.style("-fx-background-color: pink; -fx-padding: 10; -fx-border-style: solid; -fx-border-width: 2px; -fx-border-color: black;")
					.build();
				ObservableList<Node> children = vbox.getChildren();
				children.add(title);
				int numMeasures = builder.measurementsPerTuple();
				final Map<String, String> nameAbbrevMap = new HashMap<String, String>(numMeasures);
				for (int i = 0; i < numMeasures; i++){
					HBox hbox = HBoxBuilder.create()
						.padding(new Insets(0, 10, 0, 10))
						.spacing(10)
						.alignment(Pos.TOP_LEFT)
						.build();
					ObservableList<Node> hchildren = hbox.getChildren();
						
					final String num = String.valueOf(i + 1);
					Text nameLabel = new Text("Name of measure number " + num + ": ");
					final TextField nameField = new TextField();
					hchildren.add(nameLabel);
					hchildren.add(nameField);
					
					Text abbrLabel = new Text("Abbreviated unit name for measure number " + num + ": ");
					hchildren.add(abbrLabel);
					final TextField abbrField = new TextField();

					final int q = i;
					
					ChangeListener nameListener = new ChangeListener<String>(){
						@Override
						public void changed(ObservableValue<? extends String> observable,
							String oldValue, String newValue){
							String measureName = nameField.getText();
							if (measureName == null) measureName = "Measure " + q;
							if (!measureName.equals(oldValue)){
								nameAbbrevMap.remove(oldValue);
							}							
							String abbreviation = abbrField.getText();
							if (abbreviation == null) abbreviation = "Units";
							
							nameAbbrevMap.put(measureName, abbreviation);														
						}
					};
					nameField.textProperty().addListener(nameListener);
					
					ChangeListener abbrListener = new ChangeListener<String>(){
						@Override
						public void changed(ObservableValue<? extends String> observable,
							String oldValue, String newValue){
							String measureName = nameField.getText();
							if (measureName == null) measureName = "Measure " + q;
							
							String abbreviation = abbrField.getText();
							if (abbreviation == null) abbreviation = "Units";
							
							nameAbbrevMap.put(measureName, abbreviation);														
						}
					}; 
					
					abbrField.textProperty().addListener(abbrListener);
					hchildren.add(abbrField);
					children.add(hbox);
				}
				button.onActionProperty().addListener(new ChangeListener<EventHandler<ActionEvent>>(){
					@Override
					 public void changed(ObservableValue<? extends EventHandler<ActionEvent>> observable, EventHandler<ActionEvent> oldValue, EventHandler<ActionEvent> newValue){
						builder.measurementNamesAndAbbreviations(nameAbbrevMap);
					 }
				});

				button.setOnAction(new ShowDataEntryController(builder));
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