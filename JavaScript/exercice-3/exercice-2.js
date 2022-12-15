const mois = ["janvier", "frévier", "mars", "avril", "mai", "juin", "juillet", "août", "septembre", "octobre", "novembre", "décembre"];

let musiciens = [ { nom: "Mozart", prénom: "Wolfgang Amadeus", image: "WAMozart.jpg", naissance: {jour: 27, mois: 1, année: 1756}, mort: {jour: 5, mois: 12, année: 1791} }, { nom: "Bach", prénom: "Johann Sebastian", image: "JSBach.jpg", naissance: {jour: 31, mois: 3, année: 1685}, mort: {jour: 28, mois: 7, année: 1750} }, { nom: "Vivaldi", prénom: "Antonio Lucio", image: "Vivaldi.jpg", naissance: {jour: 4, mois: 3, année: 1678}, mort: {jour: 28, mois: 7, année: 1741} }, { nom: "Ravel", prénom: "Joseph Maurice", image: "Ravel.jpg", naissance: {jour: 7, mois: 3, année: 1875}, mort: {jour: 28, mois: 12, année: 1937} }, { nom: "Beethoven", prénom: "Ludwig van", image: "Ludwig.jpg", naissance: {jour: 17, mois: 12, année: 1770}, mort: {jour: 26, mois: 3, année: 1827} }, { nom: "Gershwin", prénom: "Jacob", image: "Gershwin.jpg", naissance: {jour: 26, mois: 9, année: 1898}, mort: {jour: 11, mois: 7, année: 1937} }, { nom: "Bernstein", prénom: "Leonard", image: "LeoBernstein.jpg", naissance: {jour: 25, mois: 8, année: 1918}, mort: {jour: 14, mois: 10, année: 1990} }, ];
    
function afficheDate (date)
{
    return `${date.jour} ${mois[date.mois - 1]} ${date.année}`
}

function afficheMusicien ()
{
    for (let iMusicien in musiciens)
    {
        document.write(`<div class = "musicien>"`);
        document.write(`<h1>${musiciens[iMusicien].nom}</h1>`);
        document.write(`<h2>${musiciens[iMusicien].prénom}</h2>`);
        document.write(`<img src=${musiciens[iMusicien].image}>`);
        console.log(musiciens[iMusicien].image);
        document.write(`<p>${afficheDate(musiciens[iMusicien].naissance)} - ${afficheDate(musiciens[iMusicien].mort)}</p>`);
        document.write(`</div>`)
    }
}
