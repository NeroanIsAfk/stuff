package musique;

public class Main
{
    public static void main(String[] args)
    {
        GroupeMusical premierGroupe;
        Concert ouvertureFestival;
        Personne premierePersonne;
        ReservationPlaces premiereReservation;

        premierGroupe = new GroupeMusical("Casseurs Flowteurs","Orelsan",3);
        ouvertureFestival = new Concert("Blue Birds","21 Janvier 2022","Paris",10,premierGroupe);
        premierePersonne = new Personne("Killian","Charlier","0471/32.35.65","charlier.killian@outlook.fr");
        premiereReservation = new ReservationPlaces(4,false,premierePersonne,ouvertureFestival);

        /*System.out.println(premierGroupe);
        System.out.println(ouvertureFestival);
        System.out.println(premierePersonne);*/
        System.out.println(premiereReservation);
    }
}
