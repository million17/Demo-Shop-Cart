package application.model.viewmodel.user;

import application.model.viewmodel.common.LayoutHeaderVM;

public class UserDetailVM {
    private LayoutHeaderVM layoutHeaderVM;
    private UserVM userVM;

    public LayoutHeaderVM getLayoutHeaderVM() {
        return layoutHeaderVM;
    }

    public void setLayoutHeaderVM(LayoutHeaderVM layoutHeaderVM) {
        this.layoutHeaderVM = layoutHeaderVM;
    }

    public UserVM getUserVM() {
        return userVM;
    }

    public void setUserVM(UserVM userVM) {
        this.userVM = userVM;
    }
}
