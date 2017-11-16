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
            String affichage = "";
            if (c.getName() != null) {
                affichage += c.getName() + ", ";
            }
            if (c.getEmail() != null) {
                affichage += c.getEmail() + ", " ;
            }
            if (c.getPhoneNumber() != null) {
                affichage += c.getPhoneNumber() + ", ";
            }

            String affichageFinal = affichage.substring(0,affichage.length()-2);
            System.out.println(affichageFinal);
        }
    }

    public void searchContactByName(String name) {
        for (Contact c : this.contactsList ) {
            if (c.getName().toUpperCase().contains(name.toUpperCase())) {
                String affichage = "";
                if (c.getName() != null) {
                    affichage += c.getName() + ", ";
                }
                if (c.getEmail() != null) {
                    affichage += c.getEmail() + ", ";
                }
                if (c.getPhoneNumber() != null) {
                    affichage += c.getPhoneNumber() + ", ";
                }

                String affichageFinal = affichage.substring(0,affichage.length()-2);
                System.out.println(affichageFinal);
            }
        }
    }
}
