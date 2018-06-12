package com.example.krzysztof.koszela.onlinelibrary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    //Get all books
    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    //Get one book
    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable(value = "id") Long bookId) {
        return bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));
    }

    //Post
    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return bookRepository.save(book);
    }

    //Update a book information
    @PutMapping("/books/{id}")
    public Book updateBook(@PathVariable(value = "id") Long bookId, @Valid @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));

        book.setId(bookDetails.getId());
        book.setAuthor(bookDetails.getAuthor());
        book.setPrice(bookDetails.getPrice());
        book.setRating(bookDetails.getRating());
        book.setTitle(bookDetails.getTitle());

        Book updateBook = bookRepository.save(book);
        return updateBook;
    }

    // Delete a Book
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new ResourceNotFoundException("Book", "id", bookId));

        bookRepository.delete(book);

        return ResponseEntity.ok().build();
    }
}
