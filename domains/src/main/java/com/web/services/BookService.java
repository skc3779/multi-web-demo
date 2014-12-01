package com.web.services;

import com.web.entities.Book;
import org.codehaus.jackson.JsonGenerationException;

import java.io.IOException;
import java.util.List;

/**
 * Created by seokangchun on 14. 12. 1..
 */
public interface BookService {
    List<Book> list() throws IOException;
    Book read(Integer id);
}
