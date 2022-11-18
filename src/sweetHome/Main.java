package sweetHome;

public class Main
{
    public static void main(String[] args)
    {
        Villa bungalow;
        Villa maisonCampagne;
        VillaAvecCave manoir;


        Proprietaire piscou = new Proprietaire("Flavien Goffinet", "Chat", "3865639");
        bungalow = new Villa("test", 3, 100,1000, piscou);
        maisonCampagne = new Villa("test2", 2, 4, 100, 75,3000, piscou);
        manoir = new VillaAvecCave("test3", 9, 4, 250, 200, 8000,piscou,150, true);

        piscou.ajouterVilla(bungalow);
        piscou.ajouterVilla(maisonCampagne);
        piscou.ajouterVilla(manoir);
        System.out.println(piscou.listingProprietes());
    }
}
