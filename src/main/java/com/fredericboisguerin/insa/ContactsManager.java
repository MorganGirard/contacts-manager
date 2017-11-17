package com.fredericboisguerin.insa;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactsManager {

    public ContactsManager() {
        this.contactsList = new ArrayList<Contact>();
    }

    private List<Contact> contactsList;

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

    public void saveTo(String fileName) throws IOException {
        try {
            Writer writer = new FileWriter(fileName);
            StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
            beanToCsv.write(contactsList);
            writer.close();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        }
    }

    public void readFrom(String fileName) throws FileNotFoundException {
        Reader reader = new FileReader(fileName);
        contactsList = new CsvToBeanBuilder(reader).withType(Contact.class).build().parse();
    }
}
