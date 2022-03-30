package br.com.phoebustecnologia.BookMicroservice.category.service;

import br.com.phoebustecnologia.BookMicroservice.category.dto.CategoryDTO;
import br.com.phoebustecnologia.BookMicroservice.category.model.Category;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public interface CategoryService {

    //Pesquisar livro pela Categoria
    Optional<Category> findByName(Long id, String name);

    //Listar categoria
    List<CategoryDTO> findAll();

    //Pesquisar Categoria por ID
    CategoryDTO findById(Long id);

    //Deletar categoria
    void delete(Long id);

    //Salvar categoria
    CategoryDTO save(CategoryDTO categoryDTO);

    //Atualizar categoria
    CategoryDTO update(Long id, CategoryDTO category);
}
