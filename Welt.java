
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
    public Gegenstand[][] weltArray;
 
   
    
    // Konstruktor
    public Welt()
    {
         weltArray = new Gegenstand[xLaenge][yLaenge];
         for(int i=0;i<50;i++){
                for(int z=0;z<50;z++){
                    weltArray[i][z] = new Weg(i,z);
                }
            }
         weltArray[2][2] = new Schwert(2,2);
         weltArray[4][4] = new Mensch(4,4,"männlich","Monster",10);
         
         
         
             }

    // Dienste

}
