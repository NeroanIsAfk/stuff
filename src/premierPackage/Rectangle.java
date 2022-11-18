package premierPackage;

public class Rectangle {

    int largeur;
    int hauteur;
    int coordonneeX;
    int coordonneeY;

    Rectangle(int largeur, int hauteur, int coordonneeX, int coordonneeY) {
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.coordonneeX = coordonneeX;
        this.coordonneeY = coordonneeY;
    }

    void modifierLargeur(int delta) {
        largeur += delta;
    }

    void modifierHauteur(int delta) {
        hauteur += delta;
    }

    int perimetre() {
        return (largeur + hauteur)*2;
    }

    int surface() {
       return largeur * hauteur;
    }

    void deplacerEn(int nouveauX, int nouveauY) {
        coordonneeX = nouveauX;
        coordonneeY = nouveauY;
    }
}
