package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

	@Test
	public void testContactModification() {
		if (! app.getContactHelper().isThereAContact()) {
			app.getContactHelper().createContact(new ContactData("Name", "Middle", "Last", "Nickname", "Mrs", "Inc", "Test", "test1"), true);
			app.getNavigationHelper().goToHomePage();
		}
		app.getContactHelper().editContact();
		app.getContactHelper().fillContactForm(new ContactData("Name", "Middle", "Last", "Nickname", "Mrs", "Inc", "Test", null), false);
		app.getContactHelper().submitContactModification();
	}

}
