package com.fredericboisguerin.insa;

public class Contact {
    private String name;
    private String email;
    private String phoneNumber;

    public Contact(String name, String email, String phoneNumber) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName () {
        return this.name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

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
