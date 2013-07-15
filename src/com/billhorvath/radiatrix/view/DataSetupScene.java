package com.billhorvath.radiatrix.view;

import com.billhorvath.radiatrix.*;
import com.billhorvath.radiatrix.model.*;
import com.billhorvath.radiatrix.types.*;
import com.billhorvath.radiatrix.types.impl.*;
import javafx.scene.*;
import javafx.application.*;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.fxml.*;

/**
Provides the window that allows the data setup tool to be rendered.
*/

public class DataSetupScene extends Application{
	
	private Stage stage;
	private static DataSetupScene viewer;
	
	/**
	Set up the static viewer field so it's accessible down the road.	
	*/
	@Override
	public void init(){
		assert viewer == null;
		this.viewer = this;
		this.stage = null;
	}
	/**
	
	*/
    @Override
    public void start(Stage stage) throws Exception {
    	this.stage = stage;
    	setScene(SceneResource.DATASET_SETUP);
    }
    /**
    Sets the scene. This method loads the file designated by the <code>resource</code> parameter, and renders its contents into the main Radiatrix window.
    @param resource The name of the file containing the scene to be loaded.
    */
    public void setScene(final SceneResource resource) throws Exception{
    	//assert this is the FX Application Thread
		Platform.runLater(new Runnable(){
			public void run(){
				try{
					Parent parent = resource.group();
// 					Parent parent = FXMLLoader.load(Radiatrix.class.getResource("resources/" + resource.fileName()));
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
    }
    
    /**
    Returns this application's singleton instance so it's scene can be manipulated.
    @return This application's instance.
    */
    public static DataSetupScene getViewer(){
    	assert viewer != null;
    	return viewer;
    }
}

