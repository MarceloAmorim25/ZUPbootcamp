package br.com.casadocodigo.controllers;
import br.com.casadocodigo.models.Book;
import br.com.casadocodigo.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<Book> createBook(@RequestBody @Valid Book book){
        if(book != null) {
            bookRepository.save(book);
            return ResponseEntity.ok(book);
        }

        return ResponseEntity.notFound().build();
    }
}
