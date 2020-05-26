package application.controller.web;

import application.data.model.Cart;
import application.data.model.CartProduct;
import application.data.model.User;
import application.data.service.CartProductService;
import application.data.service.CartService;
import application.data.service.UserService;
import application.model.viewmodel.cart.CartProductVM;
import application.model.viewmodel.cart.CartVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import static application.constant.Constant.SHIP_PRICE;

@Controller
@RequestMapping(path = "/cart")
public class CartController extends BaseController {

    @Autowired
    private CartProductService cartProductService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    private final Logger logger = LogManager.getLogger(CartController.class);

    @GetMapping("")
    public String cart(Model model,
                       HttpServletRequest request,
                       HttpServletResponse response,
                       final Principal principal) {

        this.getCookie(response, request, principal);
        CartVM vm = new CartVM();

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        User userEntity = userService.findUserByUsername(userName);

        int productAmount = 0;
        double totalPrice = 0L;

        String guid = this.getGuid(request);

        DecimalFormat df = new DecimalFormat("####0.00");

        List<CartProductVM> cartProductVMList = new ArrayList<>();

        if (guid != null) {
            Cart cartEntity;
            if (userEntity == null) {
                cartEntity = cartService.findFirstCartByGuid(guid);
            } else {
                cartEntity = cartService.findByUserName(userName);
            }
            if (cartEntity != null) {
                productAmount = cartEntity.getCartProductList().size();
                for (CartProduct cartProduct : cartEntity.getCartProductList()) {
                    CartProductVM cartProductVM = new CartProductVM();
                    cartProductVM.setCartProductId(cartProduct.getCartProductId());
                    cartProductVM.setProductName(cartProduct.getProductEntity().getProduct().getProductName());
                    cartProductVM.setMainImage(cartProduct.getProductEntity().getProduct().getMainImage());
                    cartProductVM.setColorName(cartProduct.getProductEntity().getColor().getName());
                    cartProductVM.setSizeName(cartProduct.getProductEntity().getSize().getName());
                    cartProductVM.setPrice(cartProduct.getProductEntity().getProduct().getPrice());
                    cartProductVM.setAmount(cartProduct.getAmount());
                    double price = cartProduct.getAmount() * cartProduct.getProductEntity().getProduct().getPrice();
                    cartProductVM.setTotalProductPrice(price);
                    totalPrice += price;


                    cartProductVMList.add(cartProductVM);


                }
                if (productAmount > 0) {
                    vm.setProductAmount(productAmount);
                    vm.setTotalPrice(totalPrice);
                    vm.setCartProductVMList(cartProductVMList);
                    if (totalPrice > 3000) {
                        vm.setShipPrice(0);
                        vm.setTotal(vm.getShipPrice() + vm.getTotalPrice());
                    } else {
                        vm.setShipPrice(SHIP_PRICE);
                        vm.setTotal(vm.getShipPrice() + vm.getTotalPrice());
                    }
                }
            }

        }


        vm.setLayoutHeaderVM(this.getLayoutHeaderVM());
        model.addAttribute("vm", vm);

        return "/cart";
    }

    public String getGuid(HttpServletRequest request) {
        Cookie cookies[] = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("guid")) return cookie.getValue();

            }
        }
        return null;
    }
}
