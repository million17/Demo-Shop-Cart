package application.controller.api;


import application.data.model.Category;
import application.data.model.Product;
import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.model.api.BaseApiResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/api/product")
public class ProductApiController {

    private static final Logger logger = LogManager.getLogger(ProductApiController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    String images[] = {
            "/no_image.jpg"
    };

    String brands[] = {
            "Viet Nam",
            "China",
            "USA",
            "Japan",
            "Korea",
    };

    @GetMapping("/fake")
    public BaseApiResult fakeProduct(){
        BaseApiResult result = new BaseApiResult();

        try {
            long totalProduct = productService.getToltalProducts();
            List<Category> categoryList = categoryService.getListAllCategories();
            List<Product> productList = new ArrayList<>();
            Random random = new Random();
            for (long i = totalProduct + 1; i < totalProduct + 3 ; i++ ) {
                Product product = new Product();
                product.setProductName("Product " + i);
                product.setShortDesc("Product " + i + " short description");

                /*random brand*/
                product.setBrand(brands[random.nextInt(images.length)]);
                /*random image*/
                product.setMain_image(images[random.nextInt(images.length)]);

                /*random price*/
                double rangeMin = 50;
                double rangeMax = 200;
                double randomPrice = rangeMin + (rangeMax - rangeMin) * random.nextDouble();
                product.setPrice(randomPrice);

                product.setCreatedDate(new Date());
                /*random category*/
                product.setCategory(categoryList.get(random.nextInt(categoryList.size())));
                productList.add(product);
            }
            productService.addNewListProducts(productList);
            result.setSuccess(true);
            result.setMessage("Fake Product Success");
        }catch (Exception ex) {

            result.setSuccess(false);
            result.setMessage("Fake Product Error");
            logger.error(ex.getMessage());
        }
        return result;
    }


}
