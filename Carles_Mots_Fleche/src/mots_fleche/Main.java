package mots_fleche;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
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
            //grille.getMotsValid(x,y,grille.getDirectionFromInt(dir));
            System.out.println("Rentrez le mot :");
            scanner.nextLine();
            mot = scanner.nextLine();
            /*System.out.println("Rentrez la definition du mot :");
            scanner.nextLine();
            definition = scanner.nextLine();*/
            grille.setCaseDefinition(x, y, definition, direction, mot);
            System.out.println(grille.getCaseRegex(4,0,"Horizontal indirect"));
            grille.afficherGrille();
        };

    }
}