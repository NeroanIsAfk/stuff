package matrice;

public class Matrice
{

    private double [][] composantes;

    //constructeur generale
    public Matrice( double composantes[][] ){

        //verifie si au moins une ligne
        if( composantes.length < 1)
            throw new RuntimeException ("Pas assez de lignes (min 0)");

        boolean matriceCorrecte = true;
        int i = 0;
        //verifie si pas de colonnes vide et si toute de meme longueur
        while( i < composantes.length && matriceCorrecte){
            matriceCorrecte = composantes[i].length > 0 && composantes[0].length == composantes[i].length;
            i++;
        }

        //message d erreurs
        if( !matriceCorrecte ){
            if( composantes[i-1].length == 0 )
                throw new RuntimeException ("Ligne vide");
            else
                throw new RuntimeException ("Colonne de taille differente");
        }
        //creer l ojet
        else
            this.composantes = composantes;
    }

    //constructeur matrice toute valeur �gale
    public Matrice( int nbLignes, int nbColonnes, double valeur){

        composantes = new double[nbLignes][nbColonnes];

        if( nbLignes < 1 )
            throw new RuntimeException ("nombre de lignes null ou n�gatif");
        if( nbColonnes < 1 )
            throw new RuntimeException ("nombre de colonnes null ou n�gatif");

        for( int iLigne = 0; iLigne < nbLignes; iLigne++){
            for( int iColonne = 0; iColonne < nbColonnes; iColonne++){
                this.composantes[iLigne][iColonne] = valeur;
            }
        }
    }

    //constructeur souple
    public Matrice (int nbLignes, int nbColonnes, double... valeurs){

        composantes = new double[nbLignes][nbColonnes];

        if( nbLignes < 1 )
            throw new RuntimeException ("nbLignes invalide");
        if( nbColonnes < 1 )
            throw new RuntimeException ("nbColonnes invalide");
        if( valeurs.length != nbLignes * nbColonnes )
            throw new RuntimeException ("nombre de valeurs incorrecte");

        for( int iLigne = 0; iLigne < nbLignes; iLigne++){
            for( int iColonne = 0; iColonne < nbColonnes; iColonne++){
                this.composantes[iLigne][iColonne] = valeurs[iLigne * nbColonnes + iColonne];
            }
        }
    }

    //getter ligne
    public int getLigne(){
        return composantes.length;
    }
    //getter colonne
    public int getColonne(){
        return composantes[0].length;
    }
    //getter valeur (utilise les indices mathematiques)
    public double getValeur( int iLigne, int iColonne ){

        if( !this.getILigneCorrecte(iLigne -1) )
            throw new RuntimeException ("iLigne invalide");
        if( !this.getIColonneCorrecte(iColonne -1) )
            throw new RuntimeException ("iColonne invalide");
        return composantes[iLigne -1][iColonne -1];
    }
    //getteur si iLigne correct
    public boolean getILigneCorrecte( int iLigne ){
        return iLigne >= 0 && iLigne < this.getLigne();
    }
    //getteur si iColonne correct
    public boolean getIColonneCorrecte( int iColonne ){
        return iColonne >= 0 && iColonne < this.getColonne() ;
    }

    //setters valeur
    public void setValeur(int iLigne, int iColonne, double valeur){
        if( getILigneCorrecte(iLigne) && getIColonneCorrecte(iColonne) )
            composantes[iLigne][iColonne] = valeur;
    }

    //dis si matrice carre
    public boolean estCarre(){
        return this.getLigne() == this.getColonne();
    }

    //static matrice identite
    public static Matrice identite (int ordre){

        if( ordre < 1 )
            throw new RuntimeException ("ordre de la matrice invalide");

        double[][] composantes;
        composantes = new double[ordre][ordre];

        for( int iLigne = 0; iLigne < ordre; iLigne++){
            for( int iColonne = 0; iColonne < ordre; iColonne++){
                composantes[iLigne][iColonne] = ( iLigne == iColonne ? 1 : 0 );
            }
        }
        return new Matrice( composantes );
    }

    //static addition
    public static Matrice somme (Matrice m1, Matrice m2){

        if( m1.getLigne() != m2.getLigne() )
            throw new RuntimeException ("les matrices doivent avoir le meme nombre de lignes");
        if( m1.getColonne() != m2.getColonne() )
            throw new RuntimeException ("les matrices doivent avoir le meme nombre de colonnes");

        double[][] composantes;
        composantes = new double[m1.getLigne()][m1.getColonne()];

        for(int iLigne = 0; iLigne < m1.getLigne();iLigne++){
            for(int iColonne = 0; iColonne < m1.getColonne();iColonne++){
                composantes[iLigne][iColonne] = m1.getValeur(iLigne+1, iColonne+1) + m2.getValeur(iLigne+1, iColonne+1);
            }
        }
        return new Matrice( composantes );
    }

    //static soustraction
    public static Matrice difference (Matrice m1, Matrice m2){

        if( m1.getLigne() != m2.getLigne() )
            throw new RuntimeException ("les matrices doivent avoir le meme nombre de lignes");
        if( m1.getColonne() != m2.getColonne() )
            throw new RuntimeException ("les matrices doivent avoir le meme nombre de colonnes");

        double[][] composantes;
        composantes = new double[m1.getLigne()][m1.getColonne()];

        for(int iLigne = 0; iLigne < m1.getLigne();iLigne++){
            for(int iColonne = 0; iColonne < m1.getColonne();iColonne++){
                composantes[iLigne][iColonne] = m1.getValeur(iLigne+1, iColonne+1) - m2.getValeur(iLigne+1, iColonne+1);
            }
        }
        return new Matrice( composantes );
    }

    //multiplication externe
    public void multiExterne(double facteur){

        for(int iLigne = 0; iLigne < getLigne();iLigne++){
            for(int iColonne = 0; iColonne < getColonne();iColonne++){
                composantes[iLigne][iColonne] *= facteur;
            }
        }
    }

    //static multiplication interne
    public static Matrice multiInterne (Matrice m1, Matrice m2){

        if( m2.getLigne() != m1.getColonne() )
            throw new RuntimeException ("les lignes de la matrice 1 et les colonnes de la matrice 2 doivent etre egale");

        double somme;

        double[][] composantes;
        composantes = new double[m1.getLigne()][m2.getColonne()];

        for(int iLigne = 0; iLigne < m1.getLigne();iLigne++){
            for(int iColonne = 0; iColonne < m2.getColonne();iColonne++){
                somme = 0;
                for(int i = 0; i < m2.getLigne(); i++)
                    somme += m1.getValeur(iLigne+1, i+1) * m2.getValeur(i+1, iColonne+1);
                composantes[iLigne][iColonne] = somme;
            }
        }
        return new Matrice( composantes );
    }

    //static transposition
    public static Matrice transposition(Matrice m){

        double[][] composantes;
        composantes = new double[m.getColonne()][m.getLigne()];

        for(int iLigne = 0; iLigne < m.getLigne();iLigne++){
            for(int iColonne = 0; iColonne < m.getColonne();iColonne++){
                composantes[iColonne][iLigne] = m.getValeur(iLigne+1, iColonne+1);
            }
        }
        return new Matrice( composantes );
    }

    //copie matrice
    public static Matrice copie( Matrice matriceACloner ){

        double[][] composantes;
        composantes = new double[ matriceACloner.getLigne()][matriceACloner.getColonne()];

        for( int iLigne = 0; iLigne < matriceACloner.getLigne(); iLigne++){
            for( int iColonne = 0; iColonne < matriceACloner.getColonne(); iColonne++){
                composantes[iLigne][iColonne] = matriceACloner.getValeur( iLigne +1, iColonne +1);
            }
        }
        return new Matrice( composantes );
    }

    //egalite de deux matrice
    public boolean equals(Matrice m){

        if( this.getLigne() != m.getLigne() )
            throw new RuntimeException ("les matrices doivent avoir le meme nombre de lignes");
        if( this.getColonne() != m.getColonne() )
            throw new RuntimeException ("les matrices doivent avoir le meme nombre de colonnes");

        boolean estEgal = true;

        int iLigne = 0;
        while(iLigne < this.getLigne() && estEgal){
            int iColonne = 0;
            while(iColonne < this.getColonne() && estEgal){
                estEgal = this.getValeur(iLigne+1, iColonne+1) == m.getValeur(iLigne+1, iColonne+1);
                iColonne++;
            }
            iLigne++;
        }
        return estEgal;
    }

    //matrice exposante
    public static Matrice exposant( Matrice m, int exposant){

        Matrice mFinal = Matrice.copie(m);

        for(int i = 1; i < exposant; i++){
            mFinal = Matrice.multiInterne(mFinal, m);
        }
        return mFinal;
    }
    //**************Partie 2****************************

    //permutation de deux ligne
    public void permutLigne(int iLigne1, int iLigne2 ){

        if( !(this.getILigneCorrecte( iLigne1-1 )) )
            throw new RuntimeException ("numero de ligne 1 incorrecte");
        if( !(this.getILigneCorrecte( iLigne2-1 )) )
            throw new RuntimeException ("numero de ligne 2 incorrecte");

        for(int iColonne = 0; iColonne < this.getColonne(); iColonne++ ){

            double temp = getValeur( iLigne1, iColonne+1 );
            setValeur(iLigne1-1, iColonne, getValeur( iLigne2, iColonne+1 ) );
            setValeur(iLigne2-1, iColonne, temp );
        }
    }

    //multiplication d'une ligne par un reel
    public void multiplierLigneParR(int iLigne, double reel ){

        if( !(this.getILigneCorrecte( iLigne-1 )) )
            throw new RuntimeException ("numero de lignen incorrecte");

        for(int iColonne = 0; iColonne < this.getColonne(); iColonne++ ){
            composantes[iLigne-1][iColonne] *= reel;
        }
    }

    //combinaisons lineaire
    public void combiLineairesLigne(int iLigneAModifier, int iLigneAAdditionner, double facteur){

        if( !(this.getILigneCorrecte( iLigneAModifier-1 )) )
            throw new RuntimeException ("numero de ligne a modifier incorrecte");
        if( !(this.getILigneCorrecte( iLigneAAdditionner-1 )) )
            throw new RuntimeException ("numero de ligne a additionner incorrecte");

        for(int iColonne = 0; iColonne < this.getColonne(); iColonne++ ){
            composantes[iLigneAModifier-1][iColonne] += facteur * getValeur(iLigneAAdditionner, iColonne+1);
        }
    }

    // déterminant
    public static double determinant(double[][]mat)
    {
        double result = 0;

        if (mat.length == 2)
        {
            result = mat[0][0] * mat[1][1] - mat[0][1] * mat[1][0];
            return result;
        }

        for (int i = 0; i < mat[0].length; i++)
        {
            double temp[][] = new double[mat.length - 1][mat[0].length - 1];

            for (int j = 1; j < mat.length; j++)
            {
                System.arraycopy(mat[j],0,temp[j-1],0,i);
                System.arraycopy(mat[j],i + 1,temp[j-1],i,mat[0].length-i-1);
            }
            result += mat[0][i] * Math.pow(-1,i) * determinant(temp);
        }
        return result;
    }

    public void inverse(Matrice mineur)
    {
        double [][] tabMineur = new double[mineur.getColonne()][mineur.getLigne()];
        Matrice matriceAdjointe = new Matrice(tabMineur);
        matriceAdjointe = mineur.transposition(mineur);
        matriceAdjointe.multiExterne(-1);
        System.out.println("1/" + determinant(composantes) + "\nmultiplie\n" + matriceAdjointe);
    }


    //toString
    @Override
    public String toString(){

        String matricesAffichage = "/ ";
        for( int iLigne = 0; iLigne < this.getLigne(); iLigne++){
            if( iLigne == this.getLigne()-1 ){
                matricesAffichage += "\\ ";
            }
            else{
                if( iLigne > 0)
                    matricesAffichage += "| ";
            }
            for(int iColonne = 0; iColonne < this.getColonne(); iColonne++){
                matricesAffichage += String.format("%-8.2f", composantes[iLigne][iColonne]);
            }
            if( iLigne == this.getLigne()-1)
                matricesAffichage += "/ \n";
            else{
                if(iLigne == 0)
                    matricesAffichage += "\\ \n";
                else
                    matricesAffichage += "| \n";
            }
        }
        return matricesAffichage;
    }
}

/* constructeur :
 *
 * avec composantes[][] :
 *  public Matrice( double composantes[][] )
 *
 * matrice identique :
 *  public Matrice( int nbLignes, int nbColonnes, double valeur)
 *
 * constructeur souple :
 *  public Matrice (int nbLignes, int nbColonnes, double... valeurs)


 * getteur :
 *
 * public int getLigne()
 *
 * public int getColonne()
 *
 * public double getValeur( int iLigne, int iColonne )
 *
 * public boolean getILigneCorrecte( int iLigne )
 *
 * public boolean getIColonneCorrecte( int iColonne )


 * setteur :
 *
 * /!\ indice mathematique
 * public void setValeur(int iLigne, int iColonne, double valeur)


 * addition :
 *
 *  public static Matrice somme (Matrice m1, Matrice m2)


 * soustraction :
 *
 *  public static Matrice difference (Matrice m1, Matrice m2)


 * multiplication :
 *
 * externe :
 *
 *  public void multiExterne(double facteur)
 *
 * interne :
 *
 *  public static Matrice multiInterne (Matrice m1, Matrice m2)


 * exposant :
 *
 *  public static Matrice exposant( Matrice m, int exposant)


 * transposition :
 *
 *  public static Matrice transposition(Matrice m)



 * autre fonction :
 *
 *  public boolean estCarre()


 * copie d'une matrice :
 *  public static Matrice copie( Matrice matriceACloner )


 * egalite entre 2 matrice :
 *
 *  public boolean equals(Matrice m)

 */
