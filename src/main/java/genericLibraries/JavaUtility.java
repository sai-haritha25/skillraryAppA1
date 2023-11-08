package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * this class contains reusable methods of java
 * @author Naveen
 *
 */

public class JavaUtility {
	/**
	 * this method generate random number within the specified limit 
	 * @param limit
	 * @return
	 */
	
	public int generateRandomNum(int limit) {
		Random random = new Random();
		return random.nextInt(limit);
		
	}
/**
 * this method generate current time
 */
	
	public String getcurrentTime() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MM_yy_hh_mm_ss");
		
		return sdf.format(date);
		
	}
}
