package application.model.viewmodel.order;

import application.model.viewmodel.common.LayoutHeaderVM;

import java.util.List;

public class OrderDetailVM {
    private LayoutHeaderVM layoutHeaderVM;
    private List<OrderProductVM> orderProductVMS;
    private OrderVM orderVM;

    public OrderVM getOrderVM() {
        return orderVM;
    }

    public void setOrderVM(OrderVM orderVM) {
        this.orderVM = orderVM;
    }

    public List<OrderProductVM> getOrderProductVMS() {
        return orderProductVMS;
    }

    public void setOrderProductVMS(List<OrderProductVM> orderProductVMS) {
        this.orderProductVMS = orderProductVMS;
    }

    public LayoutHeaderVM getLayoutHeaderVM() {
        return layoutHeaderVM;
    }

    public void setLayoutHeaderVM(LayoutHeaderVM layoutHeaderVM) {
        this.layoutHeaderVM = layoutHeaderVM;
    }
}
