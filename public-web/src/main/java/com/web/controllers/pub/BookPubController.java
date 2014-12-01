package com.web.controllers.pub;

import com.web.entities.Book;
import com.web.repositories.BookRepository;
import com.web.services.BookService;
import com.web.utils.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by seokangchun on 14. 12. 1..
 */
@Controller
@RequestMapping("/pub")
@Slf4j
public class BookPubController {

    @Autowired
    private BookService bookService;
    @Autowired
    private DateUtil dateUtil;

    @RequestMapping(value="/book/list", method = RequestMethod.GET)
    public String list(Model model) throws IOException {
        List<Map<String, String>> maps = bookService.list()
                .stream().map(b->convertToMap(b)).collect(Collectors.toList());
        model.addAttribute("books", maps);
        return "book/list";
    }

    @RequestMapping(value="/book/{id}", method=RequestMethod.GET)
    public String read(@PathVariable(value="id") Integer id, Model model) {
        model.addAttribute("book", convertToMap(bookService.read(id)));
        return "book/read";
    }

    private Map<String, String> convertToMap(Book book) {
        Map<String, String> map = new HashMap<>();
        map.put("id", String.valueOf(book.getId()));
        map.put("name", book.getName());
        map.put("author", book.getAuthor());
        String pubishDate = dateUtil.toString(book.getPublishDate(), "yyyy-MM-dd");
        map.put("publishDate", pubishDate);
        map.put("comment", book.getComment());
        map.put("rendUser", book.getRentUser() == null ? "" : book.getRentUser().getName());
        map.put("status", String.valueOf(book.getBookStatus().intValue()));
        return map;
    }


}
