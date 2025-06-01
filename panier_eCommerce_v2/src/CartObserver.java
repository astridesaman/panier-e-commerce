/**
 * Interface pour les observateurs du panier.
 */

public interface CartObserver {
    /**
     * Méthode appelée quand le panier change.
     * @param cart le panier observé
     */
    void update(ShoppingCart cart);
}
