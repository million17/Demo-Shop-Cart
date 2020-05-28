package application.controller.web;

import application.data.model.*;
import application.data.service.CartService;
import application.data.service.OrderService;
import application.data.service.UserService;
import application.model.viewmodel.cart.CartProductVM;
import application.model.viewmodel.order.OrderDetailVM;
import application.model.viewmodel.order.OrderHistoryVM;
import application.model.viewmodel.order.OrderVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(path = "/order")
public class OrderController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/checkout")
    public String checkout(Model model, HttpServletRequest request) {
        OrderDetailVM vm = new OrderDetailVM();
        OrderVM order = new OrderVM();

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

            Cart cartEntity = cartService.findFirstCartByGuid(guid);

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

            order.setOrderProductList(orderProductList);
            order.setPrice(totalPrice);


            orderService.addNewOrder(order);

            cartService.deleteCart(cartEntity.getCartId());


        }

        return "redirect:/order/history";
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
            orderVM.setShip(order.getShip());

            orderVMS.add(orderVM);
        }


        vm.setOrderVMList(orderVMS);
        vm.setLayoutHeaderVM(this.getLayoutHeaderVM(request));

        model.addAttribute("vm", vm);


        return "/order-history";

    }
}
