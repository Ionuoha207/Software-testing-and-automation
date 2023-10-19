package com.example.contactapp;


import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTest {

    @Test
    public void testValidContactCreation() {
        Contact contact = new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St");

        assertEquals("ID12345", contact.getContactID());
        assertEquals("John", contact.getFirstName());
        assertEquals("Doe", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Main St", contact.getAddress());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithNullID() {
        new Contact(null, "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithLongID() {
        new Contact("ID12345678901", "John", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithNullFirstName() {
        new Contact("ID12345", null, "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithLongFirstName() {
        new Contact("ID12345", "Johnathonathan", "Doe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithNullLastName() {
        new Contact("ID12355", "John", null, "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithLongLastName() {
        new Contact("ID12345", "John", "Doedoedoedoedoe", "1234567890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithNullPhone() {
        new Contact("ID12345", "John", "Doe", null, "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithShortPhone() {
        new Contact("ID12345", "John", "Doe", "12345", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithLongPhone() {
        new Contact("ID12345", "John", "Doe", "123456789012", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithNonDigitPhone() {
        new Contact("ID12345", "John", "Doe", "1234AB7890", "123 Main St");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithNullAddress() {
        new Contact("ID12345", "John", "Doe", "1234567890", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateContactWithLongAddress() {
        new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St. This address is far too long to be valid");
    }

    @Test
    public void testSetValidFirstName() {
        Contact contact = new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Jane");

        assertEquals("Jane", contact.getFirstName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidFirstName() {
        Contact contact = new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setFirstName("Johnathonathan");
    }

    @Test
    public void testSetValidLastName() {
        Contact contact = new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Smith");

        assertEquals("Smith", contact.getLastName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidLastName() {
        Contact contact = new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setLastName("Doedoedoedoedoe");
    }

    @Test
    public void testSetValidPhone() {
        Contact contact = new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("0987654321");

        assertEquals("0987654321", contact.getPhone());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidPhone() {
        Contact contact = new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setPhone("1234AB7890");
    }

    @Test
    public void testSetValidAddress() {
        Contact contact = new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("456 Elm St");

        assertEquals("456 Elm St", contact.getAddress());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetInvalidAddress() {
        Contact contact = new Contact("ID12345", "John", "Doe", "1234567890", "123 Main St");
        contact.setAddress("123 Main St. This address is far too long to be valid");
    }
}