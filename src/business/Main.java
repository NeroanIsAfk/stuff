package business;

public class Main
{
    public static void main(String[] args)
    {
        Client premierClient, secondClient;
        Article premierArticle;
        Achat premierAchat;

        premierClient = new Client("Killian","Charlier");
        secondClient = new Client("Flavien","Goffinet");
        premierArticle = new Article("Fromage Rapé",2);
        premierAchat = new Achat(secondClient, premierArticle);

        System.out.println(premierAchat);
        System.out.println(premierAchat.affichePrix());
        System.out.println(premierAchat.getNbExemplaires());
        System.out.println(premierAchat.getArticleEnCours());
        System.out.println(premierAchat.getClientEnCours());
    }
}
