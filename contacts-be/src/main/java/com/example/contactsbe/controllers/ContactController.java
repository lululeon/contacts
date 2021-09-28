package com.example.contactsbe.controllers;

import com.example.contactsbe.models.Contact;
import com.example.contactsbe.models.ContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ContactController {
    @Autowired
    private ContactsRepo contacts;

    @RequestMapping("/")
    public String index() {
        return "This is the Contact Controller!";
    }

    @GetMapping("/contacts")
    public List<Contact> contacts() {
        return contacts.findAll();
    }
}

