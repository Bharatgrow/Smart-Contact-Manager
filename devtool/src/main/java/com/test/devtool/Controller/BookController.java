package com.test.devtool.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.devtool.Entity.Book;
import com.test.devtool.services.BookServices;

@RestController
// @ResponseBody
public class BookController {
    
   @Autowired 
   private BookServices services;


    @GetMapping("/books")
   public ResponseEntity<List<Book>> getbooks(){

    List<Book>list=services.getAllBooks();
    if(list.size()<=0){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    
    // return services.getAllBooks();
    return ResponseEntity.of(Optional.of(list));
   }

   @GetMapping("/books/{id}")
   public ResponseEntity<Book> getbook(@PathVariable("id")int id){

    Book book=services.getBookById(id);

    if(book==null){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(book));

    // return services.getBookById(id);
   }

   @PostMapping("/books")
   public ResponseEntity<Book> addBook(@RequestBody Book book){

    Book b=null;

    try{
    services.addBook(book);
    return ResponseEntity.of(Optional.of(b));
    }

    catch(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
    
   }

   @DeleteMapping("/books/{id}")
   public ResponseEntity<Void> deleteBook(@PathVariable("id")int id){

    try{
    services.deleteBook(id);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    catch(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    
   }

   @PutMapping("/books/{id}")
   public ResponseEntity<Book> updateBook(@PathVariable("id")int id,@RequestBody Book book){

    try{

    services.updateBook(book,id);
    return ResponseEntity.status(HttpStatus.OK).build();
    }
    catch(Exception e){
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

   }
   
}
