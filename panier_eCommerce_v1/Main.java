import java.util.*;

public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.setPromotionStrategy(new TenPercentDiscount());
        cart.addObserver(new PromotionNotifier());

        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Bienvenue dans votre panier e-commerce");

        do {
            System.out.println("\nQue souhaitez-vous faire ?");
            System.out.println("1. Ajouter un article");
            System.out.println("2. Retirer un article");
            System.out.println("3. Appliquer la promotion (à partir de 5000 francs)");
            System.out.println("4. Annuler la promotion");
            System.out.println("5. Afficher les articles du panier");
            System.out.println("6. Afficher total");
            System.out.println("0. Quitter");
            input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.print("Nom de l'article : ");
                    String name = scanner.nextLine();
                    System.out.print("Prix : ");
                    double price = Double.parseDouble(scanner.nextLine());
                    cart.addItem(new Item(name, price));
                    break;
                
                case "2":
                    System.out.print("Nom de l'article à retirer : ");
                    String removeName = scanner.nextLine();
                    Item toRemove = cart.getItems().stream()
                        .filter(i -> i.getName().equalsIgnoreCase(removeName))
                        .findFirst()
                        .orElse(null);

                    if (toRemove != null) {
                        cart.removeItem(toRemove);
                    } else {
                        System.out.println("Article non trouvé dans le panier.");
                    }
                    break;

                case "3":
                    cart.applyPromotion();
                    break;

                case "4":
                    cart.cancelPromotion();
                    break;

                case "5":
                    cart.showItems();
                    break;

                case "6":
                    cart.showTotal();
                    break;

                case "0":
                    System.out.println("À bientôt !");
                    break;

                default:
                    System.out.println("Choix invalide");
            }

        } while (!input.equals("0"));

        scanner.close();
    }
}
