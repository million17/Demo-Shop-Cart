package application.model.viewmodel.cart;

import application.model.viewmodel.common.LayoutHeaderVM;

import java.util.*;

public class CartVM {
    private LayoutHeaderVM layoutHeaderVM;
    private List<CartProductVM> cartProductVMList;
    private double totalPrice;
    private double shipPrice;
    private int productAmount;
    private double total;

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public double getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(double shipPrice) {
        this.shipPrice = shipPrice;
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
