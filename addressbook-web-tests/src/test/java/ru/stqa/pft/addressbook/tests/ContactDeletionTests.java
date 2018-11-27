package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

public class ContactDeletionTests extends TestBase {

	@Test
	public void testContactDeletion() {
		if (!app.getContactHelper().isThereAContact()) {
			app.getNavigationHelper().goToGroupPage();
			if (! app.getGroupHelper().isThereAGroup()) {
				app.getGroupHelper().createGroup(new GroupData("test1", null, null));
			}
			app.getNavigationHelper().goToHomePage();
			app.getContactHelper().createContact(new ContactData("Name", "Middle", "Last", "Nickname", "Mrs", "Inc", "Test", "test1"), true);
			app.getNavigationHelper().goToHomePage();
		}
		app.getContactHelper().selectContact();
		app.getContactHelper().deleteSelectedContact();
		app.getContactHelper().acceptContactDeletion();
	}
}
