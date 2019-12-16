package com.boschchicagoconnectory.takehome.joan2ndProblem.controller;

import com.boschchicagoconnectory.takehome.joan2ndProblem.dao.BookDao;
import com.boschchicagoconnectory.takehome.joan2ndProblem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookDao bookDao;

    @GetMapping
    public List<Book> getBookList(){
        return bookDao.findAll(Sort.by(Sort.Direction.ASC, "genre", "last_name", "first_name"));
    }
}
