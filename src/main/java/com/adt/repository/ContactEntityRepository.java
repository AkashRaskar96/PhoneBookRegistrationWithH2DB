package com.adt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adt.entity.ContactEntity;

public interface ContactEntityRepository extends JpaRepository<ContactEntity, Integer> {

}
