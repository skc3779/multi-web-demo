package com.web.controllers.api;

import com.web.entities.Book;
import com.web.repositories.BookRepository;
import com.web.services.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by seokangchun on 14. 12. 1..
 */
@Controller
@RequestMapping("/api")
@Slf4j
public class BookApiController {

    @Autowired
    private BookService bookService;

    /**
     * 리스트
     * @return Json String
     */
    @RequestMapping(value = "/book/list", method = RequestMethod.GET)
    @ResponseBody
    public Object list() throws IOException {
        List<Book> books = bookService.list();
        return books;
    }

    /**
     * 보기
     * @param id ID
     * @return Json String
     */
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Object read(@PathVariable(value = "id") Integer id) {
        return bookService.read(id);
    }

}
