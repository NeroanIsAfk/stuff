package business;

public class Achat {

    private Client clientEnCours;
    private Article articleEnCours;
    private int nbExemplaires;

    public Achat(Client clientEnCours, Article articleEnCours, int nbExemplaires)
    {
        this.clientEnCours = clientEnCours;
        this.articleEnCours = articleEnCours;
        setNbExemplaires(nbExemplaires);
    }

    public Achat(Client clientEnCours, Article articleEnCours)
    {
        this.clientEnCours = clientEnCours;
        this.articleEnCours = articleEnCours;
        nbExemplaires = 1;
    }

    public void setNbExemplaires(int nbExemplaires) {
        if (nbExemplaires < 1)
        {
            this.nbExemplaires = 1;
        }
        else
        {
            this.nbExemplaires = nbExemplaires;
        }
    }

    public double coutTotal()
    {
        return (double)nbExemplaires * articleEnCours.getPrix();
    }

    public String toString()
    {
        return "Le client " + clientEnCours + " a acheté l'article " + articleEnCours + (nbExemplaires == 1 ? " en un seul exemplaire pour un motant total de " +
            + coutTotal() + " euro" + (coutTotal() > 1.99 ? "s " : " ") : " en " + nbExemplaires + " exemplaires pour un motant total de " +
                + coutTotal() + " euro" + (coutTotal() > 1.99 ? "s " : " "));
    }

    public String affichePrix()
    {
        return "Le prix est de " + articleEnCours.getPrix();
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }

    public Article getArticleEnCours() {
        return articleEnCours;
    }

    public Client getClientEnCours() {
        return clientEnCours;
    }
}
