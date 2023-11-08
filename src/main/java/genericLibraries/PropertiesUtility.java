package genericLibraries;
/**
 * this class contains reusable methods to read data from properties file
 * @author haritha
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	
	private Properties  property;
	
	/**
	 * this method is used to initialize properties file
	 * 
	 */
	public void propertiesInitialization(String filePath)
	{
		FileInputStream fis=null;
		try {
			 fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
	}
	public String readFromProperties(String key) {
		return property.getProperty(key);
	}

}
