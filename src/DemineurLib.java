// ITI1520 (Automne 2013), Devoir 4
// Nom: Alexandre Boyer, num�ro d'�tudiant: 7720512
// Nom: Nikolas Brideau, num�ro d'�tudiant: 7721021

// Classe librairie � compl�ter.

public class DemineurLib
{

	// Q1: � COMPL�TER  
	// DESCRIPTION: g�n�re un champ de mines sous forme d'une
	//         matrice de bool�ens o� une cellule � "true" indique une mine.
	// DONN�ES: 
	//        longueur: longeur du champ
	//        largeur: largeur du du champ
	//        nbMines: le nombre de mines d�sir�
	// Conseil: Consid�rez l'utilisation de Math.random(), de Math.floor()  
	//          et du for�age de type pour g�n�rer des positions al�atoires 
	//          pour les mines.
	public static boolean [][] g�n�reChampDeMines ( int longueur, int largeur, int nbMines) 
	{
		boolean[][] arrayMinesBoolean = new boolean[longueur][largeur]; // d�claration du array de mines boolean (vrai = mines ; faux  != mines)

		for(int a = 0; a < longueur; a++)
			for(int b = 0; b < largeur; b++)		//initialise le arrayMinesBoolean a faux ; a est les LIGNES et b est les COLONNES
				arrayMinesBoolean[a][b] = false;



		// MODULE DU SOUS-ALGORITHME 

		// R�SULTAT RETOURN�
		return (vraiFaux(arrayMinesBoolean,longueur, largeur, nbMines));
	}

	// Q2: � COMPL�TER  
	// DESCRIPTION: g�n�re une matrice d'entiers o� chaque
	//         cellule indique le nombre de mines adjacentes (i.e. qui
	//         touchent directement � cette cellule). Utilise 0 pour une
	//         position correspondant � celle d'une mine dans le champ.
	// DONN�ES: 
	//     champDeMines:  r�f�rence � une matrice de bool�ens repr�sentant le champ de mines.
	// Conseil: Attention aux limites p�riph�riques du champ de mines! L'utilisation d'une
	//          m�thode additionnelle pourrait �tre pratique.
	public static int [][] calculeProximit� ( boolean [][] champDeMines) 
	{
		// D�CLARATION DES VARIABLES / DICTIONNAIRE DE DONN�ES
		int [][] arrayMinesInt = new int[champDeMines.length][champDeMines[0].length]; // initialisation du array de intager
		int nbMines = 0; // nombre de mines
		
		for(int a = 0; a < champDeMines.length; a++){
			for(int b = 0; b < champDeMines[0].length; b++) {
				if (champDeMines[a][b] == true){ 
				nbMines++; // trouer le nombres de mines dans le arrays pour envoyer a la m�thode
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

			}	// grace a ce for loop, je connais les coordonn�es exactes de chaque mines.
		}
			
		// R�SULTAT RETOURN�
		return (intProx(champDeMines, arrayMinesInt, indexY, indexX, nbMines));
}

	// DESCRIPTION: d�termine si toutes les mines du champ ont �t� trouv�es.
	// DONN�ES: champDeMines: r�f�rnece � une matrice de bool�ens repr�sentant le champ de mines.
	//          tentatives: r�f�rnece � une matrice de bool�ens repr�sentant les tentatives du
	//                      joueur (true si une position repr�sente une mine potentielle (X)
	//                      ou une case d�j� cliqu�e)
	// R�SULTAT: vrai lorsque toutes les cases non tent�es correspondent � des positions 
	//           de mines dans le champ.
	// HYPOTH�SE: les deux matrices ont la m�me taille (pas besoin de v�rifier).
	public static boolean toutesTrouv�es ( boolean[][] champDeMines, boolean[][] tentatives ) 
	{
		// D�CLARATION DES VARIABLES / DICTIONNAIRE DE DONN�ES
		boolean flag = false; // d�claration d'un flag
		
		outer : for(int a = 0; a < champDeMines.length; a++){
			for(int b = 0; b < champDeMines[0].length; b++) {
				if (tentatives[a][b] == champDeMines[a][b]){
					flag = false;
					break outer; // brise le outer loop si une seul condition est fausse
				}
				else {flag = true;} // si tentatives n'�gale pas champsdemines alors flag �gale vrai car on est en train de gagn�
			}
		}
		return flag; // retour du flag
	}

	public static boolean[][] vraiFaux (boolean[][] arrayMinesBoolean,int longueur , int largeur, int nbMines)
	{
		int x = -1; // d�claration d'une variable d'index X
		int y = -1; // d�claration d'une variable d'index Y

		if (nbMines == 0) // conditions de sorties de la r�cursivit�s
		{

		}
		else
		{
			x = (int)(Math.random()*longueur); // attribue un int "random" a la variable x
			y = (int)(Math.random()*largeur); // attribue un int "random" a la variable y

			if (arrayMinesBoolean[x][y] == false) // si il n'y pas de mines au coordonn�es g�n�r�, alors le programme en met une
			{
				arrayMinesBoolean[x][y] = true;
				vraiFaux(arrayMinesBoolean,longueur, largeur, nbMines-1);
			}

			else // sinon il recommence sans d�cr�ment� le nombre de mines
			{
				vraiFaux(arrayMinesBoolean, longueur, largeur, nbMines);
			}
		}
		return arrayMinesBoolean;
	}

	public static int[][] intProx (boolean[][] champDeMines, int[][] arrayMinesInt, int[] y, int[] x, int nbMines)
	{
		if (nbMines == 0){}
		else { // v�rifie si la case adjacentes n'est pas z�ro, si vrai, elle applique +1
			if (y[nbMines-1] > 0){ // v�rifie si il existe une rang� plus haut
				if (x[nbMines-1] > 0) { // v�rifie si il existe une colonnes a gauche
					if (champDeMines[(y[nbMines-1])-1][(x[nbMines-1])-1] != true) { // v�rifie si la case en haut a droites est une mine
						arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])-1] = arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])-1] +1;}} // la case haut-gauche +1
				
				if (champDeMines[(y[nbMines-1])-1][(x[nbMines-1])] != true) { // v�rifie si la case en haut est une mine
					arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])] = arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])] +1;}// la case direct haut +1
				
				if ((x[nbMines-1]+1) < champDeMines[0].length) { // v�rifie si la case en haut � droites est une mine
					if (champDeMines[(y[nbMines-1])-1][(x[nbMines-1])+1] != true) {
						arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])+1] = arrayMinesInt[(y[nbMines-1])-1][(x[nbMines-1])+1] +1;}}//} // la case haut-droite +1
				
			}
			
			
				if (x[nbMines-1] > 0) { // v�rifie si il existe une colonnes a gauche
					if (champDeMines[(y[nbMines-1])][(x[nbMines-1])-1] != true) {
						arrayMinesInt[(y[nbMines-1])][(x[nbMines-1])-1] = arrayMinesInt[(y[nbMines-1])][(x[nbMines-1])-1] +1;}} // la case gauche +1
				
				if ((x[nbMines-1]+1) < champDeMines[0].length) { // v�rifie si il existe une colonnes a gauche
					if (champDeMines[(y[nbMines-1])][(x[nbMines-1])+1] != true) {
						arrayMinesInt[(y[nbMines-1])][(x[nbMines-1])+1] = arrayMinesInt[(y[nbMines-1])][(x[nbMines-1])+1] +1;}} // la case droite +1
			
				
				
				
				
			if (((y[nbMines-1])+1) < champDeMines.length){	// v�rifie si il existe une rang� en dessous
				if (x[nbMines-1] > 0) { // v�rifie si il existe une colonnes a gauche
					if (champDeMines[(y[nbMines-1])+1][(x[nbMines-1])-1] != true) { // v�rifie si il existe une mine en bas a gauche
						arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])-1] = arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])-1] +1;}} // la case bas-gauche +1
				
				if (champDeMines[(y[nbMines-1])+1][(x[nbMines-1])] != true) { // v�rifie si il existe une mine en bas
					arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])] = arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])] +1;} // la case direct bas +1
				
				if ((x[nbMines-1]+1) < champDeMines[0].length) { // v�rifie si il existe une mine en bas a droite
					if (champDeMines[(y[nbMines-1])+1][(x[nbMines-1])+1] != true) {
						arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])+1] = arrayMinesInt[(y[nbMines-1])+1][(x[nbMines-1])+1] +1;}} // la case bas-droite +1
				
				
			}	
				intProx(champDeMines, arrayMinesInt, y , x, nbMines-1); // rappelle de la fonction en d�cr�mentant le nombre de mines
			}
		return arrayMinesInt;
	}	
}