package br.com.phoebustecnologia.BookMicroservice.category.repositories;

import br.com.phoebustecnologia.BookMicroservice.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category , Long> {

    Optional<Category> findByName(String name);

}
