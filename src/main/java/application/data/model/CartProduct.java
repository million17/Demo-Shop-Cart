package application.data.model;

import javax.persistence.*;

@Table
@Entity(name = "dbo_cart_product")
public class CartProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_product_id")
    private int cartProductId;

    @Column(name = "cart_id", updatable = false, insertable = false)
    private int cartId;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @Column(name = "product_entity_id", updatable = false, insertable = false)
    private int productEntityId;

    @ManyToOne(optional = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_entity_id")
    private ProductEntity productEntity;

    @Column(name = "amount")
    private int amount;

    public int getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(int cartProductId) {
        this.cartProductId = cartProductId;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public int getProductEntityId() {
        return productEntityId;
    }

    public void setProductEntityId(int productEntityId) {
        this.productEntityId = productEntityId;
    }

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
