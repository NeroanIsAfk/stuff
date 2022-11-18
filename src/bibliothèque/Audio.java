package bibliothèque;

public class Audio extends Multimedia
{
    private String preneurDeSon;

    public Audio(int code, String titre, int numSalle, int anneeAcquisition, String realisateur, int duree, int numCleUSB, String preneurDeSon)
    {
        super(code, titre, numSalle, anneeAcquisition, realisateur, duree, numCleUSB);
        this.preneurDeSon = preneurDeSon;
    }

    @Override
    public String matricule()
    {
        return (super.getAnneeAcquisition() < 2000 ? "D" : "N") + super.getCode();
    }

    @Override
    public String denomination()
    {
        return "Document audio -";
    }
}
