function Cercle (rayon, couleur) 
{ 
    this.rayon = rayon; 
    this.couleur = couleur;
}

Cercle.prototype.surface = function ()
{
    return Math.PI * this.rayon * this.rayon;
}

// Chaque fonction que l'on veut ajouter à un prototype doivent ce faire de cette manière.

function Pion (positionX, positionY) 
{ 
    this.positionX = positionX; 
    this.positionY = positionY; 
    // this.droite = function () { this.positionX++; };
    // this.gauche = function () { this.positionX--; }; 
    // this.haut = function () { this.positionY++; };
    // this.bas = function () { this.positionY--; }; --> Pas bon    
}

Pion.prototype.droite = function ()
{
    this.positionX++;
}

// ... 

// protoPion.isPrototypeOf(p) donne true car on change le type de Pion en protoPion ( à cause de Object.setPrototypeOf(this, protoPion)
// donc p est bien un prototype de protoPion

// p instanceof Pion donne false car le prototype de Pion a été changé en protoPion ( avec la même commande qu'avant )
// Pour comprendre ce qui ne marche pas ici, c'est que l'instruction Object.setPrototypeOf va effectivement modifier le prototype
// de n'importe quelle variable de Pion mais le problème c'est que chaque Pion créé va devenir un proto-pion ( et le constructeur Pion devient donc inutile en un sens)
// Pour préciser il y a un lien unique entre protoPion et Pion ( de Pion qui va vers protoPion mais il faudrait un lien dans les deux sens pour cela soit correct, quand bien même ce n'est pas clean code ) ( faudrait que je fasse un schéma mais flemme zbi, demander-moi j'le ferai sur paint )

function Fenêtre (titre)
{
    this.titre = titre;
    Fenêtre.prototype.nbFenêtresCréées++;
}

Fenêtre.prototype.nbFenêtresCréées = 0;

// Alors ici, ce qui ne fonctionnait pas ce le fait que l'on fasse this.nbFenêtresCréées++, en fait cette manière d'écrire implique qu'il y a déjà un variable nbFenêtresCrées au préalable.
// Le fait est qu'il va quand même rechercher dans le prototype la variable nbFenêtresCrées mais il ne l'incrémente que au niveau de l'objet créé.