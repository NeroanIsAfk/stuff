package bibliothèque;

public class Oeuvre
{
    private int code;
    private String titre;
    private int numSalle;
    private int anneeAcquisition;
    private Emprunteur emprunteur;

    public Oeuvre(int code, String titre, int numSalle, int anneeAcquisition)
    {
        this.code = code;
        this.titre = titre;
        this.numSalle = numSalle;
        this.anneeAcquisition = anneeAcquisition;
    }

    public int getCode()
    {
        return code;
    }

    public int getNumSalle()
    {
        return numSalle;
    }

    public int getAnneeAcquisition()
    {
        return anneeAcquisition;
    }

    public String matricule()
    {
        return "O" + code;
    }

    public String emplacement()
    {
        return "(salle numéro : " + numSalle + ")";
    }

    public String denomination()
    {
        return "Oeuvre -";
    }

    public void donnerEnPret(Emprunteur nouvelEmprunteur)
    {
        this.emprunteur = nouvelEmprunteur;
    }

    public String toString()
    {
        return denomination() + " " + matricule() + " " + emplacement() + " : " + titre + "\n" + (emprunteur == null ? "Aucun emprunteur" : "Emprunteur : " + emprunteur);
    }
}
