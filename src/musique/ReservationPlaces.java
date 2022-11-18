package musique;

public class ReservationPlaces
{
    private int nbPlaces;
    private boolean estPaye;
    private Personne personne;
    private Concert concert;

    ReservationPlaces(int nbPlaces, boolean estPaye, Personne personne, Concert concert)
    {
        setNbPlaces(nbPlaces);
        this.estPaye = estPaye;
        this.personne = personne;
        this.concert = concert;
    }

    // Pour une seule place
    ReservationPlaces(boolean estPaye, Personne personne, Concert concert)
    {
        this(1, estPaye, personne, concert);
    }

    // Pour réservation forcément payée
    ReservationPlaces(int nbPlaces, Personne personne, Concert concert)
    {
        this(nbPlaces,true,personne,concert);
    }

    // Pour une place forcément payée ( il y'a deux possibilités )
    ReservationPlaces(Personne personne, Concert concert)
    {
        this(1,personne,concert);
    }

    public void setNbPlaces(int nbPlaces)
    {
        if (nbPlaces >= 1)
        {
            this.nbPlaces = nbPlaces;
        }
        else
        {
            if (this.nbPlaces == 0)
            {
                this.nbPlaces = 1;
            }
        }
    }

    public double prixTotal()
    {
        return nbPlaces * concert.getPrix();
    }

    public String toString()
    {
        return personne + "\na réservé " + nbPlaces + (nbPlaces == 1 ? " place " : "  places ") + concert + "\n" + (estPaye ? "Cette réservation est payée" : "Cette réservation est en attente de payement");
    }
}
