package com.bookStore.controller;

import com.bookStore.controller.BookService.MyBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyBookController {
    @Autowired
    private MyBookService myBookService;
    @RequestMapping("deleteMyList/{id}")
    public String deleteMyList(@PathVariable("id") int id){
      myBookService.deleteById(id);
        return "redirect:/my_books";
}
}
