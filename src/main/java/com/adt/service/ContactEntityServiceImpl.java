package com.adt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adt.dto.Contact;
import com.adt.entity.ContactEntity;
import com.adt.exception.ContactNotFound;
import com.adt.repository.ContactEntityRepository;

@Service
public class ContactEntityServiceImpl implements ContactEntityService {
	
	@Autowired
	private ContactEntityRepository contactRepo;
	
	@Override
	public boolean saveContact(Contact contact) {
		boolean isSaved=false;
		try {
			ContactEntity entity=new ContactEntity();
			/*if(contact.getContactId()!=null) {
				Optional<ContactEntity> findById = contactRepo.findById(contact.getContactId());
				entity = findById.get();
			}*/
			BeanUtils.copyProperties(contact, entity);
			ContactEntity savedEntity = contactRepo.save(entity);
			if(savedEntity.getContactId() != null) {
				isSaved=true;
			}	
		}catch (Exception e) {
			throw new ContactNotFound("Save Failed");
		}
		return isSaved;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<ContactEntity> entitys = contactRepo.findAll();
		List<Contact> contacts = new ArrayList<>();
		/*
		 * legecy Approch
		for(ContactEntity entity : entitys) {
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			contacts.add(contact);
		}
		return contacts;
		*/
		
		//Java 8 Approch
		return entitys.stream().map(entity->{
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}).collect(Collectors.toList());
		
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<ContactEntity> findById = contactRepo.findById(cid);
		if(findById.isPresent()) {
			ContactEntity entity = findById.get();
			Contact contact = new Contact();
			BeanUtils.copyProperties(entity, contact);
			return contact;
		}else {
			throw new ContactNotFound();
		}

	}

	@Override
	public boolean updateContact(Contact contact) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteContact(Integer cid) {
		contactRepo.deleteById(cid);
		return true;
	}

}
