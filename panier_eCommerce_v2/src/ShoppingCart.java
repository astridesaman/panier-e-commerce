import java.util.*;

/**
 * Panier contenant des articles et gérant promotions et notifications.
 */
public class ShoppingCart {
    private List<Item> items = new ArrayList<>();
    private List<CartObserver> observers = new ArrayList<>();
    private PromotionStrategy promotionStrategy;
    
    /**
     * Initialise le panier à vide.
     */
    private CartState state = new EmptyCartState();
    private double discountedTotal = -1;

    // ----- État -----

    public void setState(CartState newState) {
        this.state = newState;
    }

    // ----- Articles -----

    /**
     * Ajoute un article via l'état courant.
     * @param item l'article à ajouter
     */
    public void addItem(Item item) {
        state.addItem(this, item);
    }

    /**
     * Retire un article si le panier n'est pas vide.
     * @param item l'article à retirer
     */
    public void removeItem(Item item) {
        state.removeItem(this, item);
    }

    // ----- Promotions -----

    /**
     * Définit une stratégie de promotion à appliquer.
     * @param strategy la stratégie à appliquer
     */
    public void setPromotionStrategy(PromotionStrategy strategy) {
        this.promotionStrategy = strategy;
    }

    /**
     * Applique la stratégie de promotion actuelle et met à jour le total.
     */
    public void applyCurrentPromotion() {
        if (promotionStrategy != null) {
            double discounted = promotionStrategy.applyDiscount(items);
            this.discountedTotal = discounted;
            System.out.printf("Promo appliquée. Total après réduction : %.2f€%n", discounted);
        }
    }

    /**
     * Annule la promotion appliquée.
     */
    public void cancelPromotion() {
        if (state instanceof PromotionAppliedState) {
            System.out.println("↩Promo annulée. Retour au total normal.");
            setState(new ActiveCartState());
            discountedTotal = -1;
            notifyObservers();
        } else {
            System.out.println("Aucune promotion à annuler.");
        }
    }

    /**
     * Permet d'appliquer la promotion à l'état actuel.
     */
    public void applyPromotion() {
        state.applyPromotion(this);
    }

    // ----- Total -----

    /**
     * Affiche le total avec et sans promotion.
     */
    public void showTotal() {
        double total = getTotalWithoutDiscount();

        System.out.printf("Total sans réduction : %.2f€%n", total);

        if (discountedTotal >= 0 && discountedTotal < total) {
            System.out.printf("Total avec réduction : %.2f€%n", discountedTotal);
        } else {
            System.out.println("Aucune réduction appliquée.");
        }
    }
    
    /**
     * Calcule le total brut.
     * @return total sans réduction
     */
    public double getTotalWithoutDiscount() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    /**
     * Affiche le contenu du panier.
     */
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

    public List<Item> getItems() {
        return items;
    }

    // ----- Observateurs -----

    /**
     * Ajoute un observateur au panier.
     * @param obs un observateur
     */
    public void addObserver(CartObserver obs) {
        observers.add(obs);
    }

    /**
     * Notifie les observateurs du panier.
     */
    public void notifyObservers() {
        for (CartObserver obs : observers) {
            obs.update(this);
        }
    }
}
