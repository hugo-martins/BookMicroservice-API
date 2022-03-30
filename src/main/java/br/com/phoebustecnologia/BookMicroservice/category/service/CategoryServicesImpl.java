package br.com.phoebustecnologia.BookMicroservice.category.service;

import br.com.phoebustecnologia.BookMicroservice.category.dto.CategoryDTO;
import br.com.phoebustecnologia.BookMicroservice.category.model.Category;
import br.com.phoebustecnologia.BookMicroservice.category.repositories.CategoryRepository;
import br.com.phoebustecnologia.BookMicroservice.exceptions.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CategoryServicesImpl implements CategoryService{

    private final CategoryRepository categoryRepository;



    public CategoryServicesImpl(CategoryRepository categoryRepository) {
        super();
        this.categoryRepository = categoryRepository;
    }

    //Pesquisar Categoria Pelo nome
    @Override
    public Optional<Category> findByName(Long id, String name){
        return categoryRepository.findByName(name);
    }

    //Listar categoria
    @Override
    public List<CategoryDTO> findAll(){
        return CategoryDTO.categoriesFromAll(categoryRepository.findAll());
    }


    //Pesquisar Categoria por ID
    @Override
    public CategoryDTO findById(Long id){
        Category result = categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        return CategoryDTO.categoryDTO(result);
    }

    //Deletar categoria
    @Override
    public void delete(Long id){
        Category category =  categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);
        categoryRepository.delete(category);
    }


    //Salvar categoria
    @Override
    public CategoryDTO save(CategoryDTO categoryDTO){
        Category categorySaved = categoryRepository.save(Category.categorySaved(categoryDTO));
        return CategoryDTO.categorySavedDTO(categorySaved);
    }


    //Atualizar categoria
    public CategoryDTO update(Long id, CategoryDTO categoryRequest)  {
        Category category =  categoryRepository.findById(id)
                .orElseThrow(CategoryNotFoundException::new);

        CategoryDTO dto = CategoryDTO.categoryDTO(category);
        updateValues(dto,categoryRequest);
        return save(dto);
    }

    //Captura um objeto antigo e atualiza para um novo
    public void updateValues(@NotNull CategoryDTO newObj, CategoryDTO oldObj){
        newObj.setName(oldObj.getName());
    }
}
