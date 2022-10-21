package com.springrest.DemoBankTesting.stubbing;


import com.springrest.DemoBankTesting.dto.BookRequest;
import com.springrest.DemoBankTesting.exception.InvalidAvailabilityException;
import com.springrest.DemoBankTesting.model.Book;
import com.springrest.DemoBankTesting.repository.BookRepository;
import com.springrest.DemoBankTesting.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @InjectMocks
    private BookService bookService;
    @Mock
    private BookRepository bookRepository;

    @Captor
    private ArgumentCaptor<Book> argumentCaptor;

    @Test
    public void calculatePriceOfTotalBook(){
        List<Integer> bookIds= new ArrayList<>();
        bookIds.add(1);
        bookIds.add(1);

        Book book1=new Book(1,"Sita",500);
        Book book2=new Book(2,"Ram",600);
         // for here we use thenReturn()
        when(bookRepository.findById(1))
                .thenReturn(Optional.of(book1))
                .thenReturn(Optional.of(book1));
//        when(bookRepository.findById(1)).thenReturn(Optional.of(book1));
        // for here we use doReturn() it's same as previous but start with end of previous method
//         doReturn(Optional.of(book1)).when(bookRepository).findById(1);
//         doReturn(Optional.of(book2)).when(bookRepository).findById(2);
        int actualCost= bookService.calculateTotalPrice(bookIds);
        assertEquals(1000,actualCost);
    }

    @Test
    public void testSaveBook()throws Exception{
        Book book1=new Book(1,"Sita",500);
        doNothing().when(bookRepository).save(book1);
        bookService.saveBooks(book1);
    }

    @Test
    public void updatePrice(){
        bookService.updatePrice(0,600);
        verifyNoInteractions(bookRepository);
    }

    @Test
    public void updatedPrice2(){
        Book book1=new Book(1,"Sita",500);
        when(bookRepository.findById(1)).thenReturn(Optional.of(book1));
        bookService.updatePrice2(1,600);
        verify(bookRepository).findById(1);
        verify(bookRepository).save(book1);
        verifyNoMoreInteractions(bookRepository);
    }

    @Test
    public void updatedPrice3(){
        Book book1=new Book(1,"Sita",500);
        when(bookRepository.findById(1)).thenReturn(Optional.of(book1));
        bookService.updatePrice2(1,600);

        InOrder inOrder= Mockito.inOrder(bookRepository);
        inOrder.verify(bookRepository).findById(1);
        inOrder.verify(bookRepository).save(book1);
    }

    @Test
    public void testSaveBookWithBookRequestWithGreaterPrice(){
        BookRequest bookRequest=new BookRequest(1,"Ram",500);
        Book book=new Book(1,"Ram",500);
        bookService.saveBooks(book);
        bookService.saveBooks(book);
        bookService.saveBooks(book);
        //how many times we want to invoke the method
       // verify(bookRepository,atLeast(2)).save(book);
        //atMost means we want to invoke the method in 3 time but we call that methods in 4 times So it gives error
       // verify(bookRepository, atMost(3)).save(book);
        //we are checking to invoke the methods only once So if we call many time like above so it gives error.
      //  verify(bookRepository, atMostOnce()).save(book);
        //atLeast one method should be executed
        verify(bookRepository,atLeastOnce()).save(book);
    }
    @Test
    public void testAllBookAvailableWithNonVoid(){
        when(bookRepository.findAll()).thenThrow(InvalidAvailabilityException.class);
        Assertions.assertThrows(InvalidAvailabilityException.class,() -> {
            bookRepository.findAll();
        });
        }
      @Test
    public void testAllBooksWithVoid(){
        Book book=new Book(1,"Ram",500);
        doThrow(InvalidAvailabilityException.class).when(bookRepository.save(book));
        Assertions.assertThrows(InvalidAvailabilityException.class,() -> bookService.saveBook(1,"Ram",500));
      }


}



