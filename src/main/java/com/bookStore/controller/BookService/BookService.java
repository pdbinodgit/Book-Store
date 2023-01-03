package com.bookStore.controller.BookService;

import com.bookStore.entity.Book;
import com.bookStore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public void save(Book b){
    repository.save(b);
    }

    public List<Book> getAll(){
        return repository.findAll();
    }
    public Book getById(int id){
        return repository.findById(id).get();
    }

}
