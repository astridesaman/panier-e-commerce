# 🧩 Projet Génie Logiciel : Panier e-commerce (console)

## 📌 Informations générales
- **Langage** : Java  
- **Mode** : Console (texte)  
- **Groupe** : Astride SAMAN, Holisoa RASAMOELSON & Quoc-Kim BUI
- **Design patterns utilisés** :  
  - ✅ Strategy (promotions)  
  - ✅ State (états du panier)  

---

## 🗂️ Plan du projet

### 1. Présentation du contexte
- Application simulant un panier d’achat en ligne.
- Fonctionnalités principales :
  - Ajout/suppression d’articles
  - Calcul du total avec ou sans promotion
  - Application d'une promotion en fonction d'une condition

---

### 2. Diagramme de classes
- Classes principales :
  - `ShoppingCart` (composée d’une stratégie et d’un état)
  - `PromotionStrategy` (interface)
    - `RemisePourcentage`, `RemiseFixe`...
  - `CartState` (interface)
    - `EmptyCartState`, `ActiveCartState`, `PromotionAppliedState`
- Le diagramme UML illustre clairement l'utilisation de Strategy et State.

---

### 3. Choix et intérêt des design patterns

#### Strategy
- Gère différentes politiques de promotion sans changer le panier.
- Exemple : appliquer une remise selon un pourcentage ou un montant fixe.

#### State
- Gère le comportement du panier selon son état :
  - `EmptyCartState` → on peut ajouter des articles
  - `ActiveCartState` → on peut ajouter, retirer des articles, et appliquer une promotion si possible
  - `PromotionAppliedState` → plus de modification possible

---

### 4. Points positifs / négatifs

| ✅ Points positifs                        | ❌ Points négatifs                                 |
|-------------------------------------------|----------------------------------------------------|
| Prévention des erreurs                    | Implémentation du State plus complexe à débuter    |
| Bonne séparation des responsabilités      | Gestion manuelle de certaines transitions d'état   |
| Code réutilisable                         | Besoin d’une structure claire dès le départ        |

---

### 5. Conclusion sur l’utilisation des patterns
- Apport d’une structure claire et d’un code maintenable.
- Évolutivité simple (ajout d'états ou de promos sans modifier la logique principale).
- Meilleure maîtrise des principes de conception objet.

---

### 6. Ressenti sur le semestre en Génie Logiciel
- Bonne découverte des design patterns en pratique.
- Travail d’équipe enrichissant et formateur.
- Vision plus professionnelle du développement logiciel.

---


# panier-e-commerce
