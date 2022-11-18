package rationnels;

public class Rationnel
{
    private int num;
    private int dénom;

    public Rationnel(int num, int dénom)
    {
        if (dénom == 0)
        {
            throw new RuntimeException("Dénominateur nul dans le constructeur !");
        }
        this.dénom = dénom;
        this.num = num;
        normalise();
    }

    public Rationnel(int num)
    {
        this(num,1);
    }

    @Override
    public boolean equals (Object o)
    {
        // Si o n’est pas un Rationnel ...
        if (!(o instanceof Rationnel))
            return false;
        // Si c’est un Rationnel, on transtype et on teste.
        Rationnel r = (Rationnel) o;
        return (dénom == r.dénom && num == r.num);
    }

    public String toString()
    {
        if (dénom == 1)
        {
            return Integer.toString(num);
        }
        return num + "/" + dénom;
    }

    public double getValeurRéelle()
    {
        return (double)num / dénom;
    }

    private void normalise()
    {
        int pgcd = pgcd(Math.abs(num), Math.abs(dénom));

        dénom /= pgcd;
        num /= pgcd;

        if (dénom < 0)
        {
            dénom = -dénom;
            num = -num;
        }
    }

    private static int pgcd(int a, int b)
    {
        if (a == b)
        {
            return a;
        }

        if (a < b)
        {
            return pgcd(a, (b - a));
        }
        return pgcd(b, (a - b));
    }

    public Rationnel multipliéPar(Rationnel o)
    {
        int newNum = (num * o.num);
        int newDénom = (dénom * o.dénom);
        Rationnel produit = new Rationnel(newNum, newDénom);
        return produit;
    }

    public Rationnel additionnéPar(Rationnel o)
    {
        int newNum = (num + o.num);
        int newDénom = (dénom + o.dénom);
        Rationnel addition = new Rationnel(newNum, newDénom);
        return addition;
    }

    public Rationnel soustraitPar(Rationnel o)
    {
        int newNum = (num - o.num);
        int newDénom = (dénom - o.dénom);
        Rationnel soustraction = new Rationnel(newNum, newDénom);
        return soustraction;
    }

    public Rationnel diviséPar(Rationnel o)
    {
        int newNum = (num / o.num);
        int newDénom = (dénom / o.dénom);
        Rationnel division = new Rationnel(newNum, newDénom);
        return division;
    }

    public Rationnel inverséPar()
    {
        int newNum = dénom;
        int newDénom = num;
        Rationnel inversion = new Rationnel(newNum, newDénom);
        return inversion;
    }
}

