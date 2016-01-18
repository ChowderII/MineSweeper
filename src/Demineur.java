// ITI1520 (Automne 2013), Devoir 4

// Ce programme démarre le jeu de Démineur selon un champ de taille donnée
// et un nombre de mines spécifié.

import java.io.* ;

class Demineur 
{
  public static void main (String[] args)
  { 
    // DÉCLARATIONS DES VARIABLES ET DICTIONNAIRE DE DONNÉES 
    int longueur;       // DONNÉE: longueur du champ (nb de lignes)
    int largeur;        // DONNÉE: largeur du champ (nb de colonnes)
    int nombreDeMines;  // DONNÉE: nombre de mines dans le champ
    int tailleMax = 20; // INTERMÉDIAIRE: longueur et largeur maximales.
    
    // AFFICHAGE DE L'INFO D'IDENTIFICATION
    System.out.println();
    System.out.println("ITI1520 (A-2013), Devoir 4");
    System.out.println("Jeu du démineur!");
    System.out.println("----------------");
    System.out.println();
    
    // LECTURE DES VALEURS DONNÉES
    // Valide les données au passage.
    longueur = valideEntier("la longueur du champ", 1, tailleMax);
    largeur = valideEntier("la largeur du champ", 1, tailleMax);
    // Utilise longueur et largeur pour déterminer la limite supérieure.
    nombreDeMines = valideEntier("le nombre de mines", 1, longueur * largeur);

    // MODULE DE L’ALGORITHME
    System.out.println("Super! Et on démarre...") ;
    System.out.println("Click the new window in your taskbar !");
    
    new DemineurGUI ( longueur, largeur, nombreDeMines ) ;    
    // AFFICHAGE DES RÉSULTATS ET MODIFIÉES À L'ÉCRAN
  }

  // DÉFINITIONS DES MÉTHODES INVOQUÉES PAR "MAIN", S'IL Y A LIEU.
  
  // Méthode valideEntier: retourne un entier entre min et max, inclusivement
  // DONNÉES: message: Message à afficher à l'utilisateur
  //          min: limite inférieure acceptable
  //          max: limite supérieure acceptable
  // HYPOTHÈSE: min < max (pas besoin de la vérifier)
  private static int valideEntier(String message, int min, int max)
  {
    // DÉCLARATIONS DES INTERMÉDIAIRES ET RÉSULTATS 
    int résultat; // RÉSULTAT validé

    // MODULE DE L’ALGORITHME.
    System.out.print("Veuillez entrer " + message);
    System.out.print (" (entre " + min + " et " + max + ") : ");
    résultat = ITI1520.readInt();
    
    while ( (résultat < min) || (résultat > max) )
    {
      System.out.println ("Valeur invalide...");
      System.out.print("Veuillez entrer " + message);
      System.out.print (" (entre " + min + " et " + max + ") : ");
      résultat = ITI1520.readInt();
    }
    
    // RÉSULTAT RETOURNÉ
    return résultat;
  }

  
} // fin de la classe