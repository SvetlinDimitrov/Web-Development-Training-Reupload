package com.ltp.contacts.service;

import com.ltp.contacts.pojo.Contact;

import java.util.List;
import java.util.Optional;

public interface ContactService {
    Contact findById(String id);

    List<Contact> getALLContacts();

    void saveContact(Contact contact);

    void updateContact(String id ,Contact contact);

    void deleteContact(String id);
}
