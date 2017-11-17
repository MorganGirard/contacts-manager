package com.fredericboisguerin.insa;

import java.io.Serializable;

public class Contact implements Serializable {
    private String name;
    private String email;
    private String phoneNumber;

    public Contact() {}

    public Contact(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName () {
        return this.name;
    }

    public void setName(String name) { this.name = name; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) { this.email = email; }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    @Override
    public String toString() {
        String affichage = "";
        if (getName() != null) {
            affichage += getName() + ", ";
        }
        if (getEmail() != null) {
            affichage += getEmail() + ", ";
        }
        if (getPhoneNumber() != null) {
            affichage += getPhoneNumber() + ", ";
        }

        return affichage.substring(0,affichage.length()-2);
    }
}
