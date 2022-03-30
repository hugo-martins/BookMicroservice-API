package br.com.phoebustecnologia.BookMicroservice.book.service;

import br.com.phoebustecnologia.BookMicroservice.book.dto.BookDTO;
import br.com.phoebustecnologia.BookMicroservice.book.model.Book;
import br.com.phoebustecnologia.BookMicroservice.book.repositories.BookRepository;
import br.com.phoebustecnologia.BookMicroservice.category.model.Category;
import br.com.phoebustecnologia.BookMicroservice.category.repositories.CategoryRepository;
import br.com.phoebustecnologia.BookMicroservice.category.service.CategoryServicesImpl;
import br.com.phoebustecnologia.BookMicroservice.exceptions.BookNotFoundException;
import br.com.phoebustecnologia.BookMicroservice.exceptions.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookServicesImpl implements BookService{

    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final CategoryServicesImpl categoryService;

    public BookServicesImpl(BookRepository bookRepository, CategoryRepository categoryRepository, CategoryServicesImpl categoryService) {
        super();
        this.bookRepository = bookRepository;
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
    }

    //Listar livros
    @Override
    public List<BookDTO> findAll(){
        return BookDTO.ListFromAllBooks(bookRepository.findAll());
    }


    //Pesquisar Book por ID
    @Override
    public BookDTO findById(Long id){
        Book result = bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);
        return BookDTO.bookDTO(result);
    }


    //Deletar livro
    @Override
    public void delete(Long id){
        Book book =  bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        bookRepository.delete(book);
    }

    //Salvar livro
    @Transactional
    @Override
    public BookDTO save(BookDTO bookDTO){
        Book bookSave = Book.bookSaved(bookDTO);

       bookRepository.save(bookSave);
       return BookDTO.bookSavedDTO(bookSave);
    }

    //Atualizar livro
    @Transactional
    @Override
    public BookDTO update(Long id, BookDTO bookRequest)  {
        Book book =  bookRepository.findById(id)
                .orElseThrow(BookNotFoundException::new);

        BookDTO dto = BookDTO.bookDTO(book);
        updateValuesBook(dto, bookRequest);

        return this.save(dto);
    }

    //Método para salvar e atualizar entidades dos livros
    public void updateValuesBook(BookDTO newObj, BookDTO oldObj){
        newObj.setCategories(oldObj.getCategories());
        newObj.setTitle(oldObj.getTitle());
        newObj.setIsbn(oldObj.getIsbn());
        newObj.setAuthor(oldObj.getAuthor());
        newObj.setSynopsis(oldObj.getSynopsis());
        newObj.setPublicationYear(oldObj.getPublicationYear());
        newObj.setAvailableQuantity((oldObj.getAvailableQuantity()));
        newObj.setPriceSell(oldObj.getPriceSell());

    }
    public Optional<Book> findByTitle(String title) {
        return bookRepository.findByTitle(title);
    }
}
