let nbCartes = 0;
let divImages;
let timeout

window.onload = function () {
    divImages = document.getElementById("divImages");

    while (nbCartes < 1 || nbCartes > 8) {
        nbCartes = prompt("Combien de cartes carte voulez-vous ? (1-8)");
    }
    créationCartes();

    document.getElementById("btnDémarrer").addEventListener("click", afficherCartes);
}

function créationCartes() {
    for (let i = 0; i < nbCartes; i++) {
        const carte = document.createElement("img");
        carte.src = `image${Math.floor(Math.random() * 8) + 1}.jpg`;
        carte.classList.add("cadreImage", "faceCachée");
        divImages.appendChild(carte);
    }
}

function afficherCartes() {
    for (let i = 0; i < nbCartes; i++) {
        const carte = divImages.children[i];
        setTimeout(() => {
            retournerCarte(carte);
            setTimeout(() => retournerCarte(carte), 1000);
        }, 1000 * i);
    }
}

function retournerCarte(carte) {
    carte.classList.toggle("faceCachée");
}