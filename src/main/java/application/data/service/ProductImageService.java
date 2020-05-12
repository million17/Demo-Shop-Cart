package application.data.service;

import application.data.model.ProductImage;
import application.data.repository.ProductImageRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductImageService {

    @Autowired
    private ProductImageRepository productImageRepository;

    private static final Logger logger = LogManager.getLogger(ProductImageService.class);

    public List<ProductImage> getListProductImageByProductId(Integer productId) {
        try {
            return productImageRepository.getListProductImageByProductId(productId);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

}
