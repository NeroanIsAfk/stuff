let emplacementImage;
let emplacementButton;

let peintures =
[
["escaliers.jpg"],
["frappis.jpg"],                
["radeau.jpg"],
["joconde.png"],
["fleurs.jpg"],
["pipe.jpg"],
["persistence.jpg"]
];

window.onload = init;

function init ()
{
    emplacementImage = document.getElementById("divImages");
    emplacementButton = document.getElementById("btnDémarrer");
    const nbImages = parseInt(prompt("Combien d'images voulez-vous ? : "));
    emplacementButton.addEventListener("click",() => démarrer(nbImages));

    créeCadreImage(nbImages);
}

function créeCadreImage (nbImages)
{
    for (let i = 0; i < nbImages; i++)
    {
        const cadreImage = document.createElement("img");
        cadreImage.classList.add("cadreImage");
        cadreImage.src = peintures[i];
        cadreImage.style.visibility = "hidden";
        emplacementImage.appendChild(cadreImage);
    }
}

function démarrer (nbImages)
{
    for (let i = 0; i < nbImages; i++)
    {
        const imageCiblée = emplacementImage.children[i];
        setTimeout(changeVisibilté, 1000*i, imageCiblée);
        setTimeout(changeVisibilté, 1000*(i + 1), imageCiblée);
    }
}

function changeVisibilté (image)
{
    const visible = image.classList.contains("image-visible");
    image.style.visibility = visible ? "hidden" : "visible";
    image.classList.toggle("image-visible");
}