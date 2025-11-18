package com.khanAsif.shopShazil.contorller;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Department;
import com.khanAsif.shopShazil.entity.shazilProduct.Product;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.CategoryServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.DepartmentServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.ProductDescriptionServiceImplment;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.ProductServiceImplement;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.SectionServiceImplement;
import java.util.Date;
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
    
     
    
    
}
