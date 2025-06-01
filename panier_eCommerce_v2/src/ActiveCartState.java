/**
 * État représentant un panier avec au moins un article, sans promotion appliquée.
 */
public class ActiveCartState implements CartState {

    /**
     * Ajoute un article à un panier actif.
     * @param cart le panier
     * @param item l'article à ajouter
     */
    @Override
    public void addItem(ShoppingCart cart, Item item) {
        cart.getItems().add(item);
        cart.notifyObservers();
    }

    /**
     * Retire un article d’un panier actif.
     * @param cart le panier
     * @param item l'article à retirer
     */
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

    /**
     * Applique une promotion et passe à l'état PromotionApplied.
     * @param cart le panier
     */
    @Override
    public void applyPromotion(ShoppingCart cart) {
        cart.applyCurrentPromotion();
        cart.setState(new PromotionAppliedState());
    }
}
