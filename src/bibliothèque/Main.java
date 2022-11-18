package bibliothèque;

import java.util.GregorianCalendar;

public class Main
{
    public static void main(String[] args)
    {
        // GregorianCalendar dateNaissanceKillian = new GregorianCalendar(1980,12,32);
        Emprunteur emprunteur = new Emprunteur("Killian","Charlier",1980,12,30);
        Oeuvre oeuvre = new Oeuvre(1512,"Livre de la jungle",15,2021);
        Livre livre = new Livre(1077,"Alice aux pays des merveilles", 15, 2021, "Tristan", 300, 3);
        Multimedia multimedia = new Multimedia(5025,"Big Ben",5,2021,"Flavien",3600,5);
        Audio audio = new Audio(8533,"Le Big Date et nous",4,1999,"Flavien",3600,3,"Tristan");
        Video video = new Video(8533,"Les cinglés de l'IOT",5,2021,"Flavien",3600,2,"Tristan");

        // oeuvre.donnerEnPret(emprunteur);
        System.out.println(emprunteur.presentationDateNaissance());
    }
}
