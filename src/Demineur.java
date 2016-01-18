// ITI1520 (Automne 2013), Devoir 4

// Ce programme d�marre le jeu de D�mineur selon un champ de taille donn�e
// et un nombre de mines sp�cifi�.

import java.io.* ;

class Demineur 
{
  public static void main (String[] args)
  { 
    // D�CLARATIONS DES VARIABLES ET DICTIONNAIRE DE DONN�ES 
    int longueur;       // DONN�E: longueur du champ (nb de lignes)
    int largeur;        // DONN�E: largeur du champ (nb de colonnes)
    int nombreDeMines;  // DONN�E: nombre de mines dans le champ
    int tailleMax = 20; // INTERM�DIAIRE: longueur et largeur maximales.
    
    // AFFICHAGE DE L'INFO D'IDENTIFICATION
    System.out.println();
    System.out.println("ITI1520 (A-2013), Devoir 4");
    System.out.println("Jeu du d�mineur!");
    System.out.println("----------------");
    System.out.println();
    
    // LECTURE DES VALEURS DONN�ES
    // Valide les donn�es au passage.
    longueur = valideEntier("la longueur du champ", 1, tailleMax);
    largeur = valideEntier("la largeur du champ", 1, tailleMax);
    // Utilise longueur et largeur pour d�terminer la limite sup�rieure.
    nombreDeMines = valideEntier("le nombre de mines", 1, longueur * largeur);

    // MODULE DE L�ALGORITHME
    System.out.println("Super! Et on d�marre...") ;
    System.out.println("Click the new window in your taskbar !");
    
    new DemineurGUI ( longueur, largeur, nombreDeMines ) ;    
    // AFFICHAGE DES R�SULTATS ET MODIFI�ES � L'�CRAN
  }

  // D�FINITIONS DES M�THODES INVOQU�ES PAR "MAIN", S'IL Y A LIEU.
  
  // M�thode valideEntier: retourne un entier entre min et max, inclusivement
  // DONN�ES: message: Message � afficher � l'utilisateur
  //          min: limite inf�rieure acceptable
  //          max: limite sup�rieure acceptable
  // HYPOTH�SE: min < max (pas besoin de la v�rifier)
  private static int valideEntier(String message, int min, int max)
  {
    // D�CLARATIONS DES INTERM�DIAIRES ET R�SULTATS 
    int r�sultat; // R�SULTAT valid�

    // MODULE DE L�ALGORITHME.
    System.out.print("Veuillez entrer " + message);
    System.out.print (" (entre " + min + " et " + max + ") : ");
    r�sultat = ITI1520.readInt();
    
    while ( (r�sultat < min) || (r�sultat > max) )
    {
      System.out.println ("Valeur invalide...");
      System.out.print("Veuillez entrer " + message);
      System.out.print (" (entre " + min + " et " + max + ") : ");
      r�sultat = ITI1520.readInt();
    }
    
    // R�SULTAT RETOURN�
    return r�sultat;
  }

  
} // fin de la classe