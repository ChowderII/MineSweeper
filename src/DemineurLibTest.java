import junit.framework.TestCase;
import junit.framework.Assert;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class DemineurLibTest extends TestCase {
  
  /*********************************/
  /* Tests pour génèreChampDeMines */
  /*********************************/
  
  /**
   * But: teste la génération d'un champ 1x1
   */
  public void testChamp1par1() 
  { 
    boolean[][] attendu = { { true } }; // Résultat attendu
    boolean[][] rés = DemineurLib.génèreChampDeMines (1, 1, 1);
    
    // Vérification
    boolean verdict = MatriceLib.compareBool(rés, attendu);
    Assert.assertTrue(verdict);
  }
  
  
  /**
   * But: teste la génération d'un champ 2x3 de 6 mines
   */
  public void testChamp2par3() 
  { 
    boolean[][] attendu = { { true, true, true },
      { true, true, true } }; // Résultat attendu
    boolean[][] rés = DemineurLib.génèreChampDeMines (2, 3, 6);
    
    // Vérification
    boolean verdict = MatriceLib.compareBool(rés, attendu);
    Assert.assertTrue(verdict);
  }
  
  /**
   * But: teste la génération d'un champ 5x5 de 10 mines
   */
  public void testChamp5par5() 
  { 
    int attendu = 10; // Résultat attendu
    boolean[][] rés = DemineurLib.génèreChampDeMines (5, 5, attendu);
    
    // Vérification
    int nombreDeMines = MatriceLib.compteTrue(rés);
    boolean verdict = (nombreDeMines == attendu);
    
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la génération d'un champ 20x20 de 100 mines
   */
  public void testChamp20par20() 
  { 
    int attendu = 100; // Résultat attendu
    boolean[][] rés = DemineurLib.génèreChampDeMines (20, 20, attendu);
    
    // Vérification
    int nombreDeMines = MatriceLib.compteTrue(rés);
    boolean verdict = (nombreDeMines == attendu);
    
    Assert.assertTrue(verdict);
  }

  
  /*******************************/
  /* Tests pour calculeProximité */
  /*******************************/

  /**
   * But: teste le calcul de proximité d'un champ 2x2
   */
  public void testProximité2x2() 
  { 
    boolean[][] champ = { {true, false}, 
                          {false, false} }; // Donnée
    int[][] attendu = { {0, 1 },
                        {1, 1 } } ; // Résultat attendu
    int[][] rés = DemineurLib.calculeProximité(champ);
    
    // Vérification
    boolean verdict = MatriceLib.compareInt(rés, attendu);
    
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste le calcul de proximité d'un champ 4x4, v1
   */
  public void testProximité4x4v1() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Donnée
    int[][] attendu = { {1, 2, 2, 1 },
                        {1, 0, 0, 1 },
                        {1, 3, 3, 2 },
                        {0, 1, 0, 1 } } ; // Résultat attendu
    int[][] rés = DemineurLib.calculeProximité(champ);
    
    // Vérification
    boolean verdict = MatriceLib.compareInt(rés, attendu);
    
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste le calcul de proximité d'un champ 4x4, v2
   */
  public void testProximité4x4v2() 
  { 
    boolean[][] champ = { {true, true, true, false}, 
                          {true, false, true, false},
                          {true, true, true, false},
                          {false, false, false, false} }; // Donnée
    int[][] attendu = { {0, 0, 0, 2 },
                        {0, 8, 0, 3 },
                        {0, 0, 0, 2 },
                        {2, 3, 2, 1 } } ; // Résultat attendu
    int[][] rés = DemineurLib.calculeProximité(champ);
    
    // Vérification
    boolean verdict = MatriceLib.compareInt(rés, attendu);
    
    Assert.assertTrue(verdict);
  }
  
  /*****************************/
  /* Tests pour toutesTrouvées */
  /*****************************/
  
  /**
   * But: teste la vérification d'un champ 2x3 de 2 mines, incomplet
   */
  public void testTrouvéesChamp2par3incomplet() 
  { 
    boolean[][] champ = { { true, false, false},
                          { false, true, false } };  // Donnée
    boolean[][] tentatives = { { true, true, true}, 
                               { true, true, false } }; // Donnée 
    boolean attendu = false;// Résultat attendu
    boolean rés = DemineurLib.toutesTrouvées (champ, tentatives);
    
    // Vérification
    boolean verdict = (rés == attendu);
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la vérification d'un champ 2x3 de 2 mines, complet
   */
  public void testTrouvéesChamp2par3toutComplet() 
  { 
    boolean[][] champ = { { true, false, false},
                          { false, true, false } };  // Donnée
    boolean[][] tentatives = { { true, true, true}, 
                               { true, true, true } }; // Donnée 
    boolean attendu = true;// Résultat attendu
    boolean rés = DemineurLib.toutesTrouvées (champ, tentatives);
    
    // Vérification
    boolean verdict = (rés == attendu);
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la vérification d'un champ 2x3 de 2 mines, complet
   *      (cette fois-ci, les cases restantes sont toutes des mines)
   */
  public void testTrouvéesChamp2par3OKcompletMines() 
  { 
    boolean[][] champ = { { true, false, false},
                          { false, true, false } };  // Donnée
    boolean[][] tentatives = { { true, true, true}, 
                               { true, false, true } }; // Donnée 
    boolean attendu = true;// Résultat attendu
    boolean rés = DemineurLib.toutesTrouvées (champ, tentatives);
    
    // Vérification
    boolean verdict = (rés == attendu);
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la vérification d'un champ 4x4 de 3 mines, incomplet
   */
  public void testTrouvéesChamp4x4incomplet() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Donnée
    boolean[][] tentatives = { {true, true, true, true}, 
                               {true, true, false, true},
                               {true, true, true, true},
                               {true, true, true, false} }; // Donnée
    boolean attendu = false;// Résultat attendu
    boolean rés = DemineurLib.toutesTrouvées (champ, tentatives);
    
    // Vérification
    boolean verdict = (rés == attendu);
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la vérification d'un champ 4x4 de 3 mines, complet
   */
  public void testTrouvéesChamp4x4toutComplet() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Donnée
    boolean[][] tentatives = { {true, true, true, true}, 
                               {true, true, true, true},
                               {true, true, true, true},
                               {true, true, true, true} }; // Donnée
    boolean attendu = true;// Résultat attendu
    boolean rés = DemineurLib.toutesTrouvées (champ, tentatives);
    
    // Vérification
    boolean verdict = (rés == attendu);
    Assert.assertTrue(verdict);
  }  

  /**
   * But: teste la vérification d'un champ 4x4 de 3 mines, complet
   *      (cette fois-ci, les cases restantes sont toutes des mines)
   */
  public void testTrouvéesChamp4x4toutCompletMines() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Donnée
    boolean[][] tentatives = { {true, true, true, true}, 
                               {true, false, false, true},
                               {true, true, true, true},
                               {true, true, false, true} }; // Donnée
    boolean attendu = true;// Résultat attendu
    boolean rés = DemineurLib.toutesTrouvées (champ, tentatives);
    
    // Vérification
    boolean verdict = (rés == attendu);
    Assert.assertTrue(verdict);
  }  
}
