
package com.khanAsif.shopShazil.entity.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import jakarta.persistence.*;
@Entity
@Table(name="department")
public class Department implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private long id;
   
   @Column(name="department_name")
    private String departmentName;
   
   @OneToMany(mappedBy="department", cascade=CascadeType.ALL)
   private Set<Section> section = new HashSet();

   @Column(name="created_date")
   @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date createdDate;
   
   @Column(name="updated_date")
   @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date updatedDate;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    public Set<Section> getSection() {
        return section;
    }

    public void setSection(Set<Section> section) {
        this.section = section;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.section);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        return Objects.equals(this.section, other.section);
    }   
}
