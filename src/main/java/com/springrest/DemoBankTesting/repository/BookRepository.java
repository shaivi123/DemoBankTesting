package com.springrest.DemoBankTesting.repository;


import com.springrest.DemoBankTesting.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findById(Book id);

    Object findByTitle();

    List<Book> findAllBooks();
}
