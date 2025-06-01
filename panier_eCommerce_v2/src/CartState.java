/**
 * Interface d’état du panier (State Pattern).
 */
public interface CartState {
    /**
     * Ajoute un article via l'état courant.
     * @param cart le panier
     * @param item l'article à ajouter
     */
    void addItem(ShoppingCart cart, Item item);

    /**
     * Retire un article via l'état courant.
     * @param cart le panier
     * @param item l'article à retirer
     */
    void removeItem(ShoppingCart cart, Item item);

    /**
     * Permet d'appliquer la promotion en fonction de l'état du panier.
     * @param cart le panier
     */
    void applyPromotion(ShoppingCart cart);
}
