package com.khanAsif.shopShazil.service.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.ProductDescription;
import java.util.List;

public interface ProductDescriptionService {
        List<ProductDescription> getAllProductDescription();
        void save(ProductDescription productDescription);
        ProductDescription getById(Long id);
        void deleteViaId(long id);
}
