
package com.khanAsif.shopShazil.serviceImplement.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Department;
import com.khanAsif.shopShazil.repository.shazilProduct.DepartmentRepository;
import com.khanAsif.shopShazil.service.shazilProduct.DepartmentService;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImplement implements DepartmentService {
    
    @Autowired DepartmentRepository departmentRepository;

    @Override
    public List<Department> getAllDepartment() {
       return departmentRepository.findAll();
    }

    @Override
    public void save(Department department) {
        departmentRepository.save(department);
    }

    @Override
    public Department getById(Long id) {
        Optional<Department> optional = departmentRepository.findById(id);
        Department department = null;
        
        if(optional.isPresent()){
            department= optional.get();
        }else{
            throw new RuntimeException("Department not found for id : " + id);
        }
        return department;
    }

    @Override
    public void deleteViaId(long id) {
        departmentRepository.deleteById(id);
    }

}
