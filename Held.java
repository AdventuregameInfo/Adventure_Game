
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
                        System.out.println("du bist nach oben gegangen");
                        break;
            case "rechts":super.setX(super.getX()+1);
                        System.out.println("du bist nach rechts gegangen");
                        break;
            case "unten":super.setY(super.getY()+1);
                        System.out.println("du bist nach unten gegangen");
                        break; 
            case "links":super.setX(super.getX()-1);
                        System.out.println("du bist nach links gegangen");
                        break;
            default: System.out.println("falsche eingabe");
        }
    }
    public int getX(){
        return super.getX();
    }
    public int getY(){
        return super.getY();
    }
}
