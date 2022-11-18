package tournois;

public class Rencontre
{
    private Equipe locaux;
    private Equipe visiteurs;
    private int nbPointsLocaux;
    private int nbPointsVisiteurs;
    private int nbFautesLocaux;
    private int nbFautesVisiteurs;
    private Arbitre arbitre;

    public Rencontre(Equipe locaux, Equipe visiteurs, int nbPointsLocaux, int nbPointsVisiteurs, int nbFautesLocaux, int nbFautesVisiteurs, Arbitre arbitre)
    {
        this.locaux = locaux;
        this.visiteurs = visiteurs;
        setNbPointsLocaux(nbPointsLocaux);
        setNbPointsVisiteurs(nbPointsVisiteurs);
        setNbFautesLocaux(nbFautesLocaux);
        setNbFautesVisiteurs(nbFautesVisiteurs);
        this.arbitre = arbitre;
    }

    public Rencontre(Equipe locaux, Equipe visiteurs, Arbitre arbitre)
    {
        this.locaux = locaux;
        this.visiteurs = visiteurs;
        nbPointsLocaux = 0;
        nbPointsVisiteurs = 0;
        nbFautesLocaux = 0;
        nbFautesVisiteurs = 0;
        this.arbitre = arbitre;
    }

    public void setNbPointsLocaux(int nbPointsLocaux)
    {
        if (nbPointsLocaux >= 0)
        {
            this.nbPointsLocaux = nbPointsLocaux;
            // Ici, on demande de ne pas pouvoir encoder de variables qui sont en-dessous de 0 mais on veut pas supprimer l'ancienne variable qui était encodé si on se trompe
        }
    }

    public void setNbPointsVisiteurs(int nbPointsVisiteurs)
    {
        if (nbPointsVisiteurs >= 0)
        {
            this.nbPointsVisiteurs = nbPointsVisiteurs;
        }
    }

    public void setNbFautesLocaux(int nbFautesLocaux)
    {
        if (nbFautesLocaux >= 0)
        {
            this.nbFautesLocaux = nbFautesLocaux;
        }
    }

    public void setNbFautesVisiteurs(int nbFautesVisiteurs)
    {
        if (nbFautesVisiteurs >= 0)
        {
            this.nbFautesVisiteurs = nbFautesVisiteurs;
        }
    }

    public void ajouterPointsAuxLocaux()
    {
        ajouterPointsAuxLocaux(1);
    }

    public void ajouterPointsAuxLocaux(int nbPoints)
    {
        setNbPointsLocaux(nbPointsLocaux + nbPoints);
    }

    public void ajouterPointsAuxVisiteurs()
    {
        ajouterPointsAuxVisiteurs(1);
    }

    public void ajouterPointsAuxVisiteurs(int nbPoints)
    {
        setNbPointsVisiteurs(nbPointsVisiteurs + nbPoints);
    }

    public void ajouterFautesAuxVisiteurs()
    {
        nbFautesVisiteurs++;
    }

    public void ajouterFautesAuxLocaux()
    {
        nbFautesLocaux++;
    }

    public String vainqueur()
    {
        String message;

        if (nbPointsVisiteurs == nbPointsLocaux)
        {
            message = "ex aequo";
        }
        else
        {
            if (nbPointsVisiteurs > nbPointsLocaux)
            {
                message = "Victoire des " + visiteurs.getNom();
            }
            else
            {
                message = "Victoire des " + locaux.getNom();
            }
        }
        return message;
    }

    public String equieFairPlay()
    {
        String message;

        if (nbFautesLocaux == nbFautesVisiteurs)
        {
            message = "ex aequo";
        }
        else
        {
            if (nbFautesVisiteurs < nbFautesLocaux)
            {
                message = "Moins de fautes de la part des " + locaux.getNom();
            }
            else
            {
                message = "Moins de fautes de la part des " + visiteurs.getNom();
            }
        }
        return message;
    }

    public boolean exAequo()
    {
        return nbPointsVisiteurs == nbPointsLocaux;
    }

    public String presentationLocaux()
    {
        return "équipe locale " + locaux.getNom();
    }

    public String presentationVisiteurs()
    {
        return "équipe visiteur " + visiteurs.getNom();
    }

    public String presentationAdversaires()
    {
        return locaux + " reçoit " + visiteurs;
    }

    public void ajouterPoints(char caractere, int nbPoints)
    {
        if (caractere == 'L')
        {
            ajouterPointsAuxLocaux(nbPoints);
        }
        if (caractere == 'V')
        {
            ajouterPointsAuxVisiteurs(nbPoints);
            // On ré-utilise les méthodes que nous avons créé précédemment pour pouvoir faciliter l'usage
        }
    }

    public void ajouterPoints(char caractere)
    {
        if (caractere == 'L')
        {
            ajouterPointsAuxLocaux(1);
        }
        if (caractere == 'V')
        {
            ajouterPointsAuxVisiteurs(1);
            // Surcharge de méthodes -> à prendre notes
        }
    }

    public String toString()
    {
        return "Rencontre arbitrée par : " + arbitre + "\nentre \nLocaux : " + locaux + "\net \nVisiteurs : " + visiteurs + "\nVainqueur : " + vainqueur();
    }

    public Arbitre getArbitre()
    {
        return arbitre;
    }
}
