package sweetHome;

public class Villa
{
    private String adresse;
    private int nbChambres;
    private int nbEtages;
    private double surfaceRezChaussee;
    private double surfacehabitableEtages;
    private double superficieTerrain;
    private Proprietaire proprietaire;

    public Villa(String adresse, int nbChambres, int nbEtages, double surfaceRezChaussee, double surfacehabitableEtages, double superficieTerrain, Proprietaire proprietaire)
    {
        this.adresse = adresse;
        this.nbChambres = nbChambres;
        this.nbEtages = nbEtages;
        this.surfaceRezChaussee = surfaceRezChaussee;
        this.surfacehabitableEtages = surfacehabitableEtages;
        this.superficieTerrain = superficieTerrain;
        this.proprietaire = proprietaire;
    }

    public Villa(String adresse, int nbChambres, double surfaceRezChaussee, double superficieTerrain, Proprietaire proprietaire)
    {
        this(adresse, nbChambres, 0,surfaceRezChaussee, 0, superficieTerrain, proprietaire);
    }

    public Proprietaire getProprietaire()
    {
        return proprietaire;
    }

    public int getNbEtages()
    {
        return nbEtages;
    }

    public double surfaceTotale()
    {
        return surfaceRezChaussee + (surfacehabitableEtages * nbEtages);
    }

    public double superficieJardin()
    {
        return superficieTerrain - surfaceRezChaussee;
    }

    public String typeJardin()
    {
        String phrase;
        double superficieJardin = superficieJardin();

        if (superficieJardin == 0)
        {
            phrase = "sans jardin";
        }
        else
        {
            if (superficieJardin < 5000)
            {
                phrase = "avec jardin de " + superficieJardin + " ares";
            }
            else
            {
                phrase = "avec parc de " + superficieJardin + " ares";
            }
        }
        return phrase;
    }

    public boolean pourFamilleNombreuses()
    {
        return nbChambres >= 4;
    }

    public String toString()
    {
        return "La villa est située au " + adresse + " d'une surface habitable de " + surfaceTotale() + " m2 " + typeJardin() + (pourFamilleNombreuses() ? " convient pour une famille nombreuses" :  " ne convient pas pour une famille nombreuses");
    }
}
