package tournois;
import java.util.*;

public class Coach
{
    private String prenom;
    private String nom;
    private int anneeDebut;

    Coach(String prenom, String nom, int anneeDebut)
    {
        this.prenom = prenom;
        this.nom = nom;
        setAnneeDebut(anneeDebut);
    }

    int nbAnneesExperience()
    {
        return getAnneeEnCours() - anneeDebut;
    }

    public void setAnneeDebut(int anneeDebut)
    {
        int anneeEnCours = getAnneeEnCours();
        if (anneeDebut > anneeEnCours)
        {
            this.anneeDebut = anneeEnCours;
        }
        else
        {
            this.anneeDebut = anneeDebut;
        }
    }

    public int getAnneeEnCours()
    {
        GregorianCalendar dateDuJour = new GregorianCalendar();
        return dateDuJour.get(Calendar.YEAR);
    }

    public String toString()
    {
        return "Coach " + prenom + " " + nom + " ( " + nbAnneesExperience() + " années d'expérience )";
    }
}