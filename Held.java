
/**
 * @author 
 * @version 
 */
public class Held extends Mensch
{
    // Bezugsobjekte

    // Attribute
    public Gegenstand[] inventar = new Gegenstand[5];
    
    
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
    public void getInventar(){
        System.out.println("In ihrem Inventar liegen : ");
        for(int i=0;i<5;i++){
            if(inventar[i]==null){
                System.out.println("leer , ");
            }else{
                System.out.println(inventar[i].getName() + " , ");
            }
            
        }
    }
    public void setInventar(int pIndex,Gegenstand pGegenstand){
        inventar[pIndex] = pGegenstand;
    }
}
