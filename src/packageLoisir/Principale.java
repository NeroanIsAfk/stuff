package packageLoisir;

public class Principale {
    public static void main(String[] args) {

        BilletSpectacle billet;
        SejourDisney sejour;

        billet = new BilletSpectacle("Jason","12 Janvier 2022",'C',20,true);
        sejour = new SejourDisney(5,2,7,1,false);

        System.out.println(billet.descriptionBillet());
        System.out.println(sejour.resumeSejour());
    }
}
