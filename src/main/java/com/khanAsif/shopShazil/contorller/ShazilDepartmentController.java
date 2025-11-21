package com.khanAsif.shopShazil.contorller;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Department;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.DepartmentServiceImplement;
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
@RequestMapping("/department/manage")
public class ShazilDepartmentController {
    
    @Autowired private DepartmentServiceImplement departmentServiceImplement;
    
    @GetMapping("/list")
    public String departmentList(Model model){
    
        model.addAttribute("departmentList",departmentServiceImplement.getAllDepartment());
        return "department-list";
    }
    
    @GetMapping("/create")
    public String addDepartment(Model model) {

        Department department = new Department();
        model.addAttribute("department", department);
        
        return "department-create";
    }
    
    @PostMapping("/save")
    public String saveDepartment(@ModelAttribute("department") Department department) {
        Date now = new Date();
        department.setCreatedDate(now);
        departmentServiceImplement.save(department);
     
        return "redirect:/department/manage/list";
    }
    @GetMapping("/update/{id}")
    public String updateDepartmentForm(@PathVariable(value = "id") long id, Model model) {

        Department department = departmentServiceImplement.getById(id);

        model.addAttribute("department", department);
        return "department-update";
    }
    
    @PostMapping("/update")
    public String updateDepartmentSave(@ModelAttribute("department") Department department) {
       
        Department department2 = departmentServiceImplement.getById(department.getId());
        department.setCreatedDate(department2.getCreatedDate());

        department.setUpdatedDate(new Date());
        departmentServiceImplement.save(department);
     
        return "redirect:/department/manage/list";
    }
    @GetMapping("/delete/{id}")
    public String deleteDepartmentThroughId(@PathVariable(value = "id") long id) {

        
        departmentServiceImplement.deleteViaId(id);
        return "redirect:/department/manage/list";
    }
  
}
