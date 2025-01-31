package pl.tattooshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tattooshop.exceptions.ItemNotFoundException;
import pl.tattooshop.repositories.CategoryRepository;
import pl.tattooshop.repositories.ProductRepository;
import pl.tattooshop.models.Category;
import pl.tattooshop.models.Product;
import pl.tattooshop.services.CategoryService;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Category> getAllCategories(Pageable pageable) {
        Page page = categoryRepository.findAll(pageable);
        return page;
    }

    @Override
    public Page<Product> getAllProductsbyCategory(Long id, Pageable pageable) {
        Page page = productRepository.findAllProductsByCategory(id, pageable);
        return page;
    }

    @Transactional
    @Override
    public Category getCategory(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        Category category = optionalCategory.orElseThrow(()->new ItemNotFoundException(id));
        return category;
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
