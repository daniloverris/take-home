package com.boschchicagoconnectory.takehome.joan3thProblem.controller;

import com.boschchicagoconnectory.takehome.joan3thProblem.dao.BookDao;
import com.boschchicagoconnectory.takehome.joan3thProblem.model.Book;
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
