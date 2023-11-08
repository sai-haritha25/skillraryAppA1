package testScripts;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class CreateCategoryTest  extends BaseClass{
	
	@Test
	public  void createcategoryTest() throws InterruptedException   {
		
		SoftAssert soft= new SoftAssert();
		home.clickCourseTab();
		home.clickCategoryLink();
		soft.assertTrue(category.getPageHeader().contains("category"));
		
		category.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(addcategory.getPageHeader(), "add new category");
		
		Map<String, String>map= excel.readFromExcel("sheet1","add category");
		String categoryName= map.get("Name")+jutil.generateRandomNum(100);
		addcategory.setName(categoryName);
		addcategory.clickSave();
		
		soft.assertTrue(category.getSuccessMessage().contains("success"));
		boolean ispresent = false;
		List<WebElement>categoryList=category.getCategoryList();
		for (WebElement e :categoryList) {
			if(e.getText().equals(categoryName)) {
				ispresent = true;
				break;
			}
		}
		soft.assertTrue(ispresent);
		category.clickDeleteButton(categoryName, driver);
		category.clickDelete();
		soft.assertTrue(category.getSuccessMessage().contains("success"));
		soft.assertAll();
		
	}
	

}
