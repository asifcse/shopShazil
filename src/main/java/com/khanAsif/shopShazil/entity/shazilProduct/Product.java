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
@Table(name = "product")
public class Product implements Serializable {
    
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
    private long id;   
   
   @Column(name = "product_name")
    private String productName;
   
   @Column(name = "product_stock")
    private int productStock;
   
   @Column(name = "product_price_buying_per_unit")
    private double productPriceBuyingPerUnit;
   
   @Column(name="product_price_selling_per_unit")
    private double productSellingPricePerUnit;
   
   @Column(name="product_img_url_one")
    private String productImgeUrlOne;
   
   @Column(name="product_manufacturer_company_name")
    private String productManufacturerCompanyName;
   
    @Column(name="product_manufacturer_date")
    
    private String productManufacturerDate;

    @Column(name="product_expiry_date")
    private String productExpiryDate;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private Category category;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="product_description_id", unique=true)
    private ProductDescription productDescription;

    @Column(name="remarks")
    private String remarks;
    
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
    
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getProductStock() {
        return productStock;
    }
    public void setProductStock(int productStock) {
        this.productStock = productStock;
    }
    public double getProductSellingPricePerUnit() {
        return productSellingPricePerUnit;
    }
    public void setProductSellingPricePerUnit(double productSellingPricePerUnit) {
        this.productSellingPricePerUnit = productSellingPricePerUnit;
    }
    public String getProductImgeUrlOne() {
        return productImgeUrlOne;
    }
    public void setProductImgeUrlOne(String productImgeUrlOne) {
        this.productImgeUrlOne = productImgeUrlOne;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
    public Category getCategory() {
    return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
    public ProductDescription getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(ProductDescription productDescription) {
        this.productDescription = productDescription;
    }
    
    public double getProductPriceBuyingPerUnit() {
       return productPriceBuyingPerUnit;
    }

    public void setProductPriceBuyingPerUnit(double productPriceBuyingPerUnit) {
        this.productPriceBuyingPerUnit = productPriceBuyingPerUnit;
    }

    public String getProductManufacturerCompanyName() {
        return productManufacturerCompanyName;
    }

    public void setProductManufacturerCompanyName(String productManufacturerCompanyName) {
        this.productManufacturerCompanyName = productManufacturerCompanyName;
    }

    public String getProductManufacturerDate() {
        return productManufacturerDate;
    }

    public void setProductManufacturerDate(String productManufacturerDate) {
        this.productManufacturerDate = productManufacturerDate;
    }
    public String getProductExpiryDate() {
        return productExpiryDate;
    }

    public void setProductExpiryDate(String productExpiryDate) {
        this.productExpiryDate = productExpiryDate;
    }
    
}
