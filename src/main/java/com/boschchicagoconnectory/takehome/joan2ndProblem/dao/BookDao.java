package com.boschchicagoconnectory.takehome.joan2ndProblem.dao;

import com.boschchicagoconnectory.takehome.joan2ndProblem.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;

public interface BookDao extends MongoRepository<Book, String> {
    public Book findByIsbn(BigInteger id);
}
