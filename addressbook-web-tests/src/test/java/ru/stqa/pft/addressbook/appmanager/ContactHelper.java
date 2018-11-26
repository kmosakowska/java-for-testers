package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(WebDriver wd) {
		super(wd);
	}

	public void submitContactForm() {
		click(By.xpath("(//input[@name='submit'])[2]"));
	}

	public void fillContactForm(ContactData contactData, boolean creation) {
		type(By.name("firstname"), contactData.getFirstname());
		type(By.name("middlename"), contactData.getMiddlename());
		type(By.name("lastname"), contactData.getLastname());
		type(By.name("nickname"), contactData.getNickname());
		type(By.name("title"), contactData.getTitle());
		type(By.name("company"), contactData.getCompany());
		type(By.name("address"), contactData.getAddress());

		if (creation) {
			new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
		} else {
			Assert.assertFalse(isElementPresent(By.name("new_group")));
		}
	}

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void selectContact() {
		click(By.name("selected[]"));
	}

	public void deleteSelectedContact() {
		click(By.xpath("/html/body/div/div[4]/form[2]/div[2]/input"));
	}

	public void acceptContactDeletion() {
		acceptAlert();
	}

	public void editContact() {
		click(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
	}

	public void submitContactModification() {
		click(By.name("update"));
	}

	public void createContact(ContactData contact, boolean creation) {
		initContactCreation();
		fillContactForm(contact, creation);
		submitContactForm();
	}

	public boolean isThereAContact() {
		return isElementPresent(By.xpath("/html/body/div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img"));
	}
}
