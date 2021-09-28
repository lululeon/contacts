package com.example.contactsbe.models;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepo extends JpaRepository<Contact, Long> {
}
