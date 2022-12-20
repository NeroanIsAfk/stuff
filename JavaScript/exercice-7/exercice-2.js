function plus2 (valeur)
{
    return valeur + 2;
}

function fois3 (valeur)
{
    return valeur * 3;
}

function cube (valeur)
{
    return valeur * valeur * valeur;
}

function afficheNFois (s, n = "3")
{
    if (n > 0)
    {
        console.log(s);
        afficheNFois(s, n - 1);
    }
    return 0;
}

function executeNFois(f, n = "3")
{
    if (n > 0)
    {
        f();
        executeNFois(f, n - 1);
    }
    return 0;
}

function appn(f, n = "3", x)
{
    if (n > 0)
    {
        x = f(x);
        console.log(x);
        appn(f, n - 1, x);
    }
    return 0;
}

["un","deux","trois","quatre","cinq"].forEach((chaine) => console.log(chaine.length));

[1,2,3,4,5,6,7,8,9,10].filter((nombre) => nombre % 2 == 0);