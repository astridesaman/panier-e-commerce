public class ActiveCartState implements CartState {

    @Override
    public void addItem(ShoppingCart cart, Item item) {
        cart.getItems().add(item);
        cart.notifyObservers();
    }

    @Override
    public void removeItem(ShoppingCart cart, Item item) {
        if (cart.getItems().remove(item)) {
            System.out.println("Article retiré : " + item.getName());
            if (cart.getItems().isEmpty()) {
                cart.setState(new EmptyCartState());
            }
            cart.notifyObservers();
        } else {
            System.out.println("Article non trouvé.");
        }
    }

    @Override
    public void applyPromotion(ShoppingCart cart) {
        cart.applyCurrentPromotion();
        cart.setState(new PromotionAppliedState());
    }
}
