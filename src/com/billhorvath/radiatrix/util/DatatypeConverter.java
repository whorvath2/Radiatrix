package com.billhorvath.radiatrix.util;

import java.util.concurrent.atomic.*;
import java.math.*;

/**

*/
public final class DatatypeConverter{
	
	/**
	This class shouldn't be instantiated outside of this package.
	*/
	private DatatypeConverter(){}
	/**
		
	*/
	public static Number parseNumber(String numberStr){
		int i = numberStr.indexOf(':');
		String className = numberStr.substring(0, i);
		className = className.substring(className.lastIndexOf('.'));

		String number = numberStr.substring(i, numberStr.length() - 1); //-1 to pop the semicolon off the end
		
		switch(className){
			case "AtomicInteger":
				int n = Integer.parseInt(number);
				return new AtomicInteger(n);
			case "AtomicLong":
				long l = Long.parseLong(number);
				return new AtomicLong(l);
			case "BigDecimal":
				return new BigDecimal(number);
			case "BigInteger":
				return new BigInteger(number);
			case "Byte":
				return new Byte(number);
			case "Double":
				return new Double(number);
			case "Float":
				return new Float(number);
			case "Integer":
				return new Integer(number);
			case "Long":
				return new Long(number);
			case "Short":
				return new Short(number);
			default:
				assert false;
				throw new RuntimeException("Great Scott! This should never have happened!");
		}
	}
	/**
		
	*/
	public static String printNumber(Number number){
	
		String result = number.getClass().getName();
		int i = result.lastIndexOf('.');
		
		switch(result.substring(i)){
			case "AtomicInteger":
				result += ':' + new AtomicInteger(number.intValue()).toString();
				break;
			case "AtomicLong":
				result += ':' + new AtomicLong(number.longValue()).toString();
				break;
			case "BigDecimal":
				result += ':' + BigDecimal.valueOf(number.longValue()).toString();
				break;
			case "BigInteger":
				result += ':' + BigInteger.valueOf(number.intValue()).toString();
				break;
			case "Byte":
				result += ':' + Byte.toString(number.byteValue());
				break;
			case "Double":
				result += ':' + Double.toString(number.doubleValue());
				break;
			case "Float":
				result += ':' + Float.toString(number.floatValue());
				break;
			case "Integer":
				result += ':' + Integer.toString(number.intValue());
				break;
			case "Long":
				result += ':' + Long.toString(number.longValue());
				break;
			case "Short":
				result += ':' + Short.toString(number.shortValue());
				break;
			default:
				assert false;
				throw new RuntimeException("Honey, I broke the software!");
		}
		result += ';';
		return result;
	}
}
