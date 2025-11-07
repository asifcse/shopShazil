package com.khanAsif.shopShazil.service.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import java.util.List;
import com.khanAsif.shopShazil.entity.shazilProduct.Category;

public interface CategoryService {
    List<Category> getAllCategory();
    void save(Category category);
    Category getById(Long id);
    void deleteViaId(long id);
}
