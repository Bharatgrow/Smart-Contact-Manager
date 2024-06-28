package com.test.devtool.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.devtool.Entity.Book;
import com.test.devtool.dao.BookRepository;

@Component
public class BookServices {
    

    @Autowired 
    private BookRepository bookRepository;

    // private static List<Book> list=new ArrayList<>();

    // static{
    //     list.add(new Book(12,"Bhagwat Gita","God"));
    //     list.add(new Book(13,"den","Ben"));
    //     list.add(new Book(14,"Truth with Destiny","Rabindranath Tagore"));

    // }


    public List<Book> getAllBooks()
    {
      List<Book>list=(List<Book>) this.bookRepository.findAll();
      return list;
    }

    public Book getBookById(int id)
    {
        Book book=null;
        try{
        // book =list.stream().filter(e->e.getId()==id).findFirst().get();
      book=this.bookRepository.findById(id);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return book;

    }

    public Book addBook(Book b){
        // list.add(b);

      Book result=  bookRepository.save(b);

        return result;
    }

    public void deleteBook(int bid){
        // list=list.stream().filter(book->book.getId()!=bid).

        bookRepository.deleteById(bid);

        // collect(Collectors.toList());
    }

    public void updateBook(Book book,int id){
        // list.stream().map(b->{

        //     if(b.getId()==id){
        //         b.setName("bhagwan");
        //         b.setAuthor("OMG");
        //     }

        //     return b;
        // }).collect(Collectors.toList());

        book.setId(id);
        bookRepository.save(book);
        
    }
}
