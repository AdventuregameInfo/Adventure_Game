
/**
 * @author 
 * @version 
 */
public class Kampf
{
    // Bezugsobjekte

    // Attribute
    private Mensch spieler;
    private Mensch gegner;
    private boolean kampfAktiv = false;
    // Konstruktor
    public Kampf()
    {

    }

    // Dienste
    public void kaempfen(Mensch pSpieler,Mensch pGegner){
        spieler = pSpieler;
        gegner = pGegner;
        kampfAktiv = true;
        
        
    }
    public void attacke(Mensch pSpieler,int pNummer){
        if(pNummer ==1)System.out.println("attacke1");
        if(pNummer ==2)System.out.println("attacke2");
        if(pNummer ==3)System.out.println("attacke3");
    }
    
    public boolean getKampfAktiv(){
        return kampfAktiv;
    }
}
