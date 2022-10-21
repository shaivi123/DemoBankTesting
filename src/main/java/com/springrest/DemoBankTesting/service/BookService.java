package com.springrest.DemoBankTesting.service;

import com.springrest.DemoBankTesting.exception.BookNotFoundException;
import com.springrest.DemoBankTesting.exception.InvalidAvailabilityException;
import com.springrest.DemoBankTesting.model.Book;
import com.springrest.DemoBankTesting.repository.BookRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public Book saveBook(int id, String title, int price) {
        Book book = new Book();
        try {
            book.setId(id);
            book.setTitle(title);
            book.setPrice(price);

        }catch(Exception e){
            throw  new InvalidAvailabilityException("Unavailable"+e.getMessage());
        }
        return bookRepository.save(book);
    }
    public List<Book> getAllBooks() {
        try {
            return bookRepository.findAll();
        } catch (BookNotFoundException e) {
            throw new BookNotFoundException("Error");
        }
    }

    public Book getBooksById(int id) {
        Optional<Book> account = bookRepository
                .findById(id);
        return account.orElse(null);
    }
    public Book replaceBookTitle(int id, String title, int price) {
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            StringBuilder bookChange = new StringBuilder();
            bookChange.replace(0, book.get().toString().length(), title);
            book.get().setTitle(bookChange.toString());
            return book.get();
        } else {
            throw new BookNotFoundException("Error");
        }
    }
    public int calculateTotalPrice(List<Integer> bookIds) {
        int total = 0;
        for (Integer id : bookIds) {
            Optional<Book> book = bookRepository.findById(id);
            total = total + book.get().getPrice();
        }
        return total;
    }
    public void saveBooks(Book book1) {
        bookRepository.save(book1);
    }

    public void updatePrice(int id, int updatedPrice) {
        if (id <= 0) {
            return;
        }
        Optional<Book> book = bookRepository.findById(id);
        if (book.isPresent()) {
            book.get().setPrice(updatedPrice);
            bookRepository.save(book.get());
        }
    }
    public void updatePrice2(int id, int updatedPrice) {
        if (id <= 0) {
            return;
        }
        Optional<Book> book = bookRepository.findById(id);
//        if(book.get().getPrice() == updatedPrice) {
//            return;
//        }
        book.get().setPrice(updatedPrice);
        bookRepository.save(book.get());
    }


}


