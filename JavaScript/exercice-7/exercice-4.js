let grandActuel = 0;
let cadreHTML;
let tailleMaximale = 49;

window.onload = init;

function init ()
{
    cadreHTML = document.getElementById("cadre");
}

function clic (numBloc)
{
    if (numBloc == grandActuel)
    {
        return 0;
    }
    else
    {
        for (let i = 0; i < tailleMaximale; i++)
        {
            setTimeout(modWidth, 10*i, grandActuel, 500 - i * 10);
            setTimeout(modWidth, 10*i, numBloc, 20 + i * 10);
        }
        grandActuel = numBloc;
    }
}

function modWidth (numBloc, largeurAModifie)
{
    cadreHTML.children[numBloc].style.width = largeurAModifie + "px";
}