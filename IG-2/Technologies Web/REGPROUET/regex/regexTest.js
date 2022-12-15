class Exercice {

	constructor (texte, exPos, exNeg) {
		if (texte == "")
			texte = "Construisez une expression régulière qui capture intégralement chacun des exemples de la colonne de gauche mais aucun des exemples de la colonne de droite.";
		this.texte = texte;
		this.exPos = exPos;
		this.exNeg = exNeg;
	}

}

class VueExemple {

	constructor (texte, noeud, noeudGroupes = null) {
		this.texte = texte;
		this.noeud = noeud;
		this.noeud.innerHTML = texte;
		this.capturé = false;
		this.noeudGroupes = noeudGroupes;
	}

	maj (regex) {
		if (regex === null)
		{
			this.noeud.innerHTML = this.texte;
			if (this.noeudGroupes != null)
				this.noeudGroupes.innerHTML = "";
			this.capturé = false;
			return;
		}
		let nvInner = this.texte.replace(regex,"<span class='capture'>$&</span>");
		let capture = this.texte.match(new RegExp (regex,""));
		this.capturé = capture !== null && capture[0] == this.texte;
		if (this.capturé)
			this.noeud.classList.add("capture");
		else
			this.noeud.classList.remove("capture");
		this.noeud.innerHTML = nvInner;
		if (capture != null && this.noeudGroupes != null) {
			let groupes = "";
			for (let iGroupe = 1 ; iGroupe < capture.length ; iGroupe++) {
				if (iGroupe > 1) {
					groupes += "; ";
				}
				// Pour éviter les groupes undefined par exemple dans (ba)* sur chaîne vide
				if (capture[iGroupe] != null)
					groupes += `${iGroupe} &rarr; "${capture[iGroupe]}"`;
			}
			this.noeudGroupes.innerHTML = groupes;
		}
	}

}

class ListeVuesExemples {

	constructor (parent, exemples) {
		this.parent = parent;
		parent.innerHTML = "";
		this.vuesExemples = [];
		for (let exemple of exemples) {
			let noeud = document.createElement("li");
			parent.appendChild(noeud);
			this.vuesExemples.push(new VueExemple(exemple, noeud));
		}
		this.tousCapturés = null;
		this.aucunCapturé = true;
	}

	maj (regex) {
		this.tousCapturés = true;
		this.aucunCapturé = true;
		for (let vueExemple of this.vuesExemples) {
			vueExemple.maj(regex);
			this.tousCapturés &= vueExemple.capturé;
			this.aucunCapturé &= !vueExemple.capturé;
		}
	}

}

class VueExercice {

	constructor (ex) {
		this.exercice = ex;
		document.getElementById("texte").innerHTML = this.exercice.texte;
		this.exemplesPos = new ListeVuesExemples(document.getElementById("ulPositif"), ex.exPos);
		this.exemplesNeg = new ListeVuesExemples(document.getElementById("ulNegatif"), ex.exNeg);
	}

	maj (regex) {
		this.exemplesPos.maj(regex);
		this.exemplesNeg.maj(regex);
		if (this.exemplesPos.tousCapturés && this.exemplesNeg.aucunCapturé)
			afficheRes ("Bravo !", true);
	}
}

function afficheRes (texte, correct = false) {
	let cible = document.getElementById("res");
	cible.innerHTML = texte;
	if (correct)
		cible.classList.add("resCorrecte");
	else
		cible.classList.remove("resCorrecte");
}

let vueExActuel;
let exercices;
let srActuelle = 0;
let exActuel = 0;
let testLibre;

function regExpLue () {
	let input = document.getElementById("iRegexp").value;
	let regexp = null;
	if (input !== "") {
		try {
			regexp = new RegExp(input,"g");
		}
		catch (err) {
			afficheRes ("Erreur !");
		}
	}
	return regexp;
}

function majRegExp () {
	afficheRes ("");
	vueExActuel.maj(regExpLue());
	majTestLibre();
}

function majTestLibre () {
	let texte = document.getElementById("iTestLibre").value;
	testLibre.texte = texte;
	testLibre.maj(regExpLue());
}

function nvExercice () {
	document.getElementById("srno").innerHTML = srActuelle + 1;
	document.getElementById("exnb").innerHTML = exercices[srActuelle].length;
	document.getElementById("exno").innerHTML = exActuel + 1;
	vueExActuel = new VueExercice(exercices[srActuelle][exActuel]);
	document.getElementById("iRegexp").value = "";
	afficheRes("");
	document.getElementById("iTestLibre").value = "";
	majTestLibre();
	document.getElementById("bsPrec").disabled = (srActuelle == 0);
	document.getElementById("bsSuiv").disabled = (srActuelle == exercices.length - 1);
	document.getElementById("bPrec").disabled = (exActuel == 0);
	document.getElementById("bSuiv").disabled = (exActuel == exercices[srActuelle].length - 1);
}

window.onload = function () {
	document.getElementById("iRegexp").oninput = majRegExp;
	document.getElementById("iTestLibre").oninput = majTestLibre;
	testLibre = new VueExemple("", document.getElementById("resTest"), document.getElementById("sGroupes"));
	document.getElementById("bPrec").onclick = function () {
		exActuel--;
		nvExercice();
	}
	document.getElementById("bSuiv").onclick = function () {
		exActuel++;
		nvExercice();
	}
	document.getElementById("bsPrec").onclick = function () {
		srActuelle--;
		exActuel = 0;
		nvExercice();
	}
	document.getElementById("bsSuiv").onclick = function () {
		srActuelle++;
		exActuel = 0;
		nvExercice();
	}
	document.getElementById("srnb").innerHTML = exercices.length;
	nvExercice();
}

exercices = [];

// Série 1 - Introduction
exercices.push([
	new Exercice (
		"Pour voir comment cette interface fonctionne, entrez dans le cadre \"Expression régulière\" ci-dessous les séquences de symboles suivantes (une après l'autre) : 5, 51, \\d et \\d\\d. Assurez-vous de bien comprendre les réactions de l'interface dans chacun des cas.<br/><br/>En-dessous de l'expression régulière, vous pouvez entrer du texte dans la zone appelée \"Test libre\". Cela vous permet de tester l'expression régulière que vous avez entrée mais sur un texte autre que ceux qui sont proposés dans les colonnes tout en bas. Entrez-y par exemple le texte \"17 + 11 = 28\" et observez que l'interface indique les parties qui correspondent à l'expression régulière donnée. Pour l'instant, vous pouvez ignorer la ligne intitulée \"Groupes\".",
		["24", "45", "51", "17"],
		["5", "151", "3127", "hello", "-6"]),
	]);

// Série 2 - caractères et classes prédéfinies
exercices.push([
	new Exercice (
		"",
		["1a3", "1z3", "1!3", "1-3", "1\\3", "1W3", "1_3"],
		[]),
	new Exercice (
		"",
		["1a3", "1z3", "1W3", "1_3"],
		["1!3", "1-3", "1\\3"]),
	new Exercice (
		"",
		["pile", "pale", "pole"],
		["p1le", "pull", "pela", "poil"]),
	new Exercice (
		"",
		["081/12.34.56", "077/98.54.22", "011/24.35.46"],
		["0497/12.34.56", "077 65 43 21", "top/il.la.lu", "111/54.32.10"]),
	new Exercice (
		"",
		["$ 34.50", "$ 11.20", "$ 99.99"],
		["€ 12.50", "$ 51243", "$ ch.er"]),
	]);

// Série 3 - classes de caractères
exercices.push([
	new Exercice (
		"Construisez une expression régulière permettant de capturer un \"chiffre hexadécimal\".",
		["3", "7", "a", "D", "F"],
		["!", "_", "z", "Q"]),
	new Exercice (
		"Construisez une expression régulière permettant de capturer tous les mots de 3 lettres constitués d'une consonne, puis d'une voyelle, puis d'une consonne.",
		["bit", "cos", "dix", "lol", "paf", "raz", "mes"],
		["bzt", "cht", "oui", "out", "pou"]),
	new Exercice (
		"",
		["12,50$", "13.50$", "21.25€", "54,75€"],
		["17.12F", "54321$", "13!50€"]),
	new Exercice (
		"Au Canada, le code postal suit le format lettre-chiffre-lettre (espace) chiffre-lettre-chiffre. Constuisez une expression régulière permettant de capturer les codes postaux canadiens (la colonne de droite reprend les noms des localités correspondant aux codes postaux donnés en exemples).",
		["T9G 3R6", "V3Y 0S5", "V1G 1S4", "J4V 2R3", "G9T 1S1"],
		["Devon, AB", "Pitt Meadows, BC", "Dawson Creek, BC", "Greenfield Park, QC", "Grand-Mère, QC"])
	]);

// Série 4 - répétitions
exercices.push([
	new Exercice (
		"",
		["lol", "loooool", "loooooooool", "looooooooooooool"],
		["ll", "boooool", "looog", "pop"]),
	new Exercice (
		"Construisez une expression régulière permettant de capturer les nombres binaires.",
		["0", "1", "00", "10", "0101", "11010101010111"],
		["nombrebinaire", "123", "he110, w0r1d"]),
	new Exercice (
		"",
		["Quoi d'9 ?", "Quoi d'9?", "Quoi d'99999?", "Quoi d'99999999 ?"],
		["Quoi d'?", "Quoi d' ?", "Quoi d'7?", "Quoi d'9!"]),
	new Exercice (
		"À quoi reconnaît-on un nombre binaire représentant un entier pair ? Au fait qu'il se termine par un 0.",
		["0", "10", "1110", "010", "001100101100"],
		["1", "011", "0101", "00011001", "43210"]),
	new Exercice (
		"La plupart des langages utilisent le \"camelCase\" pour écrire des noms de variables. Construisez une expression régulière capturant les identificateurs de variables corrects.",
		["prixUnitaire", "tvaEnEuros", "temp", "_x203", "estEnIG", "stock2017", "ok_Mais_Moche"],
		["PascalCase", "3par3", "unSeul mot"]),
	new Exercice (
		"En Javascript, on peut écrire un tableau d'entiers en encadrant les valeurs par des crochets et en les séparant par des virgules. On peut même placer une virgule supplémentaire après le dernier nombre, et on peut espacer le tout comme on veut. Construisez une expression régulière qui capture tous les littéraux de tableaux corrects cités ci-dessous.",
		["[1, 2, 3]", "[  42 ,16  , 9 ]", "[]", "[54, 127, 32,]"],
		["[1, 2", "[4 3]", "[6, 9],", "[10, ,20]", "[, 4, 6]"]),
	new Exercice (
		"Construisez une expression régulière permettant de capturer tous les entiers décimaux à 5 chiffres, en excluant ceux qui commencent par 0. Utilisez des accolades dans votre expression régulière.",
		["12345", "61742", "34257", "70000", "90173"],
		["1234", "abcde", "01475", "00000", "12z34"]),
	new Exercice (
		"Construisez une expression régulière permettant de capturer les entiers entre 100 et 999999.",
		["111", "120", "247", "3694", "45678", "512079"],
		["12", "0479", "nombre", "-74213"]),
	new Exercice (
		"Les codes postaux anglais sont composés de la manière suivante : (1) une ou deux lettres indiquant la région, (2) un chiffre, éventuellement suivi d'un second chiffre ou d'une lettre pour le district, (3) une espace, (4) un chiffre indiquant le secteur, puis finalement (5) deux lettres indiquant une rue ou un groupe de bâtiments ou un bâtiment unique important.",
		["M15 6UU", "BS2 9TG", "MK15 9LR", "WV3 0QW", "WC2A 1PL", "N1P 1UZ"],
		["JNP 3KZ", "Z9RD 4KD", "U94V 2JI", "BD4 94K", "XS9 GHU", "M368DD"]),
	new Exercice (
		"Construisez une expression régulière pour capturer ces codes postaux et noms de localité belges.",
		["1080 Sint-Jans-Molenbeek", "1320 Beauvechain", "2000 Antwerpen", "4180 Comblain-la-Tour", "5660 Cul-des-Sarts", "7750 Mont-de-l'Enclus"],
		[]),
	new Exercice (
		"Les exemples de la colonne de gauche sont des mots comportant un 'l' doublé, ce qui n'est pas le cas de ceux de la colonne de droite.",
		["parallèle", "libellule", "collation", "pull"],
		["parler", "papoter", "boule"]),
	new Exercice (
		"Les exemples de la colonne de gauche sont des mots qui comportent au moins 2 fois la lettre l, ce qui n'est pas le cas de la colonne de droite.",
		["halali", "lilas", "libéral", "belle", "subliminal"],
		["louve", "oral", "fenêtre"]),
	new Exercice (
		"Regardez la colonne gauche. Examinez chacun des exemples. Vous trouvez le lien ? Comptez donc les mots !",
		["regardez la colonne gauche", "examinez chacun des exemples", "vous trouvez le lien", "comptez donc les mots"],
		["ici on compte très mal", "ou trop peu", "pas assez"]),
	]);


// Série 5 - groupements et disjonctions
exercices.push([
	new Exercice (
		"On peut former de nombreux mots (pas forcément français) à partir des syllabes ri, fi et li.<br/><br/>Notez que, sous la ligne vous permettant d'entrer un texte libre pour tester votre expression régulière, se trouve un emplacement intitulé \"Groupes\". Si vous avez entré une expression régulière comportant des groupements, les groupes correspondant à l'analyse du texte libre y seront cités. Vous pouvez tester cette partie de l'interface en entrant par exemple (\\d)-(\\d) comme expression régulière et AB3-4C5-6D comme texte libre. Notez que seule la première correspondance est prise en compte pour l'affichage des groupes.",
		["rififi", "filiri", "fi", "liliri", "firiliri"],
		["rifil", "ifilir", "erreur"]),
	new Exercice (
		"Parmi les noms de fichiers présentés ci-dessous, capturez ceux qui correspondent à des images (c'est-à-dire avec une extension png, jpg ou gif).",
		["plage.jpg", "vroum.gif", "iesn_v2.png", "chien.old.jpg"],
		["virus.exe", "helloworld.c", "pic.jpg.old", "syllabus.doc", "pasunepicjpg"]),
	new Exercice (
		"Les séquences d'ADN peuvent être codifiées en utilisant un alphabet de quatre lettres : A, C, G, T. Un codon est un groupe de 3 de ces lettres, comme par exemple TCG ou ACT. Un gène est une séquence composée d'au moins 3 codons, commençant par ATG et finissant par TAA, TAG ou TGA. Construisez une expression régulière permettant de capturer les gènes.",
		["ATGCCCTAA", "ATGCCCTAG", "ATGCCCTGA", "ATGATGATGTAA", "ATGAAAAACAAGAATTAA", "ATGGTAGTCGTGGTTTAG", "ATGCTACTCCTGCTTTGA"],
		["GATTACA", "ATGTAA", "ATGTAG", "ATGCCCCTAG", "TAGCCCTGA", "ATGCATAA"]),
	new Exercice (
		"On écrit parfois les grands nombres entiers en utilisant un \".\" pour séparer les groupes de trois chiffres. Construisez une expression régulière qui permet de capturer ce genre d'écriture.",
		["1.234", "5.666.777.888", "24", "34.211.700", "123.456"],
		["1234", "1.23.456", "76.245.33", "12..456"]),
	new Exercice (
		"En Javascript, on peut écrire une chaîne de caractères en l'entourrant de guillemets ou d'apostrophes. Construisez une expression régulière qui capture les littéraux corrects. Note : on ne se préoccupe pas ici du fait que le caractère utilisé pour entourrer la chaîne ne peut pas apparaître (sans échappement) à l'intérieur de la chaîne.",
		["\"hello\"", "'salut'"],
		["\"incorrect'", "'pas juste\"", "faux", "!fonctionne pas!"]),
	new Exercice (
		"Certains mots, comme \"bonbon\" sont constitués de la répétition d'un groupe de lettres. Construisez une expression régulière qui capture les mots qui ont cette forme.",
		["bonbon", "tata", "joujou", "kifkif", "tamtam", "dodo", "flonflon", "poussepousse"],
		["passe-passe", "grigris"]),
	new Exercice (
		"Construisez une expression régulière permettant de capturer les entiers entre 111 et 999999. Indice : il faut décomposer l'expression en une disjonction de plusieurs cas (a priori 4 cas)",
		["111", "120", "247", "3694", "45678", "512079"],
		["12", "0479", "110", "nombre", "-74213", "103"]),
	new Exercice (
		"Qu'est-ce qu'une heure bien formée, comme 17:34 ? En premier lieu, il faut qu'on trouve deux chiffres, \":\", puis deux chiffres. Mais tous les chiffres ne sont pas valides… Par exemple, le premier chiffre ne pêut être que 0, 1 ou 2. Et si c'est 2, le second chiffre ne peut être que 0, 1, 2 ou 3. Ce tout dernier cas pourrait s'écrire 2[0-3]. En poursuivant le raisonnement et en utilisant des disjonctions (mais le moins possible), construisez une expression régulière pour capturer les heures correctes.",
		["12:34", "00:00", "23:59", "07:40", "09:00", "10:00", "11:11", "00:15", "15:15"],
		["24:00", "08:61", "14:7", "12:32 pm", "8:34", "13:60", "09:99", "4", "-4:00"]),
	new Exercice (
		"Les mots de la colonne de gauche sont composés d'un nombre pair de lettres. Construisez une expression régulière pour les capturer. Indice : un nombre pair n'est rien d'autre qu'un multiple de 2 !",
		["ananas", "banane", "cerise", "lu", "pamplemousse", "tomate"],
		["c", "fruit", "nul", "pomme", "poire"]),
	new Exercice (
		"Créez une expression régulière pour capturer les nombres entiers qui sont plus grands ou égaux à 27. Indice : considérez les conditions à imposer aux nombres en fonction du 1er chiffre qui le compose.",
		["27", "29", "30", "34", "56", "99", "100", "149", "1048"],
		["0", "1", "2", "3", "9", "10", "11", "17", "20", "21", "25", "26"]),
	new Exercice (
		"Un bout de code HTML correct commence par une balise d'ouverture comme &lt;div> et se termine par une balise de fermeture comme &lt;/div>. Construisez une expression régulière qui capture ce genre d'expressions. Note : pour l'exercice, on utilisera des crochets au lieu des chevrons habituels du HTML.<br/><br/>"
		+ "Note : si votre expression régulière capture tous les exemples de la colonne de gauche ainsi que le dernier exemple de la colonne de droite, remplacez l'étoile correspondant à la répétition du contenu par \"*?\" pour résoudre ce problème. Ce sujet sera abordé plus tard mais, en première approche, le point d'interrogation indique qu'il faut capturer aussi peu de caractères que possible (par défaut, l'étoile en capture autant que possible).",
		["[em]emphase[/em]", "[a href=\"go.html\"]Go ![/a]", "[div class=\"new\"][em]Hi[/em][/div]", "[p]Salut, [span]Max[/span] ![/p]"],
		["[em]Mismatch ![/strong]", "[em]Cr[strong]oi[/em]sé[/strong]", "[em]Trop[/em][em]de balise[/em]"]),
	new Exercice (
		"[Plus difficile] Les nombres binaires de la colonne de gauche ont une particularité : ils comportent tous un nombre pair de 1 (alors que ce n'est pas le cas pour la colonne de droite).",
		["11", "101", "0110", "10010011", "011000100110100", "1001101"],
		["1", "000010", "100010001", "001101101", "101010101", "1011101"]),
	]);

// Série 6 - assertions
exercices.push([
	new Exercice (
		"Une phrase correcte commence par une majuscule et se termine par un point ou une ponctuation similaire. Construisez une expression régulière permettant de capturer les exemples respectant ces conditions. Attention : vous devez capturer l'entièreté des exemples de la colonne de gauche, pas juste des parties, et aucune partie des exemples de la colonne de droite !",
		["Le chien joue dehors.", "Aux U.S.A., on parle anglais.", "La suite est une autre histoire...", "Pourquoi dis-tu cela ?", "Va travailler ton cours !"],
		["manque une majuscule !", "Cette phrase ne se termine", "¿ Como estas ?"]),
	new Exercice (
		"Construisez une expression régulière qui capture tous les mots commençant par une voyelle dans les phrases suivantes, à savoir :<br/>- oiseau<br/>- oui, ou<br/>- IDE, en, anglais, EDI, in<br/>- est, un"
		+ "<br/><br/>Note : vous pouvez considérer cet exercice réussi si vous parenez à capturer les chaînes de caractères décrites ci-dessus, même si les chaînes de la colonne de gauche ne sont pas intégralement capturées.",
		["Le petit oiseau vole dehors.", "Oui, je viendrai jeudi ou vendredi.", "IDE en anglais, EDI in French", "Ce n'est qu'un nombre premier !"],
		[]),
	new Exercice (
		"Construisez une expression régulière qui capture tous les montants (uniquement les montants, pas le sigle €) des prix qui sont directement suivis du sigle €, c'est-à-dire les nombres 12.75, 3.50, 10, 12 et 20."
		+ "<br/><br/>Note : vous pouvez considérer cet exercice réussi si vous parenez à capturer les chaînes de caractères décrites ci-dessus, même si les chaînes de la colonne de gauche ne sont pas intégralement capturées.",
		["Pour les 3 articles, vous devez 12.75€.", "3.50 € la pièce, 10€ pour 4 !", "Vu le taux €/$, cela coûte 12 €.", "Vous avez la monnaie sur 20€ en pièces de 1 ?"],
		[]),
	new Exercice (
		"Construisez une expression régulière qui capture tous les mots qui commencent et se terminent par la même lettre dans les phrases suivantes, à savoir : radar, tout, aura, kayak, rêver, elle."
		+ "<br/><br/>Note : vous pouvez considérer cet exercice réussi si vous parenez à capturer les chaînes de caractères décrites ci-dessus, même si les chaînes de la colonne de gauche ne sont pas intégralement capturées.",
		["un radar sur la route", "tout participant aura un kayak", "tu peux rêver d'elle"],
		[]),
	new Exercice (
		"Un espion attend le signal de déclenchement d'une opération secrète. Pour être plus discret, le message n'est pas une phrase toute faite mais n'importe quelle phrase comportent à la fois les mots \"eau\" et \"pomme\". Construisez une expression régulière pour repérer les phrases qui correspondent à ce message secret. Note : il faut capturer <i>toute</i> la phrase-code, pas seulement une partie.",
		["L'eau est vert-pomme.", "La pomme tombe à l'eau.", "Pomme et eau ne riment pas."],
		["Une pomme sur un radeau.", "Pluie = eau.", "Pomme de rainette", "Un pommeau"]),
	new Exercice (
		"Un site exige les conditions suivantes à propos des mots de passe de connexion : le mot de passe fera entre 6 et 8 caractères alphanumériques de long, il comportera au moins une lettre majuscule et au moins un chiffre.",
		["baz0ukA", "t1nTIN", "123456aA", "BBa3ans"],
		["c0uRt", "B1enTr0pLONG", "SansChif", "m1nuscul", "12345", "AbCdE"]),
	new Exercice (
		"Les mots de la colonne de gauche ont tous une terminaison autre que -ent. Construisez une expression régulière qui capture ce genre de mots.",
		["moments", "Javascript", "expression", "mots", "différend", "an", "a", "oui"],
		["parlent", "disent", "moment", "ent", "différent"]),
	new Exercice (
		"Construisez une expression régulière qui capturera les mots constitués de caractères alphanumériques qui ne contiennent pas que des majuscules. Indice : un look-ahead négatif pourrait être utile.",
		["LaTeX", "iPad", "PascalCase", "camelCase", "toutminuscule"],
		["abc!DEF", "TOUTMAJUSCULE"])
	]);