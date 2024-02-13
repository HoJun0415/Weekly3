import java.util.ArrayList;
import java.util.List;

public class AddressBook {
    private List<Contact> contacts = new ArrayList<>();

    public void displayContacts() {
        System.out.println();

        for (Contact contact : contacts) {
            System.out.println(contact.toString());
        } System.out.println();
    }

    public boolean searchContact(String name) {
        int cnt = 0;

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equals(name)) {
                cnt++;
                System.out.println(contacts.get(i));
            }
        }

        if (cnt == 0)
            return false;

        return true;
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }


}
