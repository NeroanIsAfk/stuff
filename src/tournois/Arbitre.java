package tournois;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Arbitre
{
    private String prenom;
    private String nom;
    private String code;
    private int anneeNaissance;

    public Arbitre(String prenom, String nom, String code, int anneeNaissance)
    {
        this.prenom = prenom;
        this.nom = nom;
        this.code = code;
        // this. = variables dans le constructeur
        setAnneeNaissance(anneeNaissance);
    }

    public void setAnneeNaissance(int anneeNaissance)
    {
        int anneeEnCours = getAnneeEnCours();
        if (anneeEnCours - anneeNaissance < 18 )
        {
            this.anneeNaissance = anneeEnCours - 18;
        }
        else
        {
            this.anneeNaissance = anneeNaissance;
        }
    }

    public int getAnneeEnCours()
    {
        GregorianCalendar dateDuJour = new GregorianCalendar();
        return dateDuJour.get(Calendar.YEAR);
    }

    public String toString()
    {
        return prenom + " " + nom + " (matricule : " + anneeNaissance + code + ")";
    }
}