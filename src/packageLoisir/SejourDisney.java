package packageLoisir;

public class SejourDisney {

    int nbEnfants;
    int nbAdultes;
    int nbJours;
    int nbVehicules;
    boolean mobiliteReduite;

    SejourDisney(int nbEnfants, int nbAdultes, int nbJours, int nbVehicules, boolean mobiliteReduite) {
        this.nbEnfants = nbEnfants;
        this.nbAdultes = nbAdultes;
        this.nbJours = nbJours;
        this.nbVehicules = nbVehicules;
        this.mobiliteReduite = mobiliteReduite;
    }

    int nbNuits() {
        return nbJours - 1;
    }

    boolean estLongSejour() {
        return nbNuits() >= 3;
    }

    double coutEntreeParc() {
        double jourGratuit = 0;

        if (estLongSejour()) {
            jourGratuit = (19.9 * nbEnfants) + (45 * nbAdultes);
        }

        return (19.9 * nbEnfants * nbJours) + (45 * nbAdultes * nbJours) - jourGratuit;
    }

    int nbNuiteesEnfantsGratuites() {
        return nbNuits() / 3;
    }

    double coutHotel() {
        return (49.9 * (nbNuits() - nbNuiteesEnfantsGratuites()) * nbEnfants) + (65.5 * nbNuits() * nbAdultes);
    }

    int coutParking() {

        if (mobiliteReduite) {
            return 0;
        } else {
            return 8 * nbJours * nbVehicules;
        }
    }

    double coutTotal() {
        return coutEntreeParc() + coutHotel() + coutParking();
    }

    boolean aAccesPrioritaire() {
        return mobiliteReduite;
    }

    // Pour faire des expressions conditionnels, il faut juste mettre les conditions entières entre paranthèses car sinon le logiciel n'aime pas vraiment ça.
    String resumeSejour() {
        return "Le séjour chez de " + nbJours + " jour" + (nbJours > 1 ? "s " : " ") + "et " + nbNuits() + " nuit" + (nbNuits() > 1 ? "s " : " ") + "pour "
                + nbEnfants + " enfant" + (nbEnfants > 1 ? "s " : " ") + "et " + nbAdultes + " adulte" + (nbAdultes > 1 ? "s " : " ") + "avec "
                + nbVehicules + " véhicule" + (nbVehicules > 1 ? "s " : " ") + "pour un montant total de " + coutTotal() + " euros"
                + (mobiliteReduite ? "avec accès prioritaire." : ".");
    }

}
