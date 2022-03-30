package br.com.phoebustecnologia.BookMicroservice.book.repositories;

import br.com.phoebustecnologia.BookMicroservice.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {


    Optional<Book> findByTitle(String title);

}

