function somme (nombres)
{
    let sommeTotale = 0;

    for (let nombre of nombres)
    {
        sommeTotale += nombre;
    }

    return sommeTotale;
}

function premierPair (nombres)
{
    for (let nombre of nombres)
    {
        if (nombre % 2 == 0)
        {
            return nombre;
        }
    }

    return -1; // -> Ne pas oublier de faire ça si on fait un return dans une boucle
}

/*function dernierPair (nombres)
{
    let indiceDernierNombrePair;

    for (let iNombre in nombres)
    {
        if (nombres[iNombre] % 2 == 0)
        {
            indiceDernierNombrePair = i;
        }
    }

    return nombres[indiceDernierNombrePair];
} */

function dernierPair (nombres)
{
    for (let iNombre = nombres.lengh; iNombre > 0; iNombre--)
    {
        if (nombres[iNombre] % 2 == 0)
        {
            return nombres[iNombre];
        }
    }

    return -1;
}