package com.khanAsif.shopShazil.contorller;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Category;
import com.khanAsif.shopShazil.entity.shazilProduct.Department;
import com.khanAsif.shopShazil.entity.shazilProduct.Product;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.CategoryServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.DepartmentServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.ProductDescriptionServiceImplment;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.ProductServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.SectionServiceImplement;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product/manage")
public class ShazilProductController {
    
    @Autowired private ProductServiceImplement productServiceImplement;
    @Autowired private CategoryServiceImplement categoryServiceImplement;
    
    @GetMapping("/list")
    public String categoryList(Model model){
    
        model.addAttribute("productList",productServiceImplement.getAllProduct());
        return "product_list";
    }    
    
    @GetMapping("/create")
    public String addProductForm(Model model) {

        Product product = new Product();
        List<Category> categoryList = categoryServiceImplement.getAllCategory();
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryList);
        return "product_create";
    }     

    @PostMapping("/save")
    public String productFormSave(@ModelAttribute("product") Product product) {
        
        Date now = new Date();
        product.setCreatedDate(now);
        productServiceImplement.save(product);
        return "redirect:/product/manage/list";
    }    
    @GetMapping("/update/{id}")
    public String updateProductForm(@PathVariable(value = "id") long id, Model model) {
        Product product = productServiceImplement.getById(id);
        List<Category> categoryList = categoryServiceImplement.getAllCategory();
         model.addAttribute("categoryList", categoryList);
        model.addAttribute("product", product);
        
        return "product_update";
    }
    
    @PostMapping("/update")
    public String updateProductSave(@ModelAttribute("product") Product product) {
       
        Product product2 =productServiceImplement.getById(product.getId());
        product.setCreatedDate(product2.getCreatedDate());

        product.setUpdatedDate(new Date());
        productServiceImplement.save(product);
     
        return "redirect:/product/manage/list";
    }    
    
    @GetMapping("/delete/{id}")
    public String deleteProductThroughId(@PathVariable(value = "id") long id) {

        
        productServiceImplement.deleteViaId(id);
        return "redirect:/category/manage/list";
    }
}
