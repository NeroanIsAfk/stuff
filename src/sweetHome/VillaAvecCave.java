package sweetHome;

public class VillaAvecCave extends Villa
{
    private double surfaceCave;
    private boolean aGarageEnSousSol;

    public VillaAvecCave(String adresse, int nbChambres, int nbEtages, double surfaceRezChausee, double surfaceHabitableEtages, double superficieTerrain, Proprietaire proprietaire, double surfaceCave, boolean aGarageEnSousSol)
    {
        super(adresse, nbChambres, nbEtages, surfaceRezChausee, surfaceHabitableEtages, superficieTerrain, proprietaire);
        this.surfaceCave = surfaceCave;
        this.aGarageEnSousSol = aGarageEnSousSol;
    }

    public int nbNiveaux()
    {
        return getNbEtages() + 2;
    }

    public double surfaceTotale()
    {
        return super.surfaceTotale() + surfaceCave;
    }

    public String toString()
    {
        return super.toString() + "\nElle comporte " + nbNiveaux() + " niveaux et contient des caves de " + surfaceCave + " m2 " + (aGarageEnSousSol ? "avec garage en sous-sol" : "");
    }
}
