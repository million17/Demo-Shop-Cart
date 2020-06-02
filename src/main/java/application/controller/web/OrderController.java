package application.controller.web;

import application.constant.DELIVERYSTATUS;
import application.data.model.*;
import application.data.service.*;
import application.model.viewmodel.order.OrderDetailVM;
import application.model.viewmodel.order.OrderHistoryVM;
import application.model.viewmodel.order.OrderProductVM;
import application.model.viewmodel.order.OrderVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;

import static application.constant.Constant.SHIP_PRICE;

@Controller
@RequestMapping(path = "/order")
public class OrderController extends BaseController {

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DeliveryStatusService deliveryStatusService;

    @Autowired
    private OrderDeliveryStatusService orderDeliveryStatusService;

    @GetMapping("/checkout")
    public String checkout(Model model, HttpServletRequest request) {
        OrderDetailVM vm = new OrderDetailVM();
        OrderVM order = new OrderVM();

        DecimalFormat df = new DecimalFormat("####0.00");

        int productAmount = 0;
        double totalPrice = 0L;

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        User userEntity = userService.findUserByUsername(userName);

        if (userEntity != null) {
            order.setName(userEntity.getName());
            order.setPhoneNumber(userEntity.getPhoneNumber());
            order.setAddress(userEntity.getAddress());
        }
        vm.setLayoutHeaderVM(this.getLayoutHeaderVM(request));

        model.addAttribute("vm", vm);
        model.addAttribute("order", order);


        return "/checkout";
    }

    @PostMapping("/checkout")
    public String checkout(@Valid @ModelAttribute("order") OrderVM orderVM, HttpServletRequest request,
                           final Principal principal) {

        Order order = new Order();

        String guid = this.getGuid(request);

        if (guid != null) {
            double totalPrice = 0;
            if (principal != null) {
                String userName = SecurityContextHolder.getContext().getAuthentication().getName();
                order.setUserName(userName);
            }
            order.setGuid(guid);
            order.setAddress(orderVM.getAddress());
            order.setPhoneNumber(orderVM.getPhoneNumber());
            order.setAddress(orderVM.getAddress());
            order.setCustomerName(orderVM.getCustomerName());
            order.setEmail(orderVM.getEmail());
            order.setCreatedDate(new Date());
            order.setDeliveryStatusId(DELIVERYSTATUS.CHO_THANH_TOAN);

            Cart cartEntity = cartService.findFirstCartByGuid(guid);

            if (cartEntity != null) {
                List<OrderProduct> orderProductList = new ArrayList<>();


                for (CartProduct cartProduct : cartEntity.getCartProductList()) {
                    OrderProduct orderProduct = new OrderProduct();
                    orderProduct.setOrder(order);
                    orderProduct.setAmount(cartProduct.getAmount());
                    orderProduct.setProductEntity(cartProduct.getProductEntity());


                    double price = cartProduct.getAmount() * cartProduct.getProductEntity().getProduct().getPrice();
                    totalPrice += price;
                    orderProduct.setPrice(price);

                    orderProductList.add(orderProduct);

                }

                if (totalPrice > 3000) {
                    order.setShip((double) 0);
                } else {
                    order.setShip((double) SHIP_PRICE);
                }
                order.setPrice(totalPrice);
                order.setOrderProductList(orderProductList);
                orderService.addNewOrder(order);


                OrderDeliveryStatus orderDeliveryStatus = new OrderDeliveryStatus();
                orderDeliveryStatus.setOrder(order);
                orderDeliveryStatus.setCreatedDate(new Date());
                orderDeliveryStatus.setDeliveryStatus(deliveryStatusService.findOne(DELIVERYSTATUS.CHO_THANH_TOAN));

                orderDeliveryStatusService.addNewOrderDeliveryStatus(orderDeliveryStatus);

                cartService.deleteCart(cartEntity.getCartId());
                return "redirect:/order/history";
            }


        }

        return "redirect:/product";
    }

    @GetMapping("/history")
    public String history(Model model, HttpServletRequest request,
                          final Principal principal) {
        OrderHistoryVM vm = new OrderHistoryVM();

        List<OrderVM> orderVMS = new ArrayList<>();

        List<Order> orderEntityList = null;

        String guid = this.getGuid(request);

        if (principal != null) {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            orderEntityList = orderService.findOrderByGuidOrUserName(null, userName);
        } else if (guid != null) {
            orderEntityList = orderService.findOrderByGuidOrUserName(guid, null);
        }
        for (Order order : orderEntityList) {
            OrderVM orderVM = new OrderVM();

            orderVM.setAddress(order.getAddress());
            orderVM.setCreatedDate(order.getCreatedDate());
            orderVM.setCustomerName(order.getCustomerName());
            orderVM.setEmail(order.getEmail());
            orderVM.setPhoneNumber(order.getPhoneNumber());
            orderVM.setPrice(order.getPrice());
            orderVM.setOrderId(order.getOrderId());
            orderVM.setShip(order.getShip());
            orderVM.setDeliveryStatus(order.getDeliveryStatusId());

            orderVMS.add(orderVM);
        }


        vm.setOrderVMList(orderVMS);
        vm.setLayoutHeaderVM(this.getLayoutHeaderVM(request));

        model.addAttribute("vm", vm);


        return "/order-history";

    }

    @GetMapping("/history/{orderId}")
    public String details(Model model, HttpServletRequest request,
                          @PathVariable int orderId,
                          final Principal principal) {
        OrderDetailVM orderDetailVM = new OrderDetailVM();
        List<OrderProductVM> orderProductVMS = new ArrayList<>();
        try {
            Order orderEntity = orderService.findOne(orderId);
            if (orderEntity != null) {
                orderDetailVM.setDeliveryStatusId(orderEntity.getDeliveryStatusId());
                for (OrderProduct orderProduct : orderEntity.getOrderProductList()) {
                    OrderProductVM orderProductVM = new OrderProductVM();
                    orderProductVM.setMainImage(orderProduct.getProductEntity().getProduct().getMainImage());
                    orderProductVM.setAmount(orderProduct.getAmount());
                    orderProductVM.setColorName(orderProduct.getProductEntity().getColor().getName());
                    orderProductVM.setSizeName(orderProduct.getProductEntity().getSize().getName());
                    orderProductVM.setPrice(orderProduct.getPrice());
                    orderProductVM.setProductName(orderProduct.getProductEntity().getProduct().getProductName());

                    orderProductVMS.add(orderProductVM);
                }
                orderDetailVM.setOrderProductVMS(orderProductVMS);

            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        orderDetailVM.setLayoutHeaderVM(this.getLayoutHeaderVM(request));
        model.addAttribute("vm", orderDetailVM);


        return "order-detail";
    }
}
