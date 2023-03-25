package tn.esprit.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Entities.Category;
import tn.esprit.Services.CategoryService;
import tn.esprit.Services.ICategoryService;
import tn.esprit.Services.IProductService;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Category")
public class CatgeoryRestController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/all-categories")
    public List<Category> getAllCategories(){
        return categoryService.retrieveAllCategories();
    }

    @PostMapping("/add-category")
    public Category addCategory(@RequestBody Category c){
        return categoryService.addCategory(c);
    }

    @GetMapping("/retrieve-category/{idCategory}")
    public Category retrieveCategory(@PathVariable("idCategory") Integer idCategory){
        return categoryService.retrieveCategory(idCategory);
    }

    @PutMapping("/update-category")
    public Category updateCategory(@RequestBody Category c){
        return categoryService.updateCategory(c);
    }
    @DeleteMapping("/delete-category/{idCategory}")
    public void deleteCategory(@PathVariable("idCategory") Integer idCategory){
        categoryService.deleteCategory(idCategory);
    }

}
