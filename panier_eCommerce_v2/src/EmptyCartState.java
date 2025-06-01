/**
 * État représentant un panier vide.
 */
public class EmptyCartState implements CartState {

    /**
     * Ajoute un article au panier et change l'état vers actif.
     * @param cart le panier
     * @param item l'article à ajouter
     */
    @Override
    public void addItem(ShoppingCart cart, Item item) {
        cart.getItems().add(item);
        cart.setState(new ActiveCartState());
        cart.notifyObservers();
    }

    /**
     * Impossible de retirer un article d'un panier vide.
     * @param cart le panier
     * @param item l'article à retirer
     */
    @Override
    public void removeItem(ShoppingCart cart, Item item) {
        System.out.println("Panier déjà vide.");
    }

    /**
     * Impossible d'appliquer une promotion sur un panier vide.
     * @param cart le panier
     */
    @Override
    public void applyPromotion(ShoppingCart cart) {
        System.out.println("Impossible : panier vide.");
    }
}
