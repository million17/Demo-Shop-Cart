package application.model.viewmodel;

import application.data.model.Size;

import java.util.*;

public class HomeVM {
    List<SizeVM> sizeVMList;
    List<ProductVM> productVMList;

    public HomeVM() {
    }

    public List<SizeVM> getSizeVMList() {
        return sizeVMList;
    }

    public List<ProductVM> getProductVMList() {
        return productVMList;
    }

    public void setProductVMList(List<ProductVM> productVMList) {
        this.productVMList = productVMList;
    }

    public void setSizeVMList(List<SizeVM> sizeVMList) {
        this.sizeVMList = sizeVMList;
    }
}
