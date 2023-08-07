package mots_fleche;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int action = 0;
		int largeur = 0; int hauteur = 0; int x = 0; int y = 0; int dir = 0; String direction = null; String mot = null; String definition = null;
		
        System.out.println("Entrez la largeur de la grille :");
        largeur = scanner.nextInt();
        System.out.println("Entrez la hauteur de la grille :");
        hauteur = scanner.nextInt();

        ModeleGrille grille = new ModeleGrille(hauteur, largeur);
        grille.afficherGrilleEmpty();
        while(x >= 0 && y >= 0){
            System.out.println("Entrez les coordonnées de la definition (X : lignes, Y : Collones) Valeur negative pour arreter");
            System.out.println("X (compris entre 0 et " + (grille.getHauteur() - 1)  + " :");
            x = scanner.nextInt();
            System.out.println("Y (compris entre 0 et " + (grille.getLargeur() - 1) + " :");
            y = scanner.nextInt();
            System.out.println("Rentrez la direction :");
            System.out.println("1 : Horizontal direct");
            System.out.println("2 : Horizontal indirect");
            System.out.println("3 : Vertical direct");
            System.out.println("4 : Vertical indirect");
            dir = scanner.nextInt();
            direction = grille.getDirectionFromInt(dir);
            if(action != 0) {
            	System.out.println("Mots autorises :");
            	grille.getMotsValid(x,y,grille.getDirectionFromInt(dir));
            }
            System.out.println("Rentrez le mot :");
            scanner.nextLine();
            mot = scanner.nextLine();
            System.out.println("Rentrez la definition du mot :");
            definition = scanner.nextLine();
            grille.setCaseDefinition(x, y, definition, direction, mot);
            grille.afficherGrille();
            System.out.println("Quel action voulez vous effectuer");
            System.out.println("1 = Rentrer une autre definition");
            System.out.println("2 = Consulter les informations d'une case");
            action = scanner.nextInt();
            if(action == 2) {
                System.out.println("Entrez les coordonnées de la case recherche (X : lignes, Y : Collones)");
                System.out.println("X (compris entre 0 et " + (grille.getHauteur() - 1)  + " :");
                x = scanner.nextInt();
                System.out.println("Y (compris entre 0 et " + (grille.getLargeur() - 1) + " :");
                y = scanner.nextInt();
                System.out.println(grille.getCaseValeur(x,y));
                if(grille.getCaseValeur(x,y) == "def simple") {
                	Case caseDef = grille.getCase(x, y);
                	Definition def1 = caseDef.getDefinition1();
                	System.out.println(def1.getIntitule());
                	System.out.println(def1.getReponse());
                	System.out.println(def1.getDirection());
                }else if(grille.getCaseValeur(x,y) == "def double") {
                	Case caseDef = grille.getCase(x, y);
                	Definition def1 = caseDef.getDefinition1();
                	Definition def2 = caseDef.getDefinition2();
                	System.out.println("--- Definition 1 ---");
                	System.out.println(def1.getIntitule());
                	System.out.println(def1.getReponse());
                	System.out.println(def1.getDirection());
                	System.out.println("--- Definition 2 ---");
                	System.out.println(def2.getIntitule());
                	System.out.println(def2.getReponse());
                	System.out.println(def2.getDirection());
                }else if(grille.getCaseValeur(x,y) == "lettre") {
                	Case caseDef = grille.getCase(x, y);
                	System.out.println(caseDef.getLettre());
                }else {
                	System.out.println("Case Vide");
                }
            }
        };

    }
}