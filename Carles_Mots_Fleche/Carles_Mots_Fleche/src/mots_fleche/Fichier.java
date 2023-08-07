package mots_fleche;

import java.io.BufferedReader;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Fichier {
	
	private static final String FICHIER = "/liste_francais.txt";
	private ArrayList <String> listeDeMots = null;
	
	/**
	 * Constructeur de la classe Fichier.
	 * Il initialise la liste de mots et ouvre le fichier.
	 */
	public Fichier() {
		super();
		listeDeMots = new ArrayList<>();
		ouvrirFichier();
		
	}
	
	/**
	 * Ouvre le fichier et lit les mots ligne par ligne.
	 * Les mots sont ensuite ajoutés à la liste de mots.
	 */
	private void ouvrirFichier(){
		try{
			InputStream flux = Fichier.class.getResourceAsStream(FICHIER);
			InputStreamReader lecture = new InputStreamReader(flux, StandardCharsets.UTF_8);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;
			while ((ligne=buff.readLine())!=null){
				listeDeMots.add(ligne);
			}
			buff.close(); 
		}		
		catch (Exception e){
			System.out.println(e.toString());
		}
	}

	
	/**
	 * Affiche tous les mots présents dans la liste de mots.
	 */
	public void printMots(){
		System.out.println("affichage des mots présents dans le dictionnaire");
		for (String m  : listeDeMots) {
			System.out.println(m);
		}
	}
		
	/**
	 * Affiche les mots de la liste qui commencent par une certaine chaîne.
	 *
	 * @param d La chaîne par laquelle les mots doivent commencer.
	 */
	public void printMotsDebut(String d){
			System.out.printf("affichage des mots commençant par %s%n", d);
			for (String m  : listeDeMots) {
				if (m.startsWith(d)){
					System.out.println(m);
				}
			}
	}
	
	/**
	 * Compte le nombre de mots dans la liste qui correspondent à une expression régulière donnée.
	 *
	 * @param regex L'expression régulière à laquelle les mots doivent correspondre.
	 * @return Le nombre de mots correspondant à l'expression régulière.
	 */
	public int countMotsRegex(String regex){
		int count = 0;
		for (String m  : listeDeMots) {
	        if(m.matches(regex)) {
	        	count++;
	        }
		}
		return count;
	}
	
	/**
	 * Récupère une liste de mots qui correspondent à une expression régulière donnée.
	 *
	 * @param regex L'expression régulière à laquelle les mots doivent correspondre.
	 * @return Une liste de mots correspondant à l'expression régulière.
	 */
	public ArrayList<String> getMotsRegex(String regex) {
		ArrayList<String> motsValides = new ArrayList<>();
	    for (String m : listeDeMots) {
	        if(m.matches(regex)) {
	            motsValides.add(m);
	        }
	    }
	    return motsValides;
	}

		

}