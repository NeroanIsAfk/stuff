package roustam;

public class Main
{
    public final int NB_CELLULES = 4;

    private double[] tab = new double[NB_CELLULES];

    private int nombreChoisi;

    private double total = 0;

    private int nbValeurs = 0;

    public void checkValeurMinimale()
    {
        if (nombreChoisi < tab[0])
        {
            tab[0] = nombreChoisi;
        }
    }

    public void checkValeurMaximale()
    {
        if (nombreChoisi > tab[1])
        {
            tab[1] = nombreChoisi;
        }
    }

    public void calculeMoyenne()
    {
        total += nombreChoisi;
        nbValeurs++;
        tab[2] = (total / nbValeurs);
    }

    public void ecartType()
    {
       tab[3] = (total * total) /
    }
}
