package mots_fleche;

public class Case {
    private char lettre;
    private Definition definition1;
    private Definition definition2;
    
    public Case() {
    	
    }
    
    public void setDefinition1(String intitule, String reponse, String direction) {
        this.definition1 = new Definition(intitule, reponse, direction);
        
    }
    
    public void setDefinition2(String intitule, String reponse, String direction) {
        this.definition2 = new Definition(intitule, reponse, direction);
    }
    
    public void setLettre(char lettre) {
        this.lettre = lettre;
    }
    
    public Definition getDefinition1() {
        return this.definition1;
    }
    
    public Definition getDefinition2() {
        return this.definition2;
    }
    
    public char getLettre() {
        return this.lettre;
    }
    
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
    
    public boolean verifDirectionDefinition(String direction) {
    	if(this.definition1 != null && this.definition1.getDirection() == direction) {
    		return false;
    	}
    	return true;
    }
    
    public boolean isEmpty() {
        return lettre == '\u0000' && definition1 == null && definition2 == null;
    }
    
    
}