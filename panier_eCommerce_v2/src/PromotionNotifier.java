/**
 * Observateur qui notifie l'utilisateur lorsqu'une promotion devient applicable.
 */
public class PromotionNotifier implements CartObserver {

    /**
     * Méthode appelée lors d’un changement dans le panier.
     * @param cart le panier observé
     */
    @Override
    public void update(ShoppingCart cart) {
        if (cart.getTotalWithoutDiscount() > 5000) {
            System.out.println("Promotion possible : vous dépassez 5000 francs !");
        }
    }
}
