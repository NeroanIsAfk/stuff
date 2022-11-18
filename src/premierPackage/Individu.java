package premierPackage;

public class Individu {

    String prenom;
    int age;
    char genre;
    String localite;

    Individu(String prenom, int age, char genre, String localite) {
        this.prenom = prenom;
        this.age = age;
        this.genre = genre;
        this.localite = localite;
    }

    void modifierGenre(char nouveauGenre) {
        genre = nouveauGenre;
    }

    void modifierAge(int nouvelAge) {
        age = nouvelAge;
    }

    String affichePresentation() {
        return "Je m'appelle " + prenom + " et je suis " + (genre == 'F' ? "âgée" : "âgé") +" de "+ age + (age > 1 ? " ans" : " an") +".\n"
                + "Je réside à "+ localite;
    }
}
