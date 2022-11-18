package musique;

public class GroupeMusical
{
    private String nom;
    private String nomChanteur;
    private int nbMusiciens;

    public GroupeMusical(String nom, String nomChanteur, int nbMusiciens)
    {
        this.nom = nom;
        this.nomChanteur = nomChanteur;
        setNbMusiciens(nbMusiciens);
    }

    public void setNbMusiciens(int nbMusiciens)
    {
        if (nbMusiciens >= 0)
        {
            this.nbMusiciens = nbMusiciens;
        }
    }

    public String toString()
    {
        return nom + " (interprétation : " + nomChanteur + " - accompagnement : " + nbMusiciens + (nbMusiciens > 1 ? " musiciens)" : " musicien)");
    }
}
