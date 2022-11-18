package radar;

public class Main
{
    public static void main(String argv[])
    {
        ExcesVitesse exces = new ExcesVitesse("Châtelet", -10,150);
        ExcesVitesse exces1 = new ExcesVitesse("Châtelet", 30,80);
        ExcesVitesse exces2 = new ExcesVitesse("Châtelet", 410,120);
        Chauffard descampette = new Chauffard("Killian","Charlier","Rue des prouts");

        descampette.ajouterExcessVitesse(exces);
        descampette.ajouterExcessVitesse(exces1);
        descampette.ajouterExcessVitesse(exces2);


        System.out.println(descampette.dossierExces());
    }
}
