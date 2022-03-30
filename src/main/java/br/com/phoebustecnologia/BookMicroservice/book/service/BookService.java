package br.com.phoebustecnologia.BookMicroservice.book.service;

import br.com.phoebustecnologia.BookMicroservice.book.dto.BookDTO;
import br.com.phoebustecnologia.BookMicroservice.book.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    //Listar livros
    List<BookDTO> findAll();

    //Pesquisar livros por ID
    BookDTO findById(Long id);

    //Deletar livros
    void delete(Long id);

    //Salvar categoria
    BookDTO save(BookDTO bookDTO);

    //Atualizar categoria
    BookDTO update(Long id, BookDTO bookDTO);

    Optional<Book> findByTitle(String title);

}
