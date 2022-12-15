function demandeNombre(nombreMin, nombreMax)
{
    let nombreLu;
    let estNombreCorrect;
    let estUnNombre;

    do
    {
        nombreLu = parseInt(prompt("Rentrez un nombre : "));
        estUnNombre = isFinite(nombreLu);
        
        if (!estUnNombre) 
        {
            estNombreCorrect = nombreMin < nombreLu && nombreLu < nombreMax;
        }

    } while (!estUnNombre || !estNombreCorrect);
}

demandeNombre(10,20);