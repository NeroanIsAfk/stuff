package bibliothèque;

public class Video extends Multimedia
{
    private String producteur;

    public Video(int code, String titre, int numSalle, int anneeAcquisition, String realisateur, int duree, int numCleUSB, String producteur)
    {
        super(code, titre, numSalle, anneeAcquisition, realisateur, duree, numCleUSB);
        this.producteur = producteur;
    }

    @Override
    public String matricule()
    {
        return "V" + super.getCode();
    }

    @Override
    public String denomination()
    {
        return "Document vidéo -";
    }
}
