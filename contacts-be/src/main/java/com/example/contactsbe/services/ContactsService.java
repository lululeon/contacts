package com.example.contactsbe.services;

import com.example.contactsbe.exceptions.ContactNotFoundException;
import com.example.contactsbe.models.Contact;
import com.example.contactsbe.models.ContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsService {
    @Autowired
    private final ContactsRepo contacts;

    public ContactsService(ContactsRepo repo) {
        this.contacts = repo;
    }

    public List<Contact> allContacts() {
        return contacts.findAll();
    }

    /**
     * we can return an optional (i.e. a user mignt not be found, for a garbage id):
     * public Optional<Contact> getContact(Long id) {
     * return contacts.findById(id);
     * }
     * ... or, we can handle as an exception:
     */
    public Contact getContact(Long id) {
        return contacts.findById(id)
                .orElseThrow(() -> new ContactNotFoundException("No contact " + id + " was not found!"));
    }

    public void addContact(Contact contactInfo) {
        contacts.save(contactInfo);
    }

    public void deleteContact(Long id) {
        contacts.deleteContactById(id);
    }

    public void updateContact(Contact contactInfo) {
        contacts.save(contactInfo);
    }
}

