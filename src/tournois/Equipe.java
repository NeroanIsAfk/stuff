package tournois;
import java.util.*;

public class Equipe
{
    private String nom;
    private String categorie;
    private Club club;
    private Coach coach;

    public Equipe(String nom, String categorie, Club club, Coach coach)
    {
        this.nom = nom;
        this.categorie = categorie;
        this.club = club;
        this.coach = coach;
    }

    public String toString()
    {
        return "L'équipe " + nom + " de la catégorie " + categorie + " du " + club + " coaché par le " + coach;
    }

    public String getNom() {
        return nom;
    }
}