package com.jpa.springjpa;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository <User,Integer> {

    public List<User>  findByName(String name);
    public List<User> findByIdLessThan(int id);

    @Query("select u from User u")
    public List<User> getAllUser();

    @Query("select u from User u where u.id=:id")
    public List<User> getById(@Param("id")int id);

}
