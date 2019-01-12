import java.util.Random;
/**
 * @author 
 * @version 
 */
public class Kampf
{
    // Bezugsobjekte

    // Attribute
    private Held held;
    private Gegenstand gegner;
    private boolean kampfAktiv = false;
    private boolean kampfFertig = false;
    private String monsterRichtung ="";
    private Gegenstand[][] pArray;
    private int x,y,hp,monsterHp;
    
    

    // Konstruktor
    public Kampf()
    {

    }

    // Dienste
    public void kaempfen(String pRichtung,Gegenstand[][] test,Held spieler){
        kampfFertig = false;
        Parser parser = new Parser();
        monsterRichtung = pRichtung;
        kampfAktiv = true;
        pArray = test;
        held = spieler;
       if(pRichtung =="oben"){gegner = pArray[held.getX()][held.getY()-1];}
       else if(pRichtung =="unten"){gegner = pArray[held.getX()][held.getY()+1];}
       else if(pRichtung =="rechts"){gegner = pArray[held.getX()+1][held.getY()];}
       else if(pRichtung =="links"){gegner = pArray[held.getX()-1][held.getY()];}
        
        monsterHp=gegner.getHp();
        System.out.println("Im näheren Umfeld von einem schritt befindet sich ein Monster. Es will dich angreifen. Du befindest dich im kampfmodus. Falls du nicht weißt was du machen kannst tippe ,hilfe,");
        printHelp();
        while(!kampfFertig){
            Command command = parser.getCommand();
            kampfFertig = processCommand(command);
        }
        if(held.getHp()<=0){
            System.out.println("Du bist tot");
        }
        
    }
    //public void attacke(Mensch pSpieler,int pNummer){
     //   if(pNummer ==1)System.out.println("attacke1");
     //   if(pNummer ==2)System.out.println("attacke2");
     //   if(pNummer ==3)System.out.println("attacke3");
    //}
    public boolean processCommand(Command command){
        if(command.isUnknown()) {
            System.out.println("Bitte überprüfen sie die eingabe!");
            return false;
        }
        String commandWord = command.getCommandWord();
        if (commandWord.equals("hilfe")) {
            printHelp();
        }else if(commandWord.equals("fliehen")){
            System.out.println("Sie sind erfolgreich vor dem kampf geflohen!");
            kampfFertig = true;
            return kampfFertig;
        }else if(commandWord.equals("Attacken")){
            zeigeAttacken();
        }else if(commandWord.equals("attacke")){
            if(!command.hasSecondWord()){
                    System.out.println("Welche Attacke wollen sie ausführen?");
                    return kampfFertig;
                }
            String attackeNr = command.getSecondWord();
            int attackeint = Integer.parseInt(attackeNr);
            kaempfe(attackeint);
        }else if(commandWord.equals("itemhand")){
                if(held.handBesetzt()){System.out.println("Ein "+held.stringHand()+" befindet sich in ihrer hand");}
                else{System.out.println("nichts ist in der hand");}
            }else if(commandWord.equals("platzierehand")){
                if(command.hasSecondWord()){
                    String pIndex = command.getSecondWord();
                    int index = Integer.parseInt(pIndex)-1;
                    if(held.itemvorhanden(index)){
                        held.setHand(held.itemAnIndex(index));
                    }
                    System.out.println("Ein "+held.stringHand()+" befindet sich in ihrer hand");
                }else{
                    System.out.println("aus welchem slot soll das item in die hand gelegt werden?");
                }
            }else if (commandWord.equals("inventar")) {
                held.getInventar();
            }
        return kampfFertig;
    }
    public boolean getKampfAktiv(){
        return kampfAktiv;
    }
    public void printHelp(){
        System.out.println("mit ,Attacken, sehen sie ihre Attacken\n"+"mit ,attacke (nr der attacke), attackieren sie\n"+"mit ,fliehen, fliehen sie vor dem kampf\n"+"mit ,itemhand, überprüfst du, was in deiner hand ist \n"+"mit ,platzierehand (slot), kannst du sach in deine hand platzieren\n"+"mit ,inventar, guckst du in dein inventar");
    }
    public void kaempfe(int pAttacke){
        int monsterSchaden = 0;
        int heldSchaden = 0;
        if(held.handBesetzt()){heldSchaden = held.getHand().getSchadenspunkte();
        }else{System.out.println("Bitte plazieren sie einen Gegenstand aus ihrem inventar in ihre hand!");}
        if(gegner.getHp()<=0){gegnerTot();return;}
        if(held.getHp()>0){
            
                if(pAttacke == 1){
                    
                if(monsterRichtung == "oben"){
                    monsterSchaden = zufallsZahl() * pArray[held.getX()][held.getY()-1].getSchadenspunkte();
                }
                else if(monsterRichtung == "unten"){
                    monsterSchaden = zufallsZahl() * pArray[held.getX()][held.getY()+1].getSchadenspunkte();
                }
                else if(monsterRichtung == "rechts"){
                    monsterSchaden = zufallsZahl() * pArray[held.getX()+1][held.getY()].getSchadenspunkte();
                }
                else if(monsterRichtung == "links"){
                    monsterSchaden = zufallsZahl() * pArray[held.getX()-1][held.getY()].getSchadenspunkte();
                }
                held.setHp(held.getHp()-monsterSchaden);
            
            
            
        
            }
            else if(pAttacke == 2){
            
                System.out.println("attacke 2");
            }
                System.out.println("Du hast jetzt "+monsterSchaden+" hp weniger");
                System.out.println("Das Monster hat jetzt "+heldSchaden +" hp weniger");
            if(pAttacke ==3){
                held.setHp(0);
            }
        }else{
            
            kampfFertig = true;
            kampfAktiv = false;
        }
    }
    public void zeigeAttacken(){
        System.out.println("Sie haben 2 Attacken zur verfügung ,welche sie benutzen können\n"+"1. Attacke: High kick Schadenspunkte 15\n"+"2. Attacke: Punch Schadenspunkte 9\n");
    }
    public void gegnerTot(){
        System.out.println("Du hast dein Gegner besiegt. Hast jedoch nur noch "+held.getHp()+" hp. Nimm dich lieber in acht!");
    }
    public int zufallsZahl(){
        int randomNum = new Random().nextInt(3);
        return randomNum;
    }
}
