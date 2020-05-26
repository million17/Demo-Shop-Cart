package application.controller.web;

import application.data.model.Blog;
import application.data.model.Product;
import application.data.model.User;
import application.data.service.BlogService;
import application.data.service.ProductService;
import application.data.service.UserService;
import application.model.viewmodel.home.BlogVM;
import application.model.viewmodel.home.HomeVM;
import application.model.viewmodel.home.ProductHotVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/")
    public String home(Model model, HttpServletRequest request) {
        HomeVM vm = new HomeVM();

        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userService.findUserByUsername(username);

        List<Product> productList = productService.getListProductHot();
        List<ProductHotVM> productHotVMList = new ArrayList<>();
        for (Product product : productList) {
            ProductHotVM productHotVM = new ProductHotVM();


            productHotVM.setId(product.getProductId());
            productHotVM.setProductName(product.getProductName());
            productHotVM.setCategoryId(product.getCategoryId());
            productHotVM.setBrand(product.getBrand());
            productHotVM.setCreatedDate(product.getCreatedDate());
            productHotVM.setMainImage(product.getMainImage());
            productHotVM.setPrice(product.getPrice());
            productHotVM.setShortDesc(product.getShortDesc());

            productHotVMList.add(productHotVM);

        }

        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        List<BlogVM> blogVMList = new ArrayList<>();

        if (user == null ) {
            List<Blog> blogList = blogService.getListBlogByNoLoginRandom();

            for (Blog blog : blogList) {
                BlogVM blogVM = new BlogVM();
                blogVM.setBlogId(blog.getBlogId());
                blogVM.setContent(blog.getContent());
                blogVM.setImageBlog(blog.getImageBlog());
                blogVM.setTitle(blog.getTitle());
                String date = simpleDateFormat.format(blog.getCreatedDate());
                blogVM.setCreatedDate(date);
                blogVM.setFullName(blog.getUser().getName());

                blogVMList.add(blogVM);
            }
        } else {
            List<Blog> blogList = blogService.getListBlogByUserId(user.getId());

            for (Blog blog : blogList) {
                BlogVM blogVM = new BlogVM();
                blogVM.setBlogId(blog.getBlogId());
                blogVM.setContent(blog.getContent());
                blogVM.setImageBlog(blog.getImageBlog());
                blogVM.setTitle(blog.getTitle());
                String date = simpleDateFormat.format(blog.getCreatedDate());
                blogVM.setCreatedDate(date);
                blogVM.setFullName(blog.getUser().getName());

                blogVMList.add(blogVM);
            }
        }



        vm.setBlogVMList(blogVMList);
        vm.setProductHotVMList(productHotVMList);
        vm.setLayoutHeaderVM(this.getLayoutHeaderVM(request));


        model.addAttribute("vm", vm);


        return "/home";
    }
}
