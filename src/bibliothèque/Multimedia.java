package bibliothèque;

public class Multimedia extends Oeuvre
{
    private String realisateur;
    private int duree;
    private int numCleUSB;

    public Multimedia(int code, String titre, int numSalle, int anneeAcquisition, String realisateur, int duree, int numCleUSB)
    {
        super(code, titre, numSalle, anneeAcquisition);
        this.realisateur = realisateur;
        this.duree = duree;
        this.numCleUSB = numCleUSB;
    }

    @Override
    public String emplacement()
    {
        return "(salle numéro : " + super.getNumSalle() + ", clef USB " + numCleUSB + ")";
    }

    @Override
    public String matricule()
    {
        return "M" + super.getCode();
    }

    @Override
    public String denomination()
    {
        return "Document multimedia -";
    }
}
