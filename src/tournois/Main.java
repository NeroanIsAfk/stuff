package tournois;

import java.sql.SQLOutput;

public class Main
{
    public static void main(String[] args)
    {
        Secretaire premiereSecretaire;
        Secretaire deuxiemeSecretaire;
        Secretaire troisiemeSecretaire;
        Club premierClub;
        Club deuxiemeClub;
        Coach premierCoach;
        Coach deuxiemeCoach;
        Equipe premiereEquipe;
        Equipe deuxiemeEquipe;
        Arbitre premierArbitre;
        Rencontre challenge;

        premiereSecretaire = new Secretaire("Maxence","Minucci","0491/32/43/42");
        deuxiemeSecretaire = new Secretaire("Tristan","Daffe","0491/23/66/25");
        troisiemeSecretaire = new Secretaire("Sofian","Karabulut","0491/57/43/76");
        premierClub = new Club("Flavien's Fanboy","Amine's House",premiereSecretaire);
        deuxiemeClub = new Club("Anime's Fanboy","Tristan'House",deuxiemeSecretaire);
        premierCoach = new Coach("Maxime","Rijoukine",2100);
        deuxiemeCoach = new Coach("Evan","Binard",2002);
        premiereEquipe = new Equipe("667","B+",premierClub,premierCoach);
        deuxiemeEquipe = new Equipe("Kaaris","B",deuxiemeClub, deuxiemeCoach);
        premierArbitre = new Arbitre("Arnaud","Tupiner","NPA",2005);
        challenge = new Rencontre(premiereEquipe, deuxiemeEquipe, 1,0,5,6,premierArbitre);

        //System.out.println(premierClub);
        //System.out.println(deuxiemeClub);
        //System.out.println(premierCoach);
        //ystem.out.println(premiereEquipe);
        //System.out.println(premierArbitre);
        //System.out.println(challenge.vainqueur());
        //System.out.println(challenge.equieFairPlay());
        //System.out.println(challenge.presentationLocaux());
        //challenge.ajouterPointsAuxVisiteurs();
        //System.out.println(challenge.exAequo());
        //System.out.println(challenge.presentationAdversaires());
        System.out.println(challenge);
        System.out.println(challenge.getArbitre());
        // Nécessaire d'écrire le getArbritre car on ne peut pas accéder à ce toString sans avoir l'arbitre ( vu que la variable est private )
    }
}
