package application.controller.web;

import application.data.model.Cart;
import application.data.model.User;
import application.data.service.CartService;
import application.data.service.UserService;
import application.model.viewmodel.common.HeaderMenuVM;
import application.model.viewmodel.common.LayoutHeaderVM;
import application.model.viewmodel.home.SlideVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.ArrayList;
import java.util.UUID;

import static application.constant.Constant.COMPANY_NAME;

public class BaseController {

    @Autowired
    private CartService cartService;

    @Autowired
    private UserService userService;

    public void getCookie(HttpServletResponse response,
                          HttpServletRequest request,
                          final Principal principal) {

        Cookie cookie[] = request.getCookies();


        if (principal != null) {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            Cart cartEntity = cartService.findByUserName(userName);
            if (cartEntity != null) {
                Cookie cookie1 = new Cookie("guid", cartEntity.getGuid());
                cookie1.setPath("/");
                response.addCookie(cookie1);
            } else {
                UUID uuid = UUID.randomUUID();
                String guid = uuid.toString();
                Cart cart = new Cart();
                cart.setGuid(guid);
                cart.setUserName(userName);
                cartService.addNewCart(cart);

                Cookie cookie2 = new Cookie("guid", guid);
                cookie2.setPath("/");
                response.addCookie(cookie2);
            }
        } else {
            boolean flag2 = true;

            String guid = null;

            if (cookie != null) {
                for (Cookie c : cookie) {
                    if (c.getName().equals("guid")) {
                        flag2 = false;
                        guid = c.getValue();
                    }
                }
            }

            if (flag2 == true) {
                UUID uuid = UUID.randomUUID();
                String guid2 = uuid.toString();
                Cart cart2 = new Cart();
                cart2.setGuid(guid2);
                cartService.addNewCart(cart2);

                Cookie cookie3 = new Cookie("guid", guid2);
                cookie3.setPath("/");
                cookie3.setMaxAge(60 * 60 * 24);
                response.addCookie(cookie3);
            } else {
                Cart cartEntity = cartService.findFirstCartByGuid(guid);
                if (cartEntity != null) {
                    Cart cart3 = new Cart();
                    cart3.setGuid(guid);
                    cartService.addNewCart(cart3);
                }
            }

        }

    }

    public LayoutHeaderVM getLayoutHeaderVM() {
        LayoutHeaderVM vm = new LayoutHeaderVM();
        ArrayList<HeaderMenuVM> headerMenuVMArrayList = new ArrayList<>();
        ArrayList<SlideVM> slideVMArrayList = new ArrayList<>();

        /*set list slide*/
        slideVMArrayList.add(new SlideVM("Title Slide 1", "Caption Slide 1" ,"Link Slide 1","Name Slide 1","/user/images/master-slide-07.jpg"));
        slideVMArrayList.add(new SlideVM("Title Slide 2", "Caption Slide 2" ,"Link Slide 2","Name Slide 2","/user/images/master-slide-07.jpg"));
        slideVMArrayList.add(new SlideVM("Title Slide 3", "Caption Slide 3" ,"Link Slide 3","Name Slide 3","/user/images/master-slide-07.jpg"));

        /*set list navigation*/
        headerMenuVMArrayList.add(new HeaderMenuVM("Home","/"));
        headerMenuVMArrayList.add(new HeaderMenuVM("Product","/product"));
        headerMenuVMArrayList.add(new HeaderMenuVM("Blog","#"));
        headerMenuVMArrayList.add(new HeaderMenuVM("About","#"));
        headerMenuVMArrayList.add(new HeaderMenuVM("Contact","#"));

        /*set User Login*/
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User userEntity = userService.findUserByUsername(userName);

        if (userEntity != null) {
            vm.setUserName(userName);
            if (userEntity.getAvatar() != null ) {
                vm.setAvatar(userEntity.getAvatar());
            } else {
                vm.setAvatar("/icons/icon-header-01.png");
            }
        }

        vm.setHeaderMenuVMArrayList(headerMenuVMArrayList);
        vm.setCompanyName(COMPANY_NAME);
        vm.setSlideVMArrayList(slideVMArrayList);

        return vm;
    }
}
