/**
 * Représente un article achetable dans le panier.
 */
public class Item {
    private String name;
    private double price;

    /**
     * Constructeur qui crée un nouvel article.
     * @param name nom de l'article
     * @param price prix unitaire
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /** @return le prix unitaire de l'article */
    public double getPrice() { return price; }

    /** @return le nom de l'article */
    public String getName() { return name; }
}
