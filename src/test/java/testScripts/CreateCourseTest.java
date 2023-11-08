package testScripts;

import java.util.List; 
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateCourseTest extends BaseClass {

	@Test
       public void createCourseTest() throws InterruptedException{
       SoftAssert soft = new SoftAssert();
       home.clickCourseTab();
       home.clickCourseListLink();
      
        soft.assertTrue(course.getPageHeader().contains("cousre List"));
        
        course.clickNewButton();
        Thread.sleep(2000);
        
        soft.assertEquals(addcourse.getPageHeader(),"add new course");
        
        Map<String, String> map = excel.readFromExcel("sheet1", "add course");
        String courseName = map.get("Name")+jutil.generateRandomNum(100);
        
        addcourse.setName(courseName);
        addcourse.selectcategory(webUtil, map.get("category"));
        addcourse.setPrice(map.get("price"));
        addcourse.uploadPhoto(map.get("photo"));
        
        addcourse.setDescription(webUtil, map.get("Description"));
        addcourse.clickSaveButton();
        
        soft.assertTrue(course.getSuccessMessage().contains("success"));
        
        boolean isPresent = false;
        
        List<WebElement> courseNameList=course.getCourseList();
        
        for(WebElement name : courseNameList)
        {
        	if(name.getText().equals(courseName));
        	{
        	isPresent=true;	
        	break;
            }
        
        }
       soft.assertTrue(isPresent);
       course.clickDeleteButton(courseName, driver);
       course.clickDelete();
       soft.assertTrue(course.getSuccessMessage().contains("success"));
       if(course.getSuccessMessage().contains("success"));
       {
    	   excel.writeToexcel("Sheet1", "Add Course", "Pass",IConstantPath.EXCEL_PATH);
       }
       else {
    	   excel.writeToexcel("Sheet1", "Add Course", "Fail",IConstantPath.EXCEL_PATH);
       }
        
       soft.assertAll();
	}

}
