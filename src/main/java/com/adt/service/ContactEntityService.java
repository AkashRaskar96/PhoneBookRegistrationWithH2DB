package com.adt.service;

import java.util.List;

import com.adt.dto.Contact;

public interface ContactEntityService {

	public boolean saveContact(Contact contact);
	
	public List<Contact> getAllContacts();
	
	public Contact getContactById(Integer cid);
	
	public boolean updateContact(Contact contact);
	
	public boolean deleteContact(Integer cid);
	
	
}
