package bibliothèque;

public class Livre extends Oeuvre
{
    private String auteur;
    private int nbPages;
    private int numEtagere;

    public Livre(int code, String titre, int numSalle, int anneeAcquisition, String auteur, int nbPages, int numEtagere)
    {
        super(code, titre, numSalle, anneeAcquisition);
        this.auteur = auteur;
        this.nbPages = nbPages;
        this.numEtagere = numEtagere;
    }

    @Override
    public String emplacement()
    {
        return "(salle numéro : " + super.getNumSalle() + ", étagère " + numEtagere + ")";
    }

    @Override
    public String matricule()
    {
        return "L" + super.getCode() + "/" + super.getNumSalle();
    }

    @Override
    public String denomination()
    {
        return "Livre -";
    }
}
