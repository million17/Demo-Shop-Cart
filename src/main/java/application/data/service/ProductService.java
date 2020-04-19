package application.data.service;

import application.data.model.Product;
import application.data.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Transactional
    public void addNewListProducts(List<Product> productList) {
        productRepository.save(productList);
    }

    public long getToltalProducts(){
        return productRepository.getTotalProduct();
    }

}
