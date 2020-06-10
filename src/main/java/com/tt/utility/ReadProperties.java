package com.tt.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

//import org.eclipse.jetty.util.Loader;

public class ReadProperties {
	/*String result = "";
	InputStream input = null;
	static Properties prop = new Properties();*/
	static Properties prop = new Properties();
	static InputStream input = null;
	public static String getPropValues(String propFileName, String ObName) throws IOException {

		try {
			// Properties prop = new Properties();
			// String propFileName = "config.properties";
			//InputStream stream = Loader.class.getResourceAsStream("/myProp.properties");
			input = new FileInputStream(System.getProperty("user.dir") + "\\Config\\"+propFileName);

			 //InputStream FilePath = Loader.class.getClassLoader().getResourceAsStream(propFileName);
			//System.out.println(input);
			 prop.load(input);
			/*if (FilePath != null) {
				prop.load(FilePath);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
*/
			Date time = new Date(System.currentTimeMillis());

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} 
		String ObValue = prop.getProperty(ObName);
		return ObValue;
	}

}
