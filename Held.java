
/**
 * @author 
 * @version 
 */
public class Held extends Mensch
{
    // Bezugsobjekte

    // Attribute
    
    
    // Konstruktor
    public Held(int pX,int pY,String pGeschlecht, String pTyp, int pSchadenspunkte)
    {
        super(pX,pY,pGeschlecht,pTyp,pSchadenspunkte);
    }

    // Dienste

    public void gehe(String pRichtung){
        switch (pRichtung){
            case "oben":super.setY(super.getY()-1);
                        break;
            case "rechts":super.setX(super.getX()+1);
                        break;
            case "unten":super.setY(super.getY()+1);
                        break; 
            case "links":super.setX(super.getX()-1);
                        break;
            default: System.out.println("falsche eingabe");
        }
    }
}
