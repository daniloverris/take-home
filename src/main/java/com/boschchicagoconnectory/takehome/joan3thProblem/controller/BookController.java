package com.boschchicagoconnectory.takehome.joan3thProblem.controller;

import com.boschchicagoconnectory.takehome.joan3thProblem.dao.BookDao;
import com.boschchicagoconnectory.takehome.joan3thProblem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book/all")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @GetMapping
    public List<Book> getBookList(){
        return bookDao.findAll(Sort.by(Sort.Direction.ASC, "genre", "lastName", "firstName"));
    }
}
