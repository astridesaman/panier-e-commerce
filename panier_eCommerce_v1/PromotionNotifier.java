public class PromotionNotifier implements CartObserver {

    @Override
    public void update(ShoppingCart cart) {
        if (cart.getTotalWithoutDiscount() > 5000) {
            System.out.println("Promotion possible : vous dépassez 5000 francs !");
        }
    }
}
