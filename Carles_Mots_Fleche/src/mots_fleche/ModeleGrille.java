package mots_fleche;

import java.util.ArrayList;

public class ModeleGrille {
	private Case[][] grille;
    private int largeur;
    private int hauteur;
    private String erreur = null;

    /**
     * Constructeur pour créer une grille d'objet Case vide de la taille spécifiée
     * @param hauteur La hauteur de la grille
     * @param largeur La largeur de la grille
     */
    public ModeleGrille(int hauteur, int largeur) {
    	this.setDimensions(largeur , hauteur);
    	this.grille = new Case[this.getHauteur()][this.getLargeur()];
        for (int i = 0; i < this.getHauteur(); i++) {
            for (int j = 0; j < this.getLargeur(); j++) {
            	this.grille[i][j] = new Case();
            }
        }
        
    }
    
    /**
     * Méthode pour définir les dimensions de la grille. 
     * @param largeur La largeur de la grille
     * @param hauteur La hauteur de la grille
     * @throws IllegalArgumentException Si les dimensions de la grille ne sont pas valides
     */
    public void setDimensions(int largeur, int hauteur) {
        if (largeur > 0 && largeur <= 10 && hauteur > 0 && hauteur <= 10) {
            this.largeur = largeur;
            this.hauteur = hauteur;
            
        } else {
        	throw new IllegalArgumentException("Les dimensions de la grille ne sont pas valides.");
        }
    }
    
    /**
     * @return La hauteur de la grille
     */
    public int getHauteur() {
    	return this.hauteur;
    }
    
    /**
     * @return La largeur de la grille
     */
    public int getLargeur() {
    	return this.largeur;
    }
    
    /**
     * Obtient la case à une position spécifique dans la grille
     * @param x La position x de la case
     * @param y La position y de la case
     * @return La case à la position spécifiée
     */
    public Case getCase(int x, int y) {
    	return this.grille[x][y];
    }
    
    public void setCaseDefinition(int x, int y, String intitule, String direction, String reponse) {
    	if(this.grille[x][y].verifDirectionDefinition(direction) && this.verifPosition(x, y)) {
    		if(this.verifMot(x, y, direction, reponse)) {
            	if(this.getCaseValeur(x,y).equals("def double") || this.getCaseValeur(x,y).equals("lettre")) {
            		this.erreur = "Case déjà remplie";
            	}else if(this.getCaseValeur(x,y).equals("def simple")) {
                	this.grille[x][y].setDefinition2(intitule, reponse, direction);
                	placeLettresGrid(x, y, direction, reponse);
            	} else {
            		this.grille[x][y].setDefinition1(intitule, reponse, direction);
                	placeLettresGrid(x, y, direction, reponse);
            	}
    		}
    	}else {
    		this.erreur = "Il y a deja une definition dans cette direction";
    	}
    }
    // Ne sert qu'a l'affichge
    public void placeLettresGrid(int x, int y, String direction, String reponse) {
        for (int i = 0; i < reponse.length(); i++) {
            switch (direction) {
                case "Horizontal direct":
                    y += 1;
                    break;
                case "Horizontal indirect":
                    if(i == 0) {
                        x += 1;
                    } else {
                        y += 1;
                    }
                    break;
                case "Vertical direct":
                    x += 1;
                    break;
                case "Vertical indirect":
                    if(i == 0) {
                        y += 1;
                    } else {
                        x += 1;
                    }
                    break;
            }

            if (x >= 0 && x < this.getHauteur() && y >= 0 && y < this.getLargeur()) {
            	reponse = reponse.toLowerCase();
                this.grille[x][y].setLettre(reponse.charAt(i));
            } else {
            	this.erreur = "Le mot ne rentre pas dans le tableau";
                break;
            }
        }
    }
    
    public boolean verifPosition(int x, int y) {
        if(x < 0 || x > this.getHauteur() - 1) {
        	this.erreur = "Coordonnées invalides";
        	return false;
        }
        if(y < 0 || y > this.getLargeur() - 1) {
        	this.erreur = "Coordonnées invalides";
        	return false;
        }
        return true;
    }
    
    public boolean verifMot(int x, int y, String direction, String mot) {
        if (mot.isEmpty() == true) {
        	this.erreur = "Le mot ne peut pas être vide";
            return false;
        }
        for (int i = 0; i < mot.length(); i++) { 
        	
        switch (direction) {
        case "Horizontal direct":
            y += 1;
            break;
        case "Horizontal indirect":
            if(i == 0) {
                x += 1;
            } else {
                y += 1;
            }
            break;
        case "Vertical direct":
            x += 1;
            break;
        case "Vertical indirect":
            if(i == 0) {
                y += 1;
            } else {
                x += 1;
            }
            break;
        }
		if (x < 0 || x >= this.getHauteur() || y < 0 || y >= this.getLargeur()) {
			this.erreur = "Le mot ne rentre pas dans le tableau verifMot";
			return false;
		}

		if (this.grille[x][y].getLettre() != '\u0000') {
			if (this.grille[x][y].getLettre() != mot.charAt(i)) {
				this.erreur = "La lettre {" + mot.charAt(i) + "} du mot ne correspond pas à la lettre {" + this.grille[x][y].getLettre() + "} dans la case";
				return false;
			}
		}
	}
	return true;
    }
    
    public int getCountCasesDispo(int x, int y, String direction) {
    	int caseDispo = 0;
    	switch(direction) {
    	case "Horizontal direct":
    		for(int i = y + 1; i < this.getLargeur(); i++) {
    			if(this.getCaseValeur(x, i) == "vide" || this.getCaseValeur(x, i) == "lettre") {
    				caseDispo++;
    			}
    		}
            break;
        case "Horizontal indirect":
        	for(int i = y; i < this.getLargeur(); i++) {
        		if(this.getCaseValeur(x + 1, i) == "vide" || this.getCaseValeur(x + 1, i) == "lettre") {
                	caseDispo++;
                }
        	}
            break;
        case "Vertical direct":
        	for(int i = x + 1; i < this.getHauteur(); i++) {
        		if(this.getCaseValeur(i, y) == "vide" || this.getCaseValeur(i, y) == "lettre") {
                	caseDispo++;
                }
        	}
            break;
        case "Vertical indirect":
        	for(int i = x; i < this.getHauteur(); i++) {
        		if(this.getCaseValeur(i, y + 1) == "vide" || this.getCaseValeur(i, y + 1) == "lettre") {
                	caseDispo++;
                }
        	}
    	}
    	return caseDispo;
    }
    
    public String getCaseRegex(int x, int y, String direction) {
    	int caseDispo = this.getCountCasesDispo(x, y, direction);
    	StringBuilder regex = new StringBuilder("^");
    	switch(direction) {
    	case "Horizontal direct":
    		for(int i = y + 1; i <= caseDispo; i++) {
    			if(this.grille[x][i].getLettre() != '\u0000') {
    				regex.append(this.grille[x][i].getLettre());
    			}else {
    				regex.append(".");
    			}
    		}
            break;
        case "Horizontal indirect":
        	for(int i = y; i < caseDispo; i++) {
    			if(this.grille[x + 1][i].getLettre() != '\u0000') {
    				regex.append(this.grille[x + 1][i].getLettre());
    			}else {
    				regex.append(".");
    			}
        	}
            break;
        case "Vertical direct":
        	for(int i = x + 1; i <= caseDispo; i++) {
    			if(this.grille[i][y].getLettre() != '\u0000') {
    				regex.append(this.grille[i][y].getLettre());
    			}else {
    				regex.append(".");
    			}
        	}
            break;
        case "Vertical indirect":
        	for(int i = x; i <= caseDispo; i++) {
        		if(this.grille[i][y + 1].getLettre() != '\u0000') {
    				regex.append(this.grille[i][y + 1].getLettre());
    			}else {
    				regex.append(".");
    			}
        	}
    	}
    	regex.append("$");
    	return regex.toString();
    }
    
	public void removeDefinition(int x, int y, String direction) {
		if (verifPosition(x, y)) {
			Definition def1 = this.grille[x][y].getDefinition1();
			Definition def2 = this.grille[x][y].getDefinition2();
			if (direction.equals(def1.getDirection())) {
				this.grille[x][y].setDefinition1(null, null, null);
				this.removeMots(x, y, def1);
			} else if (direction.equals(def2.getDirection())) {
				this.grille[x][y].setDefinition2(null, null, null);
				this.removeMots(x, y, def2);
			} else {
				this.erreur = "Aucune définition dans cette direction";
			}
		} else {
			this.erreur = "Coordonnées invalides";
		}
	}
	
	public void removeMots(int x, int y, Definition def) {
		String direction = def.getDirection();
	    for (int i = 0; i < def.getReponse().length(); i++) {
	        switch (direction) {
	            case "Horizontal direct":
	                y += 1;
	                break;
	            case "Horizontal indirect":
	                if(i == 0) {
	                    x += 1;
	                } else {
	                    y += 1;
	                }
	                break;
	            case "Vertical direct":
	                x += 1;
	                break;
	            case "Vertical indirect":
	                if(i == 0) {
	                    y += 1;
	                } else {
	                    x += 1;
	                }
	                break;
	        }

	        if (x >= 0 && x < this.getHauteur() && y >= 0 && y < this.getLargeur()) {
	            char lettre = this.grille[x][y].getLettre();
	            if (!isLettreInOtherDefinition(lettre, x, y, def)) {
	                this.grille[x][y].setLettre('\u0000');
	            }
	        }
	    }
	}
	
    /**
     * Vérifie si une lettre donnée est présente dans une autre définition (qui n'est pas la définition passée en paramètre) dans la grille.
     *
     * @param lettre La lettre à vérifier.
     * @param x La coordonnée x de la case qui contient la définition actuelle.
     * @param y La coordonnée y de la case qui contient la définition actuelle.
     * @param def La définition actuelle qui doit être exclue lors de la vérification.
     * @return Retourne vrai si la lettre est présente dans une autre définition, faux sinon.
     */
	public boolean isLettreInOtherDefinition(char lettre, int x, int y, Definition def) {
	    for(int i = 0; i < this.getHauteur(); i++) {
	        for(int j = 0; j < this.getLargeur(); j++) {
	            Case caseCourante = this.grille[i][j];
	            if (caseCourante.getDefinition1() != null && caseCourante.getDefinition1() != def) {
	                String reponse = caseCourante.getDefinition1().getReponse();
	                if (reponse != null && reponse.indexOf(lettre) != -1) {
	                    return true;
	                }
	            }
	            if (caseCourante.getDefinition2() != null && caseCourante.getDefinition2() != def) {
	                String reponse = caseCourante.getDefinition2().getReponse();
	                if (reponse != null && reponse.indexOf(lettre) != -1) {
	                    return true;
	                }
	            }
	        }
	    }
	    return false;
	}

    /**
     * Obtient le statut de la case à une position donnée (x,y) sur la grille.
     * Le statut peut être l'un des suivants : "vide", "lettre", "def simple", "def double".
     * 
     * @param x La coordonnée x de la case à vérifier.
     * @param y La coordonnée y de la case à vérifier.
     * @return Le statut de la case. Peut retourner null si une erreur se produit.
     */
    public String getCaseValeur(int x, int y) {
    	if(this.grille[x][y].getLettre() == '\u0000' && this.grille[x][y].getDefinition1() == null && this.grille[x][y].getDefinition2() == null) {
    		return "vide";
    	}else if(this.grille[x][y].getLettre() != '\u0000') {
    		return "lettre";
    	}else if(this.grille[x][y].getDefinition1() != null && this.grille[x][y].getDefinition2() == null) {
    		return "def simple";
    	}else if(this.grille[x][y].getDefinition2() != null) {
    		return "def double";
    	}else {
    		this.erreur = "Erreur dans la récupération de la case.";
    		return null;
    	}
    }
    
    /**
     * Recherche les mots valides basés sur une position donnée (x,y), une direction et un fichier de mots.
     * Utilise un motif regex dérivé de la case et de la direction, et cherche les correspondances dans le fichier.
     * Imprime les mots valides à la console.
     * 
     * @param x La coordonnée x de la case de départ.
     * @param y La coordonnée y de la case de départ.
     * @param direction La direction dans laquelle chercher des mots. Les valeurs possibles sont déterminées par la méthode getDirectionFromInt.
     */
    public void getMotsValid(int x, int y, String direction) {
    	String regex = null; ArrayList<String> motsValides = new ArrayList<>();
    	Fichier f = new Fichier();
    	regex = this.getCaseRegex(x,y, direction);
    	motsValides = f.getMotsRegex(regex);
    	System.out.println(motsValides);
    }
    
    /**
     * Transforme un nombre entier en une direction sous forme de chaîne de caractères.
     * @param d Un nombre entier représentant la direction. Les valeurs possibles sont :
     *          1 pour "Horizontal direct",
     *          2 pour "Horizontal indirect",
     *          3 pour "Vertical direct",
     *          4 pour "Vertical indirect".
     * @return La direction sous forme de chaîne de caractères correspondant au nombre d'entrée.
     *         Si le nombre ne correspond à aucune direction connue, retourne "Direction inconnue".
     */
    public String getDirectionFromInt(int d) {
        switch (d) {
        case 1 :
        	return "Horizontal direct";
        case 2 :
        	return "Horizontal indirect";
        case 3 :
        	return "Vertical direct";
        case 4 : 
        	return "Vertical indirect";
        default :
        	return "Direction inconnus";
        }
    }

   
    /**
     * Méthode pour afficher la grille vide
     */
    public void afficherGrilleEmpty() {
		System.out.println("------- Grille ------");
		for (int i = 0; i < this.getHauteur(); i++) {
			for (int j = 0; j < this.getLargeur(); j++) {
				System.out.print("|");
				if (this.grille[i][j].getValDefinition() != 0) {
					System.out.print(this.grille[i][j].getValDefinition());
				} else {
					System.out.print(" ");
				}
				System.out.print(this.grille[i][j].getLettre());
				System.out.print("|");
			}
			System.out.println();
		}
    }
    /**
     * Méthode pour afficher la grille
     */
    public void afficherGrille() {
    	if(this.erreur == null) {
    		System.out.println("------- Grille ------");
        	for (int i = 0; i < this.getHauteur(); i++) {
        		for (int j = 0; j < this.getLargeur(); j++) {
        			System.out.print("|");
        			if(this.grille[i][j].getValDefinition() != 0) {
        				System.out.print(this.grille[i][j].getValDefinition());
        			}else {
        				System.out.print(" ");
        			}
        			System.out.print(this.grille[i][j].getLettre());
        			System.out.print("|");
        		}
        		System.out.println();
        	}
    	}else {
    		System.out.println("Erreur : "+ this.erreur);
    		this.erreur = null;
    	}
    }
}
