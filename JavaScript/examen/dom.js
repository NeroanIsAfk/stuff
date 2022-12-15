let nbImages;
let emplacementImage;
let timeoutId;

window.onload = init;

function init ()
{
    emplacementImage = document.getElementById("divCarrousel")
    nbImages = parseInt(prompt("Combien d'images voulez-vous ? : "));

    ajouteImageCadre();

    document.getElementById("btnStart").addEventListener("click", démarrer);
    document.getElementById("btnSuivant").addEventListener("click", suivant);
    document.getElementById("btnPrecedent").addEventListener("click", précédent);
    document.getElementById("btnStop").addEventListener("click", stop);
}

function ajouteImageCadre ()
{
    for (let i = 0; i < nbImages; i++)
    {
        const imageAffichée = document.createElement("img");
        imageAffichée.classList.add("img");
        imageAffichée.src = `chat${Math.floor(Math.random() * 6) + 1}.jpg`;
        imageAffichée.style.display = "none";
        emplacementImage.appendChild(imageAffichée);
    }
}

function démarrer ()
{
    for (let i = 0; i < nbImages; i++) 
    {
        const chat = emplacementImage.children[i];
        
        timeoutId = setTimeout(() => 
        {
            console.log(timeoutId);
            toggleVisibilitéImage(chat);
            setTimeout(() => toggleVisibilitéImage(chat), 2500);
            timeoutId--;
        }, 2500 * i);
    }

    setTimeout(toggleVisibilitéImage,2500 * nbImages, emplacementImage.children[0]);
}

function chercheImageAffichée ()
{
    let indexImageAffichée;

    for (let i = 0; i < nbImages; i++)
    {
        if (emplacementImage.children[i].classList.contains("image-visible"))
        {
            indexImageAffichée = i;
        }
    }

    return indexImageAffichée;
}

function suivant ()
{
    const indexImageVisible = chercheImageAffichée();

    if (emplacementImage.children[indexImageVisible].nextElementSibling == null)
    {
        toggleVisibilitéImage(emplacementImage.children[indexImageVisible]);
        toggleVisibilitéImage(emplacementImage.children[0]);
    }
    else
    {
        toggleVisibilitéImage(emplacementImage.children[indexImageVisible]);
        toggleVisibilitéImage(emplacementImage.children[indexImageVisible].nextElementSibling);
    }
}

function précédent ()
{
    const indexImageVisible = chercheImageAffichée();

    if (emplacementImage.children[indexImageVisible].previousElementSibling == null)
    {
        toggleVisibilitéImage(emplacementImage.children[indexImageVisible]);
        toggleVisibilitéImage(emplacementImage.children[nbImages - 1]);
    }
    else
    {
        toggleVisibilitéImage(emplacementImage.children[indexImageVisible]);
        toggleVisibilitéImage(emplacementImage.children[indexImageVisible].previousElementSibling);
    } 
}

function stop ()
{
    clearTimeout(timeoutId);
}

function toggleVisibilitéImage (image)
{
    const visible = image.classList.contains("image-visible");
    image.style.display = visible ? "none" : "inline";
    image.classList.toggle("image-visible");
}