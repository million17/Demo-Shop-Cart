package application.model.viewmodel.admin;

import application.model.viewmodel.user.UserVM;

import java.util.List;

public class AdminUserVM {
    private List<UserVM> userVMList;

    public List<UserVM> getUserVMList() {
        return userVMList;
    }

    public void setUserVMList(List<UserVM> userVMList) {
        this.userVMList = userVMList;
    }
}
