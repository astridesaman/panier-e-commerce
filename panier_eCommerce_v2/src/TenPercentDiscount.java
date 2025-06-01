import java.util.List;

/**
 * Réduction de 10% si le total dépasse 5000 francs.
 */
public class TenPercentDiscount implements PromotionStrategy {

    /**
     * Méthode pour appliquer la promotion de 10%.
     * @param items Liste des articles du panier.
     */
    @Override
    public double applyDiscount(List<Item> items) {
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        return total > 5000 ? total * 0.9 : total;
    }
}
