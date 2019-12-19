package com.boschchicagoconnectory.takehome.joan2ndProblem.controller.test;

import com.boschchicagoconnectory.takehome.joan2ndProblem.controller.UpdateBook;
import com.boschchicagoconnectory.takehome.joan2ndProblem.dao.BookDao;
import com.boschchicagoconnectory.takehome.joan2ndProblem.model.Book;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigInteger;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(UpdateBook.class)
class UpdateBookTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookDao bookDao;

    @Test
    public void whenBookQtyUpdate_saveChanges() throws Exception {
        Book json = new Book("1","1",new BigInteger("1"),"1 1","1",1,"1",1F,1);

        when(bookDao.findByIsbn(json.getIsbn())).thenReturn(json);

        this.mockMvc.perform(patch("/book/update/"+json.getIsbn()).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("qty","500"))
                .andDo(print()).andExpect(status().isOk());

        ArgumentCaptor<Book> argument = ArgumentCaptor.forClass(Book.class);
        verify(bookDao).save(argument.capture());
        Book updatedBook = argument.getValue();

        Assertions.assertTrue(updatedBook.getQty() == 500);
    }

}