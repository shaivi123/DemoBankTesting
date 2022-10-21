package com.springrest.DemoBankTesting.controller;


import com.springrest.DemoBankTesting.dto.BookRequest;
import com.springrest.DemoBankTesting.exception.DatabaseWriteException;
import com.springrest.DemoBankTesting.model.Book;
import com.springrest.DemoBankTesting.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/addData")
    public Book saveBook(@RequestBody BookRequest dto){

            return bookService.saveBook(dto.getId(),dto.getTitle(),dto.getPrice());

    }
//    public void getAllBooks(){
//        try {
//             bookService.getAllBooks();
//        }catch (SQLException e){
//            throw new DatabaseWriteException("unable"+e.getMessage());
//        }
//    }


}
