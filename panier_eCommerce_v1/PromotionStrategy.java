import java.util.List;

public interface PromotionStrategy {
    double applyDiscount(List<Item> items);
}
