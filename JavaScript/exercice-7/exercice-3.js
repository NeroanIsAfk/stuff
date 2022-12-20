let valeur = -2;
let emplacementValeur;
let emplacementOpérations;
let emplacementMultiplie;

const init = function ()
{
    valeur = 0;
    majValeur();
    emplacementOpérations = document.getElementById("bOppose");
    emplacementOpérations.addEventListener("click", calcOpposé);
    emplacementOpérations = document.getElementById("bCarre");
    emplacementOpérations.addEventListener("click", calcCarré);
    emplacementOpérations = document.getElementById("bFact");
    emplacementOpérations.addEventListener("click", calcFactorielle);
    document.getElementById("bDecremente10").onclick = calcAjoute(-10); 
    document.getElementById("bDecremente1").onclick = calcAjoute(-1); 
    document.getElementById("bIncremente1").onclick = calcAjoute(1); 
    document.getElementById("bIncremente10").onclick = calcAjoute(10);
    document.getElementById("bRAZ").addEventListener("click", reset);
    emplacementMultiplie = document.getElementById("bMultiplie");
    emplacementMultiplie.onclick = calcMultiplie(2);
    document.getElementById("bDeux").onclick = effetButtonFois(2);
    document.getElementById("bCinq").onclick = effetButtonFois(5);
    document.getElementById("bDix").onclick = effetButtonFois(10);
};

window.onload = init;

function majValeur ()
{
    emplacementValeur = document.getElementById("spanVal");
    emplacementValeur.innerHTML = valeur;
}

function calcOpposé ()
{
    valeur = Math.sign(valeur) ==  0 ? valeur : -valeur;
    majValeur();
}

function calcCarré ()
{
    valeur = Math.pow(valeur, 2);
    majValeur();
}

function calcFactorielle ()
{
    valeur = factorielle(valeur);
    majValeur();
}

function factorielle (nombre)
{
    if (nombre == 1)
    {
        return 1;
    }
    else
    {
        return nombre * factorielle(nombre - 1);
    }
}

function calcAjoute (valeurAModifié)
{
    return function ()
    {
        valeur += valeurAModifié;
        majValeur();
    }
}

function reset ()
{
    valeur = 0;
    majValeur();
}

function calcMultiplie (valeurAModifié)
{
    return function ()
    {
        valeur *= valeurAModifié;
        majValeur();
    }
}

function effetButtonFois (valeurAModifié)
{
    return () =>
    {
        emplacementMultiplie.innerHTML = "×" + valeurAModifié;
        emplacementMultiplie.onclick = calcMultiplie(valeurAModifié)
    }
}

