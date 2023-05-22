package com.ltp.contacts.web;

import com.ltp.contacts.pojo.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.ltp.contacts.service.ContactService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;


    @GetMapping("/contact/{id}")
    public ResponseEntity<Contact> getId(@PathVariable String id ){
        Contact byId = contactService.findById(id);
        return new ResponseEntity<>(byId , HttpStatus.OK);
    }
    @GetMapping("/contact/all")
    public ResponseEntity<List<Contact>> getAll(){
        List<Contact> allContacts = contactService.getALLContacts();
        return new ResponseEntity<>(allContacts , HttpStatus.OK);
    }

    @PostMapping("/contact")
    public ResponseEntity<HttpStatus> createContact(@RequestBody Contact contact){
        contactService.saveContact(contact);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/contact/{id}")
    public ResponseEntity<HttpStatus> updateContact(@RequestBody Contact contact , @PathVariable String id){
        contactService.updateContact(id , contact);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/contact/{id}")
    public ResponseEntity<HttpStatus>  deleteContact(@PathVariable String id){
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
