function délaisRespectés (chantier)
{
    let duréeTotalesEtapes = 0;

    for (const détailEtape of chantier[détailChantier]) 
    {
        if (détailEtape instanceof Number)
        {
            duréeTotalesEtapes += détailEtape;
        }    
    }
    return chantier["duréePrévue"] > duréeTotalesEtapes;
} // -> à modifier

function chantierTerminé (chantier)
{
    return chantier.étapes.every((détailEtape) => "durée" in détailEtape);
}

function majEtapesTerminées (chantier, étapesTerminées)
{
    for (const étapeTerminée of étapesTerminées) 
    {
        const indexChantier = chantier.étapes.findIndex((élément) => élément["nom"] === étapeTerminée["nom"]);
        
        if (indexChantier > -1)
        {
            chantier.étapes[indexChantier] = étapeTerminée;
        }    
    }
}