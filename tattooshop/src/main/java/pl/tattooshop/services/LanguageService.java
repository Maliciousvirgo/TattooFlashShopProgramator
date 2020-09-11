package pl.tattooshop.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pl.tattooshop.models.Language;

public interface LanguageService {

    Page<Language> getAllLanguages(Pageable pageable);

    Language getLanguage(Long id);

    void deleteLanguage(Long id);

    void saveLanguage(Language language);
}
