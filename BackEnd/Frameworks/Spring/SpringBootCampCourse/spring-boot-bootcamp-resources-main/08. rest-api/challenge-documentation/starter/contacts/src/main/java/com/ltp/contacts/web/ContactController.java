package com.ltp.contacts.web;

import java.util.List;

import javax.validation.Valid;

import com.ltp.contacts.exception.ErrorResponse;
import io.swagger.v3.oas.annotations.Operation;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.media.*;
import io.swagger.v3.oas.annotations.responses.*;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ltp.contacts.pojo.Contact;
import com.ltp.contacts.service.ContactService;

@RestController
@Tag(name = "Controller Contacts" , description = "Create and retrieve contacts")
public class ContactController {
    
    @Autowired
    private ContactService contactService;


    @GetMapping(value = "/contact/all" , produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Retrieves contacts" ,
            description = "Provides a list of all contacts")
    @ApiResponse(responseCode = "200",
            description = "Successful retrieval of contacts",
            content = @Content(
                    array = @ArraySchema(schema =
                    @Schema(implementation = Contact.class))))
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping(value = "/contact/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Get contact by id" ,
            description = "Returns a contact based on an ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404",
                    description = "Contact doesn't exist",
                    content = @Content(schema =
                    @Schema(implementation = ErrorResponse.class))),
            @ApiResponse(responseCode = "200",
                    description = "Successful retrieval of contact",
                    content = @Content(schema =
                    @Schema(implementation = Contact.class))),
    })
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        Contact contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping(value = "/contact" ,produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = "Create Contact" ,
            description = "Creates a contact from the provided payload")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Successful creation of contact"),
            @ApiResponse(responseCode = "400",
                    description = "Bad request: unsuccessful submission",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class)))
    })

    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) {
        contactService.saveContact(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

}