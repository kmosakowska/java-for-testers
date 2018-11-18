package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTests extends TestBase {

	@Test
	public void testContactCreation() throws Exception {
		initContactCreation();
		fillContactForm(new ContactData("Name", "Middle", "Last", "Nickname", "Mrs", "Inc", "Test"));
		submitContactForm();
	}
}