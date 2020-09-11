package pl.tattooshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.tattooshop.models.Category;
import pl.tattooshop.models.Product;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Page<Product> findByName(String phrase, Pageable pageable);
}
