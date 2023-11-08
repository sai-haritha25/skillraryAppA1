package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pomPages.AddNewCategory;
import pomPages.AddNewCoursePage;
import pomPages.AddNewUserPage;
import pomPages.AdminHomePage;
import pomPages.CategoryPage;
import pomPages.CourseListPage;
import pomPages.Loginpage;
import pomPages.UsersPage;
import pomPages.WelcomePage;

public class BaseClass {

	// @Beforesuite
	// @BeforeTest

	protected PropertiesUtility property;
	

	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebDriverUtility webUtil;
	protected WebDriver driver;

	public static WebDriver sdriver;
	public static JavaUtility sjutil;

	protected WelcomePage welcome;
	protected Loginpage login;
	protected AdminHomePage home;
	protected UsersPage users;
	protected CourseListPage course;
	protected CategoryPage category;
	protected AddNewUserPage adduser;
	protected AddNewCoursePage addcourse;
	protected AddNewCategory addcategory;

	@BeforeClass
	public void classConfig() {
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		jutil = new JavaUtility();
		webUtil = new WebDriverUtility();

		property.propertiesInitialization(IConstantPath.PROPERTIES_PATH);
		driver = webUtil.launchBrowser(property.readFromProperties("browser"));

		sdriver = driver;
		sjutil = jutil;

	}

	@BeforeMethod
	public void methodConfig() {
		excel.excelInitialization(IConstantPath.EXCEL_PATH);
		welcome = new WelcomePage(driver);
		login = new Loginpage(driver);
		home = new AdminHomePage(driver);
		users = new UsersPage(driver);
		course = new CourseListPage(driver);
		category = new CategoryPage(driver);
		adduser = new AddNewUserPage(driver);
		addcourse = new AddNewCoursePage(driver);
		addcategory = new AddNewCategory(driver);

		webUtil.navigateToApp(property.readFromProperties("url"));
		Assert.assertEquals(welcome.getLogo(), "skillRary_ECommerce");

		long time = Long.parseLong(property.readFromProperties("timeouts"));
		webUtil.waitTillElementFound(time);

		welcome.clickLoginButton();
		Assert.assertEquals(login.getPageHeader(), "Login");
		login.setEmail(property.readFromProperties("username"));
		login.setPassword(property.readFromProperties("password"));
		login.ClickLogin();
		Assert.assertEquals(home.getAdminIcon(), "skillRary Admin");

	}

	@AfterMethod
	public void methodTeardown() {
		excel.closeExcel();
		home.clickSignoutLink();

	}

	@AfterClass
	public void classTeardown() {
		webUtil.closeAllWindows();
		// @AfterTest
		// @AfterSuite

	}
}


