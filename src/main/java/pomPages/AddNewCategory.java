package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//this is addnewcategory
public class AddNewCategory {
	
	@FindBy(xpath = "//b[text()='Add New Category']")
	private WebElement pageHeader;
	
	@FindBy(id= "name")
	private WebElement nameTF;
	
	@FindBy(xpath = "//button[@name='add']")
	private WebElement saveButton;
	
	//initialization
    public AddNewCategory(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}
	//utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}
	public void setName(String categoryName) {
		nameTF.sendKeys(categoryName);
		
	}
		public void clickSave() {
			saveButton.click();
			
		}
	}


