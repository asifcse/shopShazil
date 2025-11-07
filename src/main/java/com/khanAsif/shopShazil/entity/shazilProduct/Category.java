package com.khanAsif.shopShazil.entity.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
     private int categoryId;

    @Column(name="category_name")
     private String categoryName;

    @Column(name="remarks")
     private String remarks; 

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private Set<Product> product = new HashSet();


    @Column(name="created_date")
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date createdDate;

    @Column(name="updated_date")
    @Temporal(jakarta.persistence.TemporalType.DATE)
     private Date updatedDate;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="section_id")
    private Section section;

    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public Set<Product> getProduct() {
        return product;
    }
    public void setProduct(Set<Product> product) {
        this.product = product;
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
    public Section getSection() {
    return section;
    }
    public void setSection(Section section) {
        this.section = section;
    }
   
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.product);
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
        final Category other = (Category) obj;
        return Objects.equals(this.product, other.product);
    }

}
