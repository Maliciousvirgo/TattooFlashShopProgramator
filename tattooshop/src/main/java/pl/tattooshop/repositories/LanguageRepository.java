package pl.tattooshop.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.tattooshop.models.Language;
import pl.tattooshop.models.Product;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    Page<Product> findByNameContaining(String phrase, Pageable pageable);
}
