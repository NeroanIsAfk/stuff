package radar;

public class ExcesVitesse
{
    private String localite;
    private int limitationVitesse;
    private int vitesseAuFlash;

    public ExcesVitesse(String localite, int limitationVitesse, int vitesseAuFlash)
    {
        this.localite = localite;
        setlimitationVitesse(limitationVitesse);
        setvitesseAuFlash(vitesseAuFlash);
    }

    public void setlimitationVitesse(int limitationVitesse)
    {
        if (limitationVitesse >= 10 && limitationVitesse <= 130)
        {
            this.limitationVitesse = limitationVitesse;
        }
        else
        {
            this.limitationVitesse = 90;
        }
    }

    public void setvitesseAuFlash(int vitesseAuFlash)
    {
        if (vitesseAuFlash < 0)
        {
            this.vitesseAuFlash = 0;
        }
        else
        {
            if (vitesseAuFlash > 400)
            {
                this.vitesseAuFlash = 400;
            }
            else
            {
                this.vitesseAuFlash = vitesseAuFlash;
            }
        }
    }

    public int getLimitationVitesse()
    {
        return limitationVitesse;
    }

    public int getVitesseAuFlash()
    {
        return vitesseAuFlash;
    }

    public int montantAmende()
    {
        int montant = 53;

        if (vitesseAuFlash > limitationVitesse + 10)
        {
            montant += (vitesseAuFlash - (limitationVitesse + 10)) * (limitationVitesse <= 50 ? 11 : 6);
        }

        return montant;
    }

    public String toString()
    {
        return montantAmende() + " euros d'amende pour avoir été flashé à " + vitesseAuFlash + " hm/h à " + localite + " sur une route limitée à " + limitationVitesse + " km/h";
    }
}
