package application.controller.web;

import application.constant.RoleIdConstant;
import application.data.model.Role;
import application.data.model.User;
import application.data.service.RoleService;
import application.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping("")
    public String home(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User userEntity = userService.findUserByUsername(userName);
        if (userEntity != null) {
            Role role = roleService.getRoleByUser(userEntity.getId());
            role.getRoleId();
            if (role.getRoleId() != RoleIdConstant.Role_Admin) {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }

        model.addAttribute("vm","Test");


        return "admin/home";
    }

    @GetMapping("/product")
    public String product(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User userEntity = userService.findUserByUsername(userName);
        if (userEntity != null) {
            Role role = roleService.getRoleByUser(userEntity.getId());
            role.getRoleId();
            if (role.getRoleId() != RoleIdConstant.Role_Admin) {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }

        model.addAttribute("vm","Test");


        return "admin/product";
    }

    @GetMapping("/category")
    public String category(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User userEntity = userService.findUserByUsername(userName);
        if (userEntity != null) {
            Role role = roleService.getRoleByUser(userEntity.getId());
            role.getRoleId();
            if (role.getRoleId() != RoleIdConstant.Role_Admin) {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }

        model.addAttribute("vm","Test");


        return "admin/category";
    }

    @GetMapping("/order")
    public String order(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User userEntity = userService.findUserByUsername(userName);
        if (userEntity != null) {
            Role role = roleService.getRoleByUser(userEntity.getId());
            role.getRoleId();
            if (role.getRoleId() != RoleIdConstant.Role_Admin) {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }

        model.addAttribute("vm","Test");


        return "admin/order";
    }

    @GetMapping("/user")
    public String user(Model model) {

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User userEntity = userService.findUserByUsername(userName);
        if (userEntity != null) {
            Role role = roleService.getRoleByUser(userEntity.getId());
            role.getRoleId();
            if (role.getRoleId() != RoleIdConstant.Role_Admin) {
                return "redirect:/login";
            }
        } else {
            return "redirect:/login";
        }

        model.addAttribute("vm","Test");


        return "admin/user";
    }
}
