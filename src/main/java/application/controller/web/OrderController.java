package application.controller.web;

import application.data.model.User;
import application.data.service.UserService;
import application.model.viewmodel.order.OrderDetailVM;
import application.model.viewmodel.order.OrderVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private UserService userService;

    @GetMapping("/checkout")
    public String orderDetails(Model model, HttpServletRequest request) {
        OrderDetailVM vm = new OrderDetailVM();
        OrderVM order = new OrderVM();

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        User userEntity = userService.findUserByUsername(userName);

        if (userEntity != null ) {

        }



        return "/checkout";
    }
}
