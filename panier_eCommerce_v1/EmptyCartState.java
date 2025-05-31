public class EmptyCartState implements CartState {

    @Override
    public void addItem(ShoppingCart cart, Item item) {
        cart.getItems().add(item);
        cart.setState(new ActiveCartState());
        cart.notifyObservers();
    }

    @Override
    public void removeItem(ShoppingCart cart, Item item) {
        System.out.println("Panier déjà vide.");
    }

    @Override
    public void applyPromotion(ShoppingCart cart) {
        System.out.println("Impossible : panier vide.");
    }
}
