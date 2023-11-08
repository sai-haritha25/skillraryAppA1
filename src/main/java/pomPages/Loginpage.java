package pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	
	
	//declaration
	@FindBy(xpath = "//h3[text()='Login']")
	private WebElement pageHeader;
	
	@FindBy(id="email")
	private WebElement emailTF;
	
	@FindBy(id ="password")
	private WebElement passwordTF;
	
	@FindBy(name = "login")
	private WebElement loginButton;
	
	//initialization
	public  Loginpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}
//utilization
	public String getPageHeader() {
		return pageHeader.getText();
		
		
	}
	public void setEmail(String email) {
		emailTF.sendKeys(email);
		
	}
	public void setPassword(String password) {
		passwordTF.sendKeys(password);
		
	}
	public void ClickLogin() {
		loginButton.submit();
		
	}
}
