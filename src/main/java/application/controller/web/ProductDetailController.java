package application.controller.web;


import application.data.model.*;
import application.data.service.*;
import application.model.viewmodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/product")
public class ProductDetailController extends BaseController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductEntityService productEntityService;

    @Autowired
    private SizeService sizeService;

    @Autowired
    private ColorService colorService;

    @Autowired
    private ProductImageService productImageService;

    @GetMapping("/{productId}")
    public String productDetail(@PathVariable Integer productId,
                                Model model,
                                @Valid @ModelAttribute("productName") ProductVM productName,
                                HttpServletRequest request,
                                HttpServletResponse response,
                                final Principal principal) {

        /*checkCookie*/
        this.getCookie(response, request, principal);

        ProductDetailVM vm = new ProductDetailVM();

        Product product = productService.findOne(productId);
        ProductVM productVM = new ProductVM();


        productVM.setBrand(product.getBrand());
        productVM.setCreatedDate(product.getCreatedDate());
        productVM.setMainImage(product.getMainImage());
        productVM.setPrice(product.getPrice());
        productVM.setProductName(product.getProductName());
        productVM.setCategoryName(product.getCategory().getName());
        productVM.setShortDesc(product.getShortDesc());

        /*set List Product Image*/
         List<ProductImage> productImageList = productImageService.getListProductImageByProductId(productId);
        List<ProductImageVM> productImageVMS = new ArrayList<>();
        for (ProductImage productImage : productImageList) {
            ProductImageVM productImageVM = new ProductImageVM();
            productImageVM.setId(productImage.getProductId());
            productImageVM.setCreatedDate(productImage.getCreatedDate());
            productImageVM.setLink(productImage.getLink());

            productImageVMS.add(productImageVM);
        }


        /*set List Product Entity chưa biết để làm gì , nên t comment lại =))
        List<ProductEntity> productEntityList = productEntityService.getAll();
        List<ProductEntityVM> productEntityVMS = new ArrayList<>();
        for (ProductEntity productEntity : productEntityList) {
            ProductEntityVM productEntityVM = new ProductEntityVM();
            productEntityVM.setProductEntityId(productEntity.getProductEntityId());
            productEntityVM.setColorId(productEntity.getColorId());
            productEntityVM.setProductId(productEntity.getProductId());
            productEntityVM.setSizeId(productEntity.getSizeId());

            productEntityVMS.add(productEntityVM);
        }*/

        /*set Size List By ProductId*/
        List<Size> sizeList = sizeService.getListSizeByProductId(productId);
        List<SizeVM> sizeVMList = new ArrayList<>();
        for (Size size : sizeList) {
            SizeVM sizeVM = new SizeVM();
            sizeVM.setId(size.getSizeId());
            sizeVM.setName(size.getName());
            sizeVM.setShortDesc(size.getShortDesc());
            sizeVM.setCreatedDate(size.getCreatedDate());

            sizeVMList.add(sizeVM);
        }


        /*set Color List By ProductId*/
        List<Color> colorList = colorService.getListColorByProductId(productId);
        List<ColorVM> colorVMList = new ArrayList<>();
        for (Color color : colorList) {
            ColorVM colorVM = new ColorVM();
            colorVM.setId(color.getColorId());
            colorVM.setName(color.getName());
            colorVM.setShortDesc(color.getShortDesc());
            colorVM.setCreatedDate(color.getCreatedDate());

            colorVMList.add(colorVM);
        }


        vm.setProductImageVMList(productImageVMS);
        vm.setProductVM(productVM);
        /*vm.setProductEntityVMList(productEntityVMS);*/
        vm.setSizeVMList(sizeVMList);
        vm.setColorVMList(colorVMList);

        model.addAttribute("vm", vm);

        return "/product-detail";
    }

}
