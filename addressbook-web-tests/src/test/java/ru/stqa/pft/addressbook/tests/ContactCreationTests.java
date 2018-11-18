package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() throws Exception {
		app.initContactCreation();
		app.fillContactForm(new ContactData("Name", "Middle", "Last", "Nickname", "Mrs", "Inc", "Test"));
		app.submitContactForm();
	}
}
