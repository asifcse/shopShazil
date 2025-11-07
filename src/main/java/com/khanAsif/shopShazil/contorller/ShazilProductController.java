
package com.khanAsif.shopShazil.contorller;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.serviceImplement.shazilProduct.CategoryServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.DepartmentServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.ProductDescriptionServiceImplment;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.ProductServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.SectionServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ShazilProductController {
     @Autowired private CategoryServiceImplement categoryServiceImplement;
     @Autowired private DepartmentServiceImplement departmentServiceImplement;
     @Autowired private ProductDescriptionServiceImplment productDescriptionImplement;
     @Autowired private ProductServiceImplement productServiceImplement;
     @Autowired private SectionServiceImplement sectionServiceImplement;
     
     @GetMapping("/index")
    public String listOfProductInSazilShop(Model model){
        model.addAttribute("allProducts", productServiceImplement.getAllProduct());
        return "all-products";
    }
}
