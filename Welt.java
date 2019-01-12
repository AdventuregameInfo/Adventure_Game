
/**
 * @author julius, elias
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
             weltArray[i][0] = new Wand(i,0,"Wand");
             weltArray[i][50] = new Wand(i,50,"Wand");
            }
         for(int i=0;i<51;i++){
             weltArray[0][i] = new Wand(0,i,"Wand");
             weltArray[50][i] = new Wand(50,i,"Wand");
            }
         
             
              
               
             }
             
             
        public boolean itemVorhanden(int pX,int pY){
        boolean ergebniss = false;
        int x=pX;
        int y=pY;
        
        switch(weltArray[x][y].getName()){
            case "Schwert":ergebniss = true;
                           break;
            case "Boot":   ergebniss = true;
                           break;
            default:       ergebniss = false;
                           break;
        }
        return ergebniss;
    } 
    // Dienste
        public void erstelleWelteins(){
            //x=1
         weltArray[0][0] = new Wand(0,0,"Baum");
         weltArray[0][1] = new Wand(0,1,"Baum");
         weltArray[0][2] = new Wand(0,2,"Baum");
         weltArray[0][3] = new Wand(0,3,"Baum");
         weltArray[0][4] = new Wand(0,4,"Baum");
         weltArray[0][5] = new Wand(0,5,"Baum");
         weltArray[0][6] = new Wand(0,6,"Baum");
         weltArray[0][7] = new Wand(0,7,"Baum");
         weltArray[0][8] = new Wand(0,8,"Baum");
         weltArray[0][9] = new Wand(0,9,"Baum");
         weltArray[0][10] = new Wand(0,10,"Baum");
         weltArray[0][11] = new Wand(0,11,"Baum");
         weltArray[0][12] = new Wand(0,12,"Baum");
         weltArray[0][26] = new Wand(0,26,"Fluss");
         weltArray[0][27] = new Wand(0,27,"Fluss");
         weltArray[0][45] = new Wand(0,45,"Wand");
         weltArray[0][46] = new Wand(0,46,"Wand");
         weltArray[0][47] = new Wand(0,47,"Wand");
         //x=2
         weltArray[1][0] = new Wand(1,0,"Baum");
         weltArray[1][1] = new Wand(1,1,"Baum");
         weltArray[1][2] = new Wand(1,2,"Baum");
         weltArray[1][6] = new Wand(1,6,"Baum");
         weltArray[1][7] = new Wand(1,7,"Baum");
         weltArray[1][8] = new Wand(1,8,"Baum");
         weltArray[1][9] = new Wand(1,9,"Baum");
         weltArray[1][10] = new Wand(1,10,"Baum");
         weltArray[1][11] = new Wand(1,11,"Baum");
         weltArray[1][12] = new Wand(1,12,"Baum");
         weltArray[1][27] = new Wand(1,27,"Fluss");
         weltArray[1][28] = new Wand(1,28,"Fluss");
         weltArray[1][45] = new Wand(1,45,"Wand");
         weltArray[1][46] = new Wand(1,46,"Wand");
         weltArray[1][47] = new Wand(1,47,"Wand");
         weltArray[1][48] = new Wand(1,48,"Wand");
         weltArray[1][49] = new Wand(1,49,"Wand");
         //x=3
         weltArray[2][0] = new Wand(2,0,"Baum");
         weltArray[2][1] = new Wand(2,1,"Baum");
         weltArray[2][2] = new Wand(2,2,"Baum");
         weltArray[2][6] = new Wand(2,6,"Baum");
         weltArray[2][7] = new Wand(2,7,"Baum");
         weltArray[2][8] = new Wand(2,8,"Baum");
         weltArray[2][9] = new Wand(2,9,"Baum");
         weltArray[2][11] = new Wand(2,11,"Baum");
         weltArray[2][12] = new Wand(2,12,"Baum");
         weltArray[2][27] = new Wand(2,27,"Fluss");
         weltArray[2][28] = new Wand(2,28,"Fluss");
         weltArray[2][29] = new Wand(2,29,"Fluss");
         weltArray[2][35] = new Wand(2,35,"Fluss");
         weltArray[2][36] = new Wand(2,36,"Fluss");
         weltArray[2][37] = new Wand(2,37,"Fluss");
         weltArray[2][45] = new Wand(2,45,"Wand");
         weltArray[2][46] = new Wand(2,46,"Wand");
         weltArray[2][47] = new Wand(2,47,"Wand");
         weltArray[2][48] = new Wand(2,48,"Wand");
         weltArray[2][49] = new Wand(2,49,"Wand");
         //x=4 
         weltArray[3][0] = new Wand(3,0,"Baum");
         weltArray[3][1] = new Wand(3,1,"Baum");
         weltArray[3][2] = new Wand(3,2,"Baum");
         weltArray[3][11] = new Wand(3,11,"Baum");
         weltArray[3][12] = new Wand(3,12,"Baum");
         weltArray[3][27] = new Wand(3,27,"Fluss");
         weltArray[3][28] = new Wand(3,28,"Fluss");
         weltArray[3][29] = new Wand(3,29,"Fluss");
         weltArray[3][30] = new Wand(3,30,"Fluss");
         weltArray[3][34] = new Wand(3,34,"Fluss");
         weltArray[3][35] = new Wand(3,35,"Fluss");
         weltArray[3][36] = new Wand(3,36,"Fluss");
         weltArray[3][37] = new Wand(3,37,"Fluss");
         weltArray[3][38] = new Wand(3,38,"Fluss");
         weltArray[3][45] = new Wand(3,45,"Wand");
         weltArray[3][46] = new Wand(3,46,"Wand");
         weltArray[3][47] = new Wand(3,47,"Wand");
         weltArray[3][48] = new Wand(3,48,"Wand");
         weltArray[3][49] = new Wand(3,49,"Wand");

         //x=5
         weltArray[4][0] = new Wand(4,0,"Baum");
         weltArray[4][1] = new Wand(4,1,"Baum");
         //weltArray[4][3] = new Schwert(4,3);//Schwert
         weltArray[4][7] = new Wand(4,7,"Baum");
         weltArray[4][29] = new Wand(4,29,"Fluss");
         weltArray[4][30] = new Wand(4,30,"Fluss");
         weltArray[4][31] = new Wand(4,31,"Fluss");
         weltArray[4][33] = new Wand(4,33,"Fluss");
         weltArray[4][34] = new Wand(4,34,"Fluss");
         weltArray[4][35] = new Wand(4,35,"Fluss");
         weltArray[4][37] = new Wand(4,37,"Fluss");
         weltArray[4][38] = new Wand(4,38,"Fluss");
         weltArray[4][39] = new Wand(4,39,"Fluss");
         weltArray[4][45] = new Wand(4,45,"Burgmauer");
         weltArray[4][46] = new Wand(4,46,"Burgmauer");
         //x=6
         weltArray[5][0] = new Wand(5,0,"Baum");
         weltArray[5][1] = new Wand(5,1,"Baum");
         weltArray[5][13] = new Wand(5,13,"Baum");
         weltArray[5][29] = new Wand(5,29,"Fluss");
         weltArray[5][30] = new Wand(5,30,"Fluss");
         weltArray[5][31] = new Wand(5,31,"Fluss");
         weltArray[5][32] = new Wand(5,32,"Fluss");
         weltArray[5][33] = new Wand(5,33,"Fluss");
         weltArray[5][34] = new Wand(5,34,"Fluss");
         weltArray[5][38] = new Wand(5,38,"Fluss");
         weltArray[5][39] = new Wand(5,39,"Fluss");
         weltArray[5][44] = new Mensch(5,44,"Weiblich","Dorfbewohner",0);
         weltArray[5][45] = new Wand(5,45,"Burgmauer");
         weltArray[5][46] = new Wand(5,46,"Burgmauer");
         //x=7
         weltArray[6][1] = new Wand(6,1,"Baum");
         weltArray[6][2] = new Wand(6,2,"Baum");
         weltArray[6][7] = new Wand(6,7,"Baum");
         weltArray[6][8] = new Wand(6,8,"Baum");
         weltArray[6][10] = new Wand(6,10,"Baum");
         weltArray[6][11] = new Wand(6,11,"Baum");
         weltArray[6][31] = new Wand(6,31,"Fluss");
         weltArray[6][32] = new Wand(6,32,"Fluss");
         weltArray[6][33] = new Wand(6,33,"Fluss");
         weltArray[6][37] = new Wand(6,37,"Fluss");
         weltArray[6][38] = new Wand(6,38,"Fluss");
         weltArray[6][39] = new Wand(6,39,"Fluss");
         weltArray[6][45] = new Tuer(6,45);//Tor zur GloriousCastle
         //weltArray[6][48] = new Armbrust(6,48);
         //x=8
         weltArray[7][1] = new Wand(7,1,"Baum");
         weltArray[7][2] = new Wand(7,2,"Baum");
         weltArray[7][7] = new Wand(7,7,"Baum");
         weltArray[7][8] = new Wand(7,8,"Baum");
         weltArray[7][10] = new Wand(7,10,"Baum");
         weltArray[7][11] = new Wand(7,11,"Baum");
         weltArray[7][36] = new Wand(7,36,"Fluss");
         weltArray[7][37] = new Wand(7,37,"Fluss");
         weltArray[7][38] = new Wand(7,38,"Fluss");
         weltArray[7][45] = new Wand(7,45,"Burgmauer");
         weltArray[7][46] = new Wand(7,46,"Burgmauer");
         //x=9
         weltArray[8][1] = new Wand(8,1,"Baum");
         weltArray[8][35] = new Wand(8,35,"Fluss");
         weltArray[8][36] = new Wand(8,36,"Fluss");
         weltArray[8][37] = new Wand(8,37,"Fluss");
         weltArray[8][45] = new Wand(8,45,"Burgmauer");
         weltArray[8][46] = new Wand(8,46,"Burgmauer");
         //x=10
         weltArray[9][1] = new Wand(9,1,"Baum");
         weltArray[9][4] = new Wand(9,4,"Baum");
         weltArray[9][5] = new Wand(9,5,"Baum");
         weltArray[9][11] = new Wand(9,11,"Baum");
         weltArray[9][33] = new Wand(9,33,"Fluss");
         weltArray[9][34] = new Wand(9,34,"Fluss");
         weltArray[9][35] = new Wand(9,35,"Fluss");
         weltArray[9][44] = new Wand(9,44,"Fluss");
         weltArray[9][45] = new Wand(9,45,"Burgmauer");
         weltArray[9][46] = new Wand(9,46,"Burgmauer");
         weltArray[9][47] = new Wand(9,47,"Burgmauer");
         weltArray[9][48] = new Wand(9,48,"Burgmauer");
         //x=11
         weltArray[10][1] = new Wand(10,1,"Baum");
         weltArray[10][4] = new Wand(10,4,"Baum");
         weltArray[10][5] = new Wand(10,5,"Baum");
         weltArray[10][8] = new Wand(10,8,"Baum");
         weltArray[10][9] = new Wand(10,9,"Baum");
         weltArray[10][34] = new Wand(10,34,"Fluss");
         weltArray[10][35] = new Wand(10,35,"Fluss");
         weltArray[10][44] = new Wand(10,44,"Fluss");
         weltArray[10][45] = new Wand(10,45,"Burgmauer");
         weltArray[10][46] = new Wand(10,46,"Burgmauer");
         weltArray[10][47] = new Wand(10,47,"Burgmauer");
         weltArray[10][48] = new Wand(10,48,"Burgmauer");
         //x=12
         weltArray[11][1] = new Wand(11,1,"Baum");
         weltArray[11][8] = new Wand(11,8,"Baum");
         weltArray[11][9] = new Wand(11,9,"Baum");
         weltArray[11][21] = new Wand(11,21,"Baum");
         weltArray[11][22] = new Wand(11,22,"Baum");
         weltArray[11][34] = new Wand(11,34,"Fluss");
         weltArray[11][35] = new Wand(11,35,"Fluss");
         weltArray[11][36] = new Wand(11,36,"Fluss");
         weltArray[11][38] = new Wand(11,38,"Fluss");
         weltArray[11][39] = new Wand(11,39,"Fluss");
         weltArray[11][44] = new Wand(11,44,"Fluss");
         weltArray[11][45] = new Wand(11,45,"Burgmauer");
         weltArray[11][46] = new Wand(11,46,"Burgmauer");
         //x=13
         weltArray[12][3] = new Wand(12,3,"Baum");
         weltArray[12][5] = new Wand(12,5,"Baum");
         weltArray[12][6] = new Wand(12,6,"Baum");
         weltArray[12][20] = new Wand(12,20,"Baum");
         weltArray[12][21] = new Wand(12,21,"Baum");
         weltArray[12][22] = new Wand(12,22,"Baum");
         weltArray[12][23] = new Wand(12,23,"Baum");
         weltArray[12][35] = new Wand(12,35,"Fluss");
         weltArray[12][36] = new Wand(12,36,"Fluss");
         weltArray[12][37] = new Wand(12,37,"Fluss");
         weltArray[12][38] = new Wand(12,38,"Fluss");
         weltArray[12][39] = new Wand(12,39,"Fluss");
         weltArray[12][40] = new Wand(12,40,"Fluss");
         weltArray[12][41] = new Wand(12,41,"Fluss");
         //x=14         
         weltArray[13][0] = new Wand(13,0,"Baum");
         weltArray[13][5] = new Wand(13,5,"Baum");
         weltArray[13][6] = new Wand(13,6,"Baum");
         weltArray[13][19] = new Wand(13,19,"Baum");
         weltArray[13][23] = new Wand(13,23,"Baum");
         weltArray[13][36] = new Wand(13,36,"Fluss");
         weltArray[13][37] = new Wand(13,37,"Fluss");
         weltArray[13][40] = new Wand(13,40,"Fluss");
         weltArray[13][41] = new Wand(13,41,"Fluss");
         //x=15
         weltArray[14][0] = new Wand(14,0,"Baum");
         weltArray[14][2] = new Wand(14,2,"Baum");
         weltArray[14][3] = new Wand(14,3,"Baum");
         weltArray[14][4] = new Wand(14,4,"Baum");
         weltArray[14][20] = new Wand(14,20,"Baum");
         weltArray[14][23] = new Wand(14,23,"Baum");
         weltArray[14][24] = new Wand(14,24,"Baum");
         weltArray[14][41] = new Wand(14,41,"Fluss");
         weltArray[14][43] = new Wand(14,43,"Fluss");
         //x=16
         weltArray[15][0] = new Wand(15,0,"Baum");
         weltArray[15][2] = new Wand(15,2,"Baum");
         weltArray[15][3] = new Wand(15,3,"Baum");
         weltArray[15][21] = new Wand(15,21,"Baum");
         weltArray[15][22] = new Wand(15,22,"Baum");
         weltArray[15][41] = new Wand(15,41,"Fluss");
         weltArray[15][44] = new Wand(15,44,"Fluss");
         //x=17
         weltArray[16][0] = new Wand(16,0,"Baum");
         weltArray[16][5] = new Wand(16,5,"Baum");
         weltArray[16][6] = new Wand(16,6,"Baum");
         weltArray[16][43] = new Wand(16,43,"Fluss");
         weltArray[16][44] = new Wand(16,44,"Fluss");
         //x=18
         weltArray[17][0] = new Wand(17,0,"Baum");
         weltArray[17][5] = new Wand(17,5,"Baum");
         weltArray[17][6] = new Wand(17,6,"Baum");
         weltArray[17][44] = new Boot(17,44);
         //x=19
         weltArray[18][0] = new Wand(18,0,"Baum");
         weltArray[18][1] = new Wand(18,1,"Baum");
         weltArray[18][3] = new Wand(18,3,"Baum");
         weltArray[18][43] = new Wand(18,43,"Fluss");
         weltArray[18][44] = new Wand(18,44,"Fluss");
         //x=20
         weltArray[19][0] = new Wand(19,0,"Baum");
         weltArray[19][43] = new Wand(19,43,"Fluss");
         weltArray[19][44] = new Wand(19,44,"Fluss");
         //x=21
         weltArray[20][0] = new Wand(20,0,"Baum");
         weltArray[20][2] = new Wand(20,2,"Baum");
         weltArray[20][42] = new Wand(20,42,"Fluss");
         weltArray[20][44] = new Wand(20,44,"Fluss");
         //x=22
         weltArray[21][2] = new Wand(21,2,"Fels");
         weltArray[21][42] = new Wand(21,42,"Fluss");
         weltArray[21][43] = new Wand(21,43,"Fluss");
         //x=23
         weltArray[22][1] = new Wand(22,1,"Fels");
         weltArray[22][22] = new Wand(22,22,"Basismauer");
         weltArray[22][23] = new Wand(22,23,"Basismauer");
         weltArray[22][24] = new Wand(22,24,"Basismauer");
         weltArray[22][25] = new Wand(22,25,"Basismauer");
         weltArray[22][26] = new Wand(22,26,"Basismauer");
         weltArray[22][42] = new Wand(22,42,"Fluss");
         weltArray[22][43] = new Wand(22,43,"Fluss");
         //x=24
         weltArray[23][1] = new Wand(23,1,"Fles");
         weltArray[23][22] = new Wand(23,22,"Basismauer");
         weltArray[23][26] = new Wand(23,26,"Basismauer");
         //x=25
         weltArray[24][1] = new Wand(24,1,"Fels");
         weltArray[24][21] = new Mensch(24,21,"Männlich","Dorfbewohner",0);
         weltArray[24][22] = new Mensch(24,22,"Männlich","Monster",10);
         weltArray[24][23] = new Boot(24,23);
         //weltArray[24][22] = new Tuer(24,22);
         weltArray[24][17] = new Schwert(24,22,"Schwert",15);
         weltArray[24][26] = new Wand(24,26,"Basismauer");
         weltArray[24][41] = new Wand(24,41,"Fluss");
         weltArray[24][42] = new Wand(24,42,"Fluss");
         
          weltArray[49][0]= new Wand(49,0,"Fels");
               weltArray[49][1]= new Wand(49,1,"Fels");
               weltArray[49][2]= new Wand(49,2,"Fels");
               weltArray[49][9]= new Wand(49,9,"Fels");
               weltArray[49][16]= new Wand(49,16,"Fels");
               weltArray[49][30]= new Wand(49,30,"DungeonWand");
               weltArray[49][33]= new Wand(49,33,"DungeonWand");
               weltArray[49][34]= new Wand(49,34,"DungeonWand");
               weltArray[49][35]= new Wand(49,35,"DungeonWand");
               weltArray[49][36]= new Wand(49,36,"DungeonWand");
               weltArray[49][39]= new Wand(49,39,"DungeonWand");
               
               weltArray[48][2]= new Wand(48,2,"Fels");
               weltArray[48][7]= new Wand(48,7,"Fels");
               weltArray[48][8]= new Wand(48,8,"Fels");
               weltArray[48][10]= new Wand(48,10,"Fels");
               weltArray[48][15]= new Wand(48,15,"Fels");
               weltArray[48][30]= new Wand(48,30,"DungeonWand");
               weltArray[48][33]= new Wand(48,33,"DungeonWand");
               weltArray[48][36]= new Wand(48,36,"DungeonWand");
               weltArray[48][39]= new Wand(48,39,"DungeonWand");
               
               weltArray[47][2]= new Wand(47,2,"Fels");
               weltArray[47][3]= new Wand(47,3,"Fels");
               weltArray[47][5]= new Wand(47,5,"Fels");
               weltArray[47][6]= new Wand(47,6,"Fels");
               weltArray[47][11]= new Wand(47,11,"Fels");
               weltArray[47][13]= new Wand(47,13,"Fels");
               weltArray[47][14]= new Wand(47,14,"Fels");
               weltArray[47][30]= new Wand(47,30,"DungeonWand");
               weltArray[47][33]= new Wand(47,33,"DungeonWand");
               weltArray[47][36]= new Wand(47,36,"DungeonWand");
               weltArray[47][39]= new Wand(47,39,"DungeonWand");
               
               weltArray[46][4]= new Wand(46,4,"Fels");
               weltArray[46][10]= new Wand(46,10,"Fels");
               weltArray[46][12]= new Wand(46,12,"Fels");
               weltArray[46][30]= new Wand(46,30,"DungeonWand");
               weltArray[46][33]= new Wand(46,33,"DungeonWand");
               weltArray[46][36]= new Wand(46,36,"DungeonWand");
               weltArray[46][39]= new Wand(46,39,"DungeonWand");
               
               weltArray[45][2]= new Wand(45,2,"Fels");
               weltArray[45][6]= new Wand(45,6,"Fels");
               weltArray[45][8]= new Wand(45,8,"Fels");
               weltArray[45][9]= new Wand(45,9,"Fels");
               weltArray[45][11]= new Wand(45,11,"Fels");
               weltArray[45][30]= new Wand(45,30,"DungeonWand");
               weltArray[45][33]= new Wand(45,33,"DungeonWand");
               weltArray[45][36]= new Wand(45,36,"DungeonWand");
               weltArray[45][39]= new Wand(45,39,"DungeonWand");
               
               weltArray[44][2]= new Wand(44,2,"Fels");
               weltArray[44][8]= new Wand(44,8,"Fels");
               weltArray[44][11]= new Wand(44,11,"Fels");
               weltArray[44][30]= new Wand(44,30,"DungeonWand");
               weltArray[44][33]= new Wand(44,33,"DungeonWand");
               weltArray[44][36]= new Wand(44,36,"DungeonWand");
               weltArray[44][39]= new Wand(44,39,"DungeonWand");
               
               weltArray[43][0]= new Wand(43,0,"Fels");
               weltArray[43][1]= new Wand(43,1,"Fels");
               weltArray[43][2]= new Wand(43,2,"Fels");
               weltArray[43][4]= new Wand(43,4,"Fels");
               weltArray[43][5]= new Wand(43,5,"Fels");
               weltArray[43][8]= new Wand(43,8,"Fels");
               weltArray[43][10]= new Wand(43,10,"Fels");
               weltArray[43][30]= new Wand(43,30,"DungeonWand");
               weltArray[43][33]= new Wand(43,33,"DungeonWand");
               weltArray[43][34]= new Wand(43,34,"DungeonWand");
               weltArray[43][36]= new Wand(43,36,"DungeonWand");
               weltArray[43][39]= new Wand(43,39,"DungeonWand");
               
               weltArray[42][1]= new Wand(42,1,"Fels");
               weltArray[42][4]= new Wand(42,4,"Fels");
               weltArray[42][7]= new Wand(42,7,"Fels");
               weltArray[42][9]= new Wand(42,9,"Fels");
               weltArray[42][30]= new Wand(42,30,"DungeonWand");
               weltArray[42][33]= new Wand(42,33,"DungeonWand");
               weltArray[42][36]= new Wand(42,36,"DungeonWand");
               weltArray[42][39]= new Wand(42,39,"DungeonWand");
               
               weltArray[41][0]= new Wand(41,0,"Fels");
               weltArray[41][1]= new Wand(41,1,"Fels");
               weltArray[41][3]= new Wand(41,3,"Fels");
               weltArray[41][4]= new Wand(41,4,"Fels");
               weltArray[41][6]= new Wand(41,6,"Fels");
               weltArray[41][8]= new Wand(41,8,"Fels");
               weltArray[41][31]= new Wand(41,31,"DungeonWand");
               weltArray[41][33]= new Wand(41,33,"DungeonWand");
               weltArray[41][36]= new Wand(41,36,"DungeonWand");
               weltArray[41][38]= new Wand(41,38,"DungeonWand");
               
               weltArray[40][0]= new Wand(40,0,"Fels");
               weltArray[40][3]= new Wand(40,3,"Fels");
               weltArray[40][7]= new Wand(40,7,"Fels");
               weltArray[40][8]= new Wand(40,8,"Fels");
               weltArray[40][32]= new Wand(40,32,"DungeonWand");
               weltArray[40][33]= new Wand(40,33,"DungeonWand");
               weltArray[40][36]= new Wand(40,36,"DungeonWand");
               weltArray[40][37]= new Wand(40,37,"DungeonWand");
               
               weltArray[39][0]= new Wand(39,39,"Fels");
               weltArray[39][2]= new Wand(39,2,"Fels");
               weltArray[39][3]= new Wand(39,3,"Fels");
               weltArray[39][7]= new Wand(39,7,"Fels");
               weltArray[39][8]= new Wand(39,8,"Fels");
               
               weltArray[38][0]= new Wand(38,0,"Fels");
               weltArray[38][2]= new Wand(38,2,"Fels");
               weltArray[38][3]= new Wand(38,3,"Fels");
               weltArray[38][4]= new Wand(38,4,"Fels");
               
               weltArray[37][0]= new Wand(37,0,"Fels");
               weltArray[37][2]= new Wand(37,2,"Fels");
               weltArray[37][3]= new Wand(37,3,"Fels");
               weltArray[37][7]= new Wand(37,7,"Fels");
               
               weltArray[36][3]= new Wand(36,3,"Fels");
               weltArray[36][4]= new Wand(36,4,"Fels");
               weltArray[36][5]= new Wand(36,5,"Fels");
               weltArray[36][6]= new Wand(36,6,"Fels");
               weltArray[36][7]= new Wand(36,7,"Fels");
               weltArray[36][8]= new Wand(36,8,"Fels");
               
               weltArray[35][0]= new Wand(35,0,"Fels");
               weltArray[35][2]= new Wand(35,2,"Fels");
               weltArray[35][3]= new Wand(35,3,"Fels");
               weltArray[35][7]= new Wand(35,7,"Fels");
               weltArray[35][17]= new Wand(35,17,"Baum");
               weltArray[35][18]= new Wand(35,18,"Baum");
               
               weltArray[34][0]= new Wand(34,0,"Fels");
               weltArray[34][4]= new Wand(34,4,"Fels");
               weltArray[34][6]= new Wand(34,6,"Fels");
               weltArray[34][16]= new Wand(34,16,"Baum");
               weltArray[34][19]= new Wand(34,19,"Baum");
               
               weltArray[33][0]= new Wand(33,0,"Fels");
               weltArray[33][1]= new Wand(33,1,"Fels");
               weltArray[33][4]= new Wand(33,4,"Fels");
               weltArray[33][5]= new Wand(33,5,"Fels");
               weltArray[33][16]= new Wand(33,16,"Baum");
               weltArray[33][20]= new Wand(33,20,"Baum");
               weltArray[33][33]= new Wand(33,33,"Baum");
               weltArray[33][34]= new Wand(33,34,"Baum");
               
               weltArray[32][0]= new Wand(32,0,"Fels");
               weltArray[32][1]= new Wand(32,1,"Fels");
               weltArray[32][3]= new Wand(32,3,"Fels");
               weltArray[32][4]= new Wand(32,4,"Fels");
               weltArray[32][15]= new Wand(32,15,"Baum");
               weltArray[32][19]= new Wand(32,19,"Baum");
               weltArray[32][32]= new Wand(32,32,"Baum");
               weltArray[32][35]= new Wand(32,35,"Baum");
               weltArray[32][36]= new Wand(32,36,"Baum");
               weltArray[32][48]= new Wand(32,48,"Fluss");
               weltArray[32][49]= new Wand(32,49,"Fluss");
               
               weltArray[31][3]= new Wand(31,3,"Fels");
               weltArray[31][16]= new Wand(31,16,"Baum");
               weltArray[31][19]= new Wand(31,19,"Baum");
               weltArray[31][31]= new Wand(31,31,"Baum");
               weltArray[31][35]= new Wand(31,35,"Baum");
               weltArray[31][46]= new Wand(31,46,"Fluss");
               weltArray[31][47]= new Wand(31,47,"Fluss");
               weltArray[31][48]= new Wand(31,48,"Fluss");
               weltArray[31][49]= new Wand(31,49,"Fluss");

               weltArray[30][1]= new Wand(30,1,"Fels");
               weltArray[30][2]= new Wand(30,2,"Fels");
               weltArray[30][17]= new Wand(30,17,"Baum");
               weltArray[30][18]= new Wand(30,18,"Baum");
               weltArray[30][32]= new Wand(30,32,"Baum");               
               weltArray[30][35]= new Wand(30,35,"Baum");
               weltArray[30][44]= new Wand(30,44,"Fluss");
               weltArray[30][45]= new Wand(30,45,"Fluss");
               weltArray[30][46]= new Wand(30,46,"Fluss");
               weltArray[30][47]= new Wand(30,47,"Fluss");
               weltArray[30][48]= new Wand(30,48,"Fluss");
               weltArray[30][49]= new Wand(30,49,"Fluss");
               
               weltArray[29][1]= new Wand(29,1,"Fels");
               weltArray[29][34]= new Wand(29,34,"Baum");
               weltArray[29][35]= new Wand(29,35,"Baum");
               weltArray[29][44]= new Wand(29,44,"Fluss");
               weltArray[29][45]= new Wand(29,45,"Fluss");
               weltArray[29][46]= new Wand(29,46,"Fluss");
               weltArray[29][47]= new Wand(29,47,"Fluss");
               weltArray[29][48]= new Wand(29,48,"Fluss");
               
               weltArray[28][1]= new Wand(28,1,"Fels");
               weltArray[28][43]= new Wand(28,43,"Fluss");
               weltArray[28][44]= new Wand(28,44,"Fluss");
               weltArray[28][45]= new Wand(28,45,"Fluss");
    
               weltArray[27][1]= new Wand(27,1,"Fels");
               weltArray[27][43]= new Wand(27,43,"Fluss");
               weltArray[27][44]= new Wand(27,44,"Fluss");
               
               weltArray[26][1]= new Wand(26,1,"Fels");
               weltArray[26][23]= new Wand(26,23,"Basismauer");
               weltArray[26][24]= new Wand(26,24,"Basismauer");
               weltArray[26][25]= new Wand(26,25,"Basismauer");
               weltArray[26][26]= new Wand(26,26,"Basismauer");
               weltArray[26][27]= new Wand(26,27,"Basismauer");
               weltArray[26][42]= new Wand(26,42,"Fluss");
               weltArray[26][43]= new Wand(26,43,"Fluss");
               weltArray[26][44]= new Wand(26,44,"Fluss");
               
               weltArray[25][1]= new Wand(25,1,"Fels");
   
               weltArray[25][27]= new Wand(25,23,"Basismauer");
               weltArray[25][42]= new Wand(25,42,"Fluss");
               weltArray[25][43]= new Wand(25,43,"Fluss");
               // Dienste

        
        }
}
