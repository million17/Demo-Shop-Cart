package application.model.viewmodel;

import java.util.List;

public class HomeVM {
    List<SizeVM> sizeVMList;
    List<ProductVM> productVMList;
    List<ColorVM> colorVMList;

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

    public List<ColorVM> getColorVMList() {
        return colorVMList;
    }

    public void setColorVMList(List<ColorVM> colorVMList) {
        this.colorVMList = colorVMList;
    }
}
