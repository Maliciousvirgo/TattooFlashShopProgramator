package pl.tattooshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.tattooshop.models.Category;
import pl.tattooshop.models.Product;

public interface CategoryService {

    Page<Product> getAllProductsbyCategory(Long id, Pageable pageable);

    Page<Category> getAllCategories(Pageable pageable);

    Category getCategory(Long id);

    void deleteCategory(Long id);

    void saveCategory(Category category);
}
