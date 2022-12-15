let nombreChoisi;

do
{
    nombreChoisi = prompt("Entrez un nombre : ");

    if (!isFinite(nombreChoisi))
    {
        alert("Fin frèrot ? T'es con ou quoi ?"); 
    } 
} while (!isFinite(nombreChoisi))

function afficheNombre()
{
    document.write("<p class =\"nombre\">" + nombreChoisi + "</p>");
}

function afficheTableau()
{
    document.write("<ul>");
    for (let i = 1; i <= 10; i++) 
    {
        document.write("<li>" + nombreChoisi + " x " + i + " = " + nombreChoisi*i + "</li>");
    }
    document.write("</ul>");
    document.write("<table><tr><th>Nombre</th><th>Facteur</th><th>Résultat</th></tr>")
    for (let i = 1; i <= 10; i++)
    {
        document.write("<tr><td>" + nombreChoisi + "</td><td>" + i + "</td><td>" + nombreChoisi*i + "</td></tr>");
    }
    document.write("</table>");
}