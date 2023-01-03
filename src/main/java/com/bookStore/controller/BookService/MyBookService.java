package com.bookStore.controller.BookService;

import com.bookStore.entity.MyBook;
import com.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyBookService {
@Autowired
   private MyBookRepository myBookRepositoryrepository;


    public  void saveMyBook(MyBook myBook){
        myBookRepositoryrepository.save(myBook);
    }

    public List<MyBook> getAllMyBook(){
        return myBookRepositoryrepository.findAll();
    }
    public void  deleteById(int id){
        myBookRepositoryrepository.deleteById(id);
    }
}
