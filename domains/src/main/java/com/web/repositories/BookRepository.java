package com.web.repositories;

import com.web.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;

import java.util.List;

/*
 * Spring data Jpa 와 QueryDsl 연결
 * QueryDslPredicateExecutor
 */
public interface BookRepository extends JpaRepository<Book, Integer>, QueryDslPredicateExecutor<Book> {
    List<Book> findByName(String name);
}
