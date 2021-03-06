
/**
 * @author tobias
 * @version 
 */
public class Held extends Mensch
{
    // Bezugsobjekte

    // Attribute
    public Gegenstand[] inventar = new Gegenstand[5];
    public Gegenstand hand;
    
    
    // Konstruktor
    public Held(int pX,int pY,String pGeschlecht, String pTyp)
    {
        super(pX,pY,pGeschlecht,pTyp, 0);
         
    }

    // Dienste

    public void gehe(String pRichtung){
        switch (pRichtung){
            case "oben":super.setY(super.getY()-1);
                        //System.out.println("du bist nach oben gegangen");
                        break;
            case "rechts":super.setX(super.getX()+1);
                        //System.out.println("du bist nach rechts gegangen");
                        break;
            case "unten":super.setY(super.getY()+1);
                        //System.out.println("du bist nach unten gegangen");
                        break; 
            case "links":super.setX(super.getX()-1);
                        //System.out.println("du bist nach links gegangen");
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
        int inv=0;
        for(int i=0;i<5;i++){
            inv++;
            if(inventar[i]==null){
                System.out.println("("+inv+") "+ "leer , ");
            }else{
                System.out.println("("+inv+") " + inventar[i].getName() + " , ");
            }
            
        }
    }
    public boolean itemvorhanden(int pSlot){
        boolean antwort = false;
        if(inventar[pSlot]!=null)antwort=true;
        return antwort;
    }
    public void setInventar(int pIndex,Gegenstand pGegenstand){
        inventar[pIndex] = pGegenstand;
    }
    public int getInventarNaechsterSlot(){
        int ergebniss = 0;
        for(int i=0;i<inventar.length;i++){
            if(inventar[i]==null){
                ergebniss = i;
                return ergebniss;
            }
        }
        return ergebniss;
    }
    public Gegenstand getHand(){
        return hand;
    }
    public void setHand(Gegenstand pGegenstand){
        hand = pGegenstand;
    }
    
    public boolean handBesetzt(){
        boolean antwort = false;
        if(hand!=null)antwort = true;
        return antwort;
    }
    
    public String stringHand(){
        return hand.getName();
    }
    public int itemAnWelchemSlot(String suchString){
        
        int ergebnis = -1;
        for(int i=0;i<inventar.length;i++){
            if(itemvorhanden(i)){
                if(inventar[i].getTyp()==suchString)ergebnis = i;
            }
        }
        return ergebnis;
    }
    public Gegenstand itemAnIndex(int pIndex){
        return inventar[pIndex];
    }
}
