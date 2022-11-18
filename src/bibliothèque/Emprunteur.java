package bibliothèque;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static java.util.Calendar.DAY_OF_MONTH;

public class Emprunteur
{
    private String prenom;
    private String nom;
    private GregorianCalendar dateNaissance;

    public Emprunteur(String prenom, String nom, GregorianCalendar dateNaissance)
    {
        this.prenom = prenom;
        this.nom = nom;
        setDateNaissance(dateNaissance);
    }

    public Emprunteur(String prenom, String nom, int annee, int mois, int jour)
    {
      this(nom, prenom, null);
      setDateNaissance(annee, mois-1, jour);
    }

    public void setDateNaissance(GregorianCalendar dateNaissance)
    {
        this.dateNaissance = dateNaissance;
    }

    public void setDateNaissance(int annee, int mois, int jour)
    {
        if (mois < 1 || mois > 12)
        {
            mois = 1;
        }

        GregorianCalendar a = new GregorianCalendar(annee, mois, jour);

        if (jour < 1 || jour > a.getActualMaximum(a.DAY_OF_MONTH))
        {
            jour = 1;
        }

        this.setDateNaissance(new GregorianCalendar(annee, mois, jour));
    }

    public String presentationDateNaissance()
    {
       return dateNaissance.get(DAY_OF_MONTH) + "/" + (dateNaissance.get(Calendar.MONTH) +1) + "/" + dateNaissance.get(Calendar.YEAR);
    }

    public String toString()
    {
        return prenom + " " + nom;
    }
}
