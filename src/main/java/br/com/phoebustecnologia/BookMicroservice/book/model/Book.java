package br.com.phoebustecnologia.BookMicroservice.book.model;

import br.com.phoebustecnologia.BookMicroservice.book.dto.BookDTO;
import br.com.phoebustecnologia.BookMicroservice.category.model.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderClassName = "Builder")
@Table(name = "Books")
public class Book implements Serializable {
    private static final long SerialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String synopsis;

    private String isbn;

    private String author;

    private String publicationYear;

    private Double priceSell;

    private Integer availableQuantity;

//    @JoinTable(name = "Books_Category",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "category_id"))
    @ManyToMany(fetch = FetchType.EAGER )
    private Set<Category> categories = new HashSet<>();



    public static Book bookFrom(BookDTO bookDTO) {
        return Book
                .builder()
                .id(bookDTO.getId())
                .title(bookDTO.getTitle())
                .isbn(bookDTO.getIsbn())
                .synopsis(bookDTO.getSynopsis())
                .author(bookDTO.getAuthor())
                .publicationYear(bookDTO.getPublicationYear())
                .categories(bookDTO.getCategories())
                .priceSell(bookDTO.getPriceSell())
                .availableQuantity(bookDTO.getAvailableQuantity())
                .build();
    }

    public static Book bookSaved(BookDTO bookDTO) {
        return Book
                .builder()
                .id(bookDTO.getId())
                .title(bookDTO.getTitle())
                .isbn(bookDTO.getIsbn())
                .synopsis(bookDTO.getSynopsis())
                .author(bookDTO.getAuthor())
                .publicationYear(bookDTO.getPublicationYear())
                .categories(bookDTO.getCategories())
                .priceSell(bookDTO.getPriceSell())
                .availableQuantity(bookDTO.getAvailableQuantity())
                .build();
    }

}
