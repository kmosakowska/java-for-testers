package ru.stqa.pft.addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
	WebDriver wd;

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

	protected void returnToGroupPage() {
		wd.findElement(By.linkText("group page")).click();
	}

	protected void submitGroupCreation() {
		wd.findElement(By.name("submit")).click();
	}

	protected void fillGroupForm(GroupData groupData) {
		wd.findElement(By.name("group_name")).click();
		wd.findElement(By.name("group_name")).clear();
		wd.findElement(By.name("group_name")).sendKeys(groupData.getName());
		wd.findElement(By.name("group_header")).click();
		wd.findElement(By.name("group_header")).clear();
		wd.findElement(By.name("group_header")).sendKeys(groupData.getHeader());
		wd.findElement(By.name("group_footer")).click();
		wd.findElement(By.name("group_footer")).clear();
		wd.findElement(By.name("group_footer")).sendKeys(groupData.getFooter());
	}

	protected void initGroupCreation() {
		wd.findElement(By.name("new")).click();
	}

	protected void goToGroupPage() {
		wd.findElement(By.linkText("groups")).click();
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		logout();
		wd.quit();
	}

	private void logout() {
		wd.findElement(By.linkText("Logout")).click();
	}

	public boolean isElementPresent(By by) {
	  try {
		wd.findElement(by);
		return true;
	  } catch (NoSuchElementException e) {
		return false;
	  }
	}

	public boolean isAlertPresent() {
	  try {
		wd.switchTo().alert();
		return true;
	  } catch (NoAlertPresentException e) {
		return false;
	  }
	}

	protected void deleteSelectedGroups() {
		wd.findElement(By.name("delete")).click();
	}

	protected void selectGroup() {
		wd.findElement(By.name("selected[]")).click();
	}

	protected void submitContactForm() {
		wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
	}

	protected void fillContactForm(ContactData contactData) {
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

	protected void initContactCreation() {
		wd.findElement(By.linkText("add new")).click();
	}
}
