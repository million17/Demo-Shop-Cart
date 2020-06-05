package application.model.viewmodel.admin;

import application.model.viewmodel.CategoryVM;

import java.util.List;

public class AdminCategoryVM {

    List<CategoryVM> categoryVMList;

    public List<CategoryVM> getCategoryVMList() {
        return categoryVMList;
    }

    public void setCategoryVMList(List<CategoryVM> categoryVMList) {
        this.categoryVMList = categoryVMList;
    }
}
