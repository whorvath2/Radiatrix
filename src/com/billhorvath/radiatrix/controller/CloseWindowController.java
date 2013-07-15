package com.billhorvath.radiatrix.controller;

import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.stage.*;

/**
Closes the window containing the button to which this event handler is added.
*/

public class CloseWindowController implements EventHandler<ActionEvent>{
	
	/**
	Closes (and nullifies) the window containing the node which is the source of <code>event</code>.

	@param event The event to be handled.
	*/
	@Override
	public void handle(ActionEvent event){
		Node node = (Node)event.getSource();
		Window win = node.getScene().getWindow();
		win.hide();
		win = null;
	}
}