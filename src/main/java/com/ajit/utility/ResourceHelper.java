package com.ajit.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.log4j.Logger;

import com.ajit.testBase.BaseTest;

public class ResourceHelper {
	private static Logger log = Logger.getLogger(ResourceHelper.class);
	
	public static String getResourcePath(String resource){
		String path = getBaseResourcePath()+"\\src\\main\\resources"+resource;
		log.info("full path is: "+path);
		return path;
	}

	private static String getBaseResourcePath() {
		// uer.dir will give us project location
		// C:\Users\ajit_\workspace\GNC_PROJECT
		String path = System.getProperty("user.dir");
		System.out.println(path);
		return path;
	}
	
	public static InputStream getResourcePathInputStream(String path) throws FileNotFoundException{
		return new FileInputStream(ResourceHelper.getResourcePath(path));
	}

}
