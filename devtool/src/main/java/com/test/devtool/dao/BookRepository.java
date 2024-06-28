package com.test.devtool.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.devtool.Entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
    public Book findById(int id);
}