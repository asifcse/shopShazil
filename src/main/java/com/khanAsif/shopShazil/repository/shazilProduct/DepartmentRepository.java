package com.khanAsif.shopShazil.repository.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.khanAsif.shopShazil.entity.shazilProduct.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long>{
    
}
