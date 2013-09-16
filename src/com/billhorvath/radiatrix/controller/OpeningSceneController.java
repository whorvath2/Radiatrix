package com.billhorvath.radiatrix.controller;

import com.billhorvath.radiatrix.view.*;
import com.billhorvath.radiatrix.util.*;
import java.io.*;
import java.net.*;
import java.util.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.*;
// import javafx.scene.shape.*;
import javafx.scene.paint.*;
// import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.collections.*;

/**

*/
public class OpeningSceneController implements Initializable{

	@FXML
	private Button createData, openData, exit;
	
	/**
	
	*/
	public OpeningSceneController(){
	}	
	
	/**
		
	*/
	@Override
    public void initialize(URL fxmlFileLocation, ResourceBundle resources) {

		assert createData != null : "fx:id=\"createData\" was not injected: check FXML file 'OpeningScene.fxml'.";
		assert openData != null : "fx:id=\"openData\" was not injected: check FXML file 'OpeningScene.fxml'.";
		assert exit != null : "fx:id=\"exit\" was not injected: check FXML file 'OpeningScene.fxml'.";
		
		createData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
				Node node = (Node)event.getSource();
				Stage stage = (Stage)node.getScene().getWindow();
				try{
					Parent parent = SceneResource.DATASET_SETUP.group();
					Group root = new Group(parent);
					stage.setTitle("Radiatrix Columnar Dataset Visualization Tool");
					stage.setScene(new Scene(root, Dimensions.SMALL.width(), Dimensions.SMALL.height()));
					stage.show();
				}
				catch(Exception e){
					e.printStackTrace();
					assert false;
				}
			}
		});
		openData.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event){
				Node node = (Node)event.getSource();
				Stage stage = (Stage)node.getScene().getWindow();
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Select the Data File");
				File file = fileChooser.showOpenDialog(stage);
				if (file != null){
					IOHandler.getInstance().load(IOType.FILE, file.toURI());
				}
			}
		});
		exit.setOnAction(new CloseWindowController());
	}
}