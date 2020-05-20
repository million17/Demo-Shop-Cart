package application.controller.web;

import application.data.model.User;
import application.data.service.UserService;
import application.model.viewmodel.user.ChangePasswordVM;
import application.model.viewmodel.user.UserDetailVM;
import application.model.viewmodel.user.UserVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Date;

@Controller
@RequestMapping(path = "/user")
public class UserController extends BaseController {

    private static final Logger logger = LogManager.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @GetMapping("/detail")
    public String userDetail(Model model) {

        UserDetailVM vm = new UserDetailVM();

        String userName = SecurityContextHolder.getContext().getAuthentication().getName();

        User userEntity = userService.findUserByUsername(userName);

        try {
            if (userEntity != null) {
                UserVM userVM = new UserVM();
                userVM.setUserId(userEntity.getId());
                userVM.setUserName(userEntity.getUserName());
                userVM.setAddress(userEntity.getAddress());
                userVM.setAvatar(userEntity.getAvatar());
                userVM.setEmail(userEntity.getEmail());
                userVM.setGender(userEntity.getGender());
                userVM.setName(userEntity.getName());

                model.addAttribute("user", userVM);

            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        vm.setLayoutHeaderVM(this.getLayoutHeaderVM());

        model.addAttribute("vm", vm);


        return "/user-detail";
    }

    @PostMapping("/update")
    public String updateDetail(@Valid @ModelAttribute("user") User user) {
        try {
            String userName = SecurityContextHolder.getContext().getAuthentication().getName();
            User userEntity = userService.findUserByUsername(userName);

            userEntity.setName(user.getName());
            userEntity.setAvatar(user.getAvatar());
            userEntity.setAddress(user.getAddress());
            userEntity.setEmail(user.getEmail());
            userEntity.setPhoneNumber(user.getPhoneNumber());
            userEntity.setCreatedDate(new Date());
            userEntity.setGender(user.getGender());

            userService.updateUser(userEntity);

            return "redirect:/user/detail?updateSuccess";

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return "redirect:/user/detail?updateFail";
    }

    @GetMapping("/change-password")
    public String changePassword(Model model) {
        ChangePasswordVM changePasswordVM = new ChangePasswordVM();

        changePasswordVM.setLayoutHeaderVM(this.getLayoutHeaderVM());


        model.addAttribute("changePassword", changePasswordVM);


        return "/change-password";
    }

    @PostMapping("change-password")
    public String updatePassword(@Valid @ModelAttribute("changePassword") ChangePasswordVM password) {

        try {
            if (password.getCurrentPassword() != null && password.getConfirmPassword() != null && password.getNewPassword() != null) {
                String userName = SecurityContextHolder.getContext().getAuthentication().getName();
                User userEntity = userService.findUserByUsername(userName);

                if (passwordEncoder.matches(password.getCurrentPassword(), userEntity.getPasswordHash()) == true) {
                    userEntity.setPasswordHash(passwordEncoder.encode(password.getNewPassword()));
                    userService.updateUser(userEntity);

                    return "redirect:/user/change-password?success";
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }

        return "redirect:/user/change-password?fail";
    }

}