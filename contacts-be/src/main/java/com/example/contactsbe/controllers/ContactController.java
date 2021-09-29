package com.example.contactsbe.controllers;

import com.example.contactsbe.models.Contact;
import com.example.contactsbe.services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private final ContactsService service;

    public ContactController(ContactsService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAll() {
        List<Contact> contacts = service.allContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable Long id) {
        Contact contact = service.getContact(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody Contact contactInfo) {
        service.addContact(contactInfo);
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody Contact contactInfo) {
        service.updateContact(contactInfo);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        service.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

