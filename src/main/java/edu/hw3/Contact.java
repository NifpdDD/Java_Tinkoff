package edu.hw3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Contact {
    public enum Sortby {
        ASC, DESC
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Contact)) {
            return false;
        }
        Contact other = (Contact) obj;
        return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    private String firstName;
    private String lastName;

    public Contact() {

    }

    public Contact(String fullName) {
        String[] nameParts = fullName.split(" ");
        this.firstName = nameParts[0];
        this.lastName = nameParts.length > 1 ? nameParts[1] : null;
    }

    public Contact[] parseContacts(String[] names, Sortby sortOrder) {
        if (names == null || names.length == 0) {
            return new Contact[0];
        }
        Comparator<Contact> comparator = getContactComparator(sortOrder);
        Contact[] contacts = new Contact[names.length];
        namesToContacts(names, contacts);
        Arrays.sort(contacts, comparator);
        return contacts;
    }

    private static void namesToContacts(String[] names, Contact[] contacts) {
        for (int i = 0; i < names.length; i++) {
            contacts[i] = new Contact(names[i]);
        }
    }

    private static Comparator<Contact> getContactComparator(Sortby sortOrder) {
        return (c1, c2) -> {
            String lastName1 = c1.lastName != null ? c1.lastName : c1.firstName;
            String lastName2 = c2.lastName != null ? c2.lastName : c2.firstName;

            if (sortOrder == Sortby.ASC) {
                return lastName1.compareTo(lastName2);
            }
            if (sortOrder == Sortby.DESC) {
                return lastName2.compareTo(lastName1);
            }
            throw new IllegalArgumentException();
        };
    }
}
