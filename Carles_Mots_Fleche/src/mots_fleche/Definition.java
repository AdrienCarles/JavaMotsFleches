package mots_fleche;

public class Definition {
	private String intitule;
	private String reponse;
	private String direction;
	
    public Definition(String intitule, String reponse, String direction) {
    	this.setIntitule(intitule);
    	this.setReponse(reponse);
    	this.setDirection(direction);
    }
    
    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }
    
    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    public void setReponse(String reponse) {
        this.reponse = reponse;
    }
    
    public String getIntitule() {
        return this.intitule;
    }
    
    public String getReponse() {
        return this.reponse;
    }
    
    public String getDirection() {
        return this.direction;
    }

}
