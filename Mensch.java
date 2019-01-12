
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
   


    
    // Konstruktor
    public Mensch(int pX,int pY,String pGeschlecht, String pTyp)
    {
        super(pX,pY,"Mensch","Mensch");
        geschlecht = pGeschlecht;
        typ = pTyp;
        hp = 100;
        
        
    }

    // Dienste
    
    public int getHp(){
        return hp;
    }
    public void setHp(int pHp){
        hp = pHp;
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
