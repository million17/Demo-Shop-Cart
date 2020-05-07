package application.data.service;

import application.data.model.Cart;
import application.data.repository.CartRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    private static final Logger logger = LogManager.getLogger(CartService.class);

    @Autowired
    private CartRepository cartRepository;

    public Cart findByUserName(String userName) {

        try {
            return cartRepository.findByUserName(userName);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    public Cart findFirstCartByGuid(String guid) {
        try {
            return cartRepository.findFirstCartByGuid(guid);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return null;
    }

    public Cart addNewCart(Cart cart) {
        return cartRepository.save(cart);
    }

}
