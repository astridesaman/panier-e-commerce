public class PromotionAppliedState implements CartState {

    @Override
    public void addItem(ShoppingCart cart, Item item) {
        System.out.println("Promo déjà appliquée. Impossible d'ajouter d'articles.");
    }

    @Override
    public void removeItem(ShoppingCart cart, Item item) {
        System.out.println("Promo appliquée. Impossible de retirer des articles.");
    }

    @Override
    public void applyPromotion(ShoppingCart cart) {
        System.out.println("Promo déjà appliquée.");
    }
}
