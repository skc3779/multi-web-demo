package com.web.repositories;

import com.web.entities.Book;
import com.web.entities.History;
import com.web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/**
 * Created by seokangchun on 14. 11. 28..
 */
public interface HistoryRepository extends JpaRepository<History, Integer>, QueryDslPredicateExecutor<History> {
    List<History> findByUser(User user);
    List<History> findByBook(Book book);
    //List<History> findByUserUsingSort(Sort sort);
}
