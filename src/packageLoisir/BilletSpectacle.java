package packageLoisir;

public class BilletSpectacle {

    String intitule;
    String date;
    char categorie;
    double tarif;
    boolean etudiant;

    BilletSpectacle(String intitule, String date, char categorie, double tarif, boolean etudiant) {
        this.intitule = intitule;
        this.date = date;
        this.categorie = categorie;
        this.tarif = tarif;
        this.etudiant = etudiant;
    }

    double tarifBillet() {
        double prix = tarif;
        if (categorie == 'A') {
            prix *= 1.1;
        } else {
            if  (categorie == 'B') {
                prix *= 0.8;
            }
        }
        if (etudiant) {
            prix *= 0.5;
        }
        return prix;
    }

    String descriptionBillet() {
        return "Billet pour le spectacle intitulé " + intitule + " du " + date + " en catégorie "
                + categorie + (etudiant ? " avec carte étudiant" : "") + " pour un total de " + tarifBillet() + " euros";
    }
}
