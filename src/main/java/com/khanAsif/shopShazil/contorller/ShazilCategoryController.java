package com.khanAsif.shopShazil.contorller;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Category;
import com.khanAsif.shopShazil.entity.shazilProduct.Section;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.SectionServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.CategoryServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.DepartmentServiceImplement;
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
@RequestMapping("/category/manage")
public class ShazilCategoryController {
    
    @Autowired private SectionServiceImplement sectionServiceImplement;
    @Autowired private CategoryServiceImplement categoryServiceImplement;

    @GetMapping("/list")
    public String categoryList(Model model){
    
        model.addAttribute("categoryList",categoryServiceImplement.getAllCategory());
        return "category_list";
    }

    @GetMapping("/create")
    public String addCategoryForm(Model model) {

        Category category = new Category();
        List<Section> sectionList = sectionServiceImplement.getAllSection();
        model.addAttribute("category", category);
        model.addAttribute("sectionList", sectionList);
        return "category_create";
    }
    
    @PostMapping("/save")
    public String CategoryFormSave(@ModelAttribute("category") Category category) {
        
        Date now = new Date();
        category.setCreatedDate(now);
        categoryServiceImplement.save(category);
        return "redirect:/category/manage/list";
    }
    
    @GetMapping("/update/{id}")
    public String updateCategoryForm(@PathVariable(value = "id") long id, Model model) {

        Category category = categoryServiceImplement.getById(id);
        List<Section> sectionList = sectionServiceImplement.getAllSection();
         model.addAttribute("sectionList", sectionList);
        model.addAttribute("category", category);
        return "category_update";
    }
    
    @PostMapping("/update")
    public String updateCategorySave(@ModelAttribute("category") Category category) {
       
        Category category2 =categoryServiceImplement.getById(category.getId());
        category.setCreatedDate(category2.getCreatedDate());

        category.setUpdatedDate(new Date());
        categoryServiceImplement.save(category);
     
        return "redirect:/category/manage/list";
    }    
    
    @GetMapping("/delete/{id}")
    public String deleteCategoryThroughId(@PathVariable(value = "id") long id) {

        
        categoryServiceImplement.deleteViaId(id);
        return "redirect:/category/manage/list";
    }
    
}
