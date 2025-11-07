package com.khanAsif.shopShazil.entity.shazilProduct;

/**
 *
 * @author Asif khan <asif.cse12@gmail.com>
 */
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import jakarta.persistence.*;

@Entity
@Table(name="product_description")
public class ProductDescription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name="description")
    private String description;
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
