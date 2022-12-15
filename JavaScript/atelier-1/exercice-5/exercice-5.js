function afficheTableau()
{
    let nombreChoisi;
    let nombreMin = Number.MAX_SAFE_INTEGER;
    let nombreMax = Number.MIN_SAFE_INTEGER;
    let nbNombres = 0;
    let somme = 0;

    document.write("<table><tr><th>No</th><th>Nombre</th><th>Min</th><th>Max</th><th>Somme</th></tr>");
    nombreChoisi = Number(prompt("Entrez un nombre"));

    while(isFinite(nombreChoisi))
    {
        nbNombres++;
        if (nombreChoisi < nombreMin)
        {
            nombreMin = nombreChoisi;
        }

        if (nombreChoisi > nombreMax)
        {
            nombreMax = nombreChoisi;
        }
        somme += nombreChoisi;

        document.write("<tr>" + celluleTableau(nbNombres) + celluleTableau(nombreChoisi) + celluleTableau(nombreMin) + celluleTableau(nombreMax) + celluleTableau(somme) + "</tr>");
        nombreChoisi = Number(prompt("Entrez un nombre"));
    }

    document.write("<table/>");
}

function celluleTableau(nombre)
{
    return `<td class = ${nombre >= 0 ? "positif" : "negatif"}> ${nombre}</td>`;
}