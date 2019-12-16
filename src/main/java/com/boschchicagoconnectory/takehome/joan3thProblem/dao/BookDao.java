package com.boschchicagoconnectory.takehome.joan3thProblem.dao;

import com.boschchicagoconnectory.takehome.joan3thProblem.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.math.BigInteger;
import java.util.List;

public interface BookDao extends MongoRepository<Book, String> {
    Book findByIsbn(BigInteger id);

    @Query("{$text: {$search: \"?0\"}}")
    List<Book> findFullTextSearch(String text);

}
