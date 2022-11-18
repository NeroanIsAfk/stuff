package musique;

public class Concert
{
    private String libelle;
    private String date;
    private String lieu;
    private double prix;
    private GroupeMusical groupe;

    public Concert(String libelle, String date, String lieu, double prix, GroupeMusical groupe)
    {
        this.libelle = libelle;
        this.date = date;
        this.lieu = lieu;
        setPrix(prix);
        this.groupe = groupe;
    }

    public void setPrix(double prix)
    {
        if (prix >= 0)
        {
            this.prix = prix;
        }
    }

    public double getPrix()
    {
        return prix;
    }

    public String toString()
    {
        return "Le concert intitulé " + libelle + " du groupe dénommé\n" + groupe + "\nprévu le " + date + " à " + lieu;
    }
}
