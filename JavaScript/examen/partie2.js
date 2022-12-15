function pretPourApprentissage (chien)
{
    return chien.tours.every((tour) => "finApprentissage" in tour);
}

function majTours (tours, chien)
{
    for (const tour of tours) 
    {
        const indexTourChien = chien.tours.findIndex((tourChien) => tourChien["nom"] === tour["nom"]);
        
        if (indexTourChien > -1)
        {
            chien.tours[indexTourChien].finApprentissage = tour.finApprentissage;
            chien.tours[indexTourChien].friandisesRecues = tour.friandisesRecues
        }
        else
        {
            if (tour.debutApprentissage)
            {
                chien.tours.push(tour);
            }
        }
    }
}

function assezDeBonbons (chien)
{
    let totalBonbons = 0;

    for (const tour of chien.tours) 
    {
        if (tour.friandisesRecues)
        {
            totalBonbons += tour.friandisesRecues
        }    
    }   
    return totalBonbons <= chien.friandisesPrevues;
}

function Chien (nom, dateDeNaissance, friandisesPrevues) 
{
    this.nom = nom;
    this.dateDeNaissance = dateDeNaissance;
    this.friandisesPrevues = friandisesPrevues;
    this.tours = [];
}

Chien.prototype.nomsTours = [];

Chien.prototype.ajouteTour = function (nom, debutApprentissage, difficulte)
{
    this.tours.push({ nom, debutApprentissage, difficulte});

    if (!this.nomsTours.includes(nom))
    {
        this.nomsTours.push(nom);
    }
}

Chien.prototype.tourLePlusDifficile = function ()
{
    let tourLePlusDur;

    for (const tour of this.tours) 
    {
        if (!tourLePlusDur)
        {
            tourLePlusDur = tour;
        }
        else
        {
            tourLePlusDur = tourLePlusDur.difficulte < tour.difficulte ? tour : tourLePlusDur;
        }
    }

    return tourLePlusDur;
}