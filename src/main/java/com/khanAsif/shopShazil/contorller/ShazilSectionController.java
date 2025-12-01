package com.khanAsif.shopShazil.contorller;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Department;
import com.khanAsif.shopShazil.entity.shazilProduct.Section;
import com.khanAsif.shopShazil.serviceImplement.shazilProduct.DepartmentServiceImplement;
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
@RequestMapping("/section/manage")
public class ShazilSectionController {
    
     @Autowired private SectionServiceImplement sectionServiceImplement;
     @Autowired private DepartmentServiceImplement departmentServiceImplement;
     
    @GetMapping("/list")
    public String sectionList(Model model){
    
        model.addAttribute("sectionList",sectionServiceImplement.getAllSection());
        return "section_list";
    }
    
    @GetMapping("/create")
    public String addSection(Model model) {

        Section section = new Section();
        List<Department> departmentList = departmentServiceImplement.getAllDepartment();
        model.addAttribute("section", section);
        model.addAttribute("departmentList", departmentList);
        return "section_create";
    }
    
    @PostMapping("/save")
    public String saveSection(@ModelAttribute("section") Section section) {
        
        Date now = new Date();
        section.setCreatedDate(now);
        sectionServiceImplement.save(section);
        return "redirect:/section/manage/list";
    }
    
    @GetMapping("/update/{id}")
    public String updateSectionForm(@PathVariable(value = "id") long id, Model model) {

        Section section = sectionServiceImplement.getById(id);
        List<Department> departmentList = departmentServiceImplement.getAllDepartment();
         model.addAttribute("departmentList", departmentList);
        model.addAttribute("section", section);
        return "section_update";
    }
    
    @PostMapping("/update")
    public String updateSectionSave(@ModelAttribute("section") Section section) {
       
        Section section2 = sectionServiceImplement.getById(section.getId());
        section.setCreatedDate(section2.getCreatedDate());

        section.setUpdatedDate(new Date());
        sectionServiceImplement.save(section);
     
        return "redirect:/section/manage/list";
    }    
    
    @GetMapping("/delete/{id}")
    public String deleteSectionThroughId(@PathVariable(value = "id") long id) {

        
        sectionServiceImplement.deleteViaId(id);
        return "redirect:/section/manage/list";
    }    
}
