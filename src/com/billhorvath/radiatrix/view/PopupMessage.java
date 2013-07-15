package com.billhorvath.radiatrix.view;

import javafx.scene.control.*;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.shape.*;
import javafx.scene.paint.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import com.billhorvath.radiatrix.controller.*;

/**
A class for displaying popup messages.
*/
public class PopupMessage{
	
	/**
	Displays a popup message that shows the submitted <code>message</code> and a button labeled <code>buttonText</code> over the provided <code>stage</code>. The button serves to close the popup.
	@param message The text message to display in the popup.
	@param buttonText The content of the text label on the button.
	@param stage The stage serving as the owner of the popup.
	*/
	public static void showPopup(String message, String buttonText, Stage stage){

		Text text = TextBuilder.create()
			.text(message)
			.build();
		Button button = ButtonBuilder.create()
			.text(buttonText)
			.build();
		button.setOnAction(new CloseWindowController());
		
		VBox vbox = VBoxBuilder.create()
			.padding(new Insets(0, 10, 0, 10))
			.spacing(10)
			.alignment(Pos.CENTER)
			.style("-fx-background-color: yellow; -fx-padding: 10; -fx-border-style: solid; -fx-border-width: 2px; -fx-border-color: black;")
			.build();
		vbox.getChildren().addAll(text, button);

		PopupBuilder.create()
			.content(vbox)
			.opacity(1.0)
			.build()
			.show(stage);
	}
}