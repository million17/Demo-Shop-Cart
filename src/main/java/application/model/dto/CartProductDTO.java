package application.model.dto;

public class CartProductDTO {
    private int cartProductId;
    private int cartId;
    private int productEntityId;
    private int amount;
    private String guid;

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

    public int getProductEntityId() {
        return productEntityId;
    }

    public void setProductEntityId(int productEntityId) {
        this.productEntityId = productEntityId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
