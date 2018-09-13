
/**
 * @author 
 * @version 
 */
public class Mensch extends Gegenstand
{
    // Bezugsobjekte

    // Attribute
    private String typ;
    private String geschlecht;
    private int hp;
    private int schadenspunkte;


    
    // Konstruktor
    public Mensch(int pX,int pY,String pGeschlecht, String pTyp, int pSchadenspunkte)
    {
        super(pX,pY,"Mensch");
        geschlecht = pGeschlecht;
        typ = pTyp;
        hp = 100;
        schadenspunkte = pSchadenspunkte;
    }

    // Dienste
    
    public int getHp(){
        return hp;
    }
    public void setHp(int pHp){
        hp = pHp;
    }
    public int getSchadenspunkte(){
        return schadenspunkte;
    }
    public void setSchadenspunkte(int pSchadenspunkte){
        schadenspunkte = pSchadenspunkte;
    }
    public String getTyp(){
        return typ;
    }
    public void setTyp(String pTyp){
        typ = pTyp;
    }
    public String getGeschlecht(){
        return geschlecht;
    }
    public void setGeschlecht(String pGeschlecht){
        geschlecht = pGeschlecht;
    }
    public int getX(){
        return super.getXPosition();
    }
    public int getY(){
        return super.getYPosition();
    }
    public void setX(int pX){
        super.setX(pX);
       
    }
    public void setY(int pY){
        super.setY(pY);
    }
}
