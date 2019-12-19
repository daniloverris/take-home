package com.boschchicagoconnectory.takehome.joan2ndProblem.controller.test;

import com.boschchicagoconnectory.takehome.joan2ndProblem.controller.BookController;
import com.boschchicagoconnectory.takehome.joan2ndProblem.dao.BookDao;
import com.boschchicagoconnectory.takehome.joan2ndProblem.model.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookDao bookDao;

    @Test
    public void getAllBooks_shouldReturnBooks() throws Exception {
        List<Book> jsonArrs = Arrays.asList(new Book("1","1",new BigInteger("1"),"1 1","1",1,"1",1F,1),
                                            new Book("2","2",new BigInteger("2"),"2 2","2",2,"2",2F,2));
        when(bookDao.findAll(Sort.by(Sort.Direction.ASC, "genre", "last_name", "first_name"))).thenReturn(jsonArrs);
        this.mockMvc.perform(get("/book")).andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title", is("1")));
    }

}