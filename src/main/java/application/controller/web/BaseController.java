package application.controller.web;

import application.data.model.Cart;
import application.data.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.UUID;

public class BaseController {

    @Autowired
    private CartService cartService;

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

        }

    }
}
