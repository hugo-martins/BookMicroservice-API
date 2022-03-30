package br.com.phoebustecnologia.BookMicroservice.category.dto;

import br.com.phoebustecnologia.BookMicroservice.category.model.Category;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    public static CategoryDTO categoryDTO (Category categoryEntity){
        return builder()
                .id(categoryEntity.getId())
                .name(categoryEntity.getName())
                .build();
    }

    public static List<CategoryDTO> categoriesFromAll(List<Category> categories) {
        return categories.stream().map(CategoryDTO::categoryDTO).collect(Collectors.toList());
    }


    public static CategoryDTO categorySavedDTO (Category categoryEntity){
        return builder()
                .name(categoryEntity.getName())
                .build();
    }

}
