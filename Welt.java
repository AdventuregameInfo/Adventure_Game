
/**
 * @author 
 * @version 
 */
public class Welt
{
    // Bezugsobjekte

    // Attribute
    private int xLaenge = 51;
    private int yLaenge = 51;
    public Gegenstand[][] weltArray;
 
   
    
    // Konstruktor
    public Welt()
    {
         weltArray = new Gegenstand[xLaenge][yLaenge];
         for(int i=0;i<51;i++){
                for(int z=0;z<51;z++){
                    weltArray[i][z] = new Weg(i,z);
                }
            }
         for(int i=0;i<51;i++){
             weltArray[i][0] = new Wand(i,0);
             weltArray[i][50] = new Wand(i,50);
            }
         for(int i=0;i<51;i++){
             weltArray[0][i] = new Wand(0,i);
             weltArray[50][i] = new Wand(50,i);
            }
         
             weltArray[25][24] = new Schwert(25,26);
         //      weltArray[25][24] = new Mensch(25,24,"männlich","Dorfbewohner",10);
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
