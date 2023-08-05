/*package mots_fleche;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FichierTest {
	
    @Test
    public void testGetWordCountByRegex() {
        Fichier f = new Fichier();
        int count = f.countMotsRegex("^....y.$");
        assertEquals(10, count);
    }
    
    @Test
    public void testGetWordsByRegex() {
    	Fichier f = new Fichier();
        List<String> words = f.getMotsRegex("^....y.$");
        List<String> expectedWords = Arrays.asList("abbaye", "appuye", "balaye", "delaye", "envoye", "essaye", "essuye", "martyr", "rallye", "zlotys");
        assertEquals(expectedWords, words);
    }
}*/
