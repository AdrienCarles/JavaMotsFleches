package mots_fleche;

public class Case {
    private char lettre;
    private Definition definition1;
    private Definition definition2;
    
    public Case() {
    	
    }

    /**
     * Définit la première définition de la case.
     *
     * @param intitule L'intitulé de la définition.
     * @param reponse La réponse de la définition.
     * @param direction La direction de la définition.
     */
    public void setDefinition1(String intitule, String reponse, String direction) {
        this.definition1 = new Definition(intitule, reponse, direction);
        
    }
    
    /**
     * Définit la deuxième définition de la case.
     *
     * @param intitule L'intitulé de la définition.
     * @param reponse La réponse de la définition.
     * @param direction La direction de la définition.
     */
    public void setDefinition2(String intitule, String reponse, String direction) {
        this.definition2 = new Definition(intitule, reponse, direction);
    }
    
    /**
     * Définit la lettre de la case.
     *
     * @param lettre La lettre à définir.
     */
    public void setLettre(char lettre) {
        this.lettre = lettre;
    }
    
    /**
     * Récupère la première définition de la case.
     *
     * @return La première définition de la case.
     */
    public Definition getDefinition1() {
        return this.definition1;
    }
    
    /**
     * Récupère la deuxième définition de la case.
     *
     * @return La deuxième définition de la case.
     */
    public Definition getDefinition2() {
        return this.definition2;
    }

    /**
     * Récupère la lettre de la case.
     *
     * @return La lettre de la case.
     */
    public char getLettre() {
        return this.lettre;
    }
    
    /**
     * Récupère la valeur de la définition de la case.
     *
     * @return La valeur de la définition de la case.
     */
    public int getValDefinition() {
        Definition def1 = this.getDefinition1();
        Definition def2 = this.getDefinition2();
        if(def1 != null && def2 != null) {
            if(def1.getReponse() == null && def2.getReponse() == null) {
                return 0;
            } else if(def1.getReponse() != null && def2.getReponse() == null){
                return 1;
            } else if(def1.getReponse() == null && def2.getReponse() != null){
                return 1;
            } else {
                return 2;
            }
        } else if(def1 != null && def1.getReponse() != null) {
            return 1;
        } else if(def2 != null && def2.getReponse() != null) {
            return 1;
        } else {
            return 0;
        }
    }
    
    /**
     * Vérifie si une direction est déjà utilisée pour une définition dans la case.
     *
     * @param direction La direction à vérifier.
     * @return true si la direction n'est pas utilisée, false sinon.
     */
    public boolean verifDirectionDefinition(String direction) {
    	if(this.definition1 != null && this.definition1.getDirection() == direction) {
    		return false;
    	}
    	return true;
    }
    
    /**
     * Vérifie si la case est vide.
     *
     * @return true si la case est vide, false sinon.
     */
    public boolean isEmpty() {
        return lettre == '\u0000' && definition1 == null && definition2 == null;
    }
    
    
}