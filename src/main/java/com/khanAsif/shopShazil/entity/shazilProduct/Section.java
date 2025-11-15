package com.khanAsif.shopShazil.entity.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "section")
public class Section implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "section_name")
    private String sectionName;

    @Column(name = "created_date")
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name = "updated_date")
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date updatedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "section", cascade = CascadeType.ALL)
    private Set<Category> category = new HashSet();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Category> getCategory() {
        return category;
    }

    public void setCategory(Set<Category> category) {
        this.category = category;
    }
}
