package com.recipe.RecipeHandler.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TimeUtil {

//Signals that a method has been invoked at an illegal or inappropriate time. 
//In other words, the Java environment or Java application is not in an appropriate state for the requested operation.	
	private TimeUtil() {
		throw new IllegalStateException("Time Utility class");
	}

	public static String getTime() {

		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		return now.format(format);
	}

}
