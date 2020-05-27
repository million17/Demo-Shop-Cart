package application.data.service;

import application.data.model.CartProduct;
import application.data.repository.CartProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CartProductService {

    private static final Logger logger = LogManager.getLogger(CartProductService.class);

    @Autowired
    private CartProductRepository cartProductRepository;

    public CartProduct findFirstCartProductByCartIdAndProductEntityId(Integer cartId, Integer productEntityId) {
        try {
            return cartProductRepository.findFirstCartProductByCartIdAndProductEntityId(cartId, productEntityId);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    public CartProduct findOne(Integer cartProductId) {
        try {
            return cartProductRepository.findOne(cartProductId);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    public boolean updateCartProduct(CartProduct cartProduct) {
        try {
            cartProductRepository.save(cartProduct);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return false;
    }

    public boolean deleteCartProduct(Integer cartProductId) {
        try {
            cartProductRepository.delete(cartProductId);
            return true;
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return false;
    }

    @Transactional
    public void addNewCartProduct(CartProduct cartProduct) {
        cartProductRepository.save(cartProduct);
    }
}
