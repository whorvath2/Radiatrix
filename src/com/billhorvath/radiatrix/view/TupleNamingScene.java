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
import javafx.beans.value.*;
import java.util.*;
import com.billhorvath.radiatrix.controller.*;
import com.billhorvath.radiatrix.types.impl.*;
import com.billhorvath.radiatrix.types.*;


/**
Provides a means of entering the raw data to be displayed in the Radiatrix.
*/

public class TupleNamingScene{
	
	private final DataSetBuilder builder;
	
	/**
	
	*/
	public TupleNamingScene(DataSetBuilder builder){
		this.builder = builder;
	}
	
	/**
	
	*/
    public void start(final Stage stage) throws Exception {
    	Platform.runLater(new Runnable(){
    		public void run(){
				Text title = new Text("Tuple names for " + builder.name());
				VBox vbox = getVbox();
				ObservableList<Node> vchildren = vbox.getChildren();
				vchildren.add(title);
				
				final int numTuples = builder.numberOfTuples();
				final List<String> tupleNames = new ArrayList<String>(numTuples);
				for (int i = 0; i < numTuples; i++){
					HBox hbox = getHbox();
					ObservableList<Node> hchildren = hbox.getChildren();

					final int num = i + 1;
					String str = "Name of tuple " + String.valueOf(num) + ": ";

					Text text = new Text(str);
					hchildren.add(text); 

					final TextField nameField = new TextField(String.valueOf(num));
					hchildren.add(nameField);
					ChangeListener listener = new ChangeListener<String>(){
						@Override
						public void changed(ObservableValue<? extends String> observable,
							String oldValue, String newValue){
							
							String tupleName = nameField.getText().trim();
							if(tupleName == null || tupleName.isEmpty()){
								tupleName = "Tuple " + num;
							}
							if (oldValue != null){
								tupleNames.remove(oldValue);
							}
							tupleNames.add(num, tupleName);
						}
					};
					nameField.textProperty().addListener(listener);
					vchildren.add(hbox);
				}
				Button button = new Button("Done Naming Tuples");
				button.onActionProperty().addListener(new ChangeListener<EventHandler<ActionEvent>>(){
					@Override
					 public void changed(ObservableValue<? extends EventHandler<ActionEvent>> observable, EventHandler<ActionEvent> oldValue, EventHandler<ActionEvent> newValue){
					 	if (tupleNames.isEmpty()){
					 		for (int i = 0; i < numTuples; i++){
					 			tupleNames.add(i, "Tuple " + (i +1));
					 		}
					 	}
						builder.tupleNames(tupleNames);
					 }
				});
				button.setOnAction(new ShowTupleSetupController(builder));
				vchildren.add(button);
				
				Group group = new Group();
				ScrollPane pane = getScrollPane(vbox);
				group.getChildren().add(pane);
				stage.setTitle("Data Entry");
				stage.setScene(new Scene(group, Dimensions.LARGE.width(), Dimensions.MEDIUM.height()));
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
			.prefViewportHeight(Dimensions.LARGE.height())
			.prefViewportWidth(Dimensions.LARGE.width())
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