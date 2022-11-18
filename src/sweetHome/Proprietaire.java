package sweetHome;

public class Proprietaire
{
    private String prenomNom;
    private String adresse;
    private String telephone;
    private Villa[] proprietes;
    private int nbVillas;

    public final int NB_MAX_PROPRIETES = 5;

    public Proprietaire(String prenomNom, String adresse, String telephone)
    {
        this.prenomNom = prenomNom;
        this.adresse = adresse;
        this.telephone = telephone;
        proprietes = new Villa[NB_MAX_PROPRIETES];
        nbVillas = 0;
    }

    public void ajouterVilla(Villa nouvelleVilla)
    {
        if (nbVillas < NB_MAX_PROPRIETES && nouvelleVilla.getProprietaire() == this)
        {
            proprietes[nbVillas] = nouvelleVilla;
            nbVillas++;
        }
    }


    public double surfaceTotale()
    {
        double total = 0;

        for (int i = 0; i < nbVillas; i++)
        {
            total += proprietes[i].surfaceTotale();
        }

        return total;
    }

    public String listingProprietes()
    {
        String message = "Listing des propriétés de " + prenomNom + " :\n";

        if (nbVillas == 0)
        {
            message += "Aucune Villa\n";
        }
        else
        {
            for (int i = 0; i < nbVillas; i++)
            {
                message += proprietes[i] + "\n";
            }

            message += "Surface totale de l'ensemble des propriétés : " + surfaceTotale() + " m2";
        }
        return message;
    }
}
