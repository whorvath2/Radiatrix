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

public class DataEntryScene{
	
	private final DataSetBuilder builder;
	
	/**
	
	*/
	public DataEntryScene(DataSetBuilder builder){
		this.builder = builder;
	}
	
	/**
	
	*/
    public void start(final Stage stage) throws Exception {
    	Platform.runLater(new Runnable(){
    		public void run(){
				Text title = new Text("Data entry for " + builder.name());
				VBox vbox = getVbox();
				ObservableList<Node> vchildren = vbox.getChildren();
				vchildren.add(title);
				
				int numTuples = builder.numberOfTuples();
				List<String> tupleNames = new ArrayList<String>(builder.tupleNames());
				final Map<String, Map<String, Number>> tupleMap = new HashMap<String, Map<String, Number>>(numTuples);
				
				for (int i = 0; i < numTuples; i++){
					String str = tupleNames.get(i);
					if (str == null) str = "Tuple " + String.valueOf(i + 1) + ": ";
					final String tupleName = str;

					Text text = new Text(str);
					vchildren.add(text); //vbox because we want this above the data fields

					HBox hbox = getHbox();
					ObservableList<Node> hchildren = hbox.getChildren();

					int num = 0;
					Map<String, String> measureNamesAndAbbr = builder.measureNamesAndAbbr();
					
					final Map<String, Number> numberMap = new HashMap<String, Number>(measureNamesAndAbbr.size());
					
					for (final String measName : measureNamesAndAbbr.keySet()){
						num++;
						text = new Text(measName + ": ");
						hchildren.add(text);

						final TextField dataField = new TextField();
						dataField.setOnAction(getEventHandler(dataField, stage));
						hchildren.add(dataField);

						ChangeListener listener = new ChangeListener<String>(){
							@Override
							public void changed(ObservableValue<? extends String> observable,
								String oldValue, String newValue){

								String data = dataField.getText();
								Double dbl = new Double(0);
								try{
									dbl = new Double(data);
								}
								catch(NumberFormatException e){
									dataField.setStyle("-fx-border-style: solid; -fx-border-width: 2px; -fx-border-color: red;");
									PopupMessage.showPopup("Please enter either a positive integer, or zero.", "Got it! Thanks!", stage);
									return;
								}								
								
								numberMap.put(measName, dbl);
							}
						};
						tupleMap.put(tupleName, numberMap);
						dataField.textProperty().addListener(listener);

						
						String abbr = measureNamesAndAbbr.get(measName);
						if (abbr == null) abbr = "";
						hchildren.add(new Text(abbr));
						
					}
					vchildren.add(hbox);
				}
				Button button = new Button("Show Me The Radiatrix!");
				button.onActionProperty().addListener(new ChangeListener<EventHandler<ActionEvent>>(){
					@Override
					 public void changed(ObservableValue<? extends EventHandler<ActionEvent>> observable, EventHandler<ActionEvent> oldValue, EventHandler<ActionEvent> newValue){
						builder.measurements(tupleMap);
					}
				});

				
				button.setOnAction(new ShowRadiatrixController(builder)); //TODO
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
//			.fitToWidth(true)
//			.fitToHeight(true)
			.prefViewportHeight(Dimensions.LARGE.height())
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