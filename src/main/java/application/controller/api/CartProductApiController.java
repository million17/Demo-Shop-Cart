package application.controller.api;

import application.data.model.Cart;
import application.data.model.CartProduct;
import application.data.model.ProductEntity;
import application.data.model.User;
import application.data.service.CartProductService;
import application.data.service.CartService;
import application.data.service.ProductEntityService;
import application.data.service.UserService;
import application.model.api.BaseApiResult;
import application.model.dto.CartProductDTO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/cart-product")
public class CartProductApiController {

    @Autowired
    UserService userService;

    @Autowired
    CartService cartService;

    @Autowired
    CartProductService cartProductService;

    @Autowired
    ProductEntityService productEntityService;

    private static final Logger logger = LogManager.getLogger(CategoryApiController.class);

    @PostMapping("/add")
    public BaseApiResult addToCart(@RequestBody CartProductDTO dto) {
        BaseApiResult result = new BaseApiResult();
        String userName = SecurityContextHolder.getContext().getAuthentication().getName();
        User userEntity = userService.findUserByUsername(userName);

        try {
            if (dto.getGuid() != null && dto.getAmount() > 0 && dto.getProductEntityId() > 0) {
                Cart cartEntity;
                if (userEntity == null)
                    cartEntity = cartService.findFirstCartByGuid(dto.getGuid());
                else
                    cartEntity = cartService.findByUserName(userEntity.getUserName());
                ProductEntity productEntity = productEntityService.findOne(dto.getProductEntityId());
                if (cartEntity != null && productEntity != null) {
                    CartProduct cartProductEntity = cartProductService.findFirstCartProductByCartIdAndProductEntityId(dto.getCartId(), dto.getProductEntityId());
                    if (cartProductEntity != null) {
                        cartProductEntity.setAmount(dto.getAmount() + cartProductEntity.getAmount());
                        cartProductService.updateCartProduct(cartProductEntity);
                    } else {
                        CartProduct cartProduct = new CartProduct();
                        cartProduct.setAmount(dto.getAmount());
                        cartProduct.setCart(cartEntity);
                        cartProduct.setProductEntity(productEntity);
                        cartProductService.addNewCartProduct(cartProduct);
                    }
                    result.setSuccess(true);
                    result.setMessage("Add To Cart Succcess ! ");
                    return result;
                } else {
                    cartEntity = new Cart();
                    cartEntity.setUserName(userEntity.getUserName());
                    cartEntity.setGuid(dto.getGuid());
                    cartService.addNewCart(cartEntity);
                    CartProduct cartProductEntity = cartProductService.findFirstCartProductByCartIdAndProductEntityId(dto.getCartId(), dto.getProductEntityId());
                    if (cartProductEntity != null) {
                        cartProductEntity.setAmount(dto.getAmount() + cartProductEntity.getAmount());
                        cartProductService.updateCartProduct(cartProductEntity);
                    } else {
                        CartProduct cartProduct = new CartProduct();
                        cartProduct.setCart(cartEntity);
                        cartProduct.setProductEntity(productEntity);
                        cartProduct.setAmount(dto.getAmount());
                        cartProductService.addNewCartProduct(cartProduct);
                    }
                    result.setMessage("Add To Cart Success ! ");
                    result.setSuccess(true);
                    return result;
                }
            }

        } catch (Exception ex) {
            logger.error(ex.getMessage());

        }
        result.setMessage("No add To Cart");
        result.setSuccess(false);
        return result;
    }
}