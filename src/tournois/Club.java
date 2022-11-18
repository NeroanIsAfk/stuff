package tournois;

public class Club
{

    private String nom;
    private String adresse;
    private Secretaire secretaireClub;

    public Club(String nom, String adresse, Secretaire secretaireClub)
    {
        this.nom = nom;
        this.adresse = adresse;
        this.secretaireClub = secretaireClub;
    }

    public String toString()
    {
        return "Club " + nom + " ( secrétaire : " + secretaireClub + " )";
    }
}
