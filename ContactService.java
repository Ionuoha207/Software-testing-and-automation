package com.example.contactapp;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ContactService {
    private Map<String, Contact> contacts = new HashMap<>();

    public void addContact(Contact contact) {
        contacts.put(contact.getContactID(), contact);
    }

    public void deleteContact(String contactID) {
        contacts.remove(contactID);
    }

    public void updateContact(String contactID, String firstName, String lastName, String phone, String address) {
        Optional<Contact> contact = Optional.ofNullable(contacts.get(contactID));
        
        
        contact.ifPresent(c -> {
            if (firstName != null && !firstName.isEmpty()) c.setFirstName(firstName);
            if (lastName != null && !lastName.isEmpty()) c.setLastName(lastName);
            if (phone != null && !phone.isEmpty()) c.setPhone(phone);
            if (address != null && !address.isEmpty()) c.setAddress(address);
        });
    }

    public Contact getContact(String contactID) {
        return contacts.get(contactID);
    }
}
