function coteEnPourcents(cote, max)
{
    const coteMax = max || 20;
    const pourcentage = (100 / coteMax) * cote;

    console.log(pourcentage + "%");
}

function donnePrixTVAC(prix, tva = 21)
{ // -> Faire attention car 0 = falsy donc la méthode avec || ne fonctionne pas ici.
    const tvaAppliquée = tva / 100;
    const prixTVAC = prix + (tvaAppliquée * prix);

    console.log(prixTVAC);
}

function min(tableau, ...nombres)
{
    let nombreMinimum = Number.MAX_SAFE_INTEGER;

    if (tableau instanceof Array)
    {
        nombres = tableau;
    }
    else 
    {
        nombres.push(tableau);
    }

    for (const nombre of nombres) 
    {
        if (nombre < nombreMinimum)
        {
            nombreMinimum = nombre;
        }
    }    
    console.log(nombreMinimum);
}

function somme(fonction , ...nombres)
{
    let somme = 0;

    if (fonction instanceof Function)
    {
        nombres.map(fonction);
    }
    else
    {
        nombres.push(fonction);
    }

    for (const nombre of nombres) 
    {
        somme += nombre;    
    }
    return somme;
}