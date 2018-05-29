package com.ajit.helper.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.ajit.utility.ResourceHelper;

public class LoggerHelper {
	
	private static boolean root = false;
	@SuppressWarnings("rawtypes")
	public static Logger getLogger( Class clas) {
		if(root){
			return Logger.getLogger(clas);	
		}
		//PropertyConfig
		PropertyConfigurator.configure(ResourceHelper.getResourcePath("\\projectConfig\\log4j.properties"));
		root = true;
		return Logger.getLogger(clas);
		
	}

}
