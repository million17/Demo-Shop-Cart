package application.model.viewmodel.cart;

import application.model.viewmodel.common.LayoutHeaderVM;

import java.util.*;

public class CartVM {
    private LayoutHeaderVM layoutHeaderVM;
    private List<CartProductVM> cartProductVMList;
    private String totalPrice;
    private double shipPrice;
    private String total;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public double getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(double shipPrice) {
        this.shipPrice = shipPrice;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LayoutHeaderVM getLayoutHeaderVM() {
        return layoutHeaderVM;
    }

    public void setLayoutHeaderVM(LayoutHeaderVM layoutHeaderVM) {
        this.layoutHeaderVM = layoutHeaderVM;
    }

    public List<CartProductVM> getCartProductVMList() {
        return cartProductVMList;
    }

    public void setCartProductVMList(List<CartProductVM> cartProductVMList) {
        this.cartProductVMList = cartProductVMList;
    }
}
