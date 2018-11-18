package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

	@Test
	public void testContactModification() {
		app.getContactHelper().editContact();
		app.getContactHelper().fillContactForm(new ContactData("Name", "Middle", "Last", "Nickname", "Mrs", "Inc", "Test"));
		app.getContactHelper().submitContactModification();
	}

}
