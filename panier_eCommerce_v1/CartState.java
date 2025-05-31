public interface CartState {
    void addItem(ShoppingCart cart, Item item);
    void removeItem(ShoppingCart cart, Item item);
    void applyPromotion(ShoppingCart cart);
}
