package pl.tattooshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.tattooshop.controllers.commands.ProductFilter;
import pl.tattooshop.models.*;

import java.util.List;

public interface ProductService {

    List<AvailabilityType> getAllAvailabilityTypes();

    List<Platform> getAllPlatforms();

    List<Language> getAllLanguages();

    List<Category> getAllCategories();

    Page<Product> getAllProducts(ProductFilter filter, Pageable pageable);

    Product getProduct(Long id);

    void deleteProduct(Long id);

    void saveProduct(Product product);
}
