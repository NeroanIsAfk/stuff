const resteEnVie = [2, 3];
const passeEnVie = 3;

const table = [];
let celluleAModifier = [];

window.onload = init;

function init ()
{
    const nbLignes = parseInt(prompt("Combien de lignes voulez-vous ? : "));
    const nbColonnes = parseInt(prompt("Combien de colonnes voulez-vous ? : "));

    remplir(nbLignes, nbColonnes);
    document.getElementById("bAvancer").addEventListener("click", avancer);
}

function remplir (nbLignesMax, nbColonnesMax)
{
    const plateauHTML = document.getElementById("plateau");
    
    for (let iLigne = 0; iLigne < nbLignesMax; iLigne++)
    {
        const ligne = document.createElement("tr");
        plateauHTML.appendChild(ligne);
        table[iLigne] = []

        for (let iColonne = 0; iColonne < nbColonnesMax; iColonne++)
        {
            const cellule = document.createElement("td");
            ligne.appendChild(cellule);
            cellule.addEventListener("click", () => changeEtat(cellule));
            table[iLigne].push(cellule);
        }
    }
}

function changeEtat (cellule)
{
    cellule.classList.toggle("vivant");   
}

function estEnVie (x,y)
{
    if (!table[x] || !table[x][y])
    {
        return false;
    }
    return table[x][y].classList.contains("vivant");
}

function updateCellule (x, y)
{
    const sontVivantVoisins = 
    [
        estEnVie(x - 1, y),
        estEnVie(x - 1, y + 1),
        estEnVie(x - 1, y - 1),
        estEnVie(x, y + 1),
        estEnVie(x, y - 1),
        estEnVie(x + 1, y),
        estEnVie(x + 1, y + 1),
        estEnVie(x + 1, y - 1)
    ].reduce((a, b) => a + b);

    const celluleEstEnVie = table[x][y].classList.contains("vivant");
    
    if (celluleEstEnVie && !resteEnVie.includes(sontVivantVoisins) || !celluleEstEnVie && passeEnVie == sontVivantVoisins)
    {
        celluleAModifier.push(table[x][y]);
    }
}

function avancer ()
{
    celluleAModifier = [];

    for (let x = 0; x < table.length; x++)
    {
        for (let y = 0; y < table[x].length; y++)
        {
            updateCellule(x,y);
        }
    }

    for (const cellule of celluleAModifier) 
    {
        changeEtat(cellule);    
    }
}