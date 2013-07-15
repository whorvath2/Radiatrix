package com.billhorvath.radiatrix.view;

import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.geometry.*;
import javafx.application.*;
import javafx.collections.*;
import java.util.*;
import com.billhorvath.radiatrix.controller.*;
import com.billhorvath.radiatrix.types.impl.*;
import com.billhorvath.radiatrix.types.*;


/**
Provides a means of entering the raw data to be displayed in the Radiatrix.
*/

public class DataEntryScene{
	
	private final int numTuples;
	private final Map<TextField, TextField> dataNamesAndUnits;
	private final String name;
	
	/**
	
	*/
	public DataEntryScene(String name, int numTuples, Map<TextField, TextField> dataNamesAndUnits){
		this.numTuples = numTuples;
		this.dataNamesAndUnits = dataNamesAndUnits;
		this.name = name;
	}
	
	/**
	
	*/
    public void start(final Stage stage) throws Exception {
    	Platform.runLater(new Runnable(){
    		public void run(){
				Text title = new Text("Data entry for " + name);
				VBox vbox = getVbox();
				ObservableList<Node> vchildren = vbox.getChildren();
				vchildren.add(title);

				final List<Tuple> tuples = new ArrayList<Tuple>(numTuples);

				Set<TextField> keys = dataNamesAndUnits.keySet();
				for (int i = 0; i < numTuples; i++){
					Text text = new Text("Tuple " + String.valueOf(i + 1) + ": ");
					vchildren.add(text); //vbox because we want this above the data fields

					HBox hbox = getHbox();
					ObservableList<Node> hchildren = hbox.getChildren();

					int num = 0;
					for (final TextField nameField : keys){
						num++;
						String measName = nameField.getText();
						if (measName == null || measName.isEmpty()){
							measName = "Measure " + num;
						}
						text = new Text(measName + ": ");
						hchildren.add(text);

						TextField dataField = new TextField();
						dataField.setOnAction(getEventHandler(dataField, stage));
						hchildren.add(dataField);

						TextField abbrField = dataNamesAndUnits.get(nameField);
						String abbr = abbrField.getText();
						if (abbr == null) abbr = "";
						hchildren.add(new Text(abbr));
					}
					vchildren.add(hbox);
				}
				Button button = new Button("Show Me The Radiatrix!");
				DataSet<Tuple> dataSet = BasicDataSet.dataSet(name, tuples); 
				button.setOnAction(new RadiatrixShowDisplayController(dataSet)); //TODO
				vchildren.add(button);
				
				Group group = new Group();
				ScrollPane pane = getScrollPane(vbox);
				group.getChildren().add(pane);
				stage.setTitle("Data Entry");
				stage.setScene(new Scene(group, Dimensions.MEDIUM.width(), Dimensions.MEDIUM.height()));
				stage.show();
    		}
    	});
    }
    /**
    Isolates construction of the VBox	
    */
    private VBox getVbox(){
		return VBoxBuilder.create()
			.padding(new Insets(0, 10, 0, 10))
			.spacing(10)
			.alignment(Pos.CENTER)
			.style("-fx-background-color: pink; -fx-padding: 10; -fx-border-style: solid; -fx-border-width: 2px; -fx-border-color: black;")
			.build();
    }
    /**
    Isolates construction of the HBox	
    */
    private HBox getHbox(){
		return HBoxBuilder.create()
			.padding(new Insets(0, 10, 0, 10))
			.spacing(10)
			.fillHeight(true)
			.alignment(Pos.CENTER)
			.style("-fx-background-color: white; -fx-padding: 10; -fx-border-style: solid; -fx-border-width: 1px; -fx-border-color: black;")
			.build();    	
    }
    /**
    Isolates construction of the ScrollPane	
    */
    private ScrollPane getScrollPane(VBox vbox){	
    	return ScrollPaneBuilder.create()
			.fitToWidth(true)
			.fitToHeight(true)
			.prefViewportHeight(Dimensions.MEDIUM.height())
			.prefViewportWidth(Dimensions.MEDIUM.width())
			.content(vbox)
			.build();
    }
    /**
    	
    */
    private EventHandler<ActionEvent> getEventHandler(final TextField field, final Stage stage){
    	return new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event){
				String data = field.getText();
				Integer integer = new Integer(-1);
				if (data != null || !(data.isEmpty())){
					try{
						integer = Integer.decode(data);
					}
					catch(NumberFormatException e){
						field.setStyle("-fx-border-style: solid; -fx-border-width: 2px; -fx-border-color: red;");
						PopupMessage.showPopup("Please enter either a positive integer, or zero.", "Got it! Thanks!", stage);
						return;
					}
				}
				
			}
		};
    }
}