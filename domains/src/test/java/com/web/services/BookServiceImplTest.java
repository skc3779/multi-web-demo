package com.web.services;

import com.web.configs.DomainConfiguration;
import com.web.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DomainConfiguration.class})
@Slf4j
public class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    public void testList() throws Exception {
        List<Book> books = bookService.list();
        assertThat(books, is(notNullValue()));
    }

    @Test
    public void testRead() throws Exception {
        Book book = bookService.read(1);
        assertThat(book, is(notNullValue()));
    }
}