package com.billhorvath.radiatrix.util;

import java.io.*;
import java.nio.*;
import java.net.*;
import com.billhorvath.radiatrix.types.*;

/**

*/
public class IOHandler{
	
	private static final IOHandler instance = new IOHandler();

	/**

	*/
	private IOHandler(){

	}
	
	/**
	Returns a singleton instance of IOHandler
	*/
	public static IOHandler getInstance(){
		return instance;
	}
	/**
		
	*/
	public DataSet load(IOType type, URI location){
		assert type != null;
		assert location != null;
		
		String scheme = location.getScheme();
		assert scheme != null;
		
		

		switch(type){
			case XML:
				break;
		}

		return null;
	}
}