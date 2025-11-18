package com.khanAsif.shopShazil.service.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import com.khanAsif.shopShazil.entity.shazilProduct.Department;
import java.util.Date;
import java.util.List;

public interface DepartmentService {
        List<Department> getAllDepartment();
        void save(Department department);
        Department getById(Long id);
        void deleteViaId(long id);
}
