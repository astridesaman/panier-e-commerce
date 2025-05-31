import java.util.*;

public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private List<CartObserver> observers = new ArrayList<>();
    private PromotionStrategy promotionStrategy;
    private CartState state = new EmptyCartState();
    private double discountedTotal = -1;

    public void setPromotionStrategy(PromotionStrategy strategy) {
        this.promotionStrategy = strategy;
    }

    public void setState(CartState newState) {
        this.state = newState;
    }

    public void addObserver(CartObserver obs) {
        observers.add(obs);
    }

    public void notifyObservers() {
        for (CartObserver obs : observers) {
            obs.update(this);
        }
    }

    public void addItem(Item item) {
        state.addItem(this, item);
    }

    public void removeItem(Item item) {
        state.removeItem(this, item);
    }

    public void applyPromotion() {
        state.applyPromotion(this);
    }

    public void applyCurrentPromotion() {
        if (promotionStrategy != null) {
            double discounted = promotionStrategy.applyDiscount(items);
            this.discountedTotal = discounted;
            System.out.printf("✅ Promo appliquée. Total après réduction : %.2f€%n", discounted);
        }
    }


    public double getTotalWithoutDiscount() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
    
    public void showTotal() {
        double total = getTotalWithoutDiscount();

        System.out.printf("💵 Total sans réduction : %.2f€%n", total);

        if (discountedTotal >= 0 && discountedTotal < total) {
            System.out.printf("🎯 Total avec réduction : %.2f€%n", discountedTotal);
        } else {
            System.out.println("❌ Aucune réduction appliquée.");
        }
    }


    public List<Item> getItems() {
        return items;
    }

    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("Le panier est vide.");
        } else {
            System.out.println("Contenu du panier :");
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                System.out.printf("  %d. %s - %.2f€%n", i + 1, item.getName(), item.getPrice());
            }
        }
    }

    public void cancelPromotion() {
        if (state instanceof PromotionAppliedState) {
            System.out.println("↩️ Promo annulée. Retour au total normal.");
            setState(new ActiveCartState());
            discountedTotal = -1;
            notifyObservers();
        } else {
            System.out.println("⚠️ Aucune promotion à annuler.");
        }
    }



}
