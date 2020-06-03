package application.controller.web;

import application.constant.RoleIdConstant;
import application.data.model.Product;
import application.data.model.ProductImage;
import application.data.model.Role;
import application.data.model.User;
import application.data.service.ProductService;
import application.data.service.RoleService;
import application.data.service.UserService;
import application.model.viewmodel.ProductImageVM;
import application.model.viewmodel.ProductVM;
import application.model.viewmodel.admin.AdminProductVM;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private static final Logger logger = LogManager.getLogger(AdminController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private ProductService productService;


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

        model.addAttribute("vm", "Test");


        return "admin/home";
    }

    @GetMapping("/product")
    public String product(Model model,
                          @Valid @ModelAttribute("productName") ProductVM productName,
                          @RequestParam(name = "categoryId", required = false) Integer categoryId,
                          @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                          @RequestParam(name = "maxSize", required = false, defaultValue = "5") Integer maxSize) {

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
        AdminProductVM vm = new AdminProductVM();
        try {
            Pageable pageable = new PageRequest(page, maxSize, null);
            Page<Product> productPage = null;

            if (categoryId != null) {
                productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, categoryId, null);
            } else if (productName.getProductName() != null && !productName.getProductName().isEmpty()) {
                productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, null, productName.getProductName().trim());
            } else {
                productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, null, null);
            }
            List<ProductVM> productVMList = new ArrayList<>();
            for (Product product : productPage.getContent()) {
                ProductVM productVM = new ProductVM();
                productVM.setProductName(product.getProductName());
                productVM.setCategoryName(product.getCategory().getName());
                productVM.setShortDesc(product.getShortDesc());
                productVM.setPrice(product.getPrice());
                productVM.setBrand(product.getBrand());
                productVM.setCreatedDate(product.getCreatedDate());
                productVM.setMainImage(product.getMainImage());

                /*List<ProductImageVM> productImageVMList = new ArrayList<>();
                for (ProductImage productImage : product.getProductImageList()) {
                    ProductImageVM productImageVM = new ProductImageVM();
                    productImageVM.setLink(productImage.getLink());
                    productImageVM.setCreatedDate(new Date());

                    productImageVMList.add(productImageVM);
                }*/

                productVMList.add(productVM);
            }

            vm.setProductVMList(productVMList);

            model.addAttribute("vm", vm);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }


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

        model.addAttribute("vm", "Test");


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

        model.addAttribute("vm", "Test");


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

        model.addAttribute("vm", "Test");


        return "admin/user";
    }
}
