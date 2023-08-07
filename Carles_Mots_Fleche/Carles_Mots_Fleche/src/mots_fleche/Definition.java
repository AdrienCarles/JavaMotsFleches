package mots_fleche;

public class Definition {
	private String intitule;
	private String reponse;
	private String direction;
	
	/**
	 * Constructeur de la classe Definition.
	 *
	 * @param intitule L'intitulé de la définition.
	 * @param reponse La réponse de la définition.
	 * @param direction La direction de la définition.
	 */
    public Definition(String intitule, String reponse, String direction) {
    	this.setIntitule(intitule);
    	this.setReponse(reponse);
    	this.setDirection(direction);
    }
    
    /**
     * Définit l'intitulé de la définition.
     *
     * @param intitule L'intitulé à définir.
     */
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    
    /**
     * Définit la direction de la définition.
     *
     * @param direction La direction à définir.
     */
    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    /**
     * Définit la réponse de la définition.
     *
     * @param reponse La réponse à définir.
     */
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    
    /**
     * Récupère l'intitulé de la définition.
     *
     * @return L'intitulé de la définition.
     */
    public String getIntitule() {
        return this.intitule;
    }
    
    /**
     * Récupère la réponse de la définition.
     *
     * @return La réponse de la définition.
     */
    public String getReponse() {
        return this.reponse;
    }
    
    /**
     * Récupère la direction de la définition.
     *
     * @return La direction de la définition.
     */
    public String getDirection() {
        return this.direction;
    }

}
