package application.controller.web;

import application.constant.RoleIdConstant;
import application.data.model.*;
import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.data.service.RoleService;
import application.data.service.UserService;
import application.model.viewmodel.CategoryVM;
import application.model.viewmodel.ProductImageVM;
import application.model.viewmodel.ProductVM;
import application.model.viewmodel.admin.AdminCategoryVM;
import application.model.viewmodel.admin.AdminProductVM;
import application.model.viewmodel.admin.AdminUserVM;
import application.model.viewmodel.user.RoleVM;
import application.model.viewmodel.user.UserVM;
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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.text.SimpleDateFormat;
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

    @Autowired
    private CategoryService categoryService;


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
                          @RequestParam(name = "maxSize", required = false, defaultValue = "5") Integer maxSize,
                          HttpServletRequest request,
                          HttpServletResponse response,
                          final Principal principal) {

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

        List<CategoryVM> categoryVMList = new ArrayList<>();
        for (Category category : categoryService.getListAllCategories()) {
            CategoryVM categoryVM = new CategoryVM();
            categoryVM.setId(category.getCategoryId());
            categoryVM.setName(category.getName());

            categoryVMList.add(categoryVM);
        }

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
            productVM.setId(product.getProductId());
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
        vm.setCategoryVMList(categoryVMList);

        model.addAttribute("vm", vm);
        model.addAttribute("page", productPage);


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

        AdminCategoryVM vm = new AdminCategoryVM();

        List<CategoryVM> categoryVMList = new ArrayList<>();

        for (Category category : categoryService.getListAllCategories()) {
            CategoryVM categoryVM = new CategoryVM();
            categoryVM.setName(category.getName());
            categoryVM.setShortDesc(category.getShortDesc());
            categoryVM.setId(category.getCategoryId());
            categoryVM.setCreatedDate(category.getCreatedDate());

            categoryVMList.add(categoryVM);
        }

        vm.setCategoryVMList(categoryVMList);

        model.addAttribute("vm", vm);


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

        AdminUserVM vm = new AdminUserVM();

        List<UserVM> userVMList = new ArrayList<>();

        for (User user : userService.getListAllUsers()) {
            UserVM userVM = new UserVM();

            String pattern = "yyyy-MM-dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


            userVM.setUserId(user.getId());
            userVM.setName(user.getName());
            userVM.setEmail(user.getEmail());
            userVM.setGender(user.getGender());
            userVM.setAvatar(user.getAvatar());
            userVM.setPhoneNumber(user.getPhoneNumber());
            String date = simpleDateFormat.format(user.getCreatedDate());
            userVM.setCreatedDate(date);
            userVM.setUserName(user.getUserName());
            userVM.setAddress(user.getAddress());
            userVM.setRoleId(roleService.getRoleByUser(user.getId()).getRoleId());

            userVM.setAddress(user.getAddress());

            userVMList.add(userVM);

        }

        List<RoleVM> roleVMList = new ArrayList<>();

        for (Role role : roleService.getListAllRole()) {
            RoleVM roleVM = new RoleVM();
            roleVM.setId(role.getRoleId());
            roleVM.setName(role.getName());

            roleVMList.add(roleVM);
        }

        vm.setUserVMList(userVMList);
        vm.setRoleVMList(roleVMList);


        model.addAttribute("vm", vm);


        return "admin/user";
    }
}
