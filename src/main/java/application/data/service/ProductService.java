package application.data.service;

import application.data.model.Product;
import application.data.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProductService {

    private static final Logger logger = LogManager.getLogger(ProductService.class);

    @Autowired
    private ProductRepository productRepository;


    @Transactional
    public void addNewProduct(Product product) {
        productRepository.save(product);
    }

    public Product findOne(int productId) {
        return productRepository.findOne(productId);
    }

    public boolean updateProduct(Product product) {
        try {
            productRepository.save(product);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return false;
    }


    @Transactional
    public void addNewListProducts(List<Product> productList) {
        productRepository.save(productList);
    }

    public long getToltalProducts() {
        return productRepository.getTotalProduct();
    }

    public boolean deleteProduct(int productId) {
        try {
            productRepository.delete(productId);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return false;
    }

}
