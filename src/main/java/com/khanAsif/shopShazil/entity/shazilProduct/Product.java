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
    private long productId;
   
   @Column(name = "product_name")
    private String productName;
   
   @Column(name = "product_stock")
    private int productStock;
   
   @Column(name = "product_price_bying_per_unit")
    private double productByingPricePerUnit;
   
   @Column(name="product_price_selling_per_unit")
    private double productSellingPricePerUnit;
   
   @Column(name="product_img_url_one")
    private String productImgeUrlOne;
   
   @Column(name="product_menufacture_company")
    private String productMenufactureName;
   
    @Column(name="product_menufacture_date")
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date productMenufactureDate;
    
    @Column(name="product_expier_date")
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date productExpierDate;
    
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
    
    public long getProductId() {
        return productId;
    }
    public void setProductId(long productId) {
        this.productId = productId;
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
    public double getProductByingPricePerUnit() {
        return productByingPricePerUnit;
    }
    public void setProductByingPricePerUnit(double productByingPricePerUnit) {
        this.productByingPricePerUnit = productByingPricePerUnit;
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
    public Date getProductMenufactureDate() {
        return productMenufactureDate;
    }
    public void setProductMenufactureDate(Date productMenufactureDate) {
        this.productMenufactureDate = productMenufactureDate;
    }
    public Date getProductExpierDate() {
        return productExpierDate;
    }
    public void setProductExpierDate(Date productExpierDate) {
        this.productExpierDate = productExpierDate;
    }
    public String getRemarks() {
        return remarks;
    }
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    public String getProductMenufactureName() {
        return productMenufactureName;
    }
    public void setProductMenufactureName(String productMenufactureName) {
        this.productMenufactureName = productMenufactureName;
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
    
    
}
