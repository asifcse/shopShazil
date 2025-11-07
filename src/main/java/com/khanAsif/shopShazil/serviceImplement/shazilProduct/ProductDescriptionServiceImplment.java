package com.khanAsif.shopShazil.serviceImplement.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.ProductDescription;
import com.khanAsif.shopShazil.repository.shazilProduct.ProductDescriptionRepository;
import com.khanAsif.shopShazil.service.shazilProduct.ProductDescriptionService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDescriptionServiceImplment implements ProductDescriptionService {
    
    @Autowired ProductDescriptionRepository productDescriptionRepository;

    @Override
    public List<ProductDescription> getAllProductDescription() {
        return productDescriptionRepository.findAll();
    }

    @Override
    public void save(ProductDescription productDescription) {
        productDescriptionRepository.save(productDescription);
    }

    @Override
    public ProductDescription getById(Long id) {
       
        Optional<ProductDescription> optional = productDescriptionRepository.findById(id);
        
        ProductDescription productDescription = null;
        if (optional.isPresent())
            productDescription = optional.get();
        else
            throw new RuntimeException(
                    "Product Description not found for id : " + id);
        return productDescription;
    }

    @Override
    public void deleteViaId(long id) {
        productDescriptionRepository.deleteById(id);
    }
}
