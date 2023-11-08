package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	//declaration
	
	@FindBy(xpath = "//h1[normalize-space(text())='Users']")
	private WebElement pageHeader;

	
	@FindBy(xpath = "//a[text()=' New']")
	private WebElement plusNewButton;
	

	
	@FindBy(xpath = "//ul[@class=\"pagination\"]/li[last()-1]/a")
	private WebElement userListLastPage;
	

	
	@FindBy(xpath = "//table/tbody/tr[last()]/td[3]")
	private WebElement lastUser;
	
	@FindBy(xpath = "//h4[text()='Success!']")
	private WebElement successMessage;
	
	//initialization
	  public UsersPage(WebDriver driver) {
		  PageFactory.initElements(driver, this);
		
	}
	  //utilization
	  public String getPageHeader() {
		  return pageHeader.getText();
		  
		
	}
		public void clickNewButton() {
			plusNewButton.click();
			
		}
		public  void clickUserListLastPage() {
			userListLastPage.click();
			
		}
		public String getUserName() {
			return lastUser.getText();
			
		}
		public String getSuccessMessage() {
			 return successMessage.getText();
		}
	}


