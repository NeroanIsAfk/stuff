package premierPackage;
import java.util.Scanner;

public class Principale {
    public static void main(String[] args) {

        Individu moi;

        moi = new Individu("Killian",19,'M',"Châtelet" );

        System.out.println(moi.affichePresentation());

        moi.modifierAge(25);
        moi.modifierGenre('F');

        System.out.println(moi.affichePresentation());

        /*Rectangle premierRectangle;

        premierRectangle = new Rectangle(10,4,1,2);

        premierRectangle.modifierHauteur(2);
        premierRectangle.modifierLargeur(4);

        System.out.println("Le périmètre est de "+ premierRectangle.perimetre());
        System.out.println("La surface est de "+ premierRectangle.surface());

        System.out.println("Largeur : "+ premierRectangle.largeur);
        System.out.println("Hauteur : "+ premierRectangle.hauteur);
        System.out.println("La coordonnée X : "+ premierRectangle.coordonneeX);
        System.out.println("La coordonnée Y : "+ premierRectangle.coordonneeY);

        int x;
        int y = 3;
        String mot;

        Scanner clavier = new Scanner(System.in);

        System.out.print("Entrez un entier : ");
        x = clavier.nextInt();

        System.out.print("Entrez un mot : ");
        mot = clavier.next();

        System.out.println("Le produit vaut "+ x*y);
        System.out.println("La somme vaut "+ x+y);
        // x + y ne fait pas directement l'addition des deux valeurs, en java, cela va afficher les deux valeurs qui sont présentes.
        System.out.println("La somme vaut "+ (x+y));
        System.out.println("Le mot enregistré est "+ mot);
         */
    }
}
