package com.boschchicagoconnectory.takehome.joan2ndProblem.controller;

import com.boschchicagoconnectory.takehome.joan2ndProblem.dao.BookDao;
import com.boschchicagoconnectory.takehome.joan2ndProblem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

@RestController
@RequestMapping("/book/update/{id}")
public class UpdateBook {

    @Autowired
    private BookDao bookDao;

    @PatchMapping
    public void update(@PathVariable BigInteger id, @RequestParam Integer qty){
        Book book = bookDao.findByIsbn(id);
        book.setQty(qty);
        bookDao.save(book);
    }
}
