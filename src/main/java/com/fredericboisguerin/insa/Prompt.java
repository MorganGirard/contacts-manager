package com.fredericboisguerin.insa;

import java.util.Scanner;

public class Prompt {
    private ContactsManager cm;
    private Scanner sc;

    private void ajouterContact() {
        System.out.println("Ajouter le nom du contact puis l'email puis le numero de telephone");
        try {
            cm.addContact(sc.next(),sc.next(),sc.next());
        } catch (InvalidContactNameException e) {
            System.out.println("Nom de contact invalide");
        } catch (InvalidEmailException e) {
            System.out.println("Email du contact invalide");
        }
    }

    private void afficherContacts() {
        cm.printAllContacts();
    }

    private void afficherContact(String nom) {
        System.out.println("Veuillez donner le nom de la personne recherchée");
        cm.searchContactByName(nom);
    }

    public void mainLoop() {
        cm = new ContactsManager();
        sc = new Scanner(System.in);

        System.out.println("> ");
        String command = sc.next();
        while(!command.equals("quit")) {
            if(command.equals("add")) {
                ajouterContact();
            } else if(command.equals("showAll")) {
                afficherContacts();
            } else if(command.equals("show")) {
                afficherContact(sc.next());
            } else {
                System.out.println("Aide: Utiliser add ou show ou showAll ou quit");
            }
            System.out.println("> ");
            command = sc.next();
        }
    }
}
