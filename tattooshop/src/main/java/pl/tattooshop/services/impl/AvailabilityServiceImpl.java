package pl.tattooshop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.tattooshop.exceptions.ItemNotFoundException;
import pl.tattooshop.repositories.AvailabilityTypeRepository;
import pl.tattooshop.models.AvailabilityType;
import pl.tattooshop.services.AvailabilityService;

import java.util.Optional;

@Service
public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityTypeRepository availabilityTypeRepository;

    @Override
    public Page<AvailabilityType> getAllTypes(Pageable pageable) {
        Page page = availabilityTypeRepository.findAll(pageable);
        return page;
    }

    @Transactional
    @Override
    public AvailabilityType getType(Long id) {
        Optional<AvailabilityType> optionalType = availabilityTypeRepository.findById(id);
        AvailabilityType type = optionalType.orElseThrow(()->new ItemNotFoundException(id));
        return type;
    }

    @Override
    public void deleteType(Long id) {
        availabilityTypeRepository.deleteById(id);
    }

    @Override
    public void saveType(AvailabilityType type) {
        availabilityTypeRepository.save(type);
    }
}
