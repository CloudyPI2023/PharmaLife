package tn.esprit.Services;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.Entities.Category;
import tn.esprit.Repositories.CategoryRepository;

import java.util.List;
@Service
@AllArgsConstructor
public class CategoryService implements ICategoryService {
    CategoryRepository categoryRepository;
    @Override
    public List<Category> retrieveAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Category addCategory(Category c) {
         categoryRepository.save(c);
        return c;
    }

    @Override
    public Category updateCategory(Category c) {
        categoryRepository.save(c);
        return c;
    }

    @Override
    public Category retrieveCategory(Integer idCategory) {
        return categoryRepository.findById(idCategory).get();
    }

    @Override
    public void deleteCategory(Integer idCategory) {
        categoryRepository.deleteById(idCategory);

    }
}
