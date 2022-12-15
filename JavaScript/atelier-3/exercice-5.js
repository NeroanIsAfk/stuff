function afficheLangage (langageProgrammation)
{
    console.log(`${langageProgrammation["nom"]} ( ${typeof(langageProgrammation["année"]) == "number" ? "vu en IG" + langageProgrammation["année"] : "pas vu en IG"} ) : ${langageProgrammation["oo"] ? "orienté objet" : "pas orienté objet"}`);
}
