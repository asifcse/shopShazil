package com.khanAsif.shopShazil.service.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Product;
import java.util.List;


public interface ProductService {
        List<Product> getAllProduct();
        void save(Product product);
        Product getById(Long id);
        void deleteViaId(long id);
}
