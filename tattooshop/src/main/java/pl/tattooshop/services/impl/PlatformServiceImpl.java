package pl.tattooshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tattooshop.exceptions.ItemNotFoundException;
import pl.tattooshop.repositories.PlatformRepository;
import pl.tattooshop.repositories.ProductRepository;
import pl.tattooshop.models.Platform;
import pl.tattooshop.models.Product;
import pl.tattooshop.services.PlatformService;

import java.util.Optional;

@Service
public class PlatformServiceImpl implements PlatformService {
    
    @Autowired
    private PlatformRepository platformRepository;
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Page<Product> getAllProductsbyPlatform(Long id, Pageable pageable) {
        Page page = productRepository.findAllProductsByPlatform(id, pageable);
        return page;
    }

    @Override
    public Page<Platform> getAllPlatforms(Pageable pageable) {
        Page page = platformRepository.findAll(pageable);
        return page;
    }

    @Transactional
    @Override
    public Platform getPlatform(Long id) {
        Optional<Platform> optionalPlatform = platformRepository.findById(id);
        Platform platform = optionalPlatform.orElseThrow(()->new ItemNotFoundException(id));
        return platform;
    }

    @Override
    public void deletePlatform(Long id) {
        platformRepository.deleteById(id);
    }

    @Override
    public void savePlatform(Platform platform) {
        platformRepository.save(platform);
    }
}
