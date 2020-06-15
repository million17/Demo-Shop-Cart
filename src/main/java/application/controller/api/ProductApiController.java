package application.controller.api;


import application.data.model.Category;
import application.data.model.Product;
import application.data.service.CategoryService;
import application.data.service.ProductService;
import application.model.api.BaseApiResult;
import application.model.api.DataApiResult;
import application.model.dto.ProductDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

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
    public BaseApiResult fakeProduct() {
        BaseApiResult result = new BaseApiResult();

        try {
            long totalProduct = productService.getToltalProducts();
            List<Category> categoryList = categoryService.getListAllCategories();
            List<Product> productList = new ArrayList<>();
            Random random = new Random();
            for (long i = totalProduct + 1; i < totalProduct + 3; i++) {
                Product product = new Product();
                product.setProductName("Product " + i);
                product.setShortDesc("Product " + i + " short description");

                /*random brand*/
                product.setBrand(brands[random.nextInt(images.length)]);
                /*random image*/
                product.setMainImage(images[random.nextInt(images.length)]);

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
        } catch (Exception ex) {

            result.setSuccess(false);
            result.setMessage("Fake Product Error");
            logger.error(ex.getMessage());
        }
        return result;
    }

    @PostMapping(value = "/create")
    public DataApiResult createProduct(@RequestBody ProductDTO dto /*ProductDTO dto*/) {
        DataApiResult result = new DataApiResult();
        try {
            Product product = new Product();
            product.setProductName(dto.getProductName());
            product.setShortDesc(dto.getShortDesc());
            product.setMainImage(dto.getMainImage());
            product.setCategory(categoryService.findOne(dto.getCategoryId()));
            product.setPrice(dto.getPrice());
            product.setBrand(dto.getBrand());
            product.setCreatedDate(new Date());

            productService.addNewProduct(product);

            result.setData(product);
            result.setSuccess(true);
            result.setMessage("ok");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setSuccess(false);
            result.setData(null);
            result.setMessage("Create product Fail !");
        }

        return result;
    }

    @GetMapping("/list")
    public DataApiResult getAllProduct() {
        DataApiResult result = new DataApiResult();

        List<Product> productList = productService.findAll();

        List<ProductDTO> productDTOList = new ArrayList<>();
        for (Product product : productList) {
            ProductDTO productDTO = new ProductDTO();
            productDTO.setId(product.getProductId());
            productDTO.setProductName(product.getProductName());
            productDTO.setBrand(product.getBrand());
            productDTO.setMainImage(product.getMainImage());
            productDTO.setCategoryId(product.getCategoryId());
            productDTO.setCategoryName(product.getCategory().getName());
            productDTO.setPrice(product.getPrice());
            productDTO.setCreatedDate(product.getCreatedDate());
            productDTO.setShortDesc(product.getShortDesc());

            productDTOList.add(productDTO);
        }

        result.setData(productDTOList);
        result.setMessage("Get All Success !");
        result.setSuccess(true);


        return result;
    }

    @PostMapping("/update/{productId}")
    public BaseApiResult updateProduct(@PathVariable int productId,
                                       @RequestBody ProductDTO dto) {
        BaseApiResult result = new BaseApiResult();

        try {
            Product product = productService.findOne(productId);
            product.setProductName(dto.getProductName());
            product.setShortDesc(dto.getShortDesc());
            product.setMainImage(dto.getMainImage());
            product.setCategory(categoryService.findOne(dto.getCategoryId()));
            product.setPrice(dto.getPrice());
            product.setBrand(dto.getBrand());
            product.setCreatedDate(new Date());

            productService.updateProduct(product);
            result.setSuccess(true);
            result.setMessage("Update " + product.getProductName() + " successfully ! ");
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setSuccess(false);
            result.setMessage("Update Fails !");
        }

        return result;
    }

    @GetMapping("/detail/{productId}")
    public BaseApiResult detailMaterial(@PathVariable int productId) {
        DataApiResult result = new DataApiResult();
        try {
            Product productEntity = productService.findOne(productId);
            if (productEntity == null) {
                result.setSuccess(false);
                result.setMessage("Can't not find Product !");
            } else  {
                ProductDTO dto = new ProductDTO();
                dto.setId(productEntity.getProductId());
                dto.setProductName(productEntity.getProductName());
                dto.setShortDesc(productEntity.getShortDesc());
                dto.setMainImage(productEntity.getMainImage());
                dto.setCategoryId(productEntity.getCategory().getCategoryId());
                dto.setPrice(productEntity.getPrice());
                dto.setBrand(productEntity.getBrand());
                dto.setCreatedDate(productEntity.getCreatedDate());

                result.setData(dto);
                result.setSuccess(true);
                result.setMessage("Get Details Product Success !");
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            result.setMessage("Product not found details! ");
            result.setSuccess(false);
        }

        return result;
    }


    @PostMapping("/delete/{productId}")
    public BaseApiResult deleteProduct(@PathVariable int productId) {
        BaseApiResult result = new BaseApiResult();

        try {
            productService.deleteProduct(productId);
            result.setMessage("Delete product success !");
            result.setSuccess(true);
        } catch (Exception ex ){
            logger.error(ex.getMessage());
            result.setMessage("Delete product fails !");
            result.setSuccess(false);
        }

        return result;
    }

}
