package com.billhorvath.radiatrix;
/**
Starts and runs the Radiatrix data visualization tool.

@author Bill Horvath II
@version 1.0
*/
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.application.*;
import javafx.event.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.fxml.*;
import java.net.*;
import java.util.*;
import com.billhorvath.radiatrix.view.*;

public class Radiatrix{

	
	/**
	
	*/
	public Radiatrix(){}


    public static void main(String[] args) {
        Application.launch(OpeningScene.class, args);
    }
    /**
		
	*/
// 	public static void main(String[] args){
// 		if (args == null || args.length == 0){
// 			//Show the data model creation and input tool
// 		}
// 		else{
// 			//Data is coming from the command line
// 			//Assumes each element in args is a string representation of a tuple
// 			//Assumes the string representation is of the following format:
// 			//tupleName1,measurementNameA:measurement,measurementNameB:measurement,...measurementNameN:measurement
// 			//tupleName2,measurementNameA:measurement,measurementNameB:measurement,...measurementNameN:measurement
// 			//tupleName3,measurementNameA:measurement,measurementNameB:measurement,...measurementNameN:measurement
// 			for (int i = 0; i < args.length; i++){
// 				String[] dataArr = args[i].split(",");
// 			}
// 			Radiatrix radiatrix = null;
// 		}
// 	}
}