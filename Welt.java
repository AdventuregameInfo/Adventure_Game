
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
         weltArray[25][26] = new Schwert(25,26);
         //weltArray[25][24] = new Mensch(25,24,"männlich","Dorfbewohner",10);
         weltArray[23][25]= new Wand(23,25);
         weltArray[24][25]= new Wand(24,25);
         weltArray[26][25]= new Wand(26,25);
         weltArray[27][25]= new Wand(27,25);
         weltArray[23][27]= new Wand(23,27);
         weltArray[24][27]= new Wand(24,27);
         weltArray[25][27]= new Wand(25,27);
         weltArray[26][27]= new Wand(26,27);
         weltArray[27][27]= new Wand(27,27);
         weltArray[23][26]= new Wand(23,26);
         weltArray[27][26]= new Wand(27,26);
         
         
             }

    // Dienste

}
