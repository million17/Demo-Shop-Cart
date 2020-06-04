package application.model.viewmodel.admin;

import application.model.viewmodel.CategoryVM;
import application.model.viewmodel.ProductVM;

import java.util.List;

public class AdminProductVM {
    List<ProductVM> productVMList;
    List<CategoryVM> categoryVMList;

    public List<CategoryVM> getCategoryVMList() {
        return categoryVMList;
    }

    public void setCategoryVMList(List<CategoryVM> categoryVMList) {
        this.categoryVMList = categoryVMList;
    }

    public List<ProductVM> getProductVMList() {
        return productVMList;
    }

    public void setProductVMList(List<ProductVM> productVMList) {
        this.productVMList = productVMList;
    }
}
