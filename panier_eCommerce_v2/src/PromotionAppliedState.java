/**
 * État du panier après qu'une promotion ait été appliquée.
 */
public class PromotionAppliedState implements CartState {
    
    /**
     * Ne peut pas ajouter d'articles à un panier avec promotion appliquée.
     * @param cart le panier
     * @param item l'article à ajouter
     */
    @Override
    public void addItem(ShoppingCart cart, Item item) {
        System.out.println("Promo déjà appliquée. Impossible d'ajouter d'articles.");
    }

    /**
     * Ne peut pas retirer d'articles à un panier avec promotion appliquée.
     * @param cart le panier
     * @param item l'article à retirer
     */
    @Override
    public void removeItem(ShoppingCart cart, Item item) {
        System.out.println("Promo appliquée. Impossible de retirer des articles.");
    }

    /**
     * La promotion est déjà appliquée.
     * @param cart le panier
     */
    @Override
    public void applyPromotion(ShoppingCart cart) {
        System.out.println("Promo déjà appliquée.");
    }
}
