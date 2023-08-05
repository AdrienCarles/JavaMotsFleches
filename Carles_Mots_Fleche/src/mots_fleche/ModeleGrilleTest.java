/*package mots_fleche;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModeleGrilleTest {

    private ModeleGrille grille;

    @BeforeEach
    public void setUp() {
        grille = new ModeleGrille(6, 6);
    }

    @Test
    public void testCreateGrille6x6() {
        assertEquals(6, grille.getHauteur());
        assertEquals(6, grille.getLargeur());
    }

    @Test
    public void testCreateGrille0x0() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ModeleGrille(0, 0);
        });
    }

    @Test
    public void testCreateGrilleNegative6xNegative6() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ModeleGrille(-6, -6);
        });
    }

    @Test
    public void testCreateGrille11x11() {
        assertThrows(IllegalArgumentException.class, () -> {
            new ModeleGrille(11, 11);
        });
    }

    @Test
    public void testGetCaseValeurVide() {
        assertEquals("vide", grille.getCaseValeur(1, 1));
    }

    @Test
    public void testGetCaseValeurLettre() {
        Case caseTest = grille.getCase(1, 1); 
        caseTest.setLettre('A');
        assertEquals("lettre", grille.getCaseValeur(1, 1));
    }

    @Test
    public void testGetCaseValeurDefSimple() {
        Case caseTest = grille.getCase(1, 1); 
        caseTest.setDefinition1("definition", "test" , "Horizontal indirect");
        assertEquals("def simple", grille.getCaseValeur(1, 1));
    }

    @Test
    public void testGetCaseValeurDefDouble() {
        Case caseTest = grille.getCase(1, 1); 
        caseTest.setDefinition1("definition1", "test" , "Horizontal indirect");
        caseTest.setDefinition2("definition2", "test" , "Horizontal indirect");
        assertEquals("def double", grille.getCaseValeur(1, 1));
    }
    
    @Test
    public void testGetCaseDispoHD() {
    	grille = new ModeleGrille(6, 10);
    	assertEquals(9, grille.getCountCasesDispo(0, 0, "Horizontal direct"));
    }
    
    @Test
    public void testGetCaseDispoHI() {
    	grille = new ModeleGrille(6, 10);
    	assertEquals(10, grille.getCountCasesDispo(0, 0, "Horizontal indirect"));
    }
    
    @Test
    public void testGetCaseDispoVD() {
    	grille = new ModeleGrille(6, 10);
    	assertEquals(5, grille.getCountCasesDispo(0, 0, "Vertical direct"));
    }
    
    @Test
    public void testGetCaseDispoVI() {
    	grille = new ModeleGrille(6, 10);
    	assertEquals(6, grille.getCountCasesDispo(0, 0, "Vertical indirect"));
    }
    
    @Test
    public void testGetCaseDispoHDnonVide() {
    	grille = new ModeleGrille(6, 6);
    	grille.setCaseDefinition(3, 4, "par anglais", "Vertical direct", "by");
        int dispo = grille.getCountCasesDispo(5, 0, "Horizontal direct");
        assertEquals(5, dispo);
        dispo = grille.getCountCasesDispo(4, 0, "Horizontal indirect");
        assertEquals(6, dispo);
        //assertEquals("^...y.$", grille.getCaseRegex(5, 0, "Horizontal direct"));
        assertEquals("^....y.$", grille.getCaseRegex(4, 0, "Horizontal indirect"));
    }
    
    @Test
    public void testFinal() {
    	grille = new ModeleGrille(6, 6);
    	grille.afficherGrilleEmpty();
        grille.setCaseDefinition(3, 4, "pronom", "Vertical direct", "me");
        grille.afficherGrille();
        assertEquals(6, grille.getCountCasesDispo(4, 0, "Horizontal indirect"));
        assertEquals("^....e.$", grille.getCaseRegex(4, 0, "Horizontal indirect"));
        grille.setCaseDefinition(4, 0, "donner pour un temps", "Horizontal indirect", "preter");
        grille.afficherGrille();
        assertEquals("def simple", grille.getCaseValeur(3, 4));
        Case caseTest = grille.getCase(3, 4);
        Definition defTest = caseTest.getDefinition1();
        assertEquals("pronom", defTest.getIntitule());
        assertEquals("me", defTest.getReponse());
        assertEquals("Vertical direct", defTest.getDirection());
        caseTest = grille.getCase(5, 4);
        assertEquals('e', caseTest.getLettre());
        grille.removeDefinition(3, 4, "Vertical direct");
        grille.afficherGrille();
        grille.setCaseDefinition(0, 0, "odorant", "Vertical direct", "pet");
        grille.setCaseDefinition(0, 0, "tient chaud en hiver", "Horizontal indirect", "pull");
        grille.afficherGrille();
    }
    
}*/
