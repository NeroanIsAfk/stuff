package musique;

public class Personne
{
    private String prenom;
    private String nom;
    private String telephone;
    private String adresseEmail;

    public Personne(String prenom, String nom, String telephone, String adresseEmail)
    {
        this.prenom = prenom;
        this.nom = nom;
        this.telephone = telephone;
        this.adresseEmail = adresseEmail;
    }

    public String toString()
    {
        return prenom + " " + nom + " (" + telephone + " - " + adresseEmail + ")";
    }
}
