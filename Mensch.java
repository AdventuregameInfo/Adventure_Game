
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
        super(pX,pY);
        geschlecht = pGeschlecht;
        typ = pTyp;
    }

    // Dienste

}
