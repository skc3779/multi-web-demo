package com.web.services;

import com.web.entities.Book;
import com.web.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * Created by seokangchun on 14. 12. 1..
 */
@Service
@Slf4j
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<Book> list() throws IOException {

        List<Book> books = bookRepository.findAll();

//        String jsonString = objectMapper.writeValueAsString(books);
//        log.info("jsonString list : {}", jsonString);

        return books;
    }

    @Override
    public Book read(Integer id) {
        return bookRepository.findById(id);
    }
}
