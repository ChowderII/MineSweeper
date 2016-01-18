import junit.framework.TestCase;
import junit.framework.Assert;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class DemineurLibTest extends TestCase {
  
  /*********************************/
  /* Tests pour g�n�reChampDeMines */
  /*********************************/
  
  /**
   * But: teste la g�n�ration d'un champ 1x1
   */
  public void testChamp1par1() 
  { 
    boolean[][] attendu = { { true } }; // R�sultat attendu
    boolean[][] r�s = DemineurLib.g�n�reChampDeMines (1, 1, 1);
    
    // V�rification
    boolean verdict = MatriceLib.compareBool(r�s, attendu);
    Assert.assertTrue(verdict);
  }
  
  
  /**
   * But: teste la g�n�ration d'un champ 2x3 de 6 mines
   */
  public void testChamp2par3() 
  { 
    boolean[][] attendu = { { true, true, true },
      { true, true, true } }; // R�sultat attendu
    boolean[][] r�s = DemineurLib.g�n�reChampDeMines (2, 3, 6);
    
    // V�rification
    boolean verdict = MatriceLib.compareBool(r�s, attendu);
    Assert.assertTrue(verdict);
  }
  
  /**
   * But: teste la g�n�ration d'un champ 5x5 de 10 mines
   */
  public void testChamp5par5() 
  { 
    int attendu = 10; // R�sultat attendu
    boolean[][] r�s = DemineurLib.g�n�reChampDeMines (5, 5, attendu);
    
    // V�rification
    int nombreDeMines = MatriceLib.compteTrue(r�s);
    boolean verdict = (nombreDeMines == attendu);
    
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la g�n�ration d'un champ 20x20 de 100 mines
   */
  public void testChamp20par20() 
  { 
    int attendu = 100; // R�sultat attendu
    boolean[][] r�s = DemineurLib.g�n�reChampDeMines (20, 20, attendu);
    
    // V�rification
    int nombreDeMines = MatriceLib.compteTrue(r�s);
    boolean verdict = (nombreDeMines == attendu);
    
    Assert.assertTrue(verdict);
  }

  
  /*******************************/
  /* Tests pour calculeProximit� */
  /*******************************/

  /**
   * But: teste le calcul de proximit� d'un champ 2x2
   */
  public void testProximit�2x2() 
  { 
    boolean[][] champ = { {true, false}, 
                          {false, false} }; // Donn�e
    int[][] attendu = { {0, 1 },
                        {1, 1 } } ; // R�sultat attendu
    int[][] r�s = DemineurLib.calculeProximit�(champ);
    
    // V�rification
    boolean verdict = MatriceLib.compareInt(r�s, attendu);
    
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste le calcul de proximit� d'un champ 4x4, v1
   */
  public void testProximit�4x4v1() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Donn�e
    int[][] attendu = { {1, 2, 2, 1 },
                        {1, 0, 0, 1 },
                        {1, 3, 3, 2 },
                        {0, 1, 0, 1 } } ; // R�sultat attendu
    int[][] r�s = DemineurLib.calculeProximit�(champ);
    
    // V�rification
    boolean verdict = MatriceLib.compareInt(r�s, attendu);
    
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste le calcul de proximit� d'un champ 4x4, v2
   */
  public void testProximit�4x4v2() 
  { 
    boolean[][] champ = { {true, true, true, false}, 
                          {true, false, true, false},
                          {true, true, true, false},
                          {false, false, false, false} }; // Donn�e
    int[][] attendu = { {0, 0, 0, 2 },
                        {0, 8, 0, 3 },
                        {0, 0, 0, 2 },
                        {2, 3, 2, 1 } } ; // R�sultat attendu
    int[][] r�s = DemineurLib.calculeProximit�(champ);
    
    // V�rification
    boolean verdict = MatriceLib.compareInt(r�s, attendu);
    
    Assert.assertTrue(verdict);
  }
  
  /*****************************/
  /* Tests pour toutesTrouv�es */
  /*****************************/
  
  /**
   * But: teste la v�rification d'un champ 2x3 de 2 mines, incomplet
   */
  public void testTrouv�esChamp2par3incomplet() 
  { 
    boolean[][] champ = { { true, false, false},
                          { false, true, false } };  // Donn�e
    boolean[][] tentatives = { { true, true, true}, 
                               { true, true, false } }; // Donn�e 
    boolean attendu = false;// R�sultat attendu
    boolean r�s = DemineurLib.toutesTrouv�es (champ, tentatives);
    
    // V�rification
    boolean verdict = (r�s == attendu);
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la v�rification d'un champ 2x3 de 2 mines, complet
   */
  public void testTrouv�esChamp2par3toutComplet() 
  { 
    boolean[][] champ = { { true, false, false},
                          { false, true, false } };  // Donn�e
    boolean[][] tentatives = { { true, true, true}, 
                               { true, true, true } }; // Donn�e 
    boolean attendu = true;// R�sultat attendu
    boolean r�s = DemineurLib.toutesTrouv�es (champ, tentatives);
    
    // V�rification
    boolean verdict = (r�s == attendu);
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la v�rification d'un champ 2x3 de 2 mines, complet
   *      (cette fois-ci, les cases restantes sont toutes des mines)
   */
  public void testTrouv�esChamp2par3OKcompletMines() 
  { 
    boolean[][] champ = { { true, false, false},
                          { false, true, false } };  // Donn�e
    boolean[][] tentatives = { { true, true, true}, 
                               { true, false, true } }; // Donn�e 
    boolean attendu = true;// R�sultat attendu
    boolean r�s = DemineurLib.toutesTrouv�es (champ, tentatives);
    
    // V�rification
    boolean verdict = (r�s == attendu);
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la v�rification d'un champ 4x4 de 3 mines, incomplet
   */
  public void testTrouv�esChamp4x4incomplet() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Donn�e
    boolean[][] tentatives = { {true, true, true, true}, 
                               {true, true, false, true},
                               {true, true, true, true},
                               {true, true, true, false} }; // Donn�e
    boolean attendu = false;// R�sultat attendu
    boolean r�s = DemineurLib.toutesTrouv�es (champ, tentatives);
    
    // V�rification
    boolean verdict = (r�s == attendu);
    Assert.assertTrue(verdict);
  }

  /**
   * But: teste la v�rification d'un champ 4x4 de 3 mines, complet
   */
  public void testTrouv�esChamp4x4toutComplet() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Donn�e
    boolean[][] tentatives = { {true, true, true, true}, 
                               {true, true, true, true},
                               {true, true, true, true},
                               {true, true, true, true} }; // Donn�e
    boolean attendu = true;// R�sultat attendu
    boolean r�s = DemineurLib.toutesTrouv�es (champ, tentatives);
    
    // V�rification
    boolean verdict = (r�s == attendu);
    Assert.assertTrue(verdict);
  }  

  /**
   * But: teste la v�rification d'un champ 4x4 de 3 mines, complet
   *      (cette fois-ci, les cases restantes sont toutes des mines)
   */
  public void testTrouv�esChamp4x4toutCompletMines() 
  { 
    boolean[][] champ = { {false, false, false, false}, 
                          {false, true, true, false},
                          {false, false, false, false},
                          {false, false, true, false} }; // Donn�e
    boolean[][] tentatives = { {true, true, true, true}, 
                               {true, false, false, true},
                               {true, true, true, true},
                               {true, true, false, true} }; // Donn�e
    boolean attendu = true;// R�sultat attendu
    boolean r�s = DemineurLib.toutesTrouv�es (champ, tentatives);
    
    // V�rification
    boolean verdict = (r�s == attendu);
    Assert.assertTrue(verdict);
  }  
}
