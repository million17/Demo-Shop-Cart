package application.model.viewmodel.admin;

import application.model.viewmodel.ProductVM;

import java.util.List;

public class AdminProductVM {
    List<ProductVM> productVMList;

    public List<ProductVM> getProductVMList() {
        return productVMList;
    }

    public void setProductVMList(List<ProductVM> productVMList) {
        this.productVMList = productVMList;
    }
}
