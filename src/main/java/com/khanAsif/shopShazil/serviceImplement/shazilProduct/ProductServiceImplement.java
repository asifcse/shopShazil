
package com.khanAsif.shopShazil.serviceImplement.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Product;
import com.khanAsif.shopShazil.service.shazilProduct.ProductService;
import org.springframework.stereotype.Service;
import com.khanAsif.shopShazil.repository.shazilProduct.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ProductServiceImplement  implements ProductService{
    
    @Autowired
    private ProductRepository ProductRepository;

    @Override
    public List<Product> getAllProduct() {
        
        return ProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        ProductRepository.save(product);
    }

    @Override
    public Product getById(Long id) {
        Optional<Product> optional = ProductRepository.findById(id);
        Product product = null;
        if (optional.isPresent())
            product = optional.get();
        else
            throw new RuntimeException(
                    "Product not found for id : " + id);
        return product;
    }

    @Override
    public void deleteViaId(long id) {
        ProductRepository.deleteById(id);
    }
}
