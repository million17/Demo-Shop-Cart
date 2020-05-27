package application.model.viewmodel;

import application.model.viewmodel.common.LayoutHeaderVM;

import java.util.List;

public class ShopProductVM {
    private List<SizeVM> sizeVMList;
    private List<ProductVM> productVMList;
    private List<ColorVM> colorVMList;
    private List<CategoryVM> categoryVMList;
    private LayoutHeaderVM layoutHeaderVM;
    private long totalProduct;

    public long getTotalProduct() {
        return totalProduct;
    }

    public void setTotalProduct(long totalProduct) {
        this.totalProduct = totalProduct;
    }

    public LayoutHeaderVM getLayoutHeaderVM() {
        return layoutHeaderVM;
    }

    public void setLayoutHeaderVM(LayoutHeaderVM layoutHeaderVM) {
        this.layoutHeaderVM = layoutHeaderVM;
    }

    public List<CategoryVM> getCategoryVMList() {
        return categoryVMList;
    }

    public void setCategoryVMList(List<CategoryVM> categoryVMList) {
        this.categoryVMList = categoryVMList;
    }

    public ShopProductVM() {
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
