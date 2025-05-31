import java.util.List;

public class TenPercentDiscount implements PromotionStrategy {

    @Override
    public double applyDiscount(List<Item> items) {
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        return total > 5000 ? total * 0.9 : total;
    }
}
