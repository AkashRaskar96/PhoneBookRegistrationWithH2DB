package com.adt.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.adt.dto.Contact;
import com.adt.entity.ContactEntity;
import com.adt.service.ContactEntityService;

@RestController
@RequestMapping("/contact")
public class ContactOperationController {
	
	@Autowired
	ContactEntityService contactService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveEntity(@RequestBody Contact contact){
		boolean result = contactService.saveContact(contact);
		if(result) 
			return new ResponseEntity<String>("Contact has been saved...!",HttpStatus.CREATED);
		return new ResponseEntity<String>("Contact is not saved...?",HttpStatus.CONFLICT);
	}
	
	@GetMapping("/getAllContacts")
	public ResponseEntity<List<Contact>> getAllContacts(){
		return new ResponseEntity<List<Contact>>(contactService.getAllContacts(),HttpStatus.OK);
	}
	
	@GetMapping("/getContact/{cid}")
	public ResponseEntity<Contact> getContact(@PathVariable Integer cid){
		Contact contact = contactService.getContactById(cid);
		return new ResponseEntity<Contact>(contact,HttpStatus.OK);
	
	}
	
	@PutMapping("/updateContact")
	public ResponseEntity<String> updateContact(@RequestBody Contact contact){
		boolean result = contactService.saveContact(contact);
		if(result) 
			return new ResponseEntity<String>("Contact has been Updated...!",HttpStatus.CREATED);
		return new ResponseEntity<String>("Contact is not Updated...?",HttpStatus.CONFLICT);

	}
	
	public ResponseEntity<String> deleteContact(@RequestBody Integer cid){
		boolean result = contactService.deleteContact(cid);
		if(result)
			return new ResponseEntity<String>("Contact has been deleted....!",HttpStatus.OK);
		return new ResponseEntity<String>("Contact is not deleted",HttpStatus.CONFLICT);
	}

}
