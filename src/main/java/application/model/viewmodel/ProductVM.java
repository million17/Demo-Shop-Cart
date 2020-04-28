package application.model.viewmodel;

import application.extension.CustomDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class ProductVM {
    private int id;
    private String productName;
    private String shortDesc;
    private String mainImage;
    private int categoryId;
    private Double price;
    private String brand;

    private Date createdDate;

    public ProductVM(int id, String productName, String shortDesc, String mainImage, int categoryId, Double price, String brand, Date createdDate) {
        this.id = id;
        this.productName = productName;
        this.shortDesc = shortDesc;
        this.mainImage = mainImage;
        this.categoryId = categoryId;
        this.price = price;
        this.brand = brand;
        this.createdDate = createdDate;
    }

    public ProductVM() {
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
