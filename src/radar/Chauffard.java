package radar;

public class Chauffard
{
    private String prenom;
    private String nom;
    private String adresse;
    private ExcesVitesse[] delitsVitesse;
    private int nbExcesVitesse;

    public final int NB_MAX_DELITS = 24;

    public Chauffard(String prenom, String nom, String adresse)
    {
        this.prenom = prenom;
        this.nom = nom;
        this.adresse = adresse;
        delitsVitesse = new ExcesVitesse[NB_MAX_DELITS];
        nbExcesVitesse = 0;
    }

    public void ajouterExcessVitesse(ExcesVitesse exces)
    {
        if (nbExcesVitesse < NB_MAX_DELITS)
        {
            delitsVitesse[nbExcesVitesse] = exces;
            nbExcesVitesse++;
        }
    }

    public int totalAmendes()
    {
        int total = 0;

        for (int iAmende = 0; iAmende < nbExcesVitesse; iAmende++)
        {
            total += delitsVitesse[iAmende].montantAmende();
        }
        return total;
    }

    public int depassamentMaximal()
    {
        int depassamentMax = 0;
        int ecartVitesse;

        for (int iDepassament = 0; iDepassament < nbExcesVitesse; iDepassament++)
        {
            ecartVitesse = delitsVitesse[iDepassament].getVitesseAuFlash() - delitsVitesse[iDepassament].getLimitationVitesse();

            if (ecartVitesse > depassamentMax)
            {
                depassamentMax = ecartVitesse;
            }
        }
        return depassamentMax;
    }

    public String dossierExces()
    {
        String message = "Dossier pour excès de vitesse de " + prenom + nom + " pour l'année en cours :\n";

        if (nbExcesVitesse == 0)
        {
            message += "aucun\n";
        }
        else
        {
            for (int i = 0; i < nbExcesVitesse; i++)
            {
                message += delitsVitesse[i] + "\n";
            }

            message += "pour un montant total de " + totalAmendes() + " euros d'amende";
        }
        return message;
    }
}
