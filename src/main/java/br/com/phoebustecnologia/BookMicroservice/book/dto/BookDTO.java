package br.com.phoebustecnologia.BookMicroservice.book.dto;

import br.com.phoebustecnologia.BookMicroservice.book.model.Book;
import br.com.phoebustecnologia.BookMicroservice.category.model.Category;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookDTO implements Serializable {
    private static final long SerialVersionID = 1L;

    private Long id;

    private String title;

    private String synopsis;

    private String isbn;

    private String author;

    private String publicationYear;

    private Double priceSell;

    private Integer availableQuantity;

    private Set<Category> categories;

    public static  BookDTO bookDTO(Book bookEntity){
        return BookDTO
                .builder()
                .id(bookEntity.getId())
                .title(bookEntity.getTitle())
                .isbn(bookEntity.getIsbn())
                .synopsis(bookEntity.getSynopsis())
                .author(bookEntity.getAuthor())
                .publicationYear(bookEntity.getPublicationYear())
                .categories(bookEntity.getCategories())
                .priceSell(bookEntity.getPriceSell())
                .availableQuantity(bookEntity.getAvailableQuantity())
                .build();
    }

    public static List<BookDTO> ListFromAllBooks (List<Book> book) {
        return book.stream().map(BookDTO::bookDTO).collect(Collectors.toList());
    }

    public static BookDTO bookSavedDTO(Book bookEntity){
        return BookDTO
                .builder()
                .title(bookEntity.getTitle())
                .isbn(bookEntity.getIsbn())
                .synopsis(bookEntity.getSynopsis())
                .author(bookEntity.getAuthor())
                .publicationYear(bookEntity.getPublicationYear())
                .categories(bookEntity.getCategories())
                .priceSell(bookEntity.getPriceSell())
                .availableQuantity(bookEntity.getAvailableQuantity())
                .build();
    }
}
