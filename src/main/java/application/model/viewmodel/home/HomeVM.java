package application.model.viewmodel.home;

import application.model.viewmodel.common.LayoutHeaderVM;

import java.util.List;

public class HomeVM {
    private LayoutHeaderVM layoutHeaderVM;
    List<ProductHotVM> productHotVMList;
    List<BlogVM> blogVMList;

    public List<BlogVM> getBlogVMList() {
        return blogVMList;
    }

    public void setBlogVMList(List<BlogVM> blogVMList) {
        this.blogVMList = blogVMList;
    }

    public List<ProductHotVM> getProductHotVMList() {
        return productHotVMList;
    }

    public void setProductHotVMList(List<ProductHotVM> productHotVMList) {
        this.productHotVMList = productHotVMList;
    }

    public LayoutHeaderVM getLayoutHeaderVM() {
        return layoutHeaderVM;
    }

    public void setLayoutHeaderVM(LayoutHeaderVM layoutHeaderVM) {
        this.layoutHeaderVM = layoutHeaderVM;
    }
}
