
/**
 * @author 
 * @version 
 */
public class Welt
{
    // Bezugsobjekte

    // Attribute
    private int xLaenge = 50;
    private int yLaenge = 50;
    private Gegenstand[][] weltArray;
   
    
    // Konstruktor
    public Welt()
    {
         weltArray = new Gegenstand[xLaenge][yLaenge];
         weltArray[2][2] = new Schwert(2,2);
    }

    // Dienste

}
