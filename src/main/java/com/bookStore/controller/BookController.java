package com.bookStore.controller;

import com.bookStore.controller.BookService.BookService;
import com.bookStore.controller.BookService.MyBookService;
import com.bookStore.entity.Book;
import com.bookStore.entity.MyBook;
import com.bookStore.repository.MyBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.*;
import java.util.List;

@Controller
public class BookController {

    @Autowired
    private BookService service;
    @Autowired
    private MyBookService myBookService;
    @GetMapping("/")
    public  String home(){
        return "home";
    }


    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }

    @GetMapping("my_books")
    public  String getMyBook(Model model){
        List<MyBook> list=myBookService.getAllMyBook();
        model.addAttribute("bookstore",list);
     return "myBook";
    }

    @GetMapping("/available_book")
    public ModelAndView getAllbook(){
       List<Book> list=service.getAll();
//        ModelAndView m=new ModelAndView();
//        m.setView("available");

       return new ModelAndView("available","bookstore",list);
    }
  @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        service.save(b);
        return "redirect:/available_book";
    }

    public BookService getService() {
        return service;
    }
    @RequestMapping("/my-list/{id}")
    public String getMyBook(@PathVariable("id") int id){

        Book book=service.getById(id);
        MyBook myBook=new MyBook(book.getId(),book.getName(),book.getAuthor(),book.getPrice());
        myBookService.saveMyBook(myBook);
        return "redirect:/my_books";
    }
}
