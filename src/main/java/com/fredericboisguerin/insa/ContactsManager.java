package com.fredericboisguerin.insa;
import java.util.ArrayList;

public class ContactsManager {

    public ContactsManager() {
        this.contactsList = new ArrayList<Contact>();
    }

    private ArrayList<Contact> contactsList;

    public void addContact(String name, String email, String phoneNumber) throws InvalidContactNameException, InvalidEmailException {
        if(name == null || name=="") {
            throw new InvalidContactNameException();
        } else if (email != null && !email.contains("@")) {
            throw new InvalidEmailException();
        }

        Contact contactAjoute = new Contact(name,email,phoneNumber);
        this.contactsList.add(contactAjoute);
    }

    public void printAllContacts() {
        for (Contact c : this.contactsList ) {
            System.out.println(c.toString());
        }
    }

    public void searchContactByName(String name) {
        for (Contact c : this.contactsList ) {
            if (c.getName().toUpperCase().contains(name.toUpperCase())) {
                System.out.println(c.toString());
            }
        }
    }
}
