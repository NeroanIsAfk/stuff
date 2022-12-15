let titreHTML = document.getElementById("titre");
let paraHTML = document.getElementById("para");

let elem = 
{
    cible : titreHTML,
    changeTexte (txt) 
    {
        this.cible.innerHTML = txt;
    }
}

elem.ajouteTexte = function (txt)
{
    this.cible.innerHTML += " " + txt;
}

elem.cible = paraHTML;

elem.changeFond = function (couleur)
{
    this.cible.style.backgroundColor = couleur;
    this.cible.innerHTML = `La couleur est désormais ${couleur}.`;
}

elem.changeCouleur = function (couleur)
{
    this.ancienneCouleur = this.couleurActuelle;
    this.couleurActuelle = couleur;
    this.cible.style.backgroundColor = couleur;
}

elem.retourColor = function ()
{
    this.cible.style.backgroundColor = this.ancienneCouleur;
}