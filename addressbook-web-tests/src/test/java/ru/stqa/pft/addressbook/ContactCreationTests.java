package ru.stqa.pft.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ContactCreationTests extends TestBase {
	private WebDriver wd;


	@BeforeMethod(alwaysRun = true)
	public void setUp() {
		wd = new FirefoxDriver();
		wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		wd.get("http://localhost/addressbook/group.php");
		login("admin", "secret");
	}

	private void login(String username, String password) {
		wd.findElement(By.name("user")).click();
		wd.findElement(By.name("user")).clear();
		wd.findElement(By.name("user")).sendKeys(username);
		wd.findElement(By.name("pass")).clear();
		wd.findElement(By.name("pass")).sendKeys(password);
		wd.findElement(By.id("LoginForm")).submit();
	}

	@Test
	public void testContactCreation() {
		initContactCreation();
		fillContactForm(new ContactData("Name", "Middle", "Last", "Nickname", "Mrs", "Inc", "Test"));
		submitContactForm();
	}

	private void submitContactForm() {
		wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
	}

	private void fillContactForm(ContactData contactData) {
		wd.findElement(By.name("firstname")).click();
		wd.findElement(By.name("firstname")).clear();
		wd.findElement(By.name("firstname")).sendKeys(contactData.getFirstname());
		wd.findElement(By.name("middlename")).clear();
		wd.findElement(By.name("middlename")).sendKeys(contactData.getMiddlename());
		wd.findElement(By.name("lastname")).clear();
		wd.findElement(By.name("lastname")).sendKeys(contactData.getLastname());
		wd.findElement(By.name("nickname")).clear();
		wd.findElement(By.name("nickname")).sendKeys(contactData.getNickname());
		wd.findElement(By.name("title")).clear();
		wd.findElement(By.name("title")).sendKeys(contactData.getTitle());
		wd.findElement(By.name("company")).clear();
		wd.findElement(By.name("company")).sendKeys(contactData.getCompany());
		wd.findElement(By.name("address")).clear();
		wd.findElement(By.name("address")).sendKeys(contactData.getAddress());
	}

	private void initContactCreation() {
		wd.findElement(By.linkText("add new")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		logout();
		wd.quit();
	}

	private void logout() {
		wd.findElement(By.linkText("Logout")).click();
	}
}

