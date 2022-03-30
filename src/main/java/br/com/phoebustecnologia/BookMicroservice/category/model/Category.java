package br.com.phoebustecnologia.BookMicroservice.category.model;

import br.com.phoebustecnologia.BookMicroservice.book.model.Book;
import br.com.phoebustecnologia.BookMicroservice.category.dto.CategoryDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(builderClassName = "Builder")
@Table(name = "categories")
public class Category implements Serializable {
    private static final long SerialVersionID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

    //@JsonIgnore
//    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
//    @PrimaryKeyJoinColumn
   // @ManyToMany
    //private final Set<Book> books = new HashSet<>();


    public static Category categoryFrom(CategoryDTO categoryDTO) {
        return builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
    }

    public static Category categorySaved(CategoryDTO categoryDTO) {
        return builder()
                .id(categoryDTO.getId())
                .name(categoryDTO.getName())
                .build();
    }

}
