package com.smartcontact.smartcontactmanager.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartcontact.smartcontactmanager.entity.Contact;
import com.smartcontact.smartcontactmanager.entity.User;

public interface ContactRepository extends JpaRepository<Contact,Integer> {

    @Query("from Contact as c where c.user.id=:userId")
    public Page<Contact> findByUser(@Param("userId")int userId,Pageable pageable);

    public List<Contact> findByNameContainingAndUser(String name,User user);

}
