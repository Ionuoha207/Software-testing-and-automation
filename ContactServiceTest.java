package com.example.contactapp;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactServiceTest {
    private ContactService contactService;

    @Before
    public void setUp() {
        contactService = new ContactService();
    }

    @Test
    public void testAddContact() {
        Contact contact = new Contact("54321", "Zain", "Lon", "5432167890", "123 Back St");
        contactService.addContact(contact);
        assertEquals(contact, contactService.getContact("54321"));
    }

    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("54321", "Zain", "Lon", "5432167890", "123 Back St");
        contactService.addContact(contact);
        contactService.deleteContact("54321");
        assertNull(contactService.getContact("54321"));
    }

    @Test
    public void testUpdateContact() {
        Contact contact = new Contact("54321", "Zain", "Lon", "5432167890", "123 Back St");
        contactService.addContact(contact);
        contactService.updateContact("54321", "Jude", "Rowe", "9876543210", "456 Front St");
        assertEquals("Jude", contactService.getContact("54321").getFirstName());
        assertEquals("Rowe", contactService.getContact("54321").getLastName());
        assertEquals("9876543210", contactService.getContact("54321").getPhone());
        assertEquals("456 Front St", contactService.getContact("54321").getAddress());
    }

    @Test
    public void testUpdateNonExistentContact() {
        contactService.updateContact("99999", "Name", "Surname", "9876543210", "Address St");
    }

    @Test
    public void testUpdateWithNullOrEmptyValues() {
        Contact contact = new Contact("54321", "Zain", "Lon", "5432167890", "123 Back St");
        contactService.addContact(contact);
        
        contactService.updateContact("54321", null, null, null, null);
        assertEquals("Zain", contactService.getContact("54321").getFirstName());
        assertEquals("Lon", contactService.getContact("54321").getLastName());
        assertEquals("5432167890", contactService.getContact("54321").getPhone());
        assertEquals("123 Back St", contactService.getContact("54321").getAddress());
        
        contactService.updateContact("54321", "", "", "", "");
        assertEquals("Zain", contactService.getContact("54321").getFirstName());
        assertEquals("Lon", contactService.getContact("54321").getLastName());
        assertEquals("5432167890", contactService.getContact("54321").getPhone());
        assertEquals("123 Back St", contactService.getContact("54321").getAddress());
    }
}
