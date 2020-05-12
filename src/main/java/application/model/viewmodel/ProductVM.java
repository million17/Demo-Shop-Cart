package application.model.viewmodel;

import application.extension.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductVM {
    private int id;
    private String productName;
    private String shortDesc;
    private String mainImage;
    private int categoryId;
    private Double price;
    private String categoryName;
    private String brand;
    List<ProductImageVM>  productImageVMS;
    List<ProductEntityVM> productEntityVMS;

    private Date createdDate;

    public ProductVM(int id, String productName, String shortDesc, String categoryName, String mainImage, int categoryId, Double price, String brand, List<ProductImageVM> productImageVMS, List<ProductEntityVM> productEntityVMS, Date createdDate) {
        this.id = id;
        this.productName = productName;
        this.shortDesc = shortDesc;
        this.mainImage = mainImage;
        this.categoryId = categoryId;
        this.price = price;
        this.brand = brand;
        this.productImageVMS = productImageVMS;
        this.productEntityVMS = productEntityVMS;
        this.createdDate = createdDate;
        this.categoryName = categoryName;
    }

    public ProductVM() {
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductImageVM> getProductImageVMS() {
        return productImageVMS;
    }

    public void setProductImageVMS(List<ProductImageVM> productImageVMS) {
        this.productImageVMS = productImageVMS;
    }

    public List<ProductEntityVM> getProductEntityVMS() {
        return productEntityVMS;
    }

    public void setProductEntityVMS(List<ProductEntityVM> productEntityVMS) {
        this.productEntityVMS = productEntityVMS;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
