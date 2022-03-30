package br.com.phoebustecnologia.BookMicroservice.book.controller;

import br.com.phoebustecnologia.BookMicroservice.book.dto.BookDTO;
import br.com.phoebustecnologia.BookMicroservice.book.model.Book;
import br.com.phoebustecnologia.BookMicroservice.book.service.BookServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    BookServicesImpl bookServicesImpl;


    //@ApiOperation("Get all book")
    @GetMapping(path = "/all")
    public List<BookDTO> findAll() {
        return bookServicesImpl.findAll();
    }

    @GetMapping(path = "/findBook/{title}")
    public Optional<Book> findByTitle(@PathVariable String title) {
        return bookServicesImpl.findByTitle(title);
    }

    //@ApiOperation("Get a book")
    @GetMapping(value = "/{id}")
    public BookDTO bookListById(@PathVariable Long id){
        return bookServicesImpl.findById(id);

    }

    //@ApiOperation("List an books by category")
//    @GetMapping(value = "/category/{id}")
//    public List<BookDTO> bookListByCategory(@RequestParam(value = "category", defaultValue = "0") Long idCat) {
//        return bookServicesImpl.findByCategoryId(idCat);
//    }

    //@ApiOperation("Save an book")
    @PostMapping
    public void addBook(@RequestBody BookDTO bookDTO) {
        bookServicesImpl.save(bookDTO);
    }

    //@ApiOperation("Delete an Book")
    @DeleteMapping(value = "/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookServicesImpl.delete(id);

    }

    //@ApiOperation("Update an book")
    @PutMapping(value = "/{id}")
    public void updateBook(@PathVariable Long id, @RequestBody BookDTO bookDTO){
        bookServicesImpl.update(id, bookDTO);
    }

}
