package com.boschchicagoconnectory.takehome.joan3thProblem.controller;

import com.boschchicagoconnectory.takehome.joan3thProblem.dao.BookDao;
import com.boschchicagoconnectory.takehome.joan3thProblem.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/book/search")
public class SearchBookController {

    @Autowired
    private BookDao bookDao;

    @GetMapping
    public List<Book> searchBookList(@RequestParam String q){
        List<Book> result = bookDao.findFullTextSearch(q);
        result.sort(new Comparator<Book>() {
            @Override
            public int compare(Book bookA, Book bookB) {
                int compare;
                String genreA = bookA.getGenre();
                String genreB = bookB.getGenre();
                compare = genreA.compareTo(genreB);
                if (compare == 0) {
                    String authorA = bookA.getAuthor();
                    String authorB = bookB.getAuthor();
                    compare = authorA.compareTo(authorB);
                }
                if (compare == 0) {
                    String titleA = bookA.getTitle();
                    String titleB = bookB.getTitle();
                    compare = titleA.compareTo(titleB);
                }

                return compare;
            }
        });

        return  result;
    }
}
