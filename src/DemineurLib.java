// ITI1520 (Automne 2013), Devoir 4
// Nom: Alexandre Boyer, numéro d'étudiant: 7720512
// Nom: Nikolas Brideau, numéro d'étudiant: 7721021

// Classe librairie à compléter.

public class DemineurLib
{

	// Q1: À COMPLÉTER  
	// DESCRIPTION: génère un champ de mines sous forme d'une
	//         matrice de booléens où une cellule à "true" indique une mine.
	// DONNÉES: 
	//        longueur: longeur du champ
	//        largeur: largeur du du champ
	//        nbMines: le nombre de mines désiré
	// Conseil: Considérez l'utilisation de Math.random(), de Math.floor()  
	//          et du forçage de type pour générer des positions aléatoires 
	//          pour les mines.
	public static boolean [][] génèreChampDeMines ( int longueur, int largeur, int nbMines) 
	{
		boolean[][] arrayMinesBoolean = new boolean[longueur][largeur]; // déclaration du array de mines boolean (vrai = mines ; faux  != mines)

		for(int a = 0; a < longueur; a++)
			for(int b = 0; b < largeur; b++)		//initialise le arrayMinesBoolean a faux ; a est les LIGNES et b est les COLONNES
				arrayMinesBoolean[a][b] = false;



		// MODULE DU SOUS-ALGORITHME 

		// RÉSULTAT RETOURNÉ
		return (vraiFaux(arrayMinesBoolean,longueur, largeur, nbMines));
	}

	// Q2: À COMPLÉTER  
	// DESCRIPTION: génère une matrice d'entiers où chaque
	//         cellule indique le nombre de mines adjacentes (i.e. qui
	//         touchent directement à cette cellule). Utilise 0 pour une
	//         position correspondant à celle d'une mine dans le champ.
	// DONNÉES: 
	//     champDeMines:  référence à une matrice de booléens représentant le champ de mines.
	// Conseil: Attention aux limites périphériques du champ de mines! L'utilisation d'une
	//          méthode additionnelle pourrait être pratique.
	public static int [][] calculeProximité ( boolean [][] champDeMines) 
	{
		// DÉCLARATION DES VARIABLES / DICTIONNAIRE DE DONNÉES
		int [][] arrayMinesInt = new int[champDeMines.length][champDeMines[0].length]; // initialisation du array de intager
		int nbMines = 0; // nombre de mines
		
		for(int a = 0; a < champDeMines.length; a++){
			for(int b = 0; b < champDeMines[0].length; b++) {
				if (champDeMines[a][b] == true){ 
				nbMines++; // trouer le nombres de mines dans le arrays pour envoyer a la méthode
				}}}
				
				int [] indexX = new int[nbMines]; // index de position des mines en X
				int [] indexY = new int[nbMines]; // index de position des mines en Y
				int i = 0; // index temporaire en X
				int j = 0; // index temporaire en Y
				
				for(int c = 0; c < champDeMines.length; c++){
					for(int d = 0; d < champDeMines[0].length; d++) {
						if (champDeMines[c][d] == true){
							indexY[i++] = c;
							indexX[j++] = d;} // remplissage des arrays de position avec la valeurs de IJ

			}	// grace a ce for loop, je connais les coordonnées exactes de chaque mines.
		}
			
		// RÉSULTAT RETOURNÉ
		return (intProx(champDeMines, arrayMinesInt, indexY, indexX, nbMines));
}

	// DESCRIPTION: détermine si toutes les mines du champ ont été trouvées.
	// DONNÉES: champDeMines: référnece à une matrice de booléens représentant le champ de mines.
	//          tentatives: référnece à une matrice de booléens représentant les tentatives du
	//                      joueur (true si une position représente une mine potentielle (X)
	//                      ou une case déjà cliquée)
	// RÉSULTAT: vrai lorsque toutes les cases non tentées correspondent à des positions 
	//           de mines dans le champ.
	// HYPOTHÈSE: les deux matrices ont la même taille (pas besoin de vérifier).
	public static boolean toutesTrouvées ( boolean[][] champDeMines, boolean[][] tentatives ) 
	{
		// DÉCLARATION DES VARIABLES / DICTIONNAIRE DE DONNÉES
		boolean flag = false; // déclaration d'un flag
		
		outer : for(int a = 0; a < champDeMines.length; a++){
			for(int b = 0; b < champDeMines[0].length; b++) {
				if (tentatives[a][b] == champDeMines[a][b]){
					flag = false;
					break outer; // brise le outer loop si une seul condition est fausse
				}
				else {flag = true;} // si tentatives n'égale pas champsdemines alors flag égale vrai car on est en train de gagné
			}
		}
		return flag; // retour du flag
	}

	public static boolean[][] vraiFaux (boolean[][] arrayMinesBoolean,int longueur , int largeur, int nbMines)
	{
		int x = -1; // déclaration d'une variable d'index X
		int y = -1; // déclaration d'une variable d'index Y

		if (nbMines == 0) // conditions de sorties de la récursivités
		{

		}
		else
		{
			x = (int)(Math.random()*longueur); // attribue un int "random" a la variable x
			y = (int)(Math.random()*largeur); // attribue un int "random" a la variable y

			if (arrayMinesBoolean[x][y] == false) // si il n'y pas de mines au coordonnées généré, alors le programme en met une
			{
				arrayMinesBoolean[x][y] = true;
				vraiFaux(arrayMinesBoolean,longueur, largeur, nbMines-1);
			}

			else // sinon il recommence sans décrémenté le nombre de mines
			{
				vraiFaux(arrayMinesBoolean, longueur, largeur, nbMines);
			}
		}
		return arrayMinesBoolean;
	}

	public static int[][] intProx (boolean[][] champDeMines, int[][] arrayMinesInt, int[] y, int[] x, int nbMines)
	{
		if (nbMines == 0){}
		else { // vérifie si la case adjacentes n'est pas zéro, si vrai, elle applique +1
			if (y[nbMines-1] > 0){ // vérifie si il existe une rangé plus haut
				if (x[nbMines-1] > 0) { // vérifie si il existe une colonnes a gauche
					if (champDeMines[(y[nbMines-1])-1][(x[nbMines-1])-1] != true) { // vérifie si la case en haut a droites est une mine
						arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])-1] = arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])-1] +1;}} // la case haut-gauche +1
				
				if (champDeMines[(y[nbMines-1])-1][(x[nbMines-1])] != true) { // vérifie si la case en haut est une mine
					arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])] = arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])] +1;}// la case direct haut +1
				
				if ((x[nbMines-1]+1) < champDeMines[0].length) { // vérifie si la case en haut à droites est une mine
					if (champDeMines[(y[nbMines-1])-1][(x[nbMines-1])+1] != true) {
						arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])+1] = arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])+1] +1;}}//} // la case haut-droite +1
				
			}
			
			
				if (x[nbMines-1] > 0) { // vérifie si il existe une colonnes a gauche
					if (champDeMines[(y[nbMines-1])][(x[nbMines-1])-1] != true) {
						arrayMinesInt[(y[nbMines-1])][(x[nbMines-1])-1] = arrayMinesInt[(y[nbMines-1])][(x[nbMines-1])-1] +1;}} // la case gauche +1
				
				if ((x[nbMines-1]+1) < champDeMines[0].length) { // vérifie si il existe une colonnes a gauche
					if (champDeMines[(y[nbMines-1])][(x[nbMines-1])+1] != true) {
						arrayMinesInt[(y[nbMines-1])][(x[nbMines-1])+1] = arrayMinesInt[(y[nbMines-1])][(x[nbMines-1])+1] +1;}} // la case droite +1
			
				
				
				
				
			if (((y[nbMines-1])+1) < champDeMines.length){	// vérifie si il existe une rangé en dessous
				if (x[nbMines-1] > 0) { // vérifie si il existe une colonnes a gauche
					if (champDeMines[(y[nbMines-1])+1][(x[nbMines-1])-1] != true) { // vérifie si il existe une mine en bas a gauche
						arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])-1] = arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])-1] +1;}} // la case bas-gauche +1
				
				if (champDeMines[(y[nbMines-1])+1][(x[nbMines-1])] != true) { // vérifie si il existe une mine en bas
					arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])] = arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])] +1;} // la case direct bas +1
				
				if ((x[nbMines-1]+1) < champDeMines[0].length) { // vérifie si il existe une mine en bas a droite
					if (champDeMines[(y[nbMines-1])+1][(x[nbMines-1])+1] != true) {
						arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])+1] = arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])+1] +1;}} // la case bas-droite +1
				
				
			}	
				intProx(champDeMines, arrayMinesInt, y , x, nbMines-1); // rappelle de la fonction en décrémentant le nombre de mines
			}
		return arrayMinesInt;
	}	
}