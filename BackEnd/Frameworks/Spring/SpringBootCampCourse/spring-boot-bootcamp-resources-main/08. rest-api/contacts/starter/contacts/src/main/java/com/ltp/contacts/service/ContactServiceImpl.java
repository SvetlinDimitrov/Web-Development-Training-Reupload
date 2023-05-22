package com.ltp.contacts.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import com.ltp.contacts.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ltp.contacts.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;
    



    private int findIndexById(String id) {
        return IntStream.range(0, contactRepository.getContacts().size())
            .filter(index -> contactRepository.getContacts().get(index).getId().equals(id))
            .findFirst()
            .orElseThrow();
    }

    @Override
    public Contact findById(String id) {
        return contactRepository.getContact(findIndexById(id));
    }

    @Override
    public List<Contact> getALLContacts() {
        return contactRepository.getContacts();
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepository.saveContact(contact);
    }

    @Override
    public void updateContact(String id , Contact contact) {
        contactRepository.updateContact(findIndexById(id), contact);
    }

    @Override
    public void deleteContact(String id) {
        contactRepository.deleteContact(findIndexById(id));
    }
}
