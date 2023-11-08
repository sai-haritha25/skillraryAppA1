package testScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateUserTest extends BaseClass {
	
	
	@Test
	public void createUserTest() {
		SoftAssert soft = new SoftAssert();
		home.clickUsersTab();
		soft.assertTrue(users.getPageHeader().contains("users"));
		
		users.clickNewButton();
		
		soft.assertEquals(adduser.getPageHeader(),"add new user");
		Map<String, String> map= excel.readFromExcel("sheet1", "add user");
		
		adduser.createNewUser(map.get("Email"), map.get("password"),map.get("FirstName"),
				map.get("LastName"),map.get("Address"),map.get("contact Info"),map.get("photo"));
		soft.assertTrue(users.getSuccessMessage().Contains("success"));
		
		if(course.getSuccessMessage().contains("success"));
		{
		excel.writeToexcel("sheet1", "add ", "pass", IConstantPath.EXCEL_PATH);
		}
		else
		{
			excel.writeToexcel("sheet1", "add ", "fail", IConstantPath.EXCEL_PATH);
			
		}
		soft.assertAll();
	}
	

}
