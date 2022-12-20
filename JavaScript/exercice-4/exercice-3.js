Number.prototype.afficheEtoiles = function ()
{
    let message = "";

    for (let i = 0; i < this; i++)
    {
        message += "*";
    }
    console.log(message);
};

String.prototype.bégaie = function ()
{
    let message = "";

    for (let lettre of this)
    {
        message += (lettre + lettre);
    }
    console.log(message);
};

Function.prototype.présente = function ()
{
    console.log(`La fonction ${this.name} attend ${this.length} ${this.length > 1 ? "arguments" : "argument"}`);
};

Array.prototype.somme = function ()
{
    let somme = 0;

    for (let nombre of this)
    {
        if (Object.getPrototypeOf(nombre) == Number.prototype)
        {
            somme += nombre;
        }
    }
    console.log(somme);
};

Array.prototype.ajouteSiPasPrésent = function (valeur)
{
    if (!this.includes(valeur))
    {
        this.push(valeur);
    }

    console.log(this);
};