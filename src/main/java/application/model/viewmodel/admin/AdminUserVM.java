package application.model.viewmodel.admin;

import application.model.viewmodel.user.RoleVM;
import application.model.viewmodel.user.UserVM;

import java.util.List;

public class AdminUserVM {
    private List<UserVM> userVMList;
    private List<RoleVM> roleVMList;

    public List<RoleVM> getRoleVMList() {
        return roleVMList;
    }

    public void setRoleVMList(List<RoleVM> roleVMList) {
        this.roleVMList = roleVMList;
    }

    public List<UserVM> getUserVMList() {
        return userVMList;
    }

    public void setUserVMList(List<UserVM> userVMList) {
        this.userVMList = userVMList;
    }
}
