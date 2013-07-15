package com.billhorvath.radiatrix.util;

import javafx.scene.*;
import javafx.scene.control.*;
import javafx.collections.*;

/**
	
*/

public final class Nodes{
	
	/**
	This is a class of utility methods which cannot be instantiated.	
	*/
	private Nodes(){}
	
	/**
	Finds and returns a specific node in a graph whose ID is equal to <code>id</code>, or <code>null</code> if no such node is found.
	
	<p>This method looks at the scene graph starting at {@link Node node}, and traverses down through it, looking for a node with an ID equal to <code>id</code>.</p> It returns the first such occurrence, which may be the submitted <code>node</code> parameter itself.
	@param node The node at which the search should begin.
	@param id The ID of the node to search for.
	@return A node whose ID is equal to <code>id</code>, or <code>null</code> if no such node is found in the graph.
	*/	
	public static Node findNode(Node node, String id){

    	String str = node.getId();
    	if (str != null){
    		if (str.equals(id)) return node;
    	}
		//Might need to add locally scoped node variable; e.g. Node result = node;

		if (node instanceof ScrollPane){
			node = ((ScrollPane)node).getContent();
			node = findNode(node, id);
			if (node != null) return node;
		}
		else if (node instanceof Parent){
			Parent parent = (Parent)node;
			ObservableList<Node> children = parent.getChildrenUnmodifiable();
			for (Node child: children){
				node = findNode(child, id);
				if (node != null) return node;
			}
		}
		return null;
	}
	
	/**
	Since this class will never be instantiated, this method will always return -1.	
	@return <code>-1</code>.
	*/
	
	public int hashCode(){
		return -1;
	}
	
	/**
	Since this class will never be instantiated, this method will always return false.
	@return <code>false</code>.
	*/
	
	public boolean equals(Object obj){
		return false;
	}
	
	/**
	Since this class will never be instantiated, this method will always return null.
	@return <code>null</code>.
	*/

	public String toString(){
		return null;
	}	
}