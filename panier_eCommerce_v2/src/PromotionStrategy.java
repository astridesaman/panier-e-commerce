import java.util.List;

/**
 * Interface de stratégie de promotion.
 */
public interface PromotionStrategy {
    /**
     * Applique une réduction sur le total.
     * @param items map d'articles avec quantités
     * @return le total après réduction
     */
    double applyDiscount(List<Item> items);
}
