package matrice;

public class Main
{
    public static void main(String[] args)
    {
        /* Matrice matrice = new Matrice(3,4,7,2,3,1,1,3,-1,2,2,-2,2,0);
        matrice.combiLineairesLigne(1,2,-7);
        matrice.combiLineairesLigne(3,2,-2);
        matrice.permutLigne(1,2);
        matrice.multiplierLigneParR(3,-0.125);
        matrice.combiLineairesLigne(1,3,-3);
        matrice.combiLineairesLigne(2,3,19);
        matrice.permutLigne(2,3);
        matrice.multiplierLigneParR(3,2);
        matrice.combiLineairesLigne(1,3,-0.5);
        matrice.combiLineairesLigne(2,3,0.5);
        System.out.println(matrice);
       */
        Matrice matrice = new Matrice(3,4,2,-1,-3,1,3,2,-2,-4,-1,-4,6,22);
        matrice.multiplierLigneParR(3,-1);
        matrice.permutLigne(1,3);
        matrice.combiLineairesLigne(2,1,-3);
        matrice.combiLineairesLigne(3,1,-2);
        matrice.multiplierLigneParR(2,-0.1);
        matrice.combiLineairesLigne(1,2,-4);
        matrice.combiLineairesLigne(3,2,9);
        matrice.multiplierLigneParR(3,-0.185);
        matrice.combiLineairesLigne(1,3,-0.4);
        matrice.combiLineairesLigne(2,3,1.6);
        System.out.println(matrice);

        Matrice matrice2 = new Matrice(3,3,2,2,2,2,2,2,2,2,2);
        matrice2.multiExterne(-1);
        System.out.println(matrice2);
    }
}
