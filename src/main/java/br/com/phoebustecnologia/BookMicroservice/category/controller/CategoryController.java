package br.com.phoebustecnologia.BookMicroservice.category.controller;

import br.com.phoebustecnologia.BookMicroservice.category.dto.CategoryDTO;
import br.com.phoebustecnologia.BookMicroservice.category.service.CategoryServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {

    @Autowired
    CategoryServicesImpl categoryServicesImpl;


    //@ApiOperation("List of category")
    @GetMapping(value = "/all")
    public List<CategoryDTO> categoryList() {

        return categoryServicesImpl.findAll();
    }

    //@ApiOperation("Find an category by ID")
    @GetMapping(value = "/{id}")
    public CategoryDTO findCategoryByID(@PathVariable(name =  "id") Long id){
        return categoryServicesImpl.findById(id);

    }

    //@ApiOperation("Save an category")
    @PostMapping
    public CategoryDTO addCategory(@RequestBody CategoryDTO category) {
        return categoryServicesImpl.save(category);
    }

    //@ApiOperation("Delete on category")
    @DeleteMapping(value = "/{id}")
    public void  deleteCategory(@PathVariable Long id) {
        categoryServicesImpl.delete(id);

    }

    //@ApiOperation("Update on category")
    @PutMapping(value = "/{id}")
    public CategoryDTO updateCategory(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO){
        return categoryServicesImpl.update(id, categoryDTO);
    }

}
