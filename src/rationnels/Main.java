package rationnels;

public class Main
{
    public static void main(String[] args)
    {
        Rationnel frac1 = new Rationnel (12, 10);
        Rationnel frac2 = new Rationnel (6, 5);
        Rationnel frac3 = new Rationnel (-6, -5);
        Rationnel addition = frac1.additionnéPar(frac2);
        System.out.println(addition);
    }
}
