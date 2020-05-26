package application.model.viewmodel.common;

import application.model.viewmodel.cart.CartProductVM;
import application.model.viewmodel.home.SlideVM;

import java.util.*;

public class LayoutHeaderVM {
    private String userName;
    private String avatar;
    private String companyName;
    private int productAmounts;
    public double totalPrices;
    private List<CartProductVM> cartProductVMList;
    private ArrayList<HeaderMenuVM> headerMenuVMArrayList;
    private ArrayList<SlideVM> slideVMArrayList;

    public int getProductAmounts() {
        return productAmounts;
    }

    public void setProductAmounts(int productAmounts) {
        this.productAmounts = productAmounts;
    }

    public double getTotalPrices() {
        return totalPrices;
    }

    public void setTotalPrices(double totalPrices) {
        this.totalPrices = totalPrices;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public ArrayList<SlideVM> getSlideVMArrayList() {
        return slideVMArrayList;
    }

    public void setSlideVMArrayList(ArrayList<SlideVM> slideVMArrayList) {
        this.slideVMArrayList = slideVMArrayList;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public ArrayList<HeaderMenuVM> getHeaderMenuVMArrayList() {
        return headerMenuVMArrayList;
    }

    public void setHeaderMenuVMArrayList(ArrayList<HeaderMenuVM> headerMenuVMArrayList) {
        this.headerMenuVMArrayList = headerMenuVMArrayList;
    }

    public List<CartProductVM> getCartProductVMList() {
        return cartProductVMList;
    }

    public void setCartProductVMList(List<CartProductVM> cartProductVMList) {
        this.cartProductVMList = cartProductVMList;
    }
}
