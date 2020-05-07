package application.controller.web;

import application.data.model.Color;
import application.data.model.Product;
import application.data.model.Size;
import application.data.service.ColorService;
import application.data.service.ProductService;
import application.data.service.SizeService;
import application.model.viewmodel.ColorVM;
import application.model.viewmodel.HomeVM;
import application.model.viewmodel.ProductVM;
import application.model.viewmodel.SizeVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;
import java.security.Principal;
import java.util.ArrayList;

@Controller
public class HomeController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private ColorService colorService;


    @GetMapping(value = "/")
    public String homePage(Model model,
                           @Valid @ModelAttribute("productName") ProductVM productName,
                           @RequestParam(name = "categoryId", required = false) Integer categoryId,
                           @RequestParam(name = "page", required = false, defaultValue = "0") Integer page,
                           @RequestParam(name = "maxSize", required = false, defaultValue = "12") Integer maxSize,
                           @RequestParam(name = "sortByPrice", required = false) String sort,
                           HttpServletRequest request,
                           HttpServletResponse response,
                           final Principal principal) {

        this.getCookie(response, request, principal);

        HomeVM vm = new HomeVM();

        /*set List Size*/
        List<SizeVM> sizeVMList = new ArrayList<>();
        for (Size size : sizeService.getAll()) {
            SizeVM sizeVM = new SizeVM();
            sizeVM.setName(size.getName());
            sizeVM.setShortDesc(size.getShortDesc());
            sizeVM.setCreatedDate(size.getCreatedDate());

            sizeVMList.add(sizeVM);
        }

        /*set List Color*/
        List<ColorVM> colorVMList = new ArrayList<>();
        for (Color color : colorService.getAll()) {
            ColorVM colorVM = new ColorVM();
            colorVM.setName(color.getName());
            colorVM.setShortDesc(color.getShortDesc());
            colorVM.setCreatedDate(color.getCreatedDate());

            colorVMList.add(colorVM);
        }

        Sort sortable = new Sort(Sort.Direction.ASC, "id");
        if (sort != null) {
            if (sort.equals("ASC")) {
                sortable = new Sort(Sort.Direction.ASC, "price");
            } else {
                sortable = new Sort(Sort.Direction.DESC, "price");
            }
        }

        Pageable pageable = new PageRequest(page, maxSize, sortable);

        Page<Product> productPage = null;

        if (categoryId != null) {
            productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, categoryId, null);
        } else if (productName.getProductName() != null && !productName.getProductName().isEmpty()) {
            productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, categoryId, productName.getProductName());
        } else {
            productPage = productService.getListProductByCategoryOrProductNameContaining(pageable, null, null);
        }

        /*set List Product*/
        List<ProductVM> productVMList = new ArrayList<>();

        for (Product product : productService.getListProductByCategoryOrProductNameContaining(null, null, null)) {
            ProductVM productVM = new ProductVM();
            productVM.setProductName(product.getProductName());
            productVM.setCategoryId(product.getCategoryId());
            productVM.setBrand(product.getBrand());
            productVM.setCreatedDate(product.getCreatedDate());
            productVM.setMainImage(product.getMainImage());
            productVM.setPrice(product.getPrice());
            productVM.setShortDesc(product.getShortDesc());

            productVMList.add(productVM);

        }

        vm.setProductVMList(productVMList);
        vm.setSizeVMList(sizeVMList);
        vm.setColorVMList(colorVMList);

        model.addAttribute("vm", vm);
        model.addAttribute("page", productPage);
        return "/home";
    }
}
