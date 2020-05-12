package application.data.service;

import application.data.model.ProductEntity;
import application.data.repository.ProductEntityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductEntityService {

    private static final Logger logger = LogManager.getLogger(ProductEntityService.class);

    @Autowired
    private ProductEntityRepository productEntityRepository;

    public ProductEntity getProductColorSize(Integer productId, Integer colorId, Integer sizeId) {
        return productEntityRepository.getProductColorSize(productId, colorId, sizeId);
    }

    public List<ProductEntity> getAll() {
        return productEntityRepository.findAll();
    }

    public ProductEntity findOne(Integer productEntityId) {
        return productEntityRepository.findOne(productEntityId);
    }

    public List<ProductEntity> findByProductId(Integer productId) {
        return productEntityRepository.findByProductId(productId);
    }
}
