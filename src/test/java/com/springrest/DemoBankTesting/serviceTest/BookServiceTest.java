package com.springrest.DemoBankTesting.serviceTest;

import com.springrest.DemoBankTesting.model.Book;
import com.springrest.DemoBankTesting.repository.BookRepository;
import com.springrest.DemoBankTesting.service.BookService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

//@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @InjectMocks
    private  BookService bookService;
    @Mock
    private  BookRepository bookRepository;

    @Rule
    public MockitoRule mockitoRule= MockitoJUnit.rule();
//    @Before
//    public void beforeEach(){
//        MockitoAnnotations.initMocks(this);
//    }
    @Test
    public void addBooks() throws SQLException {
        Book book = new Book(7,"Sita",100);
        bookService.saveBook(7,"Sita",100);
        assertEquals(7,book.getId());
    }
    @Test
    public void testTotalBooks(){
        List<Book> books=new ArrayList<>();
        books.add(new Book(1,"Sita",500));
        books.add(new Book(2,"Ram",1100));
        when(bookRepository.findAll()).thenReturn(books);
        List<Book> books1=bookService.getAllBooks();
        assertEquals(2, books.size());
//        Assertions.assertThrows(BookNotFoundException.class,() -> bookService.getAllBooks());
    }
    @Test
   public  void getBookById() {
        Book book = new Book();
        book.setId(1);
        book.setTitle("Ram");
        book.setPrice(200);
        Optional<Book> Books = Optional.of(book);
        when(bookRepository.findById(1)).thenReturn(Books);
        Optional<Book> book1 = Optional.ofNullable(bookService.getBooksById(1));
        assertEquals(1,book1.get().getId());
    }
    @Test
    public void replaceBookName(){
        Book book=new Book();
        book.setId(1);
        book.setTitle("Ravan");
        book.setPrice(500);
        Optional<Book> book1=Optional.of(book);
        when(bookRepository.findById(1)).thenReturn(book1);
        Book book2=bookService.replaceBookTitle(1,"Ram",500);
        assertNotEquals("Ravan",book2.getTitle());
    }


}
