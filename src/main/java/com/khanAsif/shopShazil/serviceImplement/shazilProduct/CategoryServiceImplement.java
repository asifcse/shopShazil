package com.khanAsif.shopShazil.serviceImplement.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */


import com.khanAsif.shopShazil.entity.shazilProduct.Category;
import com.khanAsif.shopShazil.repository.shazilProduct.CategoryRepository;
import com.khanAsif.shopShazil.service.shazilProduct.CategoryService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryServiceImplement implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategory() {
        
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public Category getById(Long id) {
       
        Optional<Category> optioanl = categoryRepository.findById(id);
        Category category= null;
        
        if(optioanl.isPresent()){
            category=optioanl.get();
        }else{
        
            throw new RuntimeException("Category not found for id : " + id);
        }
        
        return category;
    }

    @Override
    public void deleteViaId(long id) {
           categoryRepository.deleteById(id);
    }
}
