package com.example.contactapp;

public class Contact {
    private final String contactID;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactID, String firstName, String lastName, String phone, String address) {
        if (isValidContactID(contactID) && isValidFirstName(firstName) && isValidLastName(lastName) 
            && isValidPhone(phone) && isValidAddress(address)) {
            this.contactID = contactID;
            this.firstName = firstName;
            this.lastName = lastName;
            this.phone = phone;
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid contact data.");
        }
    }

    public String getContactID() {
        return contactID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (isValidFirstName(firstName)) {
            this.firstName = firstName;
        } else {
            throw new IllegalArgumentException("Invalid first name.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (isValidLastName(lastName)) {
            this.lastName = lastName;
        } else {
            throw new IllegalArgumentException("Invalid last name.");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (isValidPhone(phone)) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Invalid phone.");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (isValidAddress(address)) {
            this.address = address;
        } else {
            throw new IllegalArgumentException("Invalid address.");
        }
    }

    private boolean isValidContactID(String id) {
        return id != null && id.length() <= 10;
    }

    private boolean isValidFirstName(String name) {
        return name != null && name.length() <= 10;
    }

    private boolean isValidLastName(String name) {
        return name != null && name.length() <= 10;
    }

    private boolean isValidPhone(String phone) {
        return phone != null && phone.matches("[0-9]{10}");
    }

    private boolean isValidAddress(String address) {
        return address != null && address.length() <= 30;
    }
}
